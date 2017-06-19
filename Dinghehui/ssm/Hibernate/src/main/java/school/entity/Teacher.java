package school.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/14.
 */
public class Teacher {
    private long id;
    private String teaName;
    private Set<Student> students = new HashSet<Student>();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTeaName() {
        return teaName;
    }
    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Set getStudents() {
        return students;
    }
    public void setStudents(Set students) {
        this.students = students;
    }
    public String toString() {
        return "Teacher:[teacherId=" + this.id + "/tteacherName="
                + this.teaName + "]";
    }
}
