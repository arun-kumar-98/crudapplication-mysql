package com.crud.crudapplicationmysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String prodCode;
    private Double prodCost;
    private String vendor;

    public Product() {
        super();
    }

    public Product(Integer pid, String prodCode, Double prodCost, String vendor) {
        this.pid = pid;
        this.prodCode = prodCode;
        this.prodCost = prodCost;
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", prodCode='" + prodCode + '\'' +
                ", prodCost=" + prodCost +
                ", vendor='" + vendor + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public Double getProdCost() {
        return prodCost;
    }

    public void setProdCost(Double prodCost) {
        this.prodCost = prodCost;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
