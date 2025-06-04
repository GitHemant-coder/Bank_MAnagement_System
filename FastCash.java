import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrwal,fastcash,exit,ministatement,pinchange,balanceenquiry;
    JLabel text;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber =  pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(230,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);//image.text becoz we have to add text on image if u dot do like this then text will not appear

        deposit = new JButton("RS 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        deposit.setBackground(Color.WHITE);
        image.add(deposit);

        withdrwal = new JButton("RS 500");
        withdrwal.setBounds(355,415,150,30);
        withdrwal.addActionListener(this);
        withdrwal.setBackground(Color.WHITE);
        image.add(withdrwal);

        fastcash = new JButton("RS 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        fastcash.setBackground(Color.WHITE);
        image.add(fastcash);

        ministatement = new JButton("RS 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        ministatement.setBackground(Color.WHITE);
        image.add(ministatement);

        pinchange = new JButton("RS 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        pinchange.setBackground(Color.WHITE);
        image.add(pinchange);

        balanceenquiry = new JButton("RS 10000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        balanceenquiry.setBackground(Color.WHITE);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        exit.setBackground(Color.WHITE);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); // RS 500 OR WHICH WE WILL CLICK
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount) ){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                // Fix: Specify column names in the insert query
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+ amount + " DEBITED SUCCESSFULLY");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        new FastCash("");
    }
}
