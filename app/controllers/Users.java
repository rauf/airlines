package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.User;
import play.data.Form;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.user.signup;

import java.util.List;

public class Users extends Controller{

    public Result list(int page) {
        PagedList<User> list = User.findPage(page, 10);
        return TODO;
    }

    public Result newUser() {
        Form<User> form = Form.form(User.class);
        return ok(signup.render(form));
    }

    public Result details(int id) {
        return TODO;
    }

    public Result edit(int id){
        return TODO;
    }

    public Result save() {
        Form form = Form.form(User.class);
        Form boundForm = form.bindFromRequest();

        if(boundForm.hasErrors())
            return badRequest(signup.render(boundForm));

        User user = (User) boundForm.get();
        user.save();

        return ok();
    }

    public Result delete(int id) {
        return TODO;
    }

}
