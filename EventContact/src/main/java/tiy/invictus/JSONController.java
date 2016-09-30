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
    public User login(HttpSession session, String userName, String password) throws Exception {

        User user = users.findFirstByName(userName);

        if (user == null) {
            throw new Exception("No user exists; create a new user!");
        }
//        else if (!password.equals(user.getPassword())) {
//
//        }
        session.setAttribute("user", user);
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(HttpSession session,String email, String firstName, String lastName, String password) {

        User user = users.findFirstByName(firstName);
        if (user == null) {
            user = new User(firstName, lastName, password, email);
            users.save(user);
        }
//        else if (!password.equals(user.getPassword())) {
//            throw new Exception("Incorrect password");
//        }
        session.setAttribute("user", user);


        return user.getEmail();
    }

    @RequestMapping(path = "/home", method = RequestMethod.POST)
    public ArrayList<Event> home(int userID) {

    }

    @RequestMapping(path = "/events", method = RequestMethod.POST)
    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        Iterable<Event> allEvents = events.findAll();
        for (Event event : allEvents) {
            eventList.add(event);
        }
        try{
            //   System.out.println("Catching a nap");
            //   Thread.sleep(3000);
            //   System.out.println("Power nap");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return eventList;
    }

    @RequestMapping(path = "/eventInfo", method = RequestMethod.POST)
    public Event eventInfo(int eventID) {

        Event event = events.findOne(Integer.valueOf(eventID));

        return event;
    }

    @RequestMapping(path = "/addEvent", method = RequestMethod.POST)
    public ArrayList<Event> addEvent(HttpSession session, @RequestBody Event event) throws Exception {
        User user = (User)session.getAttribute("user");

        if (user == null) {
            throw new Exception("Unable to add event without an active user in the session");
        }
        event.adminUserID = user;

        events.save(event);

        return getAllEvents();
    }
    @RequestMapping(path = "/contacts", method = RequestMethod.POST)
    public ArrayList<User> contacts(int userID) {
        ArrayList<User> userList = new ArrayList<User>();
        Iterable<User> allUsers = users.findAll();
        for (User user : allUsers) {
            userList.add(user);
        }
        try{
            //   System.out.println("Catching a nap");
            //   Thread.sleep(3000);
            //   System.out.println("Power nap");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    @RequestMapping(path = "/contactInfo", method = RequestMethod.POST)
    public User contactInfo(int userID) {
        User user = users.findOne(Integer.valueOf(userID));

        return user;
    }
    @RequestMapping(path = "/requests", method = RequestMethod.POST)
    public ArrayList<ContactRequest> requests() {
        ArrayList<ContactRequest> contactRequestsList = new ArrayList<ContactRequest>();
        Iterable<ContactRequest> allContacts = contacts.findAll();
        for (ContactRequest contactRequest : allContacts) {
            contactRequestsList.add(contactRequest);
        }
        try{
            //   System.out.println("Catching a nap");
            //   Thread.sleep(3000);
            //   System.out.println("Power nap");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return contactRequestsList;
    }
}