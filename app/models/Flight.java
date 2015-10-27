package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;


@Entity
public class Flight extends Model{

    @Id
    public Long id;

    @Constraints.Required
    @Formats.DateTime(pattern = "DD-MM-YYYY")
    public Date departDate;           //stores date and time

   /*  will add later for round trip

   @Constraints.Required
    @Formats.DateTime(pattern = "DD:MM:YYYY")
    public Date returnDate; */


    @Formats.DateTime(pattern = "HH:mm:ss")
    public Date arrivalTime;


    @Formats.DateTime(pattern = "HH:mm:ss")
    public Date departureTime;

    @ManyToMany(mappedBy = "flights")
    public List<User> user;

    @ManyToMany
    public List<Airplane> airplanes;

    @ManyToOne
    public Route route;


    public static Finder<Long, Flight> find = new Finder<>(Flight.class);

    public Flight(){
        // left blank
    }

/*********************************METHOD*****************************************/

public static PagedList findPage(int page , int index) {

    return find.where()
            .orderBy("id asc")
            .findPagedList(page,index);

}




}
