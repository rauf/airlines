package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.text.StringFormatter;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
public class Flight extends Model{

    @Id
    public Long id;

    @ManyToMany(mappedBy = "flights")
    public List<User> user;

    @ManyToMany
    public List<Airplane> airplanes;

    @ManyToOne
    public Route route;



    public static Finder<Long,Flight> find = new Finder<>(Flight.class);


    /*****************************ATTRIBUTES***************************/
    @Constraints.Required
    public String flight_no; //mix of alphabet and number

    @Constraints.Required
    public String arrival_time;

    @Constraints.Required
    public String arrival_date;

    @Constraints.Required
    public String dest_time;

    @Constraints.Required
    public String dest_date;

    public String travel_time; //derived attribute





    public Flight(){
        // left blank
    }
}
