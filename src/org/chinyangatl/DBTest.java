package org.chinyangatl;

import org.chinyangatl.controller.DataSource;

import java.util.List;

public class DBTest {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()) {
            System.out.println("Can't open data source");
            return;
        }

        List<Manager> managers = dataSource.queryManagers(2);
        if(managers == null || managers.isEmpty()) {
            System.out.println("Manager set is empty");
        }

//        for(int i = 0; i < managers.size(); i++) {
//            System.out.println(managers.get(i).toString());
//        }

        for(Manager manager : managers) {
            System.out.println(manager.toString());
        }



//        List<Manager> managers = dataSource.queryManagers(2);
//        if(managers == null || managers.isEmpty()) {
//            System.out.println("Empty");
//            return;
//        }
//
//        for(Manager manager : managers) {
//            System.out.println(manager.toString());
//        }



        System.out.println(dataSource.queryClubManager("Arsenal Football Club"));

        System.out.println(dataSource.QUERY_CLUB);
        System.out.println(dataSource.INSERT_MANAGER);
        System.out.println(dataSource.INSERT_CLUB);
        dataSource.insertManager("Jurgen", "Klopp", "Liverpool Football Club");

        dataSource.close();
    }
}
