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
import VO.MediumVO;

public class DemoDAO {

	public void InsertDemoDetail(DemoVO demoVO) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(demoVO);

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}

	}

	public List searchDemoDetails(LoginVO loginVO) {
		List l = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			Query w = session.createQuery("from DemoVO where teacherId='"
					+ loginVO.getUserId() + "'");

			l = w.list();

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
		return l;
	}
/*	Start new code*/
	
	/*public List searchDemoDetailsForStd(DemoVO demoVO) {
		List l = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			Query w = session.createQuery("from DemoVO where demoId='"
					+ demoVO.getDemoId() + "'");

			l = w.list();

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
		return l;
	}*/
/*	end new code*/

	public List findDemoDetailsForStudent(LoginVO loginVO) {
		List l = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			Query w = session.createQuery("from DemoVO where studentId='"
					+ loginVO.getUserId() + "'");

			l = w.list();

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
		return l;
	}
	public List findDemoDetailsForTeacher(LoginVO loginVO) {
		List l = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			Query w = session.createQuery("from DemoVO where teacherId='"
					+ loginVO.getUserId() + "'");

			l = w.list();

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
		return l;
	}

	public void updateDemoDetails(DemoVO demoVO) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.saveOrUpdate(demoVO);

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	public List findDemoDetailsForTeacher(DemoVO demoVO) {
		List l = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			Query w = session.createQuery("from DemoVO where demoId='"+demoVO.getDemoId()+"'");

			l = w.list();

			tr.commit();
		} catch (Exception z) {
			z.printStackTrace();
		}
		return l;
	}

}
