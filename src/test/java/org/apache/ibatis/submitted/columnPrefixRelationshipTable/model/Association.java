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

package org.apache.ibatis.submitted.columnPrefixRelationshipTable.model;

public class Association {
	private AssociationId id;
	private Client client1;
	private Client client2;

	public AssociationId getId() {
		return id;
	}

	public void setId(AssociationId id) {
		this.id = id;
	}

	public Client getClient1() {
		return client1;
	}

	public void setClient1(Client client1) {
		this.client1 = client1;
	}

	public Client getClient2() {
		return client2;
	}

	public void setClient2(Client client2) {
		this.client2 = client2;
	}

}
