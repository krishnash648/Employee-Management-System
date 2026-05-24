package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfeducation, tffname, tfaddress, tfphone,
            tfemail, tfsalary, tfdesignation;

    JLabel lblempId, lblname, lbldob, lblaadhar;

    JButton updateBtn, backBtn;

    String empId;

    UpdateEmployee(String empId) {

        this.empId = empId;

        setTitle("Update Employee");

        setSize(1100, 700);

        setLocationRelativeTo(null);

        setResizable(false);

        setLayout(null);

        getContentPane().setBackground(new Color(6, 10, 18));

        // ================= MAIN CARD =================

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(null);

        mainPanel.setBounds(120, 60, 850, 540);

        mainPanel.setBackground(new Color(20, 26, 38));

        mainPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,20),
                        1
                )
        );

        add(mainPanel);

        // ================= HEADING =================

        JLabel heading = new JLabel("Update Employee");

        heading.setBounds(240, 30, 400, 45);

        heading.setForeground(Color.WHITE);

        heading.setHorizontalAlignment(SwingConstants.CENTER);

        heading.setFont(new Font("Segoe UI", Font.BOLD, 34));

        mainPanel.add(heading);

        // ================= SUBHEADING =================

        JLabel subheading = new JLabel("Modify employee information");

        subheading.setBounds(250, 75, 350, 30);

        subheading.setForeground(new Color(0, 200, 255));

        subheading.setHorizontalAlignment(SwingConstants.CENTER);

        subheading.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        mainPanel.add(subheading);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 16);

        // ================= LEFT COLUMN =================

        mainPanel.add(createLabel("Name", 70, 150, labelFont));

        lblname = createValueLabel(240, 150);

        mainPanel.add(lblname);

        mainPanel.add(createLabel("Date of Birth", 70, 215, labelFont));

        lbldob = createValueLabel(240, 215);

        mainPanel.add(lbldob);

        mainPanel.add(createLabel("Address", 70, 280, labelFont));

        tfaddress = createTextField(240, 280);

        mainPanel.add(tfaddress);

        mainPanel.add(createLabel("Email", 70, 345, labelFont));

        tfemail = createTextField(240, 345);

        mainPanel.add(tfemail);

        mainPanel.add(createLabel("Designation", 70, 410, labelFont));

        tfdesignation = createTextField(240, 410);

        mainPanel.add(tfdesignation);

        // ================= RIGHT COLUMN =================

        mainPanel.add(createLabel("Father's Name", 460, 150, labelFont));

        tffname = createTextField(620, 150);

        mainPanel.add(tffname);

        mainPanel.add(createLabel("Salary", 460, 215, labelFont));

        tfsalary = createTextField(620, 215);

        mainPanel.add(tfsalary);

        mainPanel.add(createLabel("Phone", 460, 280, labelFont));

        tfphone = createTextField(620, 280);

        mainPanel.add(tfphone);

        mainPanel.add(createLabel("Education", 460, 345, labelFont));

        tfeducation = createTextField(620, 345);

        mainPanel.add(tfeducation);

        mainPanel.add(createLabel("Aadhar Number", 460, 410, labelFont));

        lblaadhar = createValueLabel(620, 410);

        mainPanel.add(lblaadhar);

        // ================= EMPLOYEE ID =================

        JLabel empLabel = new JLabel("Employee ID :");

        empLabel.setBounds(70, 470, 150, 30);

        empLabel.setForeground(Color.WHITE);

        empLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));

        mainPanel.add(empLabel);

        lblempId = new JLabel();

        lblempId.setBounds(220, 470, 200, 30);

        lblempId.setForeground(new Color(0, 200, 255));

        lblempId.setFont(new Font("Segoe UI", Font.BOLD, 20));

        mainPanel.add(lblempId);

        // ================= FETCH DATA =================

        try {

            Conn c = new Conn();

            String query =
                    "select * from employee where empId = '" + empId + "'";

            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {

                lblname.setText(rs.getString("name"));

                tffname.setText(rs.getString("fname"));

                lbldob.setText(rs.getString("dob"));

                tfaddress.setText(rs.getString("address"));

                tfsalary.setText(rs.getString("salary"));

                tfphone.setText(rs.getString("phone"));

                tfemail.setText(rs.getString("email"));

                tfeducation.setText(rs.getString("education"));

                lblaadhar.setText(rs.getString("aadhar"));

                lblempId.setText(rs.getString("empId"));

                tfdesignation.setText(rs.getString("designation"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        // ================= BUTTONS =================

        updateBtn = new JButton("Update Employee");

        updateBtn.setBounds(500, 465, 160, 42);

        styleButton(updateBtn, new Color(0, 170, 120));

        updateBtn.addActionListener(this);

        mainPanel.add(updateBtn);

        backBtn = new JButton("Back");

        backBtn.setBounds(680, 465, 110, 42);

        styleButton(backBtn, new Color(220, 53, 69));

        backBtn.addActionListener(this);

        mainPanel.add(backBtn);

        setVisible(true);
    }

    // ================= LABEL =================

    private JLabel createLabel(String text, int x, int y, Font font) {

        JLabel label = new JLabel(text);

        label.setBounds(x, y, 160, 35);

        label.setForeground(Color.WHITE);

        label.setFont(font);

        return label;
    }

    // ================= VALUE LABEL =================

    private JLabel createValueLabel(int x, int y) {

        JLabel label = new JLabel();

        label.setBounds(x, y, 220, 35);

        label.setForeground(new Color(220,220,220));

        label.setFont(new Font("Segoe UI", Font.BOLD, 16));

        return label;
    }

    // ================= TEXT FIELD =================

    private JTextField createTextField(int x, int y) {

        JTextField tf = new JTextField();

        tf.setBounds(x, y, 180, 38);

        tf.setBackground(new Color(35, 42, 58));

        tf.setForeground(Color.WHITE);

        tf.setCaretColor(Color.WHITE);

        tf.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(255,255,255,25),
                                1
                        ),
                        BorderFactory.createEmptyBorder(5, 12, 5, 12)
                )
        );

        tf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        return tf;
    }

    // ================= BUTTON STYLE =================

    private void styleButton(JButton button, Color color) {

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFont(new Font("Segoe UI", Font.BOLD, 15));

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                button.setBackground(color.brighter());
            }

            public void mouseExited(MouseEvent e) {

                button.setBackground(color);
            }
        });
    }

    // ================= ACTIONS =================

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == updateBtn) {

            String fname = tffname.getText();

            String salary = tfsalary.getText();

            String address = tfaddress.getText();

            String phone = tfphone.getText();

            String email = tfemail.getText();

            String education = tfeducation.getText();

            String designation = tfdesignation.getText();

            try {

                Conn conn = new Conn();

                String query =
                        "update employee set fname = '" + fname +
                        "', salary = '" + salary +
                        "', address = '" + address +
                        "', phone = '" + phone +
                        "', email = '" + email +
                        "', education = '" + education +
                        "', designation = '" + designation +
                        "' where empId = '" + empId + "'";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Employee Updated Successfully"
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

        new UpdateEmployee("");
    }
}