import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame {

    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        Conn c = new Conn();
        int balance = getBalance(c);  // Retrieve balance from the database

        // Store the balance in the database
        saveBalance(c, balance);

        JLabel text = new JLabel("YOUR CURRENT AMOUNT BALANCE IS RS : " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        JButton back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(ae -> {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        });
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    // Method to calculate the current balance
    private int getBalance(Conn conn) {
        int balance = 0;
        try {
            String query = "SELECT * FROM bank WHERE pin = '" + pinnumber + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return balance;
    }

    // Method to store the balance in the database
    private void saveBalance(Conn conn, int balance) {
        try {
            String query = "UPDATE bank SET balance = '" + balance + "' WHERE pin = '" + pinnumber + "'";
            conn.s.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
