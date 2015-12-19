package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import com.google.common.io.Files;
import models.NotEntities.ForgotPasswordStep2;
import models.NotEntities.ForgotPasswordStep1;
import models.NotEntities.Login;
import models.User;
import play.data.Form;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.User.application.homepage;
import views.html.User.application.login;
import views.html.User.user.*;
import models.SecurityQuestion;

import java.io.File;
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
        return ok(details.render(user));
    }

    public Result edit(User user){
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

        if(user.id == null) {
            user.save();
            return ok(login.render(Form.form(Login.class)));
        }

        else {
            user.update();
            return ok(homepage.render());
        }
    }


    public Result delete(User user) {
        if(user == null)
            return notFound(homepage.render());                  //redirect to homepage
        user.delete();
        return ok(homepage.render());                            //redirect
    }


    public Result forgotPasswordStep1(){
        Form<ForgotPasswordStep1> fp = Form.form(ForgotPasswordStep1.class);
        return ok(forgotPasswordStep1.render(fp));
    }

    public Result forgotPasswordStep2() {

        Form<ForgotPasswordStep1> boundForm =Form.form(ForgotPasswordStep1.class).bindFromRequest();

        if(boundForm.hasErrors()){
            return badRequest(forgotPasswordStep1.render(boundForm));
        }
        else {

            User user = User.getUserByEmail(boundForm.get().email);

            ForgotPasswordStep2 fp2 = new ForgotPasswordStep2();
            fp2.securityQuestion = user.securityQuestion.question;
            fp2.securityAnswer="";
            fp2.email = user.email;

            Form<ForgotPasswordStep2> filledForm = Form.form(ForgotPasswordStep2.class).fill(fp2);
            return ok(forgotPasswordStep2.render(filledForm));
        }
    }

    public Result forgotPasswordAuthenticator() {
        Form<ForgotPasswordStep2> boundForm = Form.form(ForgotPasswordStep2.class).bindFromRequest();

        if(boundForm.hasErrors()){
            return badRequest(forgotPasswordStep2.render(boundForm));
        }
        else  {
            ForgotPasswordStep2 fp2 = boundForm.get();
            String password = User.getUserByEmail(fp2.email).password;
            return ok(forgotPasswordResult.render(password));
        }
    }

    public Result picture(User user) {

        if(user == null)
            return notFound();
        return ok(user.picture);
    }



}
