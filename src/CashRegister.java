import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.TextArea;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.event.*;



public class CashRegister implements ActionListener {


    JFrame frame;
    JTextArea receipt;

    JButton coffeeButton;
    JButton sugarButton;
    JButton flourButton;
    JButton chipsButton;
    JButton milkButton;
    JButton butterButton;
    JButton pepsiButton;
    JButton fantaButton;

    Produkt coffee;
    Produkt sugar;
    Produkt flour;
    Produkt chips;
    Produkt milk;
    Produkt butter;
    Produkt pepsi;
    Produkt fanta;

    Produkt selectedProduct;

    JTextArea inputProductName;
    JTextArea inputCount;
    JButton addToReceiptButton;
    JButton payButton;


    public CashRegister(){
        frame = new JFrame("KASSASYSTEM");

        coffee = new Produkt("Kaffe", 67.50);
        sugar = new Produkt("Socker", 21.99);
        flour = new Produkt("Mjöl", 23.50);
        chips = new Produkt("Chips", 32.79);
        milk = new Produkt("Mjölk", 19.99);
        butter = new Produkt("Smör", 47.50);
        pepsi = new Produkt("Pepsi", 17.50);
        fanta = new Produkt("Fanta", 18.50);
        createReceiptArea();

        createQuickButtonsArea();
        coffeeButton.addActionListener(this);
        sugarButton.addActionListener(this);
        flourButton.addActionListener(this);
        chipsButton.addActionListener(this);
        milkButton.addActionListener(this);
        butterButton.addActionListener(this);
        pepsiButton.addActionListener(this);
        fantaButton.addActionListener(this);
        createAddArea();

        addToReceiptButton.addActionListener(this);


        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(1000,800);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        frame.setVisible(true);


    }

    private void createAddArea(){
        inputProductName = new JTextArea();
        inputProductName.setBounds(20,650,300,30);
        inputProductName.setFont(new Font("Arial Black", Font.BOLD, 18));
        frame.add(inputProductName);

        JLabel label = new JLabel("Antal");
        label.setBounds(340,625,300,30);
        label.setForeground(Color.WHITE);
        frame.add(label);

        inputCount = new JTextArea();
        inputCount.setBounds(330,650,50,30);
        inputCount.setFont(new Font("Arial Black", Font.BOLD, 18));
        frame.add(inputCount);


        addToReceiptButton = new JButton("Add");
        addToReceiptButton.setBounds(400,640,70,50);
        addToReceiptButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
        frame.add(addToReceiptButton);


        payButton = new JButton("Pay");
        payButton.setBounds(480,640,70,50);
        payButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
        frame.add(payButton);


    }

    private void createQuickButtonsArea() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setBackground(Color.green);
        panel.setPreferredSize(new Dimension(600, 600));

        coffeeButton = new JButton("Kaffe");
        panel.add(coffeeButton);
        sugarButton = new JButton("Socker");
        panel.add(sugarButton);
        flourButton = new JButton("Mjöl");
        panel.add(flourButton);
        chipsButton = new JButton("Chips");
        panel.add(chipsButton);
        milkButton = new JButton("Mjölk");
        panel.add(milkButton);
        butterButton = new JButton("Smör");
        panel.add(butterButton);
        pepsiButton = new JButton("Pepsi");
        panel.add(pepsiButton);
        fantaButton = new JButton("Fanta");
        panel.add(fantaButton);




        panel.setBounds(0, 0, 600, 600);

        frame.add(panel);
    }

    private void createReceiptArea() {
        receipt = new JTextArea();
        receipt.setSize(400,400);
        receipt.setLineWrap(true);
        receipt.setEditable(false);
        receipt.setVisible(true);
        receipt.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane (receipt);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(600, 0, 400, 1000);

        frame.add(scroll);
    }

    public void run(){




    /*     receipt.append("                     STEFANS SUPERSHOP\n");
        receipt.append("----------------------------------------------------\n");
        receipt.append("\n");
        receipt.append("Kvittonummer: 122        Datum: 2024-09-01 13:00:21\n");
        receipt.append("----------------------------------------------------\n");
        receipt.append("Kaffe Gevalia           5 *     51.00    =   255.00  \n");
        receipt.append("Nallebjörn              1 *     110.00   =   110.00  \n");
        receipt.append("Total                                        ------\n");
        receipt.append("                                             306.00\n");
        receipt.append("TACK FÖR DITT KÖP\n");*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == coffeeButton) {
            inputProductName.setText(coffee.getProductName());
            selectedProduct = coffee;
        } else if (e.getSource() == sugarButton) {
            inputProductName.setText(sugar.getProductName());
            selectedProduct = sugar;
        } else if (e.getSource() == flourButton) {
            inputProductName.setText(flour.getProductName());
            selectedProduct = flour;
        } else if (e.getSource() == chipsButton) {
            inputProductName.setText(chips.getProductName());
            selectedProduct = chips;
        } else if (e.getSource() == milkButton) {
            inputProductName.setText(milk.getProductName());
            selectedProduct = milk;
        } else if (e.getSource() == butterButton) {
            inputProductName.setText(butter.getProductName());
            selectedProduct = butter;
        } else if (e.getSource() == pepsiButton) {
            inputProductName.setText(pepsi.getProductName());
            selectedProduct = pepsi;
        } else if (e.getSource() == fantaButton) {
            inputProductName.setText(fanta.getProductName());
            selectedProduct = fanta;
        } else if (e.getSource() == addToReceiptButton) {
            try {
                int count = Integer.parseInt(inputCount.getText());              //1. Antalet
                double sum = selectedProduct.getProductPrice() * count;          //2. Summan
                receipt.append(String.format("%-20s %2d * %7.2f = %7.2f\n",selectedProduct.getProductName(), count, selectedProduct.getProductPrice(), sum));    //3. Sriver ut raden

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Skriv in heltal!");
            }
        }
    }
}
