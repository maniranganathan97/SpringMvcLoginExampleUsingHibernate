//package com.springDemo;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//
//	public boolean testUser(String userName, String pass) {
//		try {
//			StandardServiceRegistry service = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
//					.build();
//
//			Metadata metadata = new MetadataSources(service).getMetadataBuilder().build();
//
//			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//			
//			Session session = sessionFactory.openSession();
//			
//			Transaction tx = session.beginTransaction();
//			
//			String sql = "FROM User where username ="+userName +" password="+pass;
//			Query q= session.createQuery(sql);
//			List result =q.list();
//			if(result!=null){
//				return true;
//			}
//			else{
//				return false;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return false;
//		
//	}
//
//}
