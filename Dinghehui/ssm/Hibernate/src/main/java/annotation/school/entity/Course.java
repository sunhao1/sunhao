package annotation.school.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/14.
 */
public class Course {
    private String courseID;
    private String courseName;
    private String StudentID;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    private Set<school.entity.Student> studentSet = new HashSet<school.entity.Student>();

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<school.entity.Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<school.entity.Student> studentSet) {
        this.studentSet = studentSet;
    }
}
