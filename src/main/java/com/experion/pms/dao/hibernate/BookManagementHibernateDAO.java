/**
 * 
 */
package com.experion.pms.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;

import com.experion.pms.dao.BookManagementDAO;
import com.experion.pms.entity.Book;

/**
 * @author AneeshChandran
 * 
 */
public class BookManagementHibernateDAO extends BaseHibernateDAO<Object>
		implements BookManagementDAO {

	private static final long serialVersionUID = 6484250259100963808L;

	private MessageSource messageSource;

	/**
	 * This method will query the BOOK table and return the Book entity based on
	 * the item number passed.
	 */
	//@Override
	@SuppressWarnings("unchecked")
	public Book queryItem(String itemNo) throws Exception {
		try {
			List<Book> bookList = getHibernateTemplate().find(
					"from Book where itemNumber = ?", itemNo);
			if (bookList != null && !bookList.isEmpty()) {
				return bookList.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	/**
	 * This will save the given book entity as a new/updated record into the
	 * database.
	 */
	public void saveItem(Book book) throws Exception {
		try {
			System.out.println("Save Book IN DAO ............"+book);
			getHibernateTemplate().merge(book);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method will delete an entry from the BOOK table based on the item
	 * number.
	 */
	//@Override
	@SuppressWarnings("unchecked")
	public void deleteItem(String itemNumber) throws Exception {
		try {
			List<Book> bookList = getHibernateTemplate().find(
					"from Book where itemNumber = ?", itemNumber);
			getHibernateTemplate().delete(bookList.get(0));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method will ship the item and set the delivered_on, delivered_by,
	 * and delivery_tracking_no values. After the shipment, the system will
	 * return the updated result to the front-end to display to the user.
	 */
	//@Override
	@SuppressWarnings("unchecked")
	public Book shipItem(String itemNumber) throws Exception {
		try {
			List<String> list = new ArrayList<String>();
			list.add(itemNumber);
			executeProcedure("book_mgmt_ship_item", list);

			List<Book> bookList = getHibernateTemplate().find(
					"from Book where itemNumber = ?", itemNumber);
			if (bookList != null && !bookList.isEmpty()) {
				return bookList.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
