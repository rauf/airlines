package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;

public class Users extends Controller{

    public Result list(int page) {
        PagedList<User> list = User.findPage(page, 10);
        return TODO;
    }

    public Result newUser() {
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
