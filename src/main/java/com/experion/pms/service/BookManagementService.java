/**
 * 
 */
package com.experion.pms.service;

import com.experion.pms.entity.Book;

/**
 * @author AneeshChandran
 * 
 */
public interface BookManagementService {

	public Book queryItem(String itemNo) throws Exception;

	public void saveItem(Book book) throws Exception;

	public void deleteItem(String itemNumber) throws Exception;

	public Book shipItem(String itemNumber) throws Exception;
}
