import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Roboto", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        add(religion);

        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String[] valCategory = {"GENERAL", "OBC", "SC", "ST", "OTHERS"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        add(category);

        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        dob.setBounds(100, 240, 300, 30);
        add(dob);

        String[] incomeCategory = {"NULL", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 250, 400, 30);
        add(income);

        JLabel gender = new JLabel("Qualification : ");
        gender.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        gender.setBounds(100, 290, 300, 30);
        add(gender);

        String[] educationValue = {"Graduate", "Post-Graduate", "Student", "PhD", "12 Pass", "OTHERS"};
        education = new JComboBox(educationValue);
        education.setBounds(300, 290, 400, 30);
        add(education);

        JLabel marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        marital.setBounds(100, 340, 300, 30);
        add(marital);

        String[] occupationalValue = {"Salaried", "Self-Employed", "Businessman/woman", "Student", "Retired", "OTHERS"};
        occupation = new JComboBox(occupationalValue);
        occupation.setBounds(300, 340, 400, 30);
        add(occupation);

        JLabel address = new JLabel("PAN NO : ");
        address.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        address.setBounds(100, 390, 300, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Aptos", Font.ITALIC, 14));
        pan.setBounds(300, 390, 400, 30);
        add(pan);

        JLabel aadharno = new JLabel("Aadhar No : ");
        aadharno.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        aadharno.setBounds(100, 440, 300, 30);
        add(aadharno);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Aptos", Font.ITALIC, 14));
        aadhar.setBounds(300, 440, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        state.setBounds(100, 490, 300, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(450, 490, 100, 30);
        syes.setBackground(Color.YELLOW);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(600, 490, 100, 30);
        sno.setBackground(Color.YELLOW);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel pinno = new JLabel("Existing Account : ");
        pinno.setFont(new Font("Bahnschrift Light", Font.BOLD, 20));
        pinno.setBounds(100, 540, 300, 30);
        add(pinno);

        eyes = new JRadioButton("YES");
        eyes.setBounds(450, 540, 100, 30);
        eyes.setBackground(Color.YELLOW);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(600, 540, 100, 30);
        eno.setBackground(Color.YELLOW);
        add(eno);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.YELLOW);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    private void showMessage(String message, Color bgColor) {
        JOptionPane pane = new JOptionPane(message, JOptionPane.WARNING_MESSAGE);
        JDialog dialog = pane.createDialog("Warning");
        dialog.getContentPane().setBackground(bgColor);
        dialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = syes.isSelected() ? "YES" : "NO";
        String existingaccount = eyes.isSelected() ? "YES" : "NO";
        String span = pan.getText();
        String saadhar = aadhar.getText();

        // Validation checks
        if (sreligion == null || sreligion.isEmpty()) {
            showMessage("Please select a religion", Color.LIGHT_GRAY);
        } else if (scategory == null || scategory.isEmpty()) {
            showMessage("Please select a category", Color.LIGHT_GRAY);
        } else if (sincome == null || sincome.isEmpty()) {
            showMessage("Please select an income category", Color.LIGHT_GRAY);
        } else if (seducation == null || seducation.isEmpty()) {
            showMessage("Please select a qualification", Color.LIGHT_GRAY);
        } else if (soccupation == null || soccupation.isEmpty()) {
            showMessage("Please select an occupation", Color.LIGHT_GRAY);
        } else if (span.isEmpty()) {
            showMessage("PAN number cannot be empty!", Color.LIGHT_GRAY);
        } else if (saadhar.isEmpty()) {
            showMessage("Aadhar number cannot be empty!", Color.LIGHT_GRAY);
        } else {
            // All validations passed, proceed to the next step
            System.out.println("All inputs are valid. Proceeding to the next step...");
            // You can create and show the next form/page here
        }

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorcitizen + "','" + existingaccount + "')";
            c.s.executeUpdate(query);

            setVisible(false); // Hide SignupTwo
            new SignupThree(formno).setVisible(true); // Open SignupThree
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        // Create an instance of SignupTwo with a dummy form number
        new SignupTwo("");
    }
}
