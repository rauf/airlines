package models;

/**
 * Created by abdul on 10/19/15.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
public class Complaint extends Model{

    @Id
    public Long id;

    @ManyToOne
    public User user;

}
