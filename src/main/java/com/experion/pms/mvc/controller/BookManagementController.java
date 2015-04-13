/**
 * 
 */
package com.experion.pms.mvc.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.experion.pms.entity.Book;
import com.experion.pms.mvc.data.BookManagementForm;
import com.experion.pms.service.BookManagementService;
import com.experion.pms.util.BookManagementUtil;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/login/*")
public class BookManagementController {

	public static final String BOOK_MANAGEMENT = "/bookmanagement";

	private static final Log log = LogFactory
			.getLog(BookManagementController.class);

	@Inject
	@Named("bookManagementService")
	public BookManagementService bookManagementService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;

	/**
	 * 
	 * @param request
	 * @return
	 * 
	 *         This method will be invoked at the initial time when the
	 *         application is loaded.
	 * 
	 */
	@RequestMapping(value = "/index")
	public ModelAndView loginAction(HttpServletRequest request) {
		return new ModelAndView(BOOK_MANAGEMENT, "bookManagementForm",
				new BookManagementForm());
	}

	/**
	 * 
	 * @param bookManagementForm
	 * @param result
	 * @param model
	 * @return
	 * 
	 *         This method is used to pull the record from the database based on
	 *         the item number entered by the user. After receiving the book
	 *         object from the service, this method will set each values to its
	 *         corresponding form objects to display in the front-end.
	 */
	@RequestMapping(value = "/queryItem")
	public ModelAndView queryItem(
			@ModelAttribute BookManagementForm bookManagementForm,
			BindingResult result, Model model) {
		
		String itemNumber = StringUtils.EMPTY;
		String pattern = "[-+]?\\d*\\.?\\d+";
		Book book = null;
		log.info("Reached the controller.........."
				+ bookManagementForm.getQueryItemNumber());
		
		if (StringUtils.isNotBlank(bookManagementForm.getQueryItemNumber())
				&& bookManagementForm.getQueryItemNumber().matches(pattern)) {
			itemNumber = String.format("%09d",
					Integer.valueOf(bookManagementForm.getQueryItemNumber()));
		} else {
			itemNumber = bookManagementForm.getQueryItemNumber();
		}
		
		try {
			book = bookManagementService.queryItem(itemNumber);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		if (book != null) {
			bookManagementForm.setItemNumber(book.getItemNumber());
			bookManagementForm.setItemDescription(book.getItemDesc());
			bookManagementForm.setReceivedDate(book.getReceivedDate());
			bookManagementForm.setShippingMethod(book.getShippingMethod());
			bookManagementForm.setShippingNotes(book.getShippingNotes());
			bookManagementForm.setShippingPriority(String.valueOf(book
					.getShippingPriority()));
			bookManagementForm.setPackageInstruction(book
					.getPackagingInstructions());
			bookManagementForm.setDeliveredOn(book.getDeliveredOn());
			bookManagementForm.setDeliveredBy(book.getDeliveredBy());
			bookManagementForm.setDeliveryTrackingNo(book.getTrackingNumber());
		} else {
			String successMsg = messageSource.getMessage("co.error.noRecords",
					null, Locale.getDefault());
			result.rejectValue("emptyRecords", null, successMsg);
			clearFormFields(bookManagementForm);
		}

		return new ModelAndView(BOOK_MANAGEMENT);
	}

	/**
	 * 
	 * @param bookManagementForm
	 * @param result
	 * @param model
	 * @return
	 * 
	 *         This method will save the records into the database as a new or
	 *         updated record based on the item number. If the item number
	 *         exists in the front-end and the user presses the saveItem button,
	 *         then the system will update the existing record in the database
	 *         otherwise it will create a new entry. After save, the method
	 *         divert the control into the same page in the front-end.
	 */
	@RequestMapping(value = "/saveItem")
	public ModelAndView saveItem(
			@ModelAttribute BookManagementForm bookManagementForm,
			BindingResult result, Model model) {
		log.info("Reached the saveItem controller..........");
		String errorMsg = StringUtils.EMPTY;
		int errorFlag = 0;

		if (bookManagementForm.getReceivedDate() == null
				|| bookManagementForm.getReceivedDate().length() == 0) {
			errorMsg = messageSource.getMessage("co.error.receivedDate", null,
					Locale.getDefault());
			result.rejectValue("receivedDate", null, errorMsg);
			errorFlag = 1;
		}
		if (StringUtils.isBlank(bookManagementForm.getItemDescription())) {
			errorMsg = messageSource.getMessage("co.error.itemDesc", null,
					Locale.getDefault());
			result.rejectValue("itemDescription", null, errorMsg);
			errorFlag = 1;
		} else if (bookManagementForm.getItemDescription().length() > 255) {
			errorMsg = messageSource.getMessage("co.error.itemDescLength",
					null, Locale.getDefault());
			result.rejectValue("itemDescription", null, errorMsg);
			errorFlag = 1;
		}
		if (StringUtils.isNotBlank(bookManagementForm.getShippingNotes())
				&& bookManagementForm.getShippingNotes().length() > 255) {
			errorMsg = messageSource.getMessage("co.error.shippingNotes", null,
					Locale.getDefault());
			result.rejectValue("shippingNotes", null, errorMsg);
			errorFlag = 1;
		}
		if (StringUtils.isNotBlank(bookManagementForm.getPackageInstruction())
				&& bookManagementForm.getPackageInstruction().length() > 255) {
			errorMsg = messageSource.getMessage("co.error.packageInstr", null,
					Locale.getDefault());
			result.rejectValue("packageInstruction", null, errorMsg);
			errorFlag = 1;
		}
		if (errorFlag == 0) {

			String itemNumber = StringUtils.EMPTY;
			int randomNo = 0;
			Book book = new Book();
			if (StringUtils.isNotBlank(bookManagementForm.getItemNumber())) {
				itemNumber = String.format("%09d",
						Integer.valueOf(bookManagementForm.getItemNumber()));
			} else {
				randomNo = BookManagementUtil.getRandomNumber();
				itemNumber = String.format("%09d", randomNo);
			}

			log.debug("Item Number generated = " + itemNumber);
			book.setItemNumber(itemNumber);
			book.setItemDesc(bookManagementForm.getItemDescription());
			book.setReceivedDate(bookManagementForm.getReceivedDate());
			book.setShippingMethod(bookManagementForm.getShippingMethod());
			book.setShippingNotes(bookManagementForm.getShippingNotes());
			if (StringUtils
					.isNotBlank(bookManagementForm.getShippingPriority())) {
				book.setShippingPriority(Integer.parseInt(bookManagementForm
						.getShippingPriority()));
			}
			book.setPackagingInstructions(bookManagementForm
					.getPackageInstruction());
			book.setDeliveredOn(bookManagementForm.getDeliveredOn());
			book.setDeliveredBy(bookManagementForm.getDeliveredBy());
			book.setTrackingNumber(bookManagementForm.getDeliveryTrackingNo());

			try {
				bookManagementService.saveItem(book);
			} catch (Exception e) {
				log.error(e.getMessage());
			}

			bookManagementForm.setItemNumber(itemNumber);
			String successMsg = messageSource.getMessage(
					"co.success.saveRecord", null, Locale.getDefault());
			result.rejectValue("gblMsg", null, successMsg);
		}

		return new ModelAndView(BOOK_MANAGEMENT);
	}

	/**
	 * 
	 * @param bookManagementForm
	 * @param result
	 * @param model
	 * @return
	 * 
	 *         This method will delete the item based on the item number. The
	 *         method query the whole row against the item number and delete it.
	 */
	@RequestMapping(value = "/deleteItem")
	public ModelAndView deleteItem(
			@ModelAttribute BookManagementForm bookManagementForm,
			BindingResult result, Model model) {
		log.info("Reached the deleteItem controller..........");
		String itemNumber = bookManagementForm.getItemNumber();
		
		try {
			bookManagementService.deleteItem(itemNumber);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		String successMsg = messageSource.getMessage("co.success.deleteRecord",
				null, Locale.getDefault());
		result.rejectValue("gblMsg", null, successMsg);

		clearFormFields(bookManagementForm);
		return new ModelAndView(BOOK_MANAGEMENT);
	}

	/**
	 * 
	 * @param bookManagementForm
	 * @param result
	 * @param model
	 * @return
	 * 
	 *         This method will ship the item saved in the database. This will
	 *         invoke the database stored procedure to decide the carrier and
	 *         update the fields of Delivered On, Delivered By and Delivery
	 *         Tracking Number. “Delivered On” date is today’s date, “Delivery
	 *         Tracking Number” is a random text of 13 characters, and if the
	 *         item number is odd number, carrier would be “FedEx” Otherwise it
	 *         will be “UPS”.
	 */
	@RequestMapping(value = "/shipItem")
	public ModelAndView shipItem(
			@ModelAttribute BookManagementForm bookManagementForm,
			BindingResult result, Model model) {
		log.info("Reached the shipItem controller..........");
		String itemNumber = bookManagementForm.getItemNumber();
		Book book = null;
		String errorMsg = StringUtils.EMPTY;
		int errorFlag = 0;
		if (StringUtils.isNotBlank(itemNumber)) {
			
			if (bookManagementForm.getReceivedDate() == null
					|| bookManagementForm.getReceivedDate().length() == 0) {
				errorMsg = messageSource.getMessage("co.error.receivedDate", null,
						Locale.getDefault());
				result.rejectValue("receivedDate", null, errorMsg);
				errorFlag = 1;
			}
			if (StringUtils.isBlank(bookManagementForm.getItemDescription())) {
				errorMsg = messageSource.getMessage("co.error.itemDesc", null,
						Locale.getDefault());
				result.rejectValue("itemDescription", null, errorMsg);
				errorFlag = 1;
			} else if (bookManagementForm.getItemDescription().length() > 255) {
				errorMsg = messageSource.getMessage("co.error.itemDescLength",
						null, Locale.getDefault());
				result.rejectValue("itemDescription", null, errorMsg);
				errorFlag = 1;
			}
			if (StringUtils.isNotBlank(bookManagementForm.getShippingNotes())
					&& bookManagementForm.getShippingNotes().length() > 255) {
				errorMsg = messageSource.getMessage("co.error.shippingNotes", null,
						Locale.getDefault());
				result.rejectValue("shippingNotes", null, errorMsg);
				errorFlag = 1;
			}
			if (StringUtils.isNotBlank(bookManagementForm.getPackageInstruction())
					&& bookManagementForm.getPackageInstruction().length() > 255) {
				errorMsg = messageSource.getMessage("co.error.packageInstr", null,
						Locale.getDefault());
				result.rejectValue("packageInstruction", null, errorMsg);
				errorFlag = 1;
			}
			
			try {
				if (errorFlag == 0) {
					book = bookManagementService.shipItem(itemNumber);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}

			if (book != null) {
				bookManagementForm.setDeliveredBy(book.getDeliveredBy());
				bookManagementForm.setDeliveredOn(book.getDeliveredOn());
				bookManagementForm.setDeliveryTrackingNo(book
						.getTrackingNumber());

				String successMsg = messageSource.getMessage(
						"co.success.saveShipment", null, Locale.getDefault());
				result.rejectValue("gblMsg", null, successMsg);
			}
		} else {
			String successMsg = messageSource.getMessage("co.error.noRecords",
					null, Locale.getDefault());
			result.rejectValue("emptyRecords", null, successMsg);
			clearFormFields(bookManagementForm);
		}
		
		return new ModelAndView(BOOK_MANAGEMENT);
	}

	/**
	 * 
	 * @param bookManagementForm
	 * 
	 *            This method will clear all the form fields.
	 */
	private void clearFormFields(BookManagementForm bookManagementForm) {
		bookManagementForm.setItemNumber(StringUtils.EMPTY);
		bookManagementForm.setItemDescription(StringUtils.EMPTY);
		bookManagementForm.setReceivedDate(StringUtils.EMPTY);
		bookManagementForm.setShippingMethod("Ground");
		bookManagementForm.setShippingNotes(StringUtils.EMPTY);
		bookManagementForm.setShippingPriority(String.valueOf(0));
		bookManagementForm.setPackageInstruction(StringUtils.EMPTY);
		bookManagementForm.setDeliveredOn(StringUtils.EMPTY);
		bookManagementForm.setDeliveredBy(StringUtils.EMPTY);
		bookManagementForm.setDeliveryTrackingNo(StringUtils.EMPTY);
	}

}
