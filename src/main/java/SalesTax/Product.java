package SalesTax;

public class Product {
    private String productName;
    private double price;
    private Category category;


    public Product(String productName, double price, Category category) {
        this.productName = productName;
        this.setPrice(price);
        this.category = category;
    }

    public Product() {
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String toString(){
        return this.productName + this.getPrice();
    }


    public boolean isExempted() {
        return !this.category.isExempted();
    }

    public boolean isImported() {
        return this.category.isImported();
    }

    public boolean isTaxable() {
        return !this.category.isExempted();
    }


    public boolean isImportedAndTaxable() {
        return this.category.isImported();
    }
}
