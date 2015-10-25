package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import com.google.common.io.Files;
import models.NotEntities.ForgotPasswordStep2;
import models.NotEntities.ForgotPasswordStep1;
import models.User;
import play.data.Form;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.user.*;
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

        if(user.id == null)
            user.save();
        else user.update();

        return ok();                            //redirect to login page
    }


    public Result delete(User user) {
        if(user == null)
            return notFound();                  //redirect to homepage
        user.delete();
        return ok();                            //redirect
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
        ForgotPasswordStep1 fp1object =boundForm.get();

        if(fp1object.validate() == null) {

            User user = User.getUserByEmail(fp1object.email);

            ForgotPasswordStep2 fp = new ForgotPasswordStep2();
            fp.securityQuestion = user.securityQuestion.question;           //filling just one field--securityQuestion
            fp.securityAnswer="";
            fp.email = user.email;
            Form<ForgotPasswordStep2> filledForm = Form.form(ForgotPasswordStep2.class).fill(fp);         //fill the form when created otherwise it does not fills

            return ok(forgotPasswordStep2.render(filledForm));

        }

        else return badRequest(forgotPasswordStep1.render(boundForm));
    }

    public Result forgotPasswordAuthenticator() {
        Form<ForgotPasswordStep2> form = Form.form(ForgotPasswordStep2.class);
        Form<ForgotPasswordStep2> boundForm = form.bindFromRequest();


        if(boundForm.hasErrors()){
            return badRequest(forgotPasswordStep2.render(boundForm));
        }

        ForgotPasswordStep2 fp = boundForm.get();

        if(fp.validate() == null) {
            String password = User.getUserByEmail(fp.email).password;
            return ok(forgotPasswordResult.render(password));
        }
        else {
            return badRequest(forgotPasswordStep2.render(boundForm));
           // return ok("validation failed");
        }
    }

    public Result picture(int id) {
        User user = User.find.byId((long) id);
        if(user == null)
            return notFound();
        return ok(user.picture);
    }



}
