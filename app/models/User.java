package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.mvc.PathBindable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User extends Model implements PathBindable<User> {

    @Id
    public Long id;

    @Lob
    public byte[] picture;

    @Constraints.Required
    public String name;

    //@Constraints.Required
    @Constraints.Email
    public String email;

    @Constraints.MinLength(6)
    //@Constraints.Required
    public String password;

    //@Constraints.Required
    public String gender;

    public String addressLine1;

    public String addressLine2;

    // @Constraints.Min(6)
    //@Constraints.Max(6)
    public int pinCode;

    //@Constraints.Required
    public String contactNo;    // multivalued

    // @Constraints.Required
    @Formats.DateTime(pattern = "yyyy-MM-dd")
    public Date dateOfBirth;

    //derived from DOB
    public int age;

    @ManyToOne
    public SecurityQuestion securityQuestion;

    //@Constraints.Required
    public String securityAnswer;

    @ManyToMany
    public List<Flight> flights;

    @OneToMany(mappedBy = "user")
    public List<Transactionn> transactionns;

    @OneToMany(mappedBy = "user")
    public List<ContactUs> contactUses;

    public static Finder<Long, User> find = new Finder<>(User.class);

    public User() {
        // left blank
    }

    //For Paging
    public static PagedList<User> findPage(int page, int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page, size);

    }

    public static User getUser(String email, String password) {

        User user = null;
        try {
            user = find.where()
                    .eq("email", email)
                    .eq("password", password)
                    .findUnique();
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public static User getUserByEmail(String email) {
        User user = null;
        try {
            user = find.where()
                    .eq("email", email)
                    .findUnique();
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public static boolean userPresent(String email) {
        try {
            User user = find.where()
                    .eq("email", email)
                    .findUnique();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /////////////////////////Path Bindable//////////////////////////

    @Override
    public User bind(String s, String s1) {
        return find.byId(Long.parseLong(s1));
    }

    @Override
    public String unbind(String s) {
        return this.id.toString();
    }

    @Override
    public String javascriptUnbind() {
        return this.id.toString();
    }


    ///////////////////////////////////////////////////////////////

}
