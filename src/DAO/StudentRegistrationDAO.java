package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CityVO;
import VO.LoginVO;
import VO.StudentRegistrationVO;

public class StudentRegistrationDAO {
	
	
	
	public List searchStudentDetails(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from StudentRegistrationVO where userId="+loginVO.getUserId());
			
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

			Query q = session.createQuery("from StudentRegistrationVO studentRegistrationVO where email='"+to+"'");

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

	public void updateStudentRegistration(StudentRegistrationVO studentRegistrationVO)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(studentRegistrationVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	

	/*public Boolean isRightEmail(StudentRegistrationVO studentRegistrationVO) {

		System.out.println("Searching in DAO..");
		List list = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		Query query = session
				.createQuery("from StudentRegistrationVO as r where r.email='"
						+ studentRegistrationVO.getEmail() + "'");
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
*/
	public void insertUserPassword(LoginVO loginVO) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(loginVO);

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	public void insertStudentDetails(StudentRegistrationVO studentRegistrationVO) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(studentRegistrationVO);

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
	}
	
	public List searchSubCategoryForStudent(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from StdNonAcaRequirementMappingVO where userId='"+loginVO.getUserId()+"'");
			
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
