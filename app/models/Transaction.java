package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Transaction extends Model {

    @Id
    public Long id;





    public Date date=new Date();

    public String mode;


    public int amount;

    @ManyToOne
    public User user;

    @ManyToMany
    public List<Passenger> passengers;

    public static Finder<Long, Transaction> find = new Finder<>(Transaction.class);

    public Transaction(){
        // left blank
    }


    public static PagedList<Transaction> findPage(int page,int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page,size);

    }

}
