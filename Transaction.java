import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawal, fastcash, exit, ministatement, pinchange, balanceenquiry;
    JLabel text;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Please Select your Transaction");
        text.setBounds(230, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Transaction buttons
        deposit = createButton("Deposit", 170, 415);
        withdrawal = createButton("Cash Withdrawal", 355, 415);
        fastcash = createButton("Fast Cash", 170, 450);
        ministatement = createButton("Mini Statement", 355, 450);
        pinchange = createButton("Pin Change", 170, 485);
        balanceenquiry = createButton("Balance Enquiry", 355, 485);
        exit = createButton("EXIT", 355, 520);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 30);
        button.addActionListener(this);
        button.setBackground(Color.WHITE);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == exit) {
            int response = JOptionPane.showConfirmDialog(this, "Do you really want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (source == deposit) {
            new Deposit(pinnumber).setVisible(true);
            dispose(); // Close the current frame
        } else if (source == withdrawal) {
            new Withdrawl(pinnumber).setVisible(true);
            dispose(); // Close the current frame
        } else if (source == fastcash) {
            new FastCash(pinnumber).setVisible(true);
            dispose(); // Close the current frame
        } else if (source == pinchange) {
            new PinChange(pinnumber).setVisible(true);
            dispose(); // Close the current frame
        } else if (source == balanceenquiry) {
            new BalanceEnquiry(pinnumber).setVisible(true);
            dispose(); // Close the current frame
        } else if (source == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
            dispose(); // Close the current frame
        }
    }

    public static void main(String args[]) {
        new Transaction("");
    }
}
