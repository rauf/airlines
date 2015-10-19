package models.UnrelatedEntity;


/**
 * Created by randomlocks on 10/20/2015.
 */


import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Feedback extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String email;   //optional , no constraints

    @Constraints.Required
    @Constraints.MinLength(20)
    public String message;

    public String rating; //rating out of 10





}
