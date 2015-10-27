package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.Admin;
import play.mvc.Controller;
import play.mvc.Result;

public class Admins extends Controller{



    public Result list(int page) {
        PagedList<Admin> list = Admin.findPage(page, 10);
        //return ok(list.render);
        return TODO;
    }

    public Result newAdmin() {
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
