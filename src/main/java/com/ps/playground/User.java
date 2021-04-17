package com.ps.playground;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USER_NAME", name = "uniqueUserNameConstraint")
})
public class User {

    /**
     * Empty constructor for jackson
     */
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="USER_NAME", nullable = false)
    private String userName;

    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    @JsonProperty("State")
    private String State;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="FOLLOWERS")
    private Long followers;

    @Column(name="FOLLOWINGS")
    private Long followings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Long getFollowings() {
        return followings;
    }

    public void setFollowings(Long followings) {
        this.followings = followings;
    }
}
