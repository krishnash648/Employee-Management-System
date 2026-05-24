package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();

    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfaddress, tfphone,
            tfaadhar, tfemail, tfsalary, tfdesignation;

    JDateChooser dcdob;

    JComboBox<String> cbeducation;

    JLabel lblempId;

    JButton add, back;

    AddEmployee() {

        setTitle("Add Employee");

        // ================= BACKGROUND IMAGE =================

        ImageIcon bgIcon = new ImageIcon(
                ClassLoader.getSystemResource("icons/bg.jpg")
        );

        Image bgImg = bgIcon.getImage().getScaledInstance(
                1400,
                800,
                Image.SCALE_SMOOTH
        );

        JLabel background = new JLabel(new ImageIcon(bgImg));

        background.setLayout(new GridBagLayout());

        setContentPane(background);

        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel();

        mainPanel.setPreferredSize(new Dimension(1200, 720));

        mainPanel.setOpaque(false);

        mainPanel.setLayout(null);

        background.add(mainPanel);

        // ================= HEADING PANEL =================

        JPanel headingPanel = new JPanel();

        headingPanel.setBounds(470, 40, 320, 70);

        headingPanel.setBackground(new Color(10, 10, 10, 210));

        headingPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255, 255, 255, 25),
                        1
                )
        );

        headingPanel.setLayout(new BorderLayout());

        mainPanel.add(headingPanel);

        JLabel heading = new JLabel("Add Employee");

        heading.setForeground(Color.WHITE);

        heading.setHorizontalAlignment(SwingConstants.CENTER);

        heading.setFont(new Font("Segoe UI", Font.BOLD, 34));

        headingPanel.add(heading);

        // ================= FORM PANEL =================

        JPanel formPanel = new JPanel();

        formPanel.setLayout(null);

        formPanel.setBackground(new Color(10, 10, 10, 210));

        formPanel.setBounds(310, 140, 620, 500);

        formPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255, 255, 255, 25),
                        1
                )
        );

        mainPanel.add(formPanel);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 17);

        // ================= NAME =================

        JLabel labelname = createLabel("Name", 40, 40, labelFont);

        formPanel.add(labelname);

        tfname = createTextField(150, 40);

        formPanel.add(tfname);

        // ================= FATHER NAME =================

        JLabel labelfname = createLabel("Father's Name", 330, 40, labelFont);

        formPanel.add(labelfname);

        tffname = createTextField(450, 40);

        formPanel.add(tffname);

        // ================= DOB =================

        JLabel labeldob = createLabel("Date of Birth", 40, 110, labelFont);

        formPanel.add(labeldob);

        dcdob = new JDateChooser();

        dcdob.setBounds(150, 110, 160, 38);

        dcdob.setBackground(new Color(45, 45, 45));

        JTextField dateText =
                (JTextField) dcdob.getDateEditor().getUiComponent();

        dateText.setBackground(new Color(45, 45, 45));

        dateText.setForeground(Color.WHITE);

        dateText.setCaretColor(Color.WHITE);

        dateText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        formPanel.add(dcdob);

        // ================= SALARY =================

        JLabel labelsalary = createLabel("Salary", 330, 110, labelFont);

        formPanel.add(labelsalary);

        tfsalary = createTextField(450, 110);

        formPanel.add(tfsalary);

        // ================= ADDRESS =================

        JLabel labeladdress = createLabel("Address", 40, 180, labelFont);

        formPanel.add(labeladdress);

        tfaddress = createTextField(150, 180);

        formPanel.add(tfaddress);

        // ================= PHONE =================

        JLabel labelphone = createLabel("Phone", 330, 180, labelFont);

        formPanel.add(labelphone);

        tfphone = createTextField(450, 180);

        formPanel.add(tfphone);

        // ================= EMAIL =================

        JLabel labelemail = createLabel("Email", 40, 250, labelFont);

        formPanel.add(labelemail);

        tfemail = createTextField(150, 250);

        formPanel.add(tfemail);

        // ================= EDUCATION =================

        JLabel labeleducation = createLabel("Education", 330, 250, labelFont);

        formPanel.add(labeleducation);

        String courses[] = {
                "BBA",
                "BCA",
                "BA",
                "BSC",
                "B.COM",
                "BTech",
                "MBA",
                "MCA",
                "MA",
                "MTech",
                "MSC",
                "PHD"
        };

        cbeducation = new JComboBox<>(courses);

        cbeducation.setBounds(450, 250, 160, 38);

        cbeducation.setBackground(new Color(45, 45, 45));

        cbeducation.setForeground(Color.WHITE);

        cbeducation.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        cbeducation.setBorder(BorderFactory.createEmptyBorder());

        formPanel.add(cbeducation);

        // ================= DESIGNATION =================

        JLabel labeldesignation = createLabel("Designation", 40, 320, labelFont);

        formPanel.add(labeldesignation);

        tfdesignation = createTextField(150, 320);

        formPanel.add(tfdesignation);

        // ================= AADHAR =================

        JLabel labelaadhar = createLabel("Aadhar Number", 330, 320, labelFont);

        formPanel.add(labelaadhar);

        tfaadhar = createTextField(450, 320);

        formPanel.add(tfaadhar);

        // ================= EMPLOYEE ID =================

        JLabel labelempId = createLabel("Employee ID", 40, 390, labelFont);

        formPanel.add(labelempId);

        lblempId = new JLabel("" + number);

        lblempId.setBounds(150, 390, 200, 35);

        lblempId.setForeground(Color.WHITE);

        lblempId.setFont(new Font("Segoe UI", Font.BOLD, 22));

        formPanel.add(lblempId);

        // ================= BUTTONS =================

        add = new JButton("Add Employee");

        add.setBounds(430, 670, 160, 42);

        styleButton(add);

        add.addActionListener(this);

        mainPanel.add(add);

        back = new JButton("Back");

        back.setBounds(620, 670, 160, 42);

        styleButton(back);

        back.addActionListener(this);

        mainPanel.add(back);

        // ================= FRAME =================

        setSize(1400, 800);

        setLocationRelativeTo(null);

        setResizable(false);

        setVisible(true);
    }

    // ================= LABEL STYLE =================

    private JLabel createLabel(String text, int x, int y, Font font) {

        JLabel label = new JLabel(text);

        label.setBounds(x, y, 180, 35);

        label.setForeground(Color.WHITE);

        label.setFont(font);

        return label;
    }

    // ================= TEXTFIELD STYLE =================

    private JTextField createTextField(int x, int y) {

        JTextField tf = new JTextField();

        tf.setBounds(x, y, 160, 38);

        tf.setBackground(new Color(45, 45, 45));

        tf.setForeground(Color.WHITE);

        tf.setCaretColor(Color.WHITE);

        tf.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));

        tf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        return tf;
    }

    // ================= BUTTON STYLE =================

    private void styleButton(JButton button) {

        button.setBackground(new Color(52, 152, 219));

        button.setForeground(Color.WHITE);

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setFont(new Font("Segoe UI", Font.BOLD, 15));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );
    }

    // ================= ACTION =================

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            String name = tfname.getText();

            String fname = tffname.getText();

            String dob = ((JTextField)
                    dcdob.getDateEditor().getUiComponent()).getText();

            String salary = tfsalary.getText();

            String address = tfaddress.getText();

            String phone = tfphone.getText();

            String email = tfemail.getText();

            String education =
                    (String) cbeducation.getSelectedItem();

            String designation = tfdesignation.getText();

            String aadhar = tfaadhar.getText();

            String empId = lblempId.getText();

            try {

                Conn conn = new Conn();

                String query =
                        "insert into employee values('" +
                                name + "', '" +
                                fname + "', '" +
                                dob + "', '" +
                                salary + "', '" +
                                address + "', '" +
                                phone + "', '" +
                                email + "', '" +
                                education + "', '" +
                                designation + "', '" +
                                aadhar + "', '" +
                                empId + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Employee Added Successfully"
                );

                setVisible(false);

                new Home();

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {

            setVisible(false);

            new Home();
        }
    }

    public static void main(String[] args) {

        new AddEmployee();
    }
}