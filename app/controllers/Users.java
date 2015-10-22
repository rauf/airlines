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
import views.html.user.signup;

import java.io.File;
import java.util.List;

public class Users extends Controller{

    public Result list(int page) {
        PagedList<User> list = User.findPage(page, 10);
        return TODO;
    }

    public Result newUser() {
        Form<User> form = Form.form(User.class);
        return ok(signup.render(form));
    }

    public Result details(int id) {
        return TODO;
    }

    public Result edit(int id){
        return TODO;
    }

    public Result save() {

        Form<User> boundForm = Form.form(User.class).bindFromRequest();

        if(boundForm.hasErrors()) {
            flash("error", boundForm.errors().toString());
            return badRequest(signup.render(boundForm));
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

        user.save();

        return ok(signup.render(Form.form(User.class)));
    }

    public Result delete(int id) {
        return TODO;
    }

}
