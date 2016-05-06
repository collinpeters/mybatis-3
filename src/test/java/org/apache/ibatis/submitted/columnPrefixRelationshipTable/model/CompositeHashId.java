package org.apache.ibatis.submitted.columnPrefixRelationshipTable.model;

import java.io.Serializable;

/**
 * Interface for any composite hash ID. That is, a hash ID that is composed of two IDs.
 * 
 * Order is important hence {@link #getOne()} and {@link #getTwo()}
 *
 * @author collin
 */
public interface CompositeHashId<ID extends Serializable> extends Serializable {

	/**
	 * For this composite ID, return the first ID
	 * 
	 * @return
	 */
	ID getOne();

	/**
	 * For this composite ID, return the second ID
	 * 
	 * @return
	 */
	ID getTwo();

}
