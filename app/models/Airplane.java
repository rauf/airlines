package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


/**
 * Created by randomlocks on 10/20/2015.
 */

@Entity
public class Airplane extends Model {
/********************************RELATIONS******************************************************/
    @Id
    public Long id;

    @ManyToMany(mappedBy = "airplanes")
    public List<Flight> flights;

    public static Finder<Long,Airplane> find = new Finder<>(Airplane.class);


    /**************************** ATTRIBUTES ************************************************/
    @Constraints.Required
    public String reg_no;  // Registration number-mix of alphabet and number


    @Constraints.Required
    public String type;

    @Constraints.Required
    public String total_seat;






    public Airplane(){
        // left blank
    }
}
