package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ApplyVO;
import VO.ComplainVO;
import VO.LoginVO;

public class ApplyDAO {

	public void Apply(ApplyVO applyVO) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(applyVO);

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}

	}
	
	
	public List findAppliedStudent(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
		
			
			Query w=session.createQuery("from ApplyVO where teacherId='"+loginVO.getUserId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchApplyDetails(LoginVO loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
		
			
			Query w=session.createQuery("from ApplyVO where studentId='"+loginVO.getUserId()+"' ");
			
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
