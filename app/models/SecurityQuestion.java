package models;


/**
 * Created by abdul on 10/19/15.
 */


import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
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

    public static PagedList<SecurityQuestion> findPage(int page,int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page,size);
    }

    public static List<SecurityQuestion> forDB() {
        return find.all();
    }

}
