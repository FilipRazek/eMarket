package logic;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

import model.ShoppingCartItem;
import model.Product;

@Named
@ApplicationScoped
public class ShoppingCartManager implements Serializable {

    private List<ShoppingCartItem> cartItems;
    private Product prodToAdd;

    public ShoppingCartManager() {
        cartItems = new ArrayList<>();
    }

    @PostConstruct
    public void initCart() {
        cartItems.add(new ShoppingCartItem(1, 2, new Product(2, "Produit", 57.0)));
    }

    public String addToCart() {
        ShoppingCartItem addedItem = new ShoppingCartItem(1, 1, prodToAdd);
        cartItems.add(addedItem);
        return "gotocart";
    }

    public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Product getProdToAdd() {
        return prodToAdd;
    }

    public void setProdToAdd(Product prodToAdd) {
        this.prodToAdd = prodToAdd;
    }
}
