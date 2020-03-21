package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.LoginVO;
import VO.NonAcademicSubjectVO;
import VO.StandardVO;
import VO.StudentRegistrationVO;
import VO.SubCategoryVO;
import VO.TeacherRegistrationVO;


public class TeacherRegistrationDAO {
	
	
	/*public List searchByEmail(String to) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		try {

			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionfactory.openSession();

			Query q = session.createQuery("from TeacherRegistrationVO teacherRegistrationVO where email='"+to+"'");

			ls = q.list();
			System.out.println(ls.size());
			System.out.println("Done");
			// session.flush();
			// session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return ls;
		
	}*/
	
	
	public List searchTeacherDetails(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from TeacherRegistrationVO where userId="+loginVO.getUserId());
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	

	public void updateTeacherRegistration(TeacherRegistrationVO teacherRegistrationVO)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(teacherRegistrationVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	
	/*public Boolean isRightEmail(TeacherRegistrationVO teacherRegistrationVO) {

		System.out.println("Searching in DAO..");
		List list = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		Query query = session
				.createQuery("from TeacherRegistrationVO as r where r.email='"
						+ teacherRegistrationVO.getEmail() + "'");
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
	public void insertUserPassword(LoginVO loginVO)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(loginVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	public void insertTeacherDetails(TeacherRegistrationVO teacherRegistrationVO)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(teacherRegistrationVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	
	public List searchTeacher()
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from TeacherRegistrationVO");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchTeacherName(SubCategoryVO subCategoryVO, StandardVO standardVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from TeacherRequirementVO as teacherReq where teacherReq.teacherRequirementId in (select teacherAcaReqMapping.teacherRequirementVO from TeacherAcaRequirementMappingVO as teacherAcaReqMapping where teacherAcaReqMapping.standardVO='"+standardVO.getStandardId()+"' ) ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	
	
	public List searchTeacherNameForNonAcademicCategory(NonAcademicSubjectVO nonAcademicSubjectVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from TeacherRequirementVO as teacherReq where teacherReq.teacherRequirementId in (select teacherNonAcaReq.teacherRequirementVO from TeacherNonAcaRequirementMappingVO as teacherNonAcaReq where teacherNonAcaReq.nonAcademicSubjectVO='"+nonAcademicSubjectVO.getNonAcademicSubjectId()+"' ) ");
			
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
