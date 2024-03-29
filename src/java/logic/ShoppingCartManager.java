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
        cartItems.add(new ShoppingCartItem(1, 1, new Product(0, "Assurance ski", 148.55)));
    }

    public String addToCart() {
        ShoppingCartItem addedItem = new ShoppingCartItem(1, 1, prodToAdd);
        cartItems.add(addedItem);
        return "gotocart";
    }

    public Double getPrice() {
        return cartItems
                .stream()
                .map(item -> item.getAmount() * item.getProduct().getPrice())
                .reduce(0.0, (subTotal, item) -> subTotal + item);
    }

    public void incrementItemAmount(ShoppingCartItem product) {
        product.setAmount(product.getAmount() + 1);
    }

    public void decrementItemAmount(ShoppingCartItem product) {
        if (product.getAmount() == 1) {
            removeItem(product);
        } else {
            product.setAmount(product.getAmount() - 1);
        }
    }

    public void removeItem(ShoppingCartItem product) {
        cartItems.remove(product);
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
