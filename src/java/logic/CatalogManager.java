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
    private Integer formID;
    private String formName;
    private Double formPrice;

    public CatalogManager() {
        productList = new ArrayList<>();
    }

    @PostConstruct
    public void initCatalog() {
        productList.add(new Product(1, "Masque de ski", 149.99));
        productList.add(new Product(2, "Skis", 1322.0));
        productList.add(new Product(3, "Micka", 9000.0));
    }

    public String createProduct() {
        productList.add(new Product(formID, formName, formPrice));
        return "gotocatalog";
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getFormID() {
        return formID;
    }

    public void setFormID(Integer formID) {
        this.formID = formID;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Double getFormPrice() {
        return formPrice;
    }

    public void setFormPrice(Double formPrice) {
        this.formPrice = formPrice;
    }

}
