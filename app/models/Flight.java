package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
public class Flight extends Model{

    @Id
    public Long id;

    @ManyToMany(mappedBy = "flights")
    public List<User> user;

    @ManyToMany
    public List<Airplane> airplanes;

    @ManyToOne
    public Route route;

}
