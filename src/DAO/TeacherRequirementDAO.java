package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CategoryVO;
import VO.CityVO;
import VO.LoginVO;
import VO.MediumVO;
import VO.StandardVO;
import VO.StdAcaRequirementMappingVO;
import VO.StdNonAcaRequirementMappingVO;
import VO.StudentRequirementVO;
import VO.SubCategoryVO;
import VO.TeacherAcaRequirementMappingVO;
import VO.TeacherNonAcaRequirementMappingVO;
import VO.TeacherRequirementVO;


public class TeacherRequirementDAO {
	
	public List searchMedium(SubCategoryVO subCategoryVO) {
		List list = new ArrayList();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from MediumVO where subCategoryId="+subCategoryVO.getSubCategoryId());
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	public List searchStandard(MediumVO mediumVO) {
		List list = new ArrayList();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from StandardVO where mediumId="+mediumVO.getMediumId());
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	public List searchAcademicSubject(StandardVO standardVO) {
		List list = new ArrayList();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from AcademicSubjectVO where standardId="+standardVO.getStandardId());
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	public List searchNonAcademicSubject(SubCategoryVO subCategoryVO) {
		List list = new ArrayList();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from NonAcademicSubjectVO where subCategoryId="+subCategoryVO.getSubCategoryId());
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	public List searchArea(CityVO cityVO) {
		List list = new ArrayList();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from AreaVO where cityId="+cityVO.getCityId());
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	public void insertTeacherRequirement(TeacherRequirementVO teacherRequirementVO )
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(teacherRequirementVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	
	public void insertAcademicTeacherRequirementMapping(TeacherAcaRequirementMappingVO teacherAcaRequirementMappingVO)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(teacherAcaRequirementMappingVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	
	public void insertNonAcademicTeacherRequirementMapping(TeacherNonAcaRequirementMappingVO teacherNonAcaRequirementMappingVO)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(teacherNonAcaRequirementMappingVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	
	public List searchTeacherRequirement(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from TeacherRequirementVO where userId='"+loginVO.getUserId()+"' ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchTeacherAcaRequirement(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from TeacherAcaRequirementMappingVO where userId='"+loginVO.getUserId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	public List searchTeacherNonAcaRequirement(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from TeacherNonAcaRequirementMappingVO where userId='"+loginVO.getUserId()+"'");
			
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
