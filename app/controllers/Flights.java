package controllers;

import com.avaje.ebean.PagedList;
import models.Flight;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by randomlocks on 10/22/2015.
 */
public class Flights extends Controller {

    public Result list(int page) {
        PagedList<Flight> list = Flight.findPage(page, 10);
        //return ok(list.render);
        return TODO;
    }

    public Result newFlight() {
        return TODO;
    }

    public Result details(int id) {
        return TODO;
    }

    public Result save() {
        return TODO;
    }

    public Result delete(int id) {
        return TODO;
    }

}
