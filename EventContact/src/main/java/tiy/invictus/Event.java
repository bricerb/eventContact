package tiy.invictus;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Brice on 9/29/16.
 */

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    int id;

    @Column
    String title;

    @Column
    String address;

    @Column
    String description;

    @ManyToOne
    User adminUserID;

    @ManyToMany
    User attendees;

    @Column
    String dateAndTime;



    public Event() {
    }

    public Event(int id, String title, String address, String description, User adminUserID, User attendees, String dateAndTime) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.description = description;
        this.adminUserID = adminUserID;
        this.attendees = attendees;
        this.dateAndTime = dateAndTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAdminUserID() {
        return adminUserID;
    }

    public void setAdminUserID(User adminUserID) {
        this.adminUserID = adminUserID;
    }

    public User getAttendees() {
        return attendees;
    }

    public void setAttendees(User attendees) {
        this.attendees = attendees;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
