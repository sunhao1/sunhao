package email.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/6/14.
 */
public class UserMap {
    // Fields
    private Integer id;
    private String name;
    private Map emails = new HashMap();

    // Constructors
    /** default constructor */
    public UserMap() {
    }

    /** full constructor */
    public UserMap(String name) {
        this.name = name;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getEmails() {
        return emails;
    }

    public void setEmails(Map emails) {
        this.emails = emails;
    }

}
