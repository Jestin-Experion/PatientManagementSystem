/**
 * 
 */
package com.experion.pms.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

import com.experion.pms.dao.BookManagementDAO;
import com.experion.pms.entity.Book;
import com.experion.pms.service.BookManagementService;

/**
 * @author AneeshChandran
 * 
 */
public class BookManagementServiceImpl implements BookManagementService {

	private MessageSource messageSource;

	private BookManagementDAO bookManagementDAO;
	
	private static final Log log = LogFactory
			.getLog(BookManagementServiceImpl.class);


	//@Override
	public Book queryItem(String itemNo) throws Exception {
		try {
			return bookManagementDAO.queryItem(itemNo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	//@Override
	public void deleteItem(String itemNumber) throws Exception {
		try {
			bookManagementDAO.deleteItem(itemNumber);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	//@Override
	public void saveItem(Book book) throws Exception {
		try {
			bookManagementDAO.saveItem(book);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	//@Override
	public Book shipItem(String itemNumber) throws Exception {
		try {
			return bookManagementDAO.shipItem(itemNumber);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public BookManagementDAO getBookManagementDAO() {
		return bookManagementDAO;
	}

	public void setBookManagementDAO(BookManagementDAO bookManagementDAO) {
		this.bookManagementDAO = bookManagementDAO;
	}

}
