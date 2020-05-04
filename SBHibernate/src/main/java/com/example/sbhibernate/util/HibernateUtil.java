package com.example.sbhibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import javax.imageio.spi.ServiceRegistry;

/**
 * 单利模式 获取session
 */
public class HibernateUtil {

    public static void main(String[] args) {
    }

    private HibernateUtil () {}

    private static HibernateUtil hibernateUtil = null;

    public static HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }

    /**
     * 提供获取SessionFactory的获取方法
     * @return SessionFactory
     */
    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = (ServiceRegistry) configuration.getStandardServiceRegistryBuilder().build();
        SessionFactory sessionFactory = new MetadataSources((org.hibernate.service.ServiceRegistry) serviceRegistry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    public Session getSession() {
        return getSessionFactory().getCurrentSession();
    }
}
