package org.example.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

public interface Iarticles {

    void viewTableArticles();
    void getArticlesByStatus(int status);
    void createArticle(long idproduct, long idprovider, String description, String idfamily, int stock, int stockminimal, LocalDate expirece, float cost, float p_sell, int createdby,
                       LocalDate created, LocalDate modificated, String status);
}
