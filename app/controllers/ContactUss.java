package controllers;

import com.avaje.ebean.PagedList;
import models.ContactUs;
import models.NotEntities.Login;
import models.User;
import play.data.Form;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.User.application.homepage;
import views.html.User.application.login;
import views.html.User.contactus.contactus;
import views.html.User.contactus.list;


import java.util.Date;

/**
 * Created by abdul on 10/21/15.
 */

public class ContactUss extends Controller{


    public Result list(int page) {
        User user = User.getUserByEmail(session("email"));

        if(user == null) {
            flash("notLoggedIn","Log In Please");
            return badRequest(login.render(Form.form(Login.class)));
        }

        PagedList<ContactUs> pagedList =
                ContactUs.find
                        .where()
                        .eq("user",user)
                        .orderBy("date desc")
                        .findPagedList(page, 10);


        return ok(list.render(pagedList));
    }


    public Result newContact() {
        User user = User.getUserByEmail(session("email"));

        if( user ==null ) {
            flash("notLoggedIn","You are currently not logged In. Log In Please");
            Form<Login> form = Form.form(Login.class);
            return ok(login.render(form));
        }

        Form<ContactUs> form = Form.form(ContactUs.class);
        return ok(contactus.render(form));
    }

    public Result save() {

        Form<ContactUs> boundForm = Form.form(ContactUs.class).bindFromRequest();

        if(boundForm.hasErrors()) {
            return badRequest(contactus.render(boundForm));
        }
        else {
            ContactUs contactUs = boundForm.get();
            contactUs.date = new Date();
            contactUs.user = User.getUserByEmail(session("email"));
            contactUs.save();
            return ok(homepage.render());
        }
    }


    public Result details(int id) {
        return TODO;
    }

    public Result delete(int id) {
        return TODO;
    }


}
