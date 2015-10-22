package models;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.api.mvc.Result;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Admin extends Model{

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
    @Formats.DateTime(pattern = "dd-MM-yyyy")
    public Date dateOfBirth;

    @Constraints.Required
    public String securityAnswer;

    //derived from DOB
    public int age;

    @ManyToOne
    public SecurityQuestion securityQuestion;


    public static Finder<Long,Admin> find = new Finder<>(Admin.class);

    public Admin() {
        //left blank
    }

    public static PagedList<Admin> findPage(int page,int size) {
        return   find.where()
                .orderBy("id asc")
                .findPagedList(page,size);

    }

}
