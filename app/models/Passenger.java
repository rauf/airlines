package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passenger extends Model{

    @Id
    public Long id;


    //relationship with Transaction left


    public static Finder<Long,Passenger> find = new Finder<>(Passenger.class);

    public Passenger(){
        // left blank
    }
}
