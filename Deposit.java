import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 450, 25);
        image.add(text);  // Adding text to image

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
            } else {
                try {
                    // Validate if the entered amount is a valid integer
                    int depositAmount = Integer.parseInt(number);
                    Conn conn = new Conn();

                    // Insert deposit transaction into the bank table
                    String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', '" + date + "', 'Deposit', '" + depositAmount + "')";
                    conn.s.executeUpdate(query);

                    // Fetch the updated balance after deposit
                    int updatedBalance = getBalance(conn);

                    // Inform the user about the successful deposit and updated balance
                    JOptionPane.showMessageDialog(null, "RS " + depositAmount + " Deposited Successfully\nUpdated Balance: RS " + updatedBalance);

                    // Clear the amount field after successful deposit
                    amount.setText("");

                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error while processing the deposit. Please try again.");
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
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

    public static void main(String[] args) {
        new Deposit("");
    }
}
