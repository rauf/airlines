package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.UnrelatedEntity.Feedback;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.User.Feedback.newFeedback;


public class Feedbacks extends Controller{
    private static final Form<Feedback> feedbackform = Form.form(Feedback.class);


    public Result list(int page) {
        PagedList<Feedback> list = Feedback.findPage(page, 10);
        //return ok(list.render);
        return TODO;
    }

    public Result newFeedback() {
        return ok(newFeedback.render(feedbackform));


    }

    public Result save() {

        Form<Feedback> form = feedbackform.bindFromRequest();
        Feedback feedback = form.get();

        feedback.save();   // saves in the Feedback table




        //flash("success",String.format("Thankyou for the feedback"));
        return ok(views.html.User.Feedback.feedbackredirect.render());
    }

    public Result delete(int id) {
        return TODO;
    }


    public Result details(int id) {
        return TODO;
    }







}
