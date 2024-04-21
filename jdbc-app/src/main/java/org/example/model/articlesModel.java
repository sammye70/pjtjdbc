package org.example.model;

import org.example.config.settings;
import org.example.entities.Iarticles;
import org.example.entities.articlesEntity;

import java.sql.*;

public class articlesModel implements Iarticles {


    @Override
    public void viewTableArticles() {
        try{
            Connection con = settings.Connection().getConnection();
            PreparedStatement statement = con.prepareCall("call ebgsolut_abejas.spGet_AllProduct();");
            Statement statement1 = con.createStatement();
            ResultSet rs = statement.executeQuery();

            var obj  = new  articlesEntity();
            //List<articlesEntity> lsProducts = new ArrayList<>();

            System.out.println("Products Report on Stock");
            while (rs.next()){
               obj.setNumber(rs.getLong("numero"));
               obj.setIdproduct(rs.getLong("idproducto"));
               obj.setDescription(rs.getString("descripcion"));

               System.out.println(obj.getNumber() + "   +   " + obj.getIdproduct() + "   +   " + obj.getDescription());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getArticlesByStatus(int status) {

        try {
            var obj = new articlesEntity();

            Connection connection = settings.Connection().getConnection();
            PreparedStatement statement = connection.prepareCall("{call ebgsolut_abejas.spGet_ProductByStatus(?)}");
            statement.setString(1, String.valueOf(status)); //Set parameters on stored procedure
            ResultSet rs = statement.executeQuery();

            System.out.println("Report of Product by Status");

            while (rs.next()){
                obj.setNumber(rs.getLong("numero"));
                obj.setIdproduct(rs.getLong("idproducto"));
                obj.setDescription(rs.getString("descripcion"));
                obj.setStatus(rs.getString("estado"));

                System.out.println(obj.getNumber() + "   +   " + obj.getIdproduct() + "   +   " + obj.getDescription() + "   +  "  + obj.getStatus(String.valueOf(status)));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
