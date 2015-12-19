package controllers;

import models.NotEntities.Login;
import play.data.Form;
import play.mvc.*;

import views.html.*;
import views.html.User.application.homepage;
import views.html.User.application.login;

import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Application extends Controller {

    public Result index() {
        return ok(homepage.render());
    }


    public Result authenticate() {              //will receive calls from login action method

        Form<Login> boundForm = Form.form(Login.class).bindFromRequest();
        if(boundForm.hasErrors())
            return badRequest(login.render(boundForm));
        else{
            Login loginObject = boundForm.get();
            session().clear();
            session("email",loginObject.email);
            flash("loggedIn","You have successfully logged In");
            return ok(homepage.render());
        }

    }

    public Result login() {
        Form<Login> form = Form.form(Login.class);
        return ok(login.render(form));            //login form
    }

    public Result logout() {
        session().clear();
        return ok(homepage.render());
    }


}
