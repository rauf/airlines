package models;

/**
 * Created by randomlocks on 10/20/2015.
 */


import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Fare extends Model {

    @Id
    public Long id;

    @OneToMany(mappedBy = "fare")
    public List<Route> routes;


    public static Finder<Long,Fare> find = new Finder<>(Fare.class);
}
