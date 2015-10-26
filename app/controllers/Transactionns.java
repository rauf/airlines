package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.NotEntities.Login;
import models.Transactionn;
import models.User;
import play.data.Form;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.application.login;
import views.html.transaction.list;


public class Transactionns extends Controller{


    public Result list(int page) {

        User user = User.getUserByEmail(session("email"));

        if(user == null) {
            flash("notLoggedIn","Log In Please");
            return badRequest(login.render(Form.form(Login.class)));
        }

        PagedList<Transactionn> pagedList =
                Transactionn.find.where()
                .eq("user", user)
                .orderBy("date desc")
                .findPagedList(page, 10);

        return ok(list.render(pagedList));
    }

    public Result newTransaction() {
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
