package school.entity;

import annotation.school.entity.Course;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/14.
 */
public class Student {
    private long id;
    private String stuName;
    private Teacher teacher;
    private String cID;
    private Set<Course> courses = new HashSet<Course>();

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String toString() {
        return "student:[studentId=" + this.id + "/tstudentName="
                + this.stuName + "]";
    }
}
