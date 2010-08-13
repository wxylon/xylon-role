package test;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.role.pojo.Tauth;
import org.role.pojo.Torganization;
import org.role.pojo.Trole;
import org.role.pojo.Tuser;

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
	
	public static void testUser(){
		Session session = sessionFactory.openSession();
		Set set = new HashSet();
		Tuser tuser = new Tuser();
		tuser.setUserName("xiaoqi");
		tuser.setCreateTime(new Date());
		tuser.setEmail("1@g.com");
		tuser.setLastLoginTime(new Date());
		tuser.setLoginCount(0);
		tuser.setPassWord("000000");
		tuser.setVserName("测试");
		tuser.setLoginTime(new Date());
		set.add(tuser);
		Torganization torganization = new Torganization();
		torganization.setToName("技术部");
		torganization.setCreateTime(new Date());
		torganization.setDescription("测试用例");
		torganization.setToParentId(0);
//		torganization.setTusers(set);
		Transaction tr = session.beginTransaction();
		tuser.setTorganization(torganization);
		tr.begin();
		session.save(torganization);
		session.save(tuser);
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
		testUser();

	}

}

