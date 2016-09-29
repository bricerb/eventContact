package tiy.invictus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Brice on 9/29/16.
 */

@RestController
public class JSONController {

    @Autowired
    EventRepository events;

    @Autowired
    UserRepository users;

    @Autowired
    ContactRequestRepository contacts;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User login(String userName, String password) {
        User user = users.findFirstByName(userName);
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(String email, String firstName, String lastName, String password) {

    }

    @RequestMapping(path = "/home", method = RequestMethod.POST)
    public ArrayList<Event> home(int userID) {

    }

    @RequestMapping(path = "/events", method = RequestMethod.POST)
    public ArrayList<Event> allEvents() {

    }

    @RequestMapping(path = "/eventInfo", method = RequestMethod.POST)
    public Event eventInfo(int eventID) {

    }

    @RequestMapping(path = "/addEvent", method = RequestMethod.POST)
    public Event addEvent(HttpSession session, @RequestBody Event event) {

    }

    @RequestMapping(path = "/contacts", method = RequestMethod.POST)
    public ArrayList<User> contacts(int userID) {

    }

    @RequestMapping(path = "/contactInfo", method = RequestMethod.POST)
    public User contactInfo(int userID) {

    }

    @RequestMapping(path = "/requests", method = RequestMethod.POST)
    public ArrayList<ContactRequest> requests() {

    }
}
