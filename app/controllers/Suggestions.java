package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.Suggestion;
import play.mvc.Result;
import play.mvc.Controller;

import java.util.List;

public class Suggestions extends Controller {


    public Result list(int page) {
        PagedList<Suggestion> list = Suggestion.findPage(page, 10);
        //return ok(list.render);
        return TODO;
    }

    public Result newSuggestion() {
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
