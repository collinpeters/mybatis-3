package org.apache.ibatis.submitted.columnPrefixRelationshipTable.model;

import java.io.Serializable;

public class AssociationId implements Serializable, CompositeHashId<Integer> {

	private static final long serialVersionUID = 1077348961121150630L;

	private Integer clientId1;

	private Integer clientId2;

	public Integer getOne() {
		return clientId1;
	}

	public Integer getTwo() {
		return clientId2;
	}
}