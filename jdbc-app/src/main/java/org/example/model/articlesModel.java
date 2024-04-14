package org.example.model;

import org.example.config.settings;
import org.example.entities.Iarticles;
import org.example.entities.articlesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class articlesModel implements Iarticles {


    @Override
    public void viewTableArticles() {
        try{
            Connection con = settings.Connection().getConnection();
            PreparedStatement statement = con.prepareCall("call ebgsolut_abejas.spGet_AllProduct();");
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
}
