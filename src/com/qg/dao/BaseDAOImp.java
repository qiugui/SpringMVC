 package com.qg.dao;
 
 
import java.io.Serializable;  
import java.util.Collection;  
import java.util.List;  
  
  
import org.hibernate.Criteria;  
  
import org.hibernate.criterion.Restrictions;  
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;  
import com.qg.dao.BaseDAO;  
  
 public class BaseDAOImp extends HibernateDaoSupport implements BaseDAO {  

	   
	     public List findAllBy(Class clazz, String name, Object value) {  
	         Criteria cr = getSession().createCriteria(clazz);  
	         cr.add(Restrictions.in(name, new Object[]{value}));  
	         List list = cr.list();   
	         return list;  
	     }  
	   
	     public Object findBy(Class clazz, String name, Object value) {  
	         Criteria cr = getSession().createCriteria(clazz);  
	         cr.add(Restrictions.in(name, new Object[]{value}));  
	         return cr.list().get(0);  
	     }  
	   
	     public List findLike(Class clazz, String name, String value) {  
	         Criteria cr = getSession().createCriteria(clazz);  
	         cr.add(Restrictions.like(name, "%"+value+"%"));  
	         return cr.list();  
	     }  
	   
	     public void flush() {  
	         getHibernateTemplate().flush();  
	     }  
	   
	     public List getAllObject(Class clazz) {  
	   
	         return this.getHibernateTemplate().loadAll(clazz);  
	   
	         //return getHibernateTemplate().loadAll(clazz);  
	   
	     }  
	   
	     public Object getObject(Class clazz, Serializable id) {  
	         return getHibernateTemplate().load(clazz, id);  
	     }  
	     public void removeAllObject(Collection collection) {  
	         getHibernateTemplate().deleteAll(collection);  
	     }  
	   
	     public void removeObject(Class clazz, Serializable id) {  
	         Object object = this.getHibernateTemplate().load(clazz, id);  
	         getHibernateTemplate().delete(object);  
	     }  
	   
	     public void removeObject(Object o) {  
	         getHibernateTemplate().delete(o);  
	     }  
	   
	     public void saveObject(Object o) {  
	         getHibernateTemplate().saveOrUpdate(o);  
	     }  
	   
	     public Object find(String queryString, Object[] values) {  
	         Object object = null;  
	         List list = getHibernateTemplate().find(queryString, values);  
	         if(list.size()>0)  
	             object = list.get(0);  
	             return object;  
	     }  
	   
	     public List findList(String queryString, Object[] values) {  
	         return getHibernateTemplate().find(queryString, values);  
	     }  
	   
	       
	   
	 }  


 