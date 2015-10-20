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
import java.util.Date;
import java.util.List;

@Entity
public class Passenger extends Model{

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    @Formats.DateTime(pattern = "mm-MM-yyyy")
    public Date dateOfBirth;

    public int age;     //derived from DOB

    public String gender;

    @ManyToMany(mappedBy = "passengers")
    public List<Transaction> transactions;

    public static Finder<Long,Passenger> find = new Finder<>(Passenger.class);

    public Passenger(){
        // left blank
    }
}
