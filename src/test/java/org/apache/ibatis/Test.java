package org.apache.ibatis;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by liaoxudong
 * Date:2018/1/19
 */

public class Test {
    public static void main(String[] args) {
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = drivers.iterator();

        while (iterator.hasNext()) {// 迭代过程中具体的驱动实现会将自己注册到DriverManager
            Driver next = iterator.next();
            Enumeration<Driver> drivers1 = DriverManager.getDrivers();
            System.out.println(drivers1);
            try {
                DriverManager.registerDriver(next);// 为什么不像这样在将
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Enumeration<Driver> drivers2 = DriverManager.getDrivers();
            System.out.println(drivers2);
        }


    }
}
