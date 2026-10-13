public class Product {

    private String productName;
    private double productPrice;
    private double vatRate;


    public Product(String productName, double productPrice, double vatRate) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.vatRate = vatRate;
    }

    public String getProductName() {
        return productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public double getVatRate() {
        return vatRate;
    }
}



