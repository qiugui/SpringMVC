 package com.qg.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

 /** 
* @ClassName: HqlUtil 
* @Description:  注入hibernateTemplate
* @author qiugui 
* @date 2014年11月21日 下午5:58:00 
*  
*/ 
@Component("hqlUtil")
 public class HqlUtil {

	 @Resource(name="hibernateTemplate")
	 private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	 
}

 