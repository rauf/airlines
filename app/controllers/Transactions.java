package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.Transaction;
import play.data.Form;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.User.Transaction.newtransaction;
import views.html.User.Transaction.transactionredirect;


import java.util.Date;


public class Transactions extends Controller{

    public static int fare=0;
    public static Date date;


    Form<Transaction> transactionForm = Form.form(Transaction.class);


    public Result list(int page) {
        PagedList<Transaction> list = Transaction.findPage(page, 10);
        return ok(views.html.User.Transaction.list.render(list));

    }

    public Result newTransaction() {

        return ok(newtransaction.render(transactionForm));

    }

    public Result details(int id) {
        return TODO;
    }

    public Result save() {

        Form<Transaction> form = transactionForm.bindFromRequest();
        Transaction transaction = form.get();
        transaction.date=date;
        transaction.amount=fare;
        transaction.save();
        return ok(transactionredirect.render()); //needs updation


    }

    public Result delete(int id) {
        return TODO;
    }
}
