package models;


/**
 * Created by abdul on 10/19/15.
 */


import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SecurityQuestion extends Model{

    @Id
    public Long id;

    @Constraints.Required
    public String question;

    @OneToMany(mappedBy = "securityQuestion")
    List<User> users;



    public static Finder<Long,SecurityQuestion> find = new Finder<>(SecurityQuestion.class);

    public SecurityQuestion(){
        // left blank
    }
}
