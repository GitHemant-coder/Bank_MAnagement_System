import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;

        setLayout(null);

        JLabel l1 = new JLabel("PAGE 3 : ACCOUNT DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("SAVING ACCOUNT");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.YELLOW);
        r1.setBounds(100, 200, 200, 30);
        add(r1);

        r2 = new JRadioButton("CURRENT ACCOUNT");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.YELLOW);
        r2.setBounds(100, 240, 200, 30);
        add(r2);

        r3 = new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.YELLOW);
        r3.setBounds(350, 200, 250, 30);
        add(r3);

        r4 = new JRadioButton("RECURRING DEPOSIT ACCOUNT");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.YELLOW);
        r4.setBounds(350, 240, 300, 30);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("CARD NUMBER:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel carddetail = new JLabel("Your 16 digit card number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 330, 300, 30);
        add(carddetail);

        JLabel pin = new JLabel("PASSWORD NUMBER:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 300, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel pinnumber = new JLabel("Your 04 digit password");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 12));
        pinnumber.setBounds(100, 400, 300, 30);
        add(pinnumber);

        JLabel service = new JLabel("SERVICES REQUIRED:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 450, 450, 30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.YELLOW);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.YELLOW);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.YELLOW);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL AND SMS ALERT");
        c4.setBackground(Color.YELLOW);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 250, 30);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.YELLOW);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.YELLOW);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.YELLOW);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);  // Make sure this is added
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);  // Make sure this is added
        add(cancel);

        getContentPane().setBackground(Color.YELLOW);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "SAVING ACCOUNT";
            } else if (r2.isSelected()) {
                accountType = "CURRENT ACCOUNT";
            } else if (r3.isSelected()) {
                accountType = "FIXED DEPOSIT ACCOUNT";
            } else if (r4.isSelected()) {
                accountType = "RECURRING DEPOSIT ACCOUNT";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);
            String pinnumber = String.format("%04d", random.nextInt(10000)); // Generates a 4-digit number

            StringBuilder facility = new StringBuilder();
            if (c1.isSelected()) facility.append("ATM CARD, ");
            if (c2.isSelected()) facility.append("INTERNET BANKING, ");
            if (c3.isSelected()) facility.append("MOBILE BANKING, ");
            if (c4.isSelected()) facility.append("EMAIL & SMS ALERTS, ");
            if (c5.isSelected()) facility.append("CHEQUE BOOK, ");
            if (c6.isSelected()) facility.append("E-STATEMENT, ");

            // Remove trailing comma
            if (facility.length() > 0) {
                facility.setLength(facility.length() - 2);
            }

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You must agree to the declaration");
                } else {
                    Conn conn = new Conn();
                    String query1 = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
                    conn.s.executeUpdate(query1);

                    String query2 = "INSERT INTO login VALUES('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true); // Navigate to the next step
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new SignupThree("");
    }
}
