import java.util.ArrayList;

public class Receipt {

    private ArrayList<ReceiptRow> rows = new ArrayList<>();

    public void addRow(Product item, int count) {        // Lägger en rad i listan.
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
}
