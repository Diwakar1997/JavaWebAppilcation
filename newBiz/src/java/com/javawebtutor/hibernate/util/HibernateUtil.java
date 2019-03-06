package com.javawebtutor.hibernate.util;


import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.javawebtutor.model.User;

public class HibernateUtil {

    private static SessionFactory factory;

    public static SessionFactory initSessionFactory() {
        try {
            if (factory == null) {
                Configuration config = new Configuration();
                config.addAnnotatedClass(User.class);
                
                config.configure();

                Properties properties = config.getProperties();
                ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
                ServiceRegistry serviceRegistry = serviceRegistryBuilder.applySettings(properties).build();

                factory = config.buildSessionFactory(serviceRegistry);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("|ERROR -------------> initsessionfactory   catch block");
            if (factory != null && !factory.isClosed()) {
                factory.close();
            }
        }
        return factory;
    }

    public static Session getSession() {
        Session session = null;
        if (factory == null) {
            session = initSessionFactory().openSession();
        } else {
            session = factory.openSession();
        }
        return session;
    }

    public static void closeFactory() {
        if (factory != null && !factory.isClosed()) {
            factory.close();
            factory = null;
        }
    }
}