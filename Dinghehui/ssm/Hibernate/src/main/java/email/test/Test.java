package email.test;

import email.entity.UserMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by admin on 2017/6/14.
 */
public class Test {
    public static void main(String[] args) {
        // Configuration管理Hibernate配置
        Configuration config = new Configuration().configure();
        // 根据Configuration建立 SessionFactory
        // SessionFactory用来建立Session
        SessionFactory sessionFactory = config.buildSessionFactory();

        // 创建实例
        UserMap user1 = new UserMap();
        user1.setName("user1");
        user1.getEmails().put("no.1", "email1");
        user1.getEmails().put("no.2", "email2");

        UserMap user2 = new UserMap();
        user2.setName("user2");
        user2.getEmails().put("no.3", "email3");
        user2.getEmails().put("no.4", "email4");

        // 添加数据
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user1);
            session.save(user2);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        // 关闭sessionFactory
        sessionFactory.close();

    }

}
