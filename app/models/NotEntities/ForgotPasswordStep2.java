package models.NotEntities;

import com.avaje.ebean.Model;
import models.User;
import play.data.validation.Constraints;

/**
 * Created by abdul on 10/24/15.
 */
public class ForgotPasswordStep2 extends Model {

    @Constraints.Required
    public String email;

    public String securityQuestion;

    @Constraints.Required
    public String securityAnswer;

    public String validate() {
        try {
            User user = User.getUserByEmail(email);
            if (!user.securityAnswer.equals(securityAnswer))
                return "Please enter the correct answer";
        }catch (Exception e) {
            return "Email-Id not found";
        }
        return null;
    }

}
