/**
 *
 */
package com.experion.pms.dao.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.experion.pms.dao.BaseDAO;
import com.experion.pms.entity.Book;

/**
 * @author Aneesh Chandran
 * 
 */
public class BaseHibernateDAO<T> extends HibernateDaoSupport implements
		BaseDAO, Serializable {

	private static final long serialVersionUID = -6499974777212536676L;

	/**
	 * This method will execute the stored procedure in the database. The
	 * procedure name, and its arguments are passed as incoming parameters.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void executeProcedure(final String procName,
			final List<String> procArgs) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(final Session session)
					throws HibernateException, SQLException {
				try {
					Query query = session
							.createSQLQuery(
									"CALL " + procName + "(:itemNumber)")
							.addEntity(Book.class)
							.setParameter("itemNumber", procArgs.get(0));

					query.executeUpdate();
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println("Something went wrong with id ");
					e.printStackTrace();
					throw new RuntimeException(e);
				}
				return null;
			}
		});
	}
	
	public List<Object> getDetails(String entityName,String whereField,String whereValue,String orderBy)
			throws Exception {
		try {
			
			if(whereField!=StringUtils.EMPTY && whereValue!=StringUtils.EMPTY){
				@SuppressWarnings("unchecked")
				List<Object> list = getHibernateTemplate().find(
						"from "+entityName+" where "+whereField+"='"+whereValue+"' order by "+ orderBy);
				if (list != null && !list.isEmpty()) {
					return list;
				}
			}else{
				@SuppressWarnings("unchecked")
				List<Object> list = getHibernateTemplate().find(
						"from "+entityName+" order by "+orderBy);
				if (list != null && !list.isEmpty()) {
					return list;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		// TODO Auto-generated method stub
		return null;
	}

}
