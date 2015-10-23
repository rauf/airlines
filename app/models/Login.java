package models;

/**
 * Created by abdul on 10/23/15.
 */

import com.avaje.ebean.Model;

public class Login extends Model {

    public String email;
    public String password;

    public String validate() {
        if(User.getUser(email,password) == null)
            return "Invalid Email/Password Combination";
        return null;
    }
}
