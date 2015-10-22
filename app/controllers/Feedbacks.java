package controllers;

/**
 * Created by abdul on 10/21/15.
 */
import com.avaje.ebean.PagedList;
import models.UnrelatedEntity.Feedback;
import play.mvc.Result;
import play.mvc.Controller;

import java.util.List;

public class Feedbacks extends Controller{


    public Result list(int page) {
        PagedList<Feedback> list = Feedback.findPage(page, 10);
        //return ok(list.render);
        return TODO;
    }

    public Result newFeedback() {
        return TODO;
    }

    public Result save() {
        return TODO;
    }

    public Result delete(int id) {
        return TODO;
    }


    public Result details(int id) {
        return TODO;
    }

}
