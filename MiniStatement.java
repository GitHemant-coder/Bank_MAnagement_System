import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;  // Store the PIN number
        setTitle("MINI STATEMENT");
        setLayout(null);

        JLabel mini = new JLabel("<html>");
        add(mini);

        JLabel bank = new JLabel("MAHARASHTRIAN BANK");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            if (rs.next()) {
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace for better debugging
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("YOUR CURRENT ACCOUNT BALANCE IS RS " + bal);
            balance.setBounds(20, 450, 400, 20);  // Adjust bounds as necessary
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace for better debugging
        }

        mini.setText(mini.getText() + "</html>");
        mini.setBounds(20, 140, 400, 250);  // Adjust height based on expected content

        // Set a larger font for better visibility
        Font font = new Font("Arial", Font.PLAIN, 16);
        mini.setFont(font);
        card.setFont(font);
        balance.setFont(font);

        setSize(500, 700);  // Increase window size for more space
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        // Handle window close event to reopen Transaction window
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                new Transaction(pinnumber).setVisible(true);  // Reopen Transaction window
                dispose();  // Dispose of the MiniStatement window
            }
        });
    }

    public static void main(String[] args) {
        new MiniStatement("1234");  // Test with a sample PIN number
    }
}
