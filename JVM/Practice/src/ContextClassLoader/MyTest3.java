package ContextClassLoader;

/*
@Author: Toyz
@Date: 2019/8/31
@Time: 13:41
@Purpose:
@Related:
*/


import java.sql.Connection;
import java.sql.DriverManager;

public class MyTest3 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://lo","username","123");
    }
}

