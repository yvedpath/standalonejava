package com.mycompany.app;
import java.sql.*;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
public class jdbc {
	public static void main(String args[])
	{
		jdbc j=new jdbc();
		System.out.println("Inside main method. Object Created"); 
		Integer empID1=j.addEmployee("YV",1000);
		ArrayList all=new ArrayList();
		try
		{
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(details.class).buildSessionFactory();
			Session session=factory.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from details");
			all=(ArrayList) query.list();
		}
		catch(HibernateException exception){
			System.out.println("Problem creating session factory");
			exception.printStackTrace();
		}
		for (int i=0;i<all.size();i++)
		{
			details d=(details) all.get(i);
			System.out.println(d.getId()+d.getName()+d.getAge());
		}

	}
	public Integer addEmployee(String fname,int salary){
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		Integer employeeId=null;
		try{
			tx=session.beginTransaction();
			Employee employee=new Employee();
			employee.setFirstName(fname);
			employee.setSalary(salary);
			employeeId=(Integer)session.save(employee);
			System.out.println("Table Created\n\n\n\n\n\n"); 
			tx.commit();
		}catch (HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employeeId;

	}
}
