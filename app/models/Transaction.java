package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction extends Model {

    @Id
    public Long id;

    @ManyToOne
    public User user;


    //relationship with passenger left

    public static Finder<Long,Transaction> find = new Finder<>(Transaction.class);

    public Transaction(){
        // left blank
    }

}
