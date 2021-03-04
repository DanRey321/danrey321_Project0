package com.project0.Templates;

public class UserTemplate {


    private String FirstName;
    private String LastName;
    private String role;
    private String Username;
    private String password;

    public UserTemplate(String firstName, String lastName, String role, String username, String password) {
        FirstName = firstName;
        LastName = lastName;
        this.role = role;
        Username = username;
        this.password = password;
    }

    public UserTemplate() {
        super();
    }



    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
