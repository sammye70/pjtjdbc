package org.example.entities;

import java.sql.Date;
import java.sql.Timestamp;


public class articlesEntity {

    private long number;
    private long idproduct;
    private String idprovider;
    private String description;
    private String idfamily;
    private int stock;
    private int minstock;
    private Timestamp expirece;
    private float cost;
    private float sellprice;
    private int createby;
    private Date created;
    private Date modificated;
    private String status;

    public articlesEntity() {
    }


    public articlesEntity(long number, long idproduct, String idprovider, String description, String idfamily, int stock, int minstock, Timestamp expirece, float cost, float sellprice, int createby, Date created, Date modificated, String status) {
        this.number = number;
        this.idproduct = idproduct;
        this.idprovider = idprovider;
        this.description = description;
        this.idfamily = idfamily;
        this.stock = stock;
        this.minstock = minstock;
        this.expirece = expirece;
        this.cost = cost;
        this.sellprice = sellprice;
        this.createby = createby;
        this.created = created;
        this.modificated = modificated;
        this.status = status;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(long idproduct) {
        this.idproduct = idproduct;
    }

    public String getIdprovider() {
        return idprovider;
    }

    public void setIdprovider(String idprovider) {
        this.idprovider = idprovider;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdfamily() {
        return idfamily;
    }

    public void setIdfamily(String idfamily) {
        this.idfamily = idfamily;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinstock() {
        return minstock;
    }

    public void setMinstock(int minstock) {
        this.minstock = minstock;
    }

    public Timestamp getExpirece() {
        return expirece;
    }

    public void setExpirece(Timestamp expirece) {
        this.expirece = expirece;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSellprice() {
        return sellprice;
    }

    public void setSellprice(float sellprice) {
        this.sellprice = sellprice;
    }

    public int getCreateby() {
        return createby;
    }

    public void setCreateby(int createby) {
        this.createby = createby;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModificated() {
        return modificated;
    }

    public void setModificated(Date modificated) {
        this.modificated = modificated;
    }

    public String getStatus(String s) {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "articlesModel{" +
                "number=" + number +
                ", idproduct=" + idproduct +
                ", idprovider='" + idprovider + '\'' +
                ", description='" + description + '\'' +
                ", idfamily='" + idfamily + '\'' +
                ", stock=" + stock +
                ", minstock=" + minstock +
                ", expirece=" + expirece +
                ", cost=" + cost +
                ", sellprice=" + sellprice +
                ", createby=" + createby +
                ", created=" + created +
                ", modificated=" + modificated +
                ", status='" + status + '\'' +
                '}';
    }
}
