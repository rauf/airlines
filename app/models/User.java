package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User extends Model {

    @Id
    public Long id;

    public byte[] picture;

    @Constraints.Required
    public String name;

    @Constraints.MinLength(6)
    @Constraints.Required
    public String password;

    @Constraints.Required
    public String gender;

    public String addressLine1;

    public String addressLine2;

    @Constraints.Min(6)
    @Constraints.Max(6)
    public int pincode;

    @Constraints.Required
    public String contactNo;    // multivalued

    @Constraints.Required
    @Constraints.Email
    public String email;

    @Constraints.Required
    @Formats.DateTime(pattern = "dd-MM-yyyy")
    public Date dateOfBirth;

    //derived from DOB
    public int age;

    @ManyToOne
    public SecurityQuestion securityQuestion;

    @Constraints.Required
    public String securityAnswer;

    @ManyToMany
    public List<Flight> flights;

    @OneToMany(mappedBy = "user")
    public List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    public List<Complaint> complaints;

    public static Finder<Long,User> find = new Finder<>(User.class);

    public User(){
        // left blank
    }

    //For Paging
    public static PagedList<User> findPage(int page,int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page,size);

    }

}
