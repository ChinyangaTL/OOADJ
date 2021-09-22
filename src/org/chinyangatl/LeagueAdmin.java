package org.chinyangatl;

public class LeagueAdmin extends EndUser{
    public LeagueAdmin() {
    }

    public LeagueAdmin(String firstName, String lastName, String age) {
        super(firstName, lastName, age);
    }

    @Override
    public void login() {

    }

    public void collectGameInfo(Fixture fixture) {}
}
