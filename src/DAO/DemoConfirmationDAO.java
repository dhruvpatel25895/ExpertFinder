package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ApplyVO;
import VO.ComplainVO;

import VO.DemoVO;
import VO.LoginVO;

public class DemoConfirmationDAO {

	/*public void InsertDemoConfirmation(DemoConfirmationVO demoConfirmationVO) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(demoConfirmationVO);

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
*/
	}
	
	/*public List searchDemoConfirmationDetails(DemoVO demoVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
		
			
			Query w=session.createQuery("from DemoConfirmationVO where demoConfirmationId='"+demoVO.getDemoId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}*/
	
	

