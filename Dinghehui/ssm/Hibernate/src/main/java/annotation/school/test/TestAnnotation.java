package annotation.school.test;


import annotation.school.entity.Student;
import annotation.school.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by admin on 2017/6/15.
 */
public class TestAnnotation {
    public static void main(String[] args){
        TestAnnotation test = new TestAnnotation();
        test.save();
        test.oneToOne();
    }

    private void oneToOne() {
        Configuration cfg = new AnnotationConfiguration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            query(session);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
    }

    private void query(Session session) {
        Teacher t = (Teacher)session.get(Teacher.class,1L);
        Student stu = t.getStudent();
        System.out.println(stu.getStuName());
        Student s = (Student)session.get(Student.class,1L);
        Teacher teacher = s.getTeacher();
        System.out.println(teacher.getTeaName());
    }

    private void save() {
        Configuration cfg = new AnnotationConfiguration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            saveStu(session);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if(session != null){
                if(session.isOpen()){
                    session.close();
                }
            }
        }
    }

    private void saveStu(Session session) {
        Student stu = new Student();
        stu.setStuName("凤姐");
        stu.setcID("001");
        Teacher t = new Teacher();
        t.setStudent(stu);
        t.setTeaName("潇洒哥");
        session.save(stu);
        session.save(t);
    }
}
