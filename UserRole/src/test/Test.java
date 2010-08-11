package test;


import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
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
	
	/*
	public static void test01(){
		Session session = sessionFactory.openSession();
		String HQL = "from Menu ";
		Query query = session.createQuery(HQL);
		List menulist = query.list();
		for(int i=0;i<menulist.size();i++){
			Menu menu = (Menu)menulist.get(i);
			System.out.println("menu name=" + menu.getMenuName());
			System.out.println("menu id=" + menu.getMenuId());
			System.out.println("-----------------------------------");
			Set set = menu.getActions();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()){
				Action action = (Action)iterator.next();
				System.out.println("action name="+action.getActionName());
				System.out.println("action id="+action.getActionId());
			}
		}
		
	}
	
	public static void test02(){
		Session session = sessionFactory.openSession();
		String HQL = "from Menu ";
		Query query = session.createQuery(HQL);
		List menulist = query.list();
		for(int i=0;i<menulist.size();i++){
			Menu menu = (Menu)menulist.get(i);
			System.out.println("menu name=" + menu.getMenuName());
			System.out.println("menu id=" + menu.getMenuId());
			System.out.println("-----------------------------------");
			List list = menu.getActions();
			for(int k=0;k<list.size();k++){
				Action action = (Action)list.get(k);
				if(action !=null){
					System.out.println("action name="+action.getActionName());
					System.out.println("action id="+action.getActionId());
				}
			}
		}
		
	}
	public static void test03(){
		Session session = sessionFactory.openSession();
		String HQL = "from Menu ";
		Query query = session.createQuery(HQL);
		List menulist = query.list();
		for(int i=0;i<menulist.size();i++){
			Menu menu = (Menu)menulist.get(i);
			System.out.println("menu name=" + menu.getMenuName());
			System.out.println("menu id=" + menu.getMenuId());
			System.out.println("-----------------------------------");
			Map  map = menu.getActions();
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry entry = (Entry)iterator.next();
				Action action = (Action)entry.getValue();
				System.out.println("action name="+action.getActionName());
				System.out.println("action id="+action.getActionId());
			}
		}
		
	}
	
	
	public static void test04(){
		Session session = sessionFactory.openSession();
		String HQL = "from Menu ";
		Query query = session.createQuery(HQL);
		List menulist = query.list();
		for(int i=0;i<menulist.size();i++){
			Menu menu = (Menu)menulist.get(i);
			System.out.println("menu name=" + menu.getMenuName());
			System.out.println("menu id=" + menu.getMenuId());
			System.out.println("-----------------------------------");
			Collection  collection = menu.getActions();
			Iterator iterator = collection.iterator();
			while(iterator.hasNext()){
				Action action = (Action)iterator.next();
				System.out.println("action name="+action.getActionName());
				System.out.println("action id="+action.getActionId());
			}
		}
		
	}
	public static void test05(){
		Session session = sessionFactory.openSession();
		String HQL = "from Menu ";
		Query query = session.createQuery(HQL);
		List menulist = query.list();
		for(int i=0;i<menulist.size();i++){
			Menu menu = (Menu)menulist.get(i);
			System.out.println("menu name=" + menu.getMenuName());
			System.out.println("menu id=" + menu.getMenuId());
			System.out.println("-----------------------------------");
			Action[] actions = menu.getActions();
			for(int k=0;k<actions.length;k++){
				Action action = actions[k];
				if(action!=null){
					
					System.out.println("action name="+action.getActionName());
					System.out.println("action id="+action.getActionId());
				}
			}
		}
		
	}
	*/
	
	
//	public static void test06(){
//		Session session = sessionFactory.openSession();
//		String HQL = "from Tuser ";
//		Query query = session.createQuery(HQL);
//		List rolelist = query.list();
//		for(int i=0;i<rolelist.size();i++){
//			Tuser user = (Tuser)rolelist.get(i);
//			System.out.println("Tuser name=" + user.getUserName());
//			System.out.println("-----------------------------------");
//			Set set = user.getTroles();
//			Iterator iterator = set.iterator();
//			while(iterator.hasNext()){
//				Trole action = (Trole)iterator.next();
//				if(action != null){
//					System.out.println("Trole name="+action.getTrName());
//				}
//			}
//		}
//		
//	}
	
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
	public static void main(String[] args) {
		
		//test01();
		//test02();
		//test03();
		//test04();
		//test05();
		testInsert();

	}

}

