import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("BANK MANAGEMENT SYSTEM");
        setLayout(null);

        // Load image (ensure the image path is correct)
        ImageIcon i1 = new ImageIcon("logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100); // resize the image
        add(label);

        JLabel text = new JLabel("WELCOME");
        text.setFont(new Font("ALGERIAN", Font.BOLD, 38));
        text.setBounds(280, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Arial Black", Font.BOLD, 28));
        cardno.setBounds(120, 150, 200, 40);
        add(cardno);

        cardTextField = new JTextField(); // Text box for card number
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Aptos", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PASSWORD:");
        pin.setFont(new Font("Arial Black", Font.BOLD, 28));
        pin.setBounds(120, 220, 194, 25);
        add(pin);

        pinTextField = new JPasswordField(); // Password field
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Aptos", Font.BOLD, 14));
        add(pinTextField);

        // Buttons
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Frame background color
        getContentPane().setBackground(Color.cyan);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            String cardnumber = cardTextField.getText();
            String pinnumber = new String(pinTextField.getPassword());

            Conn conn = new Conn(); // Assuming Conn is defined elsewhere
            String query = "SELECT * FROM login WHERE cardnumber = '" + cardnumber + "' AND pin = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true); // Assuming Transaction class is defined
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            new SignupOne().setVisible(true); // Assuming SignupOne class is defined
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
