package annotation.IDcard.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 2017/6/15.
 */
@Entity
@Table(name = "IDCard")
public class IDCard implements Serializable {

    private Integer id;//流水号
    private String cardno;//身份证号码
    private Person person;//对应的人

    public IDCard() {
    }

    public IDCard(String cardno) {
        this.cardno = cardno;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, length = 18, unique = true)
    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    /**
     * @return
     * @OneToOne注释指明IDCard与Person为一对一关系，IDCard是关系被维护端，optional =  false设置person属性值不能为null，也就是身份证必须有对应的主人。
     * @JoinColumn(name =  "Person_ID",  referencedColumnName  ="personid",unique  =  true)指明IDCard对应表的Person_ID列作为外键与
     * Person对应表的personid列进行关联,unique=  true  指明Person_ID  列的值不可重复。
     */
    @OneToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Person_ID", referencedColumnName = "personid", unique = true)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

