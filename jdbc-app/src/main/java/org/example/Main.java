package org.example;


import org.example.model.articlesModel;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public  static  void main(String[] args) {

        // View Table Articles in Stock
        var obj = new articlesModel();
       // obj.viewTableArticles();

        // View Articles by status
         // obj.getArticlesByStatus(1);

        //Insert new article
        obj.createArticle(567L, 2, "Product Test",  String.valueOf(3),  8, 10,  LocalDate.now(), 56.8f, 100,
              2, LocalDate.now(),  LocalDate.now(), String.valueOf(1 ));
    }
}