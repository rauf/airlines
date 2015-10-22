package controllers;

import com.avaje.ebean.PagedList;
import models.Fare;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by randomlocks on 10/22/2015.
 */
public class Fares extends Controller {






    public Result list(int page) {
        PagedList<Fare> list = Fare.findPage(page, 10);
        //return ok(list.render);
        return TODO;
    }

    public Result newFare() {
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
