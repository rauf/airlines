package models;


/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
public class Flight extends Model{

    @Id
    public Long id;

    @ManyToMany(mappedBy = "flight")
    public List<User> user;

}
