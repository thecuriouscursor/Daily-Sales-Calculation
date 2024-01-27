/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dailysalescalculation;

/**
 *
 * @author Kristin Maureal 
 * @credits chatGPT for explaining concepts and syntax implementation
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Abstraction
abstract class Sales {
    public abstract double calculateSales(double x, double y);
}

// Abstraction
interface InputBox {
    void displayInputBox();
}

class ProductSales extends Sales implements InputBox {
    
    Variables V = new Variables("0", 0.0, 0.0, 0.0, 0.0); 
    
    @Override
    public void displayInputBox() {
        // Defining components
        JFrame productSoldFrame = new JFrame("Phone Sold");
        JLabel itemNameLabel = new JLabel("Item Name: ");
        JTextField itemNameField = new JTextField(20);
        JLabel priceLabel = new JLabel("Price: ");
        JTextField priceField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantity: ");
        JTextField quantityField = new JTextField(5);
        JButton calculateButton = new JButton("Calculate");
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String itemName = itemNameField.getText();
                double price = Double.parseDouble(priceField.getText());
                V.setPrice(price);
                int quantity = Integer.parseInt(quantityField.getText());
                V.setQuantity(quantity);
                
                // Calculate and display sales
                double totalSales = calculateSales(price, quantity);
                JOptionPane.showMessageDialog(productSoldFrame, "Item Name: " + itemName + "\nTotal Sales: " + totalSales);
            }
        });
        
        // Assembling the components
        GroupLayout layout = new GroupLayout(productSoldFrame.getContentPane());
        productSoldFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemNameLabel)
                    .addComponent(priceLabel)
                    .addComponent(quantityLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemNameLabel)
                    .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quantityLabel)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        
        productSoldFrame.setSize(400, 250);
        productSoldFrame.setVisible(true);
    }
    
    @Override
    public double calculateSales(double price, double quantity) {
        double p = V.getPrice();
        double q = V.getQuantity();

        return p * q;
    }
}

class ServiceSales extends Sales implements InputBox {
    
    Variables V = new Variables("0", 0.0, 0.0, 0.0, 0.0);
    
    @Override
    public void displayInputBox() {
        JFrame repairServiceFrame = new JFrame("Repair Service");
        JLabel serviceNameLabel = new JLabel("Service Name: ");
        JTextField serviceNameField = new JTextField(20);
        JLabel priceperhrLabel = new JLabel("Price per hour: ");
        JTextField priceperhrField = new JTextField(10);
        JLabel nhrsLabel = new JLabel("Number of hours: ");
        JTextField nhrsField = new JTextField(5);
        JButton calculateButton = new JButton("Calculate");
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String serviceName = serviceNameField.getText();
                double priceperhr = Double.parseDouble(priceperhrField.getText());
                V.setPriceperhr(priceperhr);
                int nhrs = Integer.parseInt(nhrsField.getText());
                V.setNhrs(nhrs);
                
                
                // Calculate and display sales
                double totalSales = calculateSales(priceperhr, nhrs);
                JOptionPane.showMessageDialog(repairServiceFrame, "Service Name: " + serviceName + "\nTotal Sales: " + totalSales);
            }
        });
        
        // Assembling the components
        GroupLayout layout = new GroupLayout(repairServiceFrame.getContentPane());
        repairServiceFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serviceNameLabel)
                    .addComponent(priceperhrLabel)
                    .addComponent(nhrsLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceperhrField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nhrsField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serviceNameLabel)
                    .addComponent(serviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(priceperhrLabel)
                    .addComponent(priceperhrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nhrsLabel)
                    .addComponent(nhrsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        
        repairServiceFrame.setSize(500, 250);
        repairServiceFrame.setVisible(true);
    }
        
    @Override
    public double calculateSales(double pph, double nhrs) {
        double p = V.getPriceperhr();
        double n = V.getNhrs();
        
        return p * n;
    }
}

class Variables {
    private String name;
    private double price;
    private double quantity;
    private double priceperhr;
    private double nhrs;
    
    // Constructor
    public Variables(String name, double price, double quantity, double priceperhr, double nhrs) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.priceperhr = priceperhr;
        this.nhrs = nhrs;
    } 
    
    // getters
    public double getPrice() {
        return price;
    }
    public double getQuantity() {
        return quantity;
    }
    public double getPriceperhr() {
        return priceperhr;
    }
    public double getNhrs() {
        return nhrs;
    }
    
    // setters
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public void setPriceperhr(double priceperhr) {
        this.priceperhr = priceperhr;
    }
    public void setNhrs(double nhrs) {
        this.nhrs = nhrs;
    }
    
}


public class DailySalesCalculation {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // GUI with Swing
            JFrame mainFrame = new JFrame("Daily Sales Calculation Program");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel("Welcome to Daily Sales Calculation", JLabel.CENTER);

            JButton productButton = new JButton("Product");
            JButton serviceButton = new JButton("Service");

            ProductSales P = new ProductSales();
            ServiceSales S = new ServiceSales();

            productButton.addActionListener(e -> {
                P.displayInputBox();
            });

            serviceButton.addActionListener(e -> {
                S.displayInputBox();
            });

            // Binding the main components
            mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
            mainFrame.add(label);
            mainFrame.add(productButton);
            mainFrame.add(serviceButton);
            mainFrame.setSize(300, 110);
            mainFrame.setVisible(true);
        });
    }
}
