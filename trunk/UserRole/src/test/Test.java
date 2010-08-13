package test;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.role.pojo.Tauth;
import org.role.pojo.Trole;

public class Test {

	private static SessionFactory  sessionFactory ;
	static{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	
	public static void testInsert(){
		Session session = sessionFactory.openSession();
		
		Set set = new HashSet(0);
		Tauth tauth = new Tauth();
		tauth.setTaName("ADMIN");
		tauth.setDescription("测试权限1");
		tauth.setTaParentId(0);
		
		Tauth tauth2 = new Tauth();
		tauth2.setTaName("ANYMOUSE");
		tauth2.setDescription("测试权限2");
		tauth2.setTaParentId(0);
		
		set.add(tauth);
		set.add(tauth2);
		Trole trole = new Trole();
		trole.setCreateTime(new Date());
		trole.setDescription("测试角色");
		trole.setParentTrId(0);
		trole.setTrName("管理员");
		trole.setTauths(set);
		Transaction tr = session.beginTransaction();
		tr.begin();
		session.save(trole);
		tr.commit();
		session.close();
	}
	
	public static void testQuery(){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		tr.begin();
		Trole trole = (Trole)session.get(Trole.class, 12);
		System.out.println(trole.getTauths().size());
		tr.commit();
		session.close();
	}
	public static void main(String[] args) {
		
		//test01();
		//test02();
		//test03();
		//test04();
//		testQuery();
		testInsert();

	}

}

