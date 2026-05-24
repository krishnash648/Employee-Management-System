package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpId;

    JButton delete, back;

    JLabel lblname, lblphone, lblemail, lblwarning;

    RemoveEmployee() {

        setTitle("Remove Employee");

        setSize(1250, 720);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(new Color(7, 11, 20));

        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(null);

        mainPanel.setBounds(70, 45, 1090, 590);

        mainPanel.setBackground(new Color(15, 20, 30));

        mainPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(255,255,255,18),
                                1
                        ),
                        BorderFactory.createEmptyBorder(20,20,20,20)
                )
        );

        add(mainPanel);

        // ================= TOP TAG =================

        JLabel topTag = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");

        topTag.setBounds(0, 25, 1090, 25);

        topTag.setForeground(new Color(0, 200, 255));

        topTag.setHorizontalAlignment(SwingConstants.CENTER);

        topTag.setFont(new Font("Segoe UI", Font.BOLD, 15));

        mainPanel.add(topTag);

        // ================= HEADING =================

        JLabel heading = new JLabel("Remove Employee");

        heading.setBounds(0, 55, 1090, 55);

        heading.setForeground(Color.WHITE);

        heading.setHorizontalAlignment(SwingConstants.CENTER);

        heading.setFont(new Font("Segoe UI", Font.BOLD, 40));

        mainPanel.add(heading);

        // ================= SUBHEADING =================

        JLabel subheading = new JLabel(
                "Remove employee records from the database"
        );

        subheading.setBounds(0, 110, 1090, 30);

        subheading.setForeground(new Color(170,170,170));

        subheading.setHorizontalAlignment(SwingConstants.CENTER);

        subheading.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        mainPanel.add(subheading);

        // ================= LEFT CARD =================

        JPanel infoCard = new JPanel();

        infoCard.setLayout(null);

        infoCard.setBounds(70, 180, 430, 300);

        infoCard.setBackground(new Color(20, 26, 38));

        infoCard.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,15),
                        1
                )
        );

        mainPanel.add(infoCard);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 18);

        Font valueFont = new Font("Segoe UI", Font.BOLD, 17);

        // ================= EMPLOYEE ID =================

        JLabel labelempId = new JLabel("Employee ID");

        labelempId.setBounds(35, 35, 150, 30);

        labelempId.setForeground(Color.WHITE);

        labelempId.setFont(labelFont);

        infoCard.add(labelempId);

        cEmpId = new Choice();

        cEmpId.setBounds(190, 35, 180, 32);

        cEmpId.setBackground(new Color(35, 42, 58));

        cEmpId.setForeground(Color.WHITE);

        infoCard.add(cEmpId);

        try {

            Conn c = new Conn();

            ResultSet rs =
                    c.s.executeQuery(
                            "select empId from employee"
                    );

            while (rs.next()) {

                cEmpId.add(rs.getString("empId"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        // ================= NAME =================

        JLabel labelname = new JLabel("Name");

        labelname.setBounds(35, 105, 150, 30);

        labelname.setForeground(Color.WHITE);

        labelname.setFont(labelFont);

        infoCard.add(labelname);

        lblname = new JLabel();

        lblname.setBounds(190, 105, 200, 30);

        lblname.setForeground(new Color(220,220,220));

        lblname.setFont(valueFont);

        infoCard.add(lblname);

        // ================= PHONE =================

        JLabel labelphone = new JLabel("Phone");

        labelphone.setBounds(35, 165, 150, 30);

        labelphone.setForeground(Color.WHITE);

        labelphone.setFont(labelFont);

        infoCard.add(labelphone);

        lblphone = new JLabel();

        lblphone.setBounds(190, 165, 200, 30);

        lblphone.setForeground(new Color(220,220,220));

        lblphone.setFont(valueFont);

        infoCard.add(lblphone);

        // ================= EMAIL =================

        JLabel labelemailText = new JLabel("Email");

        labelemailText.setBounds(35, 225, 150, 30);

        labelemailText.setForeground(Color.WHITE);

        labelemailText.setFont(labelFont);

        infoCard.add(labelemailText);

        lblemail = new JLabel();

        lblemail.setBounds(190, 225, 220, 30);

        lblemail.setForeground(new Color(220,220,220));

        lblemail.setFont(new Font("Segoe UI", Font.BOLD, 15));

        infoCard.add(lblemail);

        // ================= RIGHT CARD =================

        JPanel imageCard = new JPanel();

        imageCard.setLayout(null);

        imageCard.setBounds(580, 180, 430, 300);

        imageCard.setBackground(new Color(20, 26, 38));

        imageCard.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,15),
                        1
                )
        );

        mainPanel.add(imageCard);

        // ================= IMAGE =================

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/delete.png")
        );

        Image i2 = i1.getImage().getScaledInstance(
                180,
                180,
                Image.SCALE_SMOOTH
        );

        JLabel image = new JLabel(new ImageIcon(i2));

        image.setBounds(125, 25, 180, 180);

        imageCard.add(image);

        // ================= WARNING =================

        lblwarning = new JLabel(
                "Warning: This action cannot be undone"
        );

        lblwarning.setBounds(40, 225, 350, 30);

        lblwarning.setHorizontalAlignment(SwingConstants.CENTER);

        lblwarning.setForeground(new Color(255, 99, 99));

        lblwarning.setFont(new Font("Segoe UI", Font.BOLD, 17));

        imageCard.add(lblwarning);

        // ================= BUTTONS PANEL =================

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(1, 2, 30, 0));

        buttonPanel.setBackground(new Color(15, 20, 30));

        buttonPanel.setBounds(310, 515, 470, 50);

        mainPanel.add(buttonPanel);

        // ================= DELETE BUTTON =================

        delete = createButton(
                "Delete Employee",
                new Color(220, 38, 38)
        );

        delete.addActionListener(this);

        buttonPanel.add(delete);

        // ================= BACK BUTTON =================

        back = createButton(
                "Back",
                new Color(75, 85, 99)
        );

        back.addActionListener(this);

        buttonPanel.add(back);

        // ================= FETCH DATA =================

        fetchEmployeeData();

        cEmpId.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                fetchEmployeeData();
            }
        });

        setVisible(true);
    }

    // ================= FETCH EMPLOYEE =================

    private void fetchEmployeeData() {

        try {

            Conn c = new Conn();

            String query =
                    "select * from employee where empId = '" +
                    cEmpId.getSelectedItem() + "'";

            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {

                lblname.setText(rs.getString("name"));

                lblphone.setText(rs.getString("phone"));

                lblemail.setText(rs.getString("email"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ================= BUTTON STYLE =================

    private JButton createButton(String text, Color color) {

        JButton button = new JButton(text);

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFont(new Font("Segoe UI", Font.BOLD, 16));

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

        return button;
    }

    // ================= ACTIONS =================

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == delete) {

            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this employee?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                try {

                    Conn c = new Conn();

                    String query =
                            "delete from employee where empId = '" +
                            cEmpId.getSelectedItem() + "'";

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(
                            null,
                            "Employee Deleted Successfully"
                    );

                    setVisible(false);

                    new Home();

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

        } else {

            setVisible(false);

            new Home();
        }
    }

    public static void main(String[] args) {

        new RemoveEmployee();
    }
}