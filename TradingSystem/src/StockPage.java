import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

// Shared User Interface - allows users to visualize the stock data
public class StockPage extends JFrame {
    private ManagerService ms;
    private Stock stock;
    private JTextField priceField = new JTextField(10);
    private JTextField nameField = new JTextField(10);
    private JTextField symbolField = new JTextField(10);
    private JButton updateButton = new JButton("Update Price");
    private JButton updateNameButton = new JButton("Update Name");
    private JButton updateSymbolButton = new JButton("Update Symbol");
    private JButton deactivateButton = new JButton("Deactivate");
    JButton cancelButton = new JButton("Cancel");

    public StockPage(Stock stock) {
        this.stock = stock;
        this.ms = ManagerService.getInstance();

        setTitle("Stock Page");
        setSize(600, 200);

        // Add stock information to the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("ID:"));
        panel.add(new JLabel(Integer.toString(stock.getID())));

        panel.add(new JLabel("Name:"));
        panel.add(new JLabel(stock.getName()));

        panel.add(new JLabel("Symbol:"));
        panel.add(new JLabel(stock.getSymbol()));

        panel.add(new JLabel("Price:"));
        panel.add(new JLabel(Double.toString(stock.getPrice())));

        // Add price update fields to the panel
        panel.add(new JLabel("Update Price:"));
        panel.add(priceField);

        // Add name update fields to the panel
        panel.add(new JLabel("Update Name:"));
        panel.add(nameField);

        // Add symbol update fields to the panel
        panel.add(new JLabel("Update Symbol:"));
        panel.add(symbolField);

        // Add update and deactivate buttons to the panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(updateButton);
        buttonPanel.add(updateNameButton);
        buttonPanel.add(updateSymbolButton);
        buttonPanel.add(deactivateButton);
        buttonPanel.add(cancelButton);

        // Add action listener to update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double price = Double.parseDouble(priceField.getText().trim());
                    if (price <= 0 || Double.isInfinite(price)){
                        JOptionPane.showMessageDialog(null, "Please enter valid double price.", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else{
                        stock.setPrice(price);
                        ms.updateStockPrice(stock,price);
                    }
                    try {
                        ManageStocksPage msp = new ManageStocksPage();
                        msp.setVisible(true);
                        setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(StockPage.this, "Invalid price format.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Add action listener to update name button
        updateNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newName = nameField.getText();
                if (!newName.isEmpty()) {
                    try {
                        stock.setName(newName);
                        // Update the name in the database or perform any other necessary operations
                        ms.updateStockName(stock, newName);
                        ManageStocksPage msp = new ManageStocksPage();
                        msp.setVisible(true);
                        setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(StockPage.this, "Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

// Add action listener to update symbol button
        updateSymbolButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newSymbol = symbolField.getText();
                if (!newSymbol.isEmpty()) {
                    try {
                        stock.setSymbol(newSymbol);
                        // Update the symbol in the database or perform any other necessary operations
                        ms.updateStockSymbol(stock, newSymbol);
                        ManageStocksPage msp = new ManageStocksPage();
                        msp.setVisible(true);
                        setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(StockPage.this, "Please enter a valid symbol.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // redirect to ManageUsersPage
                ManageStocksPage msp = null;
                try {
                    msp = new ManageStocksPage();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                msp.setVisible(true);
                setVisible(false);
            }
        });

        // Add action listener to deactivate button
        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stock.setActive(false);
                ms.blockStock(stock.getSymbol());
                // open the manage stocks page
                try {
                    ManageStocksPage msp = new ManageStocksPage();
                    msp.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the panels to the JFrame
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
