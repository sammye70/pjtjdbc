package org.example.model;

import org.example.config.settings;
import org.example.entities.Iarticles;
import org.example.entities.articlesEntity;

import java.sql.*;
import java.time.LocalDate;

public class articlesModel implements Iarticles {


    @Override
    public void viewTableArticles() {
        try{
            Connection con = settings.Connection().getConnection();
            PreparedStatement statement = con.prepareCall("call spGet_AllProduct();");
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
            PreparedStatement statement = connection.prepareCall("{call spGet_ProductByStatus(?)}"); // calling store procedure "{call sp_name(?)}; ?=number of parameters"
            statement.setString(1, String.valueOf(status)); //Setting parameters on stored procedure
            ResultSet rs = statement.executeQuery();


            System.out.println("Report of Product by Status");

            while (rs.next()){
                obj.setNumber(rs.getLong("numero"));
                obj.setIdproduct(rs.getLong("idproducto"));
                obj.setDescription(rs.getString("descripcion"));
                obj.setExpirece(rs.getTimestamp("f_vencimiento"));
                obj.setIdfamily(rs.getString("category"));
                obj.setStatus(rs.getString("estado"));

                System.out.println(obj.getNumber() + "   +   " + obj.getIdproduct() + "   +   " + obj.getDescription() + "   +  " +  obj.getIdfamily() + " + " +obj.getExpirece() + " +  " + obj.getStatus(String.valueOf(status)));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
   public void createArticle(long idproduct, long idprovider, String description, String idfamily, int stock, int stockminimal, LocalDate expirece, float cost, float p_sell, int createdby,
                              LocalDate created, LocalDate modificated, String status) {

        try{
            System.out.println("Create an Article");

            Connection connection = settings.Connection().getConnection();

            PreparedStatement statement = connection.prepareCall("{call spCreateProduct(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setLong(1,idproduct);
            statement.setString(2, String.valueOf(idprovider));
            statement.setString(3,  description);
            statement.setString(4, idfamily);
            statement.setFloat(5,stock);
            statement.setFloat(6,stockminimal);
            statement.setDate(7,Date.valueOf(expirece));
            statement.setFloat(8,cost);
            statement.setFloat(9,p_sell);
            statement.setInt(10, createdby);
            statement.setDate(11, Date.valueOf(created));
            statement.setDate(12, Date.valueOf(modificated));
            statement.setString(13, status);

            ResultSet rs = statement.executeQuery();

            rs.insertRow();
            }
            catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
