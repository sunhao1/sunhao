package school.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import annotation.school.entity.Course;
import school.entity.Student;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by admin on 2017/6/14.
 */
public class TestManyToMany {
    public static  void main(String[] args){
        TestManyToMany test = new TestManyToMany();
        test.testAdd();
        test.testQuery();
    }
    public static void testAdd(){
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = null;
        try{
            session = factory.openSession();
            session.beginTransaction();
            add(session);
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
//            add(session);
            query(session);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    private static void query(Session session) {
        Course math = (Course) session.get(Course.class,"001");
        Set<Student> studentSet=math.getStudentSet();
        Iterator<Student> it = studentSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getStuName());
        }
        Student s1 = (Student)session.get(Student.class,2L);
        Set<Course> courseSet = s1.getCourses();
        Iterator<Course> itc = courseSet.iterator();
        while(itc.hasNext()){
            System.out.println(itc.next().getCourseName());
        }
    }

    private static void add(Session session) {
         Course math = new Course();
         math.setCourseID("001");
         math.setCourseName("数学");
         Course artist = new Course();
         artist.setCourseID("002");
         artist.setCourseName("艺术");
         Course computer = new Course();
         computer.setCourseID("003");
         computer.setCourseName("计算机");
        Student  s1 = new Student();
        s1.setStuName("星矢");
        Student s2 = new Student();
        s2.setStuName("雅典娜");
        Student s3 = new Student();
        s3.setStuName("旋涡鸣人");
        math.getStudentSet().add(s1);
        math.getStudentSet().add(s3);
        computer.getStudentSet().add(s2);
        s1.getCourses().add(math);
        s2.getCourses().add(computer);
        s3.getCourses().add(math);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(math);
        session.save(artist);
        session.save(computer);
    }
}
