package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


/**
 * Created by randomlocks on 10/20/2015.
 */

@Entity
public class Airplane extends Model {


 @Id
 public Long id;

 @ManyToMany(mappedBy = "airplanes")
 public List<Flight> flights;









}
