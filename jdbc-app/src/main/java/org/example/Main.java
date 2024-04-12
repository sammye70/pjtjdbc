package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public  static  void main(String[] args) {

        try {
            Connection con = settings.Connection().getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM category");
            ResultSet rs = statement.executeQuery();

            System.out.println("Id  "  +  "  category ");
            while (rs.next()){
                String id = rs.getString(1);
                String category = rs.getString(2);
                System.out.println(id + "     " + category);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }
}