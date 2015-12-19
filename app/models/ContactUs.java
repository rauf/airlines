package models;

/**
 * Created by abdul on 10/19/15.
 */


import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
public class ContactUs extends Model{

    @Id
    public Long id;

    public String subject;

    @Lob
    @Constraints.Required
    public String description;

    public Date date;

    @ManyToOne
    public User user;


    public static Finder<Long, ContactUs> find = new Finder<>(ContactUs.class);

    public ContactUs(){
        // left blank
    }

    public  PagedList<ContactUs> findPage(int page,int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page,size);
    }








}
