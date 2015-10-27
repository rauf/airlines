package controllers;

/**
 * Created by abdul on 10/21/15.
 */

import com.avaje.ebean.PagedList;
import models.Passenger;
import models.UnrelatedEntity.PassengerList;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.User.Passenger.newpassenger;
import views.html.User.Passenger.passengerredirect;


public class Passengers extends Controller {


    public static int total_passenger;
    Form<PassengerList> passengerForm = Form.form(PassengerList.class);


    public Result list(int page) {
        PagedList<Passenger> list = Passenger.findPage(page, 10);
        //return ok(list.render);
        return TODO;
    }

    public Result newPassenger() {
        return ok(newpassenger.render(passengerForm,total_passenger));
    }

    public Result details(int id) {
        return TODO;
    }

    public Result save() {


       Form<PassengerList> form = passengerForm.bindFromRequest();
        PassengerList passengerList = form.get();

        for(int i=1;i<=total_passenger;i++)
        {
            Passenger passenger = new Passenger();
            passenger.age=passengerList.age.get(i);
            passenger.gender=passengerList.gender.get(i);
            passenger.name=passengerList.name.get(i);

            passenger.save();



        }


        return ok(passengerredirect.render());


    }

    public Result delete(int id) {
        return TODO;
    }



}
