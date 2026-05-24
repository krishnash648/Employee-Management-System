package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove;

    Home() {

        setTitle("Employee Management System");

        setSize(1400, 800);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        setLayout(null);

        // ================= MAIN BACKGROUND =================

        getContentPane().setBackground(new Color(7, 11, 20));

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();

        sidebar.setLayout(null);

        sidebar.setBackground(new Color(15, 20, 30));

        sidebar.setBounds(0, 0, 270, 800);

        sidebar.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        0,
                        1,
                        new Color(255,255,255,15)
                )
        );

        add(sidebar);

        // ================= LOGO =================

        JLabel logo = new JLabel("EMS");

        logo.setForeground(new Color(0, 200, 255));

        logo.setFont(new Font("Segoe UI", Font.BOLD, 42));

        logo.setBounds(40, 35, 150, 50);

        sidebar.add(logo);

        // ================= TITLE =================

        JLabel title = new JLabel("Dashboard");

        title.setForeground(Color.WHITE);

        title.setFont(new Font("Segoe UI", Font.BOLD, 30));

        title.setBounds(40, 85, 220, 40);

        sidebar.add(title);

        // ================= WELCOME =================

        JLabel welcome = new JLabel("Welcome Admin");

        welcome.setForeground(new Color(170,170,170));

        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        welcome.setBounds(43, 132, 200, 25);

        sidebar.add(welcome);

        // ================= DIVIDER =================

        JSeparator separator = new JSeparator();

        separator.setBounds(35, 190, 190, 10);

        separator.setForeground(new Color(255,255,255,25));

        sidebar.add(separator);

        // ================= QUICK ACTION =================

        JLabel quick = new JLabel("Quick Actions");

        quick.setForeground(new Color(0,200,255));

        quick.setFont(new Font("Segoe UI", Font.BOLD, 19));

        quick.setBounds(40, 230, 200, 30);

        sidebar.add(quick);

        // ================= MENU PANEL =================

        JPanel menuPanel = new JPanel();

        menuPanel.setLayout(new GridLayout(4, 1, 0, 18));

        menuPanel.setBackground(new Color(15, 20, 30));

        menuPanel.setBounds(35, 290, 200, 240);

        sidebar.add(menuPanel);

        // ================= SIDEBAR BUTTONS =================

        add = createMenuButton("Add Employee");

        add.addActionListener(this);

        menuPanel.add(add);

        view = createMenuButton("View Employees");

        view.addActionListener(this);

        menuPanel.add(view);

        update = createMenuButton("Update Employee");

        update.addActionListener(this);

        menuPanel.add(update);

        remove = createMenuButton("Remove Employee");

        remove.addActionListener(this);

        menuPanel.add(remove);

        // ================= FOOTER =================

        JLabel footer = new JLabel("Designed by Krishna");

        footer.setForeground(new Color(120,120,120));

        footer.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        footer.setBounds(45, 710, 180, 20);

        sidebar.add(footer);

        // ================= MAIN CONTENT PANEL =================

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(null);

        mainPanel.setBounds(320, 70, 980, 610);

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

        topTag.setBounds(0, 45, 980, 25);

        topTag.setHorizontalAlignment(SwingConstants.CENTER);

        topTag.setForeground(new Color(0,200,255));

        topTag.setFont(new Font("Segoe UI", Font.BOLD, 15));

        mainPanel.add(topTag);

        // ================= MAIN HEADING =================

        JLabel heading = new JLabel("Manage Employees");

        heading.setBounds(0, 80, 980, 60);

        heading.setHorizontalAlignment(SwingConstants.CENTER);

        heading.setForeground(Color.WHITE);

        heading.setFont(new Font("Segoe UI", Font.BOLD, 42));

        mainPanel.add(heading);

        // ================= SUBHEADING =================

        JLabel subheading = new JLabel(
                "Track records, update employee data and manage workforce efficiently"
        );

        subheading.setBounds(0, 145, 980, 30);

        subheading.setHorizontalAlignment(SwingConstants.CENTER);

        subheading.setForeground(new Color(170,170,170));

        subheading.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        mainPanel.add(subheading);

        // ================= STATS CARDS =================

        JPanel stat1 = createStatCard(
                "Employee Records",
                "Manage employee database"
        );

        stat1.setBounds(90, 240, 240, 120);

        mainPanel.add(stat1);

        JPanel stat2 = createStatCard(
                "Updates & Changes",
                "Modify employee details"
        );

        stat2.setBounds(370, 240, 240, 120);

        mainPanel.add(stat2);

        JPanel stat3 = createStatCard(
                "Admin Controls",
                "Remove and manage users"
        );

        stat3.setBounds(650, 240, 240, 120);

        mainPanel.add(stat3);

        // ================= BOTTOM INFO PANEL =================

        JPanel infoPanel = new JPanel();

        infoPanel.setLayout(null);

        infoPanel.setBackground(new Color(20, 26, 38));

        infoPanel.setBounds(90, 430, 800, 95);

        infoPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,15),
                        1
                )
        );

        mainPanel.add(infoPanel);

        JLabel infoTitle = new JLabel("System Overview");

        infoTitle.setForeground(Color.WHITE);

        infoTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));

        infoTitle.setBounds(30, 18, 250, 25);

        infoPanel.add(infoTitle);

        JLabel infoText = new JLabel(
                "Access employee details, update records, manage data and streamline operations from one dashboard."
        );

        infoText.setForeground(new Color(190,190,190));

        infoText.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        infoText.setBounds(30, 50, 740, 25);

        infoPanel.add(infoText);

        setVisible(true);
    }

    // ================= STAT CARD =================

    private JPanel createStatCard(String title, String subtitle) {

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(20, 26, 38));

        panel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,15),
                        1
                )
        );

        JLabel titleLbl = new JLabel(title);

        titleLbl.setForeground(Color.WHITE);

        titleLbl.setFont(new Font("Segoe UI", Font.BOLD, 20));

        titleLbl.setBounds(25, 30, 200, 25);

        panel.add(titleLbl);

        JLabel subLbl = new JLabel(subtitle);

        subLbl.setForeground(new Color(170,170,170));

        subLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        subLbl.setBounds(25, 65, 200, 20);

        panel.add(subLbl);

        return panel;
    }

    // ================= MENU BUTTON =================

    private JButton createMenuButton(String text) {

        JButton button = new JButton(text);

        button.setBackground(new Color(20, 26, 38));

        button.setForeground(Color.WHITE);

        button.setFont(new Font("Segoe UI", Font.BOLD, 16));

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setBorder(
                BorderFactory.createEmptyBorder(0, 18, 0, 0)
        );

        button.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                button.setBackground(new Color(0, 173, 181));
            }

            public void mouseExited(MouseEvent e) {

                button.setBackground(new Color(20, 26, 38));
            }
        });

        return button;
    }

    // ================= ACTIONS =================

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            setVisible(false);

            new AddEmployee();

        } else if (ae.getSource() == view) {

            setVisible(false);

            new ViewEmployee();

        } else if (ae.getSource() == update) {

            setVisible(false);

            new ViewEmployee();

        } else if (ae.getSource() == remove) {

            setVisible(false);

            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {

        new Home();
    }
}