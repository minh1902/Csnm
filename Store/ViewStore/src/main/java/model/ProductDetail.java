/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */

public class ProductDetail {
    private Integer productId;
    private Integer count;

    public ProductDetail() {
    }

    public ProductDetail(Integer productId, Integer count) {
            this.productId = productId;
            this.count = count;
    }

    public Integer getproductId() {
            return productId;
    }

    public void setproductId(Integer productId) {
            this.productId = productId;
    }

    public Integer getcount() {
            return count;
    }

    public void setcount(Integer count) {
            this.count = count;
    }

    @Override
    public String toString() {
            return "ProductDetail [productId=" + productId + ", count=" + count + "]";
    }
	
	
}

