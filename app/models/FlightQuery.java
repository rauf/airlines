package models;

import com.avaje.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;
import java.util.List;

/*
 * Created by randomlocks on 10/23/2015.
 */

@Entity
public class FlightQuery extends Model {

@Id
public Long id;


 public Date depart_date= new Date();


    public String source;

    public String destination;

    public int adult;

    public int children;

    public int infant;


/******************************Constructor*****************************************/
    public FlightQuery() {

    }

 /*****************************Method************************************************/

    public static Finder<Long,FlightQuery> find = new Finder<>(FlightQuery.class);



    public static List<SqlRow> findQuery(int page , int index, String source , String destination , Date date) {

        /* sql query need updation for airport_id and fare_id */

        String sql = "select DISTINCT airplane.id,airplane.reg_no,airplane.type,airplane.total_seat,source,destination,depart_date,amount from airplane,routee,flight,fare,airport ,flight_airplane   where airplane.id IN  (select AIRPLANE_ID  from FLIGHT_AIRPLANE where FLIGHT_ID IN (select id from flight where depart_date= :date \n" +
                "AND ROUTE_ID IN (select id from routee where source= :first and destination= :destination and airport_id IN (select id from airport where CITY= :first OR COUNTRY= :first) AND fare_id IN (select id from fare) ))\n" +
                ") and source= :first  and destination= :destination and depart_date= :date   ;";

        SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
        sqlQuery.setParameter("first",source);
        sqlQuery.setParameter("destination",destination);
        sqlQuery.setParameter("date",date);

        return  sqlQuery.findList();

    }


    public static PagedList findPage(int page , int index) {

        return find.where()
                .orderBy("id asc")
                .findPagedList(page,index);

    }


}
