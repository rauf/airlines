package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
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

    public String address;

    @Constraints.Required
    public String contactNo;    // multivalued

    @Constraints.Required
    @Constraints.Email
    public String email;

    @Constraints.Required
    public String dateOfBirth;

    @Constraints.Required
    public String securityAnswer;

    //derived from DOB
    public int age;

    @ManyToOne
    public SecurityQuestion securityQuestion;

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

}
