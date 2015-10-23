package controllers;


/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.SecurityQuestion;
import play.mvc.Result;
import play.mvc.Controller;

import java.util.List;

public class SecurityQuestions extends Controller {

    public Result list(int page) {
        PagedList<SecurityQuestion> securityQuestions = SecurityQuestion.findPage(page, 10);
        return TODO;
    }

    public Result save() {
        return TODO;
    }

    public Result details(int id) {
        return TODO;
    }

    public Result delete(int id) {
        return TODO;
    }

    public Result newQuestion() {
        return TODO;
    }

}
