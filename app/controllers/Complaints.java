package controllers;

import com.avaje.ebean.PagedList;
import models.Complaint;
import play.mvc.Result;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by abdul on 10/21/15.
 */

public class Complaints extends Controller{


    public Result list(int page) {
        PagedList<Complaint> complaints = Complaint.findPage(page, 10);
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

    public Result newComplaint() {
        return TODO;
    }

}
