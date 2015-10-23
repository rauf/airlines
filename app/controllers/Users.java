package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import com.google.common.io.Files;
import models.User;
import play.data.Form;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.user.details;
import views.html.user.signup;
import models.SecurityQuestion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Users extends Controller {

    public Result list(int page) {
        PagedList<User> list = User.findPage(page, 10);
        return TODO;
    }

    public List<SecurityQuestion> questions = SecurityQuestion.forDB();

    public Result newUser() {
        Form<User> form = Form.form(User.class);
        return ok(signup.render(form,questions));
    }

    public Result details(User user) {
        //User user = User.find.byId((long) id);
        return ok(details.render(user));
    }

    public Result edit(User user){
       // User user = User.find.byId(id);
        Form<User> filledForm = Form.form(User.class).fill(user);
        return ok(signup.render(filledForm,questions));
    }

    public Result save() {

        Form<User> boundForm = Form.form(User.class).bindFromRequest();

        if(boundForm.hasErrors()) {
            flash("error", boundForm.errors().toString());
            return badRequest(signup.render(boundForm,questions));
        }

        User user = boundForm.get();

        MultipartFormData multipartFormData = request().body().asMultipartFormData();
        MultipartFormData.FilePart filePart = multipartFormData.getFile("picture");

        if(filePart!=null) {
            File picture = filePart.getFile();
            try {
                user.picture = Files.toByteArray(picture);
            } catch (Exception e) {
            }
        }

        //binding security question
        SecurityQuestion secQues = SecurityQuestion.find.byId(user.securityQuestion.id);
        user.securityQuestion = secQues;

        if(user.id == null)
            user.save();
        else user.update();

        return ok();                            //redirect to login page
    }


    public Result delete(User user) {
       // User user  = User.find.byId((long) id);
        if(user == null)
            return notFound();                  //redirect to homepage
        user.delete();
        return ok();                            //redirect
    }


    public Result picture(int id) {
        User user = User.find.byId((long) id);
        if(user == null)
            return notFound();
        return ok(user.picture);
    }

}
