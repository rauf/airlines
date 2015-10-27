package models;


/**
 * Created by randomlocks on 10/20/2015.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;

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


    public static Finder<Long, Airport> find = new Finder<>(Airport.class);

    /***************************************ATTRIBUTES*********************************************/


    public String name;


    public String country;


    public String city;


    public String address; //optional




    public Airport(){
        // left blank
    }

/***************************************METHODS**************************************************/

public static PagedList findPage(int page , int index) {

    return find.where()
            .orderBy("id asc")
            .findPagedList(page,index);

}




}
