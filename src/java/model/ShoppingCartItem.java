package model;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable {

    private Integer id;
    private Integer amount;
    private Product product;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Integer id, Integer amount, Product product) {
        this.id = id;
        this.amount = amount;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
