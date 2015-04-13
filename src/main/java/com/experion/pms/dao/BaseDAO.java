/**
 * 
 */
package com.experion.pms.dao;

import java.util.List;

/**
 * @author Aneesh Chandran
 * 
 */
public interface BaseDAO {

	public void executeProcedure(final String procName, List<String> procArgs)
			throws Exception;
	public List<Object> getDetails(String entityName,String whereField,String whereValue,String orderBy) throws Exception;

}
