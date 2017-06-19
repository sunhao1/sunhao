package annotation.school.entity;

import annotation.school.entity.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/14.
 */
@Entity
@Table(name="teacher",schema="school")
public class Teacher {
    private long id;
    private String teaName;
    private Set<Student> students = new HashSet<Student>();
    private Student student;

    @OneToOne
    @JoinColumn(name="stuID")
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="t_id",nullable = false,unique = true)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name="t_name")
    public String getTeaName() {
        return teaName;
    }
    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
    @Transient
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
