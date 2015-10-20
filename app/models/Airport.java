package models;


/**
 * Created by randomlocks on 10/20/2015.
 */

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Airport extends Model {

    /***************************************RELATIONS*********************************************/

    @Id
    public Long id;

    @OneToOne(mappedBy = "airport")
    public Route route;


    public static Finder<Long,Airport> find = new Finder<>(Airport.class);

    /***************************************ATTRIBUTES*********************************************/

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String country;

    @Constraints.Required
    public String city;


    public String address; //optional




    public Airport(){
        // left blank
    }
}
