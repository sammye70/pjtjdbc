package org.example;


import org.example.model.articlesModel;

public class Main {

    public  static  void main(String[] args) {

        // View Table Articles in Stock
       // var obj = new articlesModel();
       // obj.viewTableArticles();

        // View Articles by status
        var obj1 = new articlesModel();
        obj1.getArticlesByStatus(2);



    }
}