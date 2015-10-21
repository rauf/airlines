package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

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

    @Constraints.Required
    public Airport from;

    @Constraints.Required
    public Airport to;

    @Formats.DateTime(pattern = "dd-MM-yyyy")
    public Date date;

    public String modeOfPayment;

    @Constraints.Required
    public int amount;

    @ManyToOne
    public User user;

    @ManyToMany
    public List<Passenger> passengers;

    public static Finder<Long,Transaction> find = new Finder<>(Transaction.class);

    public Transaction(){
        // left blank
    }


    public static List<Transaction> findPage(int page,int size) {
        return find.where()
                .orderBy("id asc")
                .findPagedList(page,size)
                .getList();
    }

}
