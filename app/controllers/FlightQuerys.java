package controllers;

import com.avaje.ebean.PagedList;
import com.avaje.ebean.SqlRow;
import models.FlightQuery;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.User.flightquery.flightdblist;
import views.html.User.flightquery.newflightquery;
import views.html.User.flightquery.flightqueryredirect;
import views.html.User.flightquery.flightlist;

import java.util.Date;
import java.util.List;

/**
 * Created by randomlocks on 10/23/2015.
 */
public class FlightQuerys extends Controller {


    public static Date date;
    public static String reg;
    public static String source;
    public static String destination;
    // public static String ;


    Form<FlightQuery> flightQueryForm = Form.form(FlightQuery.class);

    public Result list(int page) {
        //PagedList<FlightQuery> list = FlightQuery.findPage(page, 10,date);

        List<SqlRow> list = FlightQuery.findQuery(page, 10, source, destination, date);


        // for(SqlRow l : list)
        //{
        //reg+=l.getString("reg_no");


        //}

        return ok(flightlist.render(list));


    }

    public Result newFlightQuery() {

        return ok(newflightquery.render(flightQueryForm));
    }

    public Result details(int page) {

        PagedList<FlightQuery> list = FlightQuery.findPage(page, 10);

        return ok(flightdblist.render(list));

    }

    public Result save() {


        Form<FlightQuery> form = flightQueryForm.bindFromRequest();
        FlightQuery flightQuery = form.get();
        date = flightQuery.depart_date;
        source = flightQuery.source;
        destination = flightQuery.destination;

        Passengers.total_passenger = flightQuery.adult + flightQuery.children + flightQuery.infant;
        Transactionns.date = flightQuery.depart_date;


        flightQuery.save();

        return ok(flightqueryredirect.render());

    }

    public Result delete(int id) {
        return TODO;
    }


}
