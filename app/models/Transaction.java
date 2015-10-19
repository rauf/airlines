package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by abdul on 10/19/15.
 */
@Entity
public class Transaction extends Model {

    @Id
    public Long id;

    @ManyToOne
    public User user;


    //relationship with passenger left


}
