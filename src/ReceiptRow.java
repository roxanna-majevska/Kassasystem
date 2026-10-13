public class ReceiptRow {

    private Product product;
    private int count;

    public ReceiptRow (Product product, int count) {
        this.product = product;
        this.count = count;
    }
    public Product getProduct() {
        return product;
    }
    public int getCount() {
        return count;
    }

    public double getBrutto()  {
        return product.getProductPrice() * count;
    }
    public double getNetto() {
        return getBrutto() / (1.0 + product.getVatRate() / 100.0);
    }
    public double getVatAmount() {
        return getBrutto() - getNetto();
    }
}
