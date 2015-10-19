package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Suggestion extends Model{

    @Id
    public Long id;

    public String topic;

    @Constraints.Required
    public String description;

    @Constraints.Required
    public String date;


    public static Finder<Long,Suggestion> find = new Finder<>(Suggestion.class);

    public Suggestion(){
        // left blank
    }
}
