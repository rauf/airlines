package controllers;

import models.NotEntities.Login;
import play.data.Form;
import play.mvc.*;

import views.html.*;
import views.html.application.login;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }


    public Result authenticate() {              //will receive calls from login action method

        Form<Login> boundForm = Form.form(Login.class).bindFromRequest();
        if(boundForm.hasErrors())
            return badRequest(login.render(boundForm));

        Login loginObject = boundForm.get();

        if(loginObject.validate() == null) {
            session().clear();
            session("email",loginObject.email);
            flash("loggedIn","You have successfully logged In");
            return ok(login.render(boundForm));                              // x redirect to home page
        }

        else {
            flash("logInError","Incorrect Email or Password");
            return badRequest(login.render(boundForm));
        }
    }

    public Result login() {
        Form<Login> form = Form.form(Login.class);
        return ok(login.render(form));            //login form
    }

    public Result logout() {
        session().clear();
        return ok();                         //x redirect to homepage
    }


}
