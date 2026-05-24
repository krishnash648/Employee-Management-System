package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    JButton continueBtn;

    Splash() {

        setTitle("Employee Management System");

        setSize(1400, 800);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        // ================= BACKGROUND =================

        getContentPane().setBackground(new Color(7, 11, 20));

        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(null);

        mainPanel.setBounds(80, 40, 1220, 670);

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

        // ================= TOP LABEL =================

        JLabel topLabel = new JLabel(
                "EMPLOYEE MANAGEMENT SYSTEM"
        );

        topLabel.setBounds(0, 35, 1220, 25);

        topLabel.setForeground(new Color(0, 200, 255));

        topLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        mainPanel.add(topLabel);

        // ================= HEADING =================

        JLabel heading = new JLabel(
                "Manage Employees Efficiently"
        );

        heading.setBounds(0, 70, 1220, 60);

        heading.setForeground(Color.WHITE);

        heading.setHorizontalAlignment(SwingConstants.CENTER);

        heading.setFont(new Font("Segoe UI", Font.BOLD, 46));

        mainPanel.add(heading);

        // ================= SUBTITLE =================

        JLabel subtitle = new JLabel(
                "Modern employee administration and management dashboard"
        );

        subtitle.setBounds(0, 135, 1220, 30);

        subtitle.setForeground(new Color(145,145,145));

        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 19));

        mainPanel.add(subtitle);

        // ================= IMAGE =================
        
        ImageIcon i1 = new ImageIcon(
        ClassLoader.getSystemResource("icons/front.jpg")
        );

        Image i2 = i1.getImage().getScaledInstance(
        760,
        300,
        Image.SCALE_SMOOTH
        );

        JLabel image = new JLabel(new ImageIcon(i2));

        image.setBounds(230, 240, 760, 300);

        mainPanel.add(image);

        // ================= CONTINUE BUTTON =================

        continueBtn = new JButton("CONTINUE");

        continueBtn.setBounds(500, 575, 220, 52);

        continueBtn.setBackground(new Color(0, 173, 181));

        continueBtn.setForeground(Color.WHITE);

        continueBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));

        continueBtn.setFocusPainted(false);

        continueBtn.setBorderPainted(false);

        continueBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        continueBtn.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                continueBtn.setBackground(
                        new Color(0, 150, 160)
                );
            }

            public void mouseExited(MouseEvent e) {

                continueBtn.setBackground(
                        new Color(0, 173, 181)
                );
            }
        });

        continueBtn.addActionListener(this);

        mainPanel.add(continueBtn);

        // ================= SMALL TEXT =================

        JLabel hint = new JLabel(
                "Click to continue"
        );

        hint.setBounds(0, 630, 1220, 20);

        hint.setForeground(new Color(120,120,120));

        hint.setHorizontalAlignment(SwingConstants.CENTER);

        hint.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        mainPanel.add(hint);

        setVisible(true);
    }

    // ================= ACTION =================

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);

        new Login();
    }

    public static void main(String args[]) {

        new Splash();
    }
}