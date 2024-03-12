package logic;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

import model.Product;

@Named
@ApplicationScoped
public class CatalogManager implements Serializable {

    private List<Product> productList;

    public CatalogManager() {
    }

    @PostConstruct
    public void initCatalog() {
        productList = new ArrayList<>();
        productList.add(new Product(0, "Masque de ski", 149.99));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
