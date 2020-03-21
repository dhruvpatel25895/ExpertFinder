package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.LoginVO;
import VO.StudentRegistrationVO;
import VO.TeacherRegistrationVO;

public class LoginDAO {
	
	
	public List searchUserDetails(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from LoginVO where userId='"+loginVO.getUserId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchStudent()
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from LoginVO where usertype='Student'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchTeacher()
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from LoginVO where usertype='Teacher'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchDemoList()
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from DemoVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchAppliedList()
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from ApplyVO");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchByEmail(String to) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		try {

			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionfactory.openSession();

			Query q = session.createQuery("from LoginVO loginVO where email='"+to+"'");

			ls = q.list();
			System.out.println(ls.size());
			System.out.println("Done");
			// session.flush();
			// session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return ls;
		
	}
	
	public Boolean isRightEmail(LoginVO loginVO) {

		System.out.println("Searching in DAO..");
		List list = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		Query query = session
				.createQuery("from LoginVO as r where r.email='"
						+ loginVO.getEmail() + "'");
		list = query.list();
		System.out.println("isRightMail list size :: " + list.size());
		tr.commit();

		System.out.println("HQL :- " + query);
		System.out.println("Searching in DAO Completed!");

		if (list.size() == 0) {
			System.out.println("returning false!");
			return false;
		} else {
			System.out.println("returning true!");
			return true;
		}
	}
	

	public List authentication(LoginVO loginVO) {
		List ls = new ArrayList();

		try {
			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();

			session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from LoginVO where userName='"
					+ loginVO.getUserName() + "'and password='"
					+ loginVO.getPassword() + "'");
			ls = q.list();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	public void update(LoginVO loginVO)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(loginVO);
			
			tr.commit();
			session.flush();
			session.close();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	public List complainAdmin() {
		List ls = new ArrayList();

		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session
					.createQuery("from LoginVO where userName = 'admin'");
						
			ls = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public List searchAllUser()
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from LoginVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}

}
