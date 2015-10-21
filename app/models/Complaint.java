package models;

/**
 * Created by abdul on 10/19/15.
 */


import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.data.validation.Constraints;
import scala.collection.immutable.Page;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
public class Complaint extends Model{

    @Id
    public Long id;

    public String topic;

    @Constraints.Required
    public String description;

    @Constraints.Required
    public String date;

    @ManyToOne
    public User user;




    public static Finder<Long,Complaint> find = new Finder<>(Complaint.class);

    public Complaint(){
        // left blank
    }

    public static PagedList<Complaint> findPage(int page,int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page,size);

    }








}
