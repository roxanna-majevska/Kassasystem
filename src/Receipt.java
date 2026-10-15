import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Receipt {

    private ArrayList<ReceiptRow> rows = new ArrayList<>();

    private int receiptNumber;                   // Kvittots eget nummer.
    private LocalDateTime dateTime = LocalDateTime.now();

    public Receipt (int receiptNumber) {  // Tar emot numret.
        this.receiptNumber = receiptNumber;
    }

    public void addRow(Product item, int count) {        // Lägger en rad i listan med ReceiptRow.
        ReceiptRow row = new ReceiptRow(item, count);
        rows.add(row);
    }

    public double getTotalBrutto() {     // Går igenom alla rader och lägger ihop dem.
        double brutto = 0;
        for (ReceiptRow row : rows) {     // Tar en rad i taget ur listan och kallar den row.
            brutto = brutto + row.getBrutto();  // Ger radens bruttosumma.
        }
        return brutto;
    }

    public double getTotalVat() {
        double vat = 0;
        for (ReceiptRow row : rows) {
            vat = vat + row.getVatAmount();
        }
        return vat;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public String getReceiptText() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = "Kvitto nr " + receiptNumber  + "      Datum: " + dateTime.format(format) + "\n\n";
        for (ReceiptRow row : rows) {
            text = text + String.format("%-20s %2d * %7.2f = %7.2f\n",
                    row.getProduct().getProductName(),
                    row.getCount(),
                    row.getProduct().getProductPrice(),
                    row.getBrutto());
        }
        text = text + String.format("\n%36s%7.2f\n", "Total:" , getTotalBrutto());
        return text;
    }
    public String getVatTableText() {
        String text = "\n" + String.format("%8s %10s %10s %10s\n", "Moms %", "Moms", "Netto", "Brutto");
        for (ReceiptRow row : rows) {
            text  = text  + String.format("%8.1f %10.2f %10.2f %10.2f\n",
                    row.getProduct().getVatRate(), // Moms %
                    row.getVatAmount(),            // Moms för raden
                    row.getNetto(),
                    row.getBrutto());
        }
        return text;

    }

}
