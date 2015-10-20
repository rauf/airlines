package models;

/**
 * Created by randomlocks on 10/20/2015.
 */


import com.avaje.ebean.Model;
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

    @Constraints.Required
    public int amount;

    @Constraints.Required
    public String description;   // a brief description related to Fare charge

    @Constraints.Required
    public String condition;   //fare condition like mode of payment or Minimum age etc .


    public Fare(){
        // left blank
    }
}

