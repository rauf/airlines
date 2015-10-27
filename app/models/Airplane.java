package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;

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

    public static Finder<Long, Airplane> find = new Finder<>(Airplane.class);


    /**************************** ATTRIBUTES ************************************************/

    public String reg_no;  // Registration number-mix of alphabet and number



    public String type;


    public String total_seat;






    public Airplane(){
        // left blank
    }


 /**************************************METHODS***************************************************/

 public static PagedList findPage(int page , int index) {

     return find.where()
             .orderBy("id asc")
             .findPagedList(page,index);

 }














}



