package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "Ravi@007");
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from employee");
//            while (rs.next())
//                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4));

//            int count = stmt.executeUpdate("update employee set emp_name = 'karthick' where id =1");
//            System.out.println(count);

            boolean response = stmt.execute("select * from employee");
//            boolean response = stmt.execute("insert into employee(emp_name,salary,gender)\r\n"
//                    + "values(\"Sambath\",610000.0,\"M\")");
//
            if (response) {
                ResultSet rs = stmt.getResultSet();
                while (rs.next())
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4));

            }else {
                int count = stmt.getUpdateCount();
                System.out.println(count);

            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
