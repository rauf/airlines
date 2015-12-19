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
import views.html.User.application.login;
import views.html.User.transaction.list;
import views.html.User.transaction.newtransaction;
import views.html.User.transaction.transactionredirect;


import java.util.Date;


public class Transactionns extends Controller{

    public static int fare=0;
    public static Date date;


    Form<Transactionn> transactionForm = Form.form(Transactionn.class);


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



/*

    public Result list2(int page) {
        PagedList<Transactionn> list = Transactionn.findPage(page, 10);
        return ok(list.render(list));

    }
*/

    public Result newTransaction() {

        return ok(newtransaction.render(transactionForm));

    }

    public Result details(int id) {
        return TODO;
    }

    public Result save() {

        Form<Transactionn> form = transactionForm.bindFromRequest();
        Transactionn transactionn = form.get();
        transactionn.date=date;
        transactionn.amount=fare;
        transactionn.save();
        return ok(transactionredirect.render()); //needs updation


    }

    public Result delete(int id) {
        return TODO;
    }
}
