package controllers;

import com.avaje.ebean.PagedList;
import models.Complaint;
import models.NotEntities.Login;
import models.User;
import play.data.Form;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.application.login;
import views.html.complaint.complaint;

import java.util.Date;
import java.util.List;

/**
 * Created by abdul on 10/21/15.
 */

public class Complaints extends Controller{


    public Result list(int page) {
        PagedList<Complaint> complaints = Complaint.findPage(page, 10);
        return TODO;
    }


    public Result newComplaint() {
        User user = User.getUserByEmail(session("email"));

        if(user ==null ) {
            flash("notLoggedIn","You are currently not logged In. Log In Please");
            Form<Login> form = Form.form(Login.class);
            return ok(login.render(form));
        }

        Form<Complaint> form = Form.form(Complaint.class);
        return ok(complaint.render(form));
    }

    public Result save() {

        Form<Complaint> boundForm = Form.form(Complaint.class).bindFromRequest();

        if(boundForm.hasErrors()) {
            return badRequest(complaint.render(boundForm));
        }
        else {
            Complaint complaint = boundForm.get();
            complaint.date = new Date();
            complaint.user = User.getUserByEmail(session("email"));
            complaint.save();
            return ok("Form has been successfully submitted");
        }
    }


    public Result details(int id) {
        return TODO;
    }

    public Result delete(int id) {
        return TODO;
    }


}
