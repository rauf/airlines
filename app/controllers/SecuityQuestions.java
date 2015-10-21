package controllers;


/**
 * Created by abdul on 10/21/15.
 */

import models.SecurityQuestion;
import play.mvc.Result;
import play.mvc.Controller;

import java.util.List;

public class SecuityQuestions extends Controller {

    public Result list(int page) {
        List<SecurityQuestion> securityQuestions = SecurityQuestion.findPage(page, 10);
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
