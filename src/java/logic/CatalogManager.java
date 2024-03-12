package logic;

import java.util.List;
import java.io.Serializable;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

import model.Product;

@Named
@ApplicationScoped
public class CatalogManager implements Serializable {

    private List<Product> productList;

    public CatalogManager() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
