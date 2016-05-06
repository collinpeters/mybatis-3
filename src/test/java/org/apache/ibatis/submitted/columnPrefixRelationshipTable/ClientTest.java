/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.submitted.columnPrefixRelationshipTable;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.submitted.columnPrefixRelationshipTable.mappers.ClientMapper;
import org.apache.ibatis.submitted.columnPrefixRelationshipTable.model.Client;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClientTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUp() throws Exception {
		// create an SqlSessionFactory
		Reader reader = Resources
				.getResourceAsReader("org/apache/ibatis/submitted/columnPrefixRelationshipTable/mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		reader.close();

		// populate in-memory database
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		reader = Resources
				.getResourceAsReader("org/apache/ibatis/submitted/columnPrefixRelationshipTable/CreateDB.sql");
		ScriptRunner runner = new ScriptRunner(conn);
		runner.setLogWriter(null);
		runner.runScript(reader);
		reader.close();
		session.close();
	}

	@Test
	public void loadClient() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);
			Client client = mapper.load();

			assertThat(client.getId(), is(1));
			assertThat(client.getFirstname(), is("Bob"));
			assertThat(client.getLastname(), is("Smith"));
			assertThat(client.getAssociations().size(), is(1));
			assertThat("First client should have ID 1", client.getAssociations().get(0).getId().getOne(), is(1));
			assertThat("Second client should have ID 2", client.getAssociations().get(0).getId().getTwo(), is(2));
			assertThat("First client entity should have ID 1", client.getAssociations().get(0).getClient1().getId(),
					is(1));
			assertThat("Second client entity should have ID 2", client.getAssociations().get(0).getClient2().getId(),
					is(2));
		} finally {
			sqlSession.close();
		}
	}

}
