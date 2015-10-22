package models;

/**
 * Created by randomlocks on 10/20/2015.
 */


import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Fare extends Model {

    @Id
    public Long id;

    @OneToMany(mappedBy = "fare")
    public List<Route> routes;


    public static Finder<Long,Fare> find = new Finder<>(Fare.class);


    /**************************************************ATTRIBUTES*********************************************/


    public int amount;


    public String description;   // a brief description related to Fare charge


    public String condition;   //fare condition like mode of payment or Minimum age etc .


    public Fare(){
        // left blank
    }

/**************************************************METHODS******************************************************/


 public static PagedList findPage(int page , int index) {

     return find.where()
             .orderBy("id asc")
             .findPagedList(page,index);

 }


}

