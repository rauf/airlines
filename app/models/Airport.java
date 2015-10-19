package models;


/**
 * Created by randomlocks on 10/20/2015.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Airport extends Model {

    @Id
    public Long id;

    @OneToOne(mappedBy = "airport")
    public Route route;

}
