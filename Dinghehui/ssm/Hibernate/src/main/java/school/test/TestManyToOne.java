package school.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import school.entity.Student;
import school.entity.Teacher;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by admin on 2017/6/14.
 */
public class TestManyToOne {
    public static  void main(String[] args){
        TestManyToOne test = new TestManyToOne();
        test.testAddStudent();
        test.testQuery();
    }
    public static void testAddStudent(){
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            addStudent(session);
//            addTeacher(session);
//            query(session);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    public static void testQuery(){
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
//            addStudent(session);
//            addTeacher(session);
            query(session);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    public static void addStudent(Session session){
        Teacher t = new Teacher();
        t.setTeaName("老李");
        Student stu = new Student();
        stu.setStuName("张三");
        stu.setTeacher(t);
        session.save(t);
        session.save(stu);
    }
    public static void query(Session session){
        Teacher t = (Teacher) session.get(Teacher.class,1L);
        Set<Student> s = t.getStudents();
        Iterator<Student> it = s.iterator();
        while(it.hasNext()){
            Student student = it.next();
            System.out.println(student.getId());
            System.out.println(student.getStuName());
        }
    }
}
