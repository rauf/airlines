package models.NotEntities;

import com.avaje.ebean.Model;
import models.User;
import play.data.validation.Constraints;

/**
 * Created by abdul on 10/25/15.
 */
public class ForgotPasswordStep1 extends Model{

    @Constraints.Required
    public String email;

    public String validate() {

        if(User.userPresent(email) == false) {
            return "Email does not exist";
        }

        return null;
    }
}
