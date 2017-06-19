package annotation.IDcard.entity;

/**
 * Created by admin on 2017/6/15.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 关系维护端Person.java
 */
@Entity
@Table(name = "Person")
public class Person implements Serializable {

    private Integer personid;//人员ID
    private String name;// 姓名
    private boolean sex;//性别
    private Short age;//年龄
    private Date birthday;//生日
    private IDCard idcard;//身份证号码

    @Id
    @GeneratedValue
    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    @Column(name = "PersonName", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Column(nullable = false)
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    /*
* @Temporal主要是用来指明java.util.Date 或 java.util.Calendar 类型的属性具体与数据库（date,time,timestamp）三个类型中的那一个进行映射
*/
    @Temporal(value = TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /*
* @OneToOne注释指明Person 与IDCard为一对一关系，@OneToOne注释五个属性：targetEntity、cascade、fetch、optional 和mappedBy，
*fetch属性默认值是FetchType.EAGER。optional = true设置idcard属性可以为null,也就是允讦没有身份证，未成年人就是没有身份证的。
*
*targetEntity属性:Class类型的属性。定义关系类的类型，默认是该成员属性对应的类类型，所以通常不需要提供定义。
*cascade属性：CascadeType[]类型。该属性定义类和类之间的级联关系。定义的级联关系将被容器视为对当前类对象及其关联类对象采取相同的操作，
*而且这种关系是递归调用的。cascade的值只能从CascadeType.PERSIST（级联新建）、CascadeType.REMOVE（级联删除）、
*CascadeType.REFRESH（级联刷新）、CascadeType.MERGE（级联更新）中选择一个或多个。还有一个选择是使用CascadeType.ALL，表示选择全部四项。
*
*fetch属性：FetchType类型的属性。可选择项包括：FetchType.EAGER 和FetchType.LAZY。
*FetchType.EAGER表示关系类(本例是OrderItem类)在主类加载的时候同时加载，FetchType.LAZY表示关系类在被访问时才加载。默认值是FetchType.LAZY。
*
*@OrderBy(value = "id ASC")注释指明加载元组时按id的升序排序（降序 "DESC"）
*/
    @OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "person")
    public IDCard getIdcard() {
        return idcard;
    }

    public void setIdcard(IDCard idcard) {
        this.idcard = idcard;
    }
}