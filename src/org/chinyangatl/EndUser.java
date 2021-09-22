package org.chinyangatl;

public abstract class EndUser {
    private String firstName;
    private String lastName;
    private String age;

    public EndUser() {

    }

    public EndUser(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // CLASS METHODS
    public abstract void login();

    public void viewLogTable() {}

    public  void viewFixtures() {}



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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
