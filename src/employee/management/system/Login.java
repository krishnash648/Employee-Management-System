package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername;

    JPasswordField tfpassword;

    JButton login;

    Login() {

        setTitle("Employee Management System");

        setSize(1100, 650);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(new Color(7, 11, 20));

        // ================= LEFT PANEL =================

        JPanel leftPanel = new JPanel();

        leftPanel.setBounds(0, 0, 470, 650);

        leftPanel.setBackground(new Color(15, 20, 30));

        leftPanel.setLayout(null);

        add(leftPanel);

        // ================= LOGO =================

        JLabel logo = new JLabel("EMS");

        logo.setForeground(new Color(0, 200, 255));

        logo.setFont(new Font("Segoe UI", Font.BOLD, 46));

        logo.setBounds(60, 55, 200, 50);

        leftPanel.add(logo);

        // ================= TITLE =================

        JLabel title = new JLabel("Welcome Back");

        title.setForeground(Color.WHITE);

        title.setFont(new Font("Segoe UI", Font.BOLD, 36));

        title.setBounds(60, 120, 320, 45);

        leftPanel.add(title);

        // ================= SUBTITLE =================

        JLabel subtitle = new JLabel(
                "Login to access employee dashboard"
        );

        subtitle.setForeground(new Color(170,170,170));

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        subtitle.setBounds(62, 170, 320, 30);

        leftPanel.add(subtitle);

        // ================= USERNAME =================

        JLabel lblusername = new JLabel("Username");

        lblusername.setForeground(Color.WHITE);

        lblusername.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        lblusername.setBounds(60, 255, 120, 25);

        leftPanel.add(lblusername);

        tfusername = new JTextField();

        tfusername.setBounds(60, 290, 330, 48);

        styleTextField(tfusername);

        leftPanel.add(tfusername);

        // ================= PASSWORD =================

        JLabel lblpassword = new JLabel("Password");

        lblpassword.setForeground(Color.WHITE);

        lblpassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        lblpassword.setBounds(60, 365, 120, 25);

        leftPanel.add(lblpassword);

        tfpassword = new JPasswordField();

        tfpassword.setBounds(60, 400, 330, 48);

        styleTextField(tfpassword);

        leftPanel.add(tfpassword);

        // ================= LOGIN BUTTON =================

        login = new JButton("LOGIN");

        login.setBounds(60, 500, 330, 50);

        login.setBackground(new Color(0, 173, 181));

        login.setForeground(Color.WHITE);

        login.setFont(new Font("Segoe UI", Font.BOLD, 17));

        login.setFocusPainted(false);

        login.setBorderPainted(false);

        login.setCursor(new Cursor(Cursor.HAND_CURSOR));

        login.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                login.setBackground(new Color(0, 150, 160));
            }

            public void mouseExited(MouseEvent e) {

                login.setBackground(new Color(0, 173, 181));
            }
        });

        login.addActionListener(this);

        leftPanel.add(login);

        // ================= LOGIN INFO =================

        JLabel demo = new JLabel(
                "Demo Login : admin / 12345"
        );

        demo.setForeground(new Color(130,130,130));

        demo.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        demo.setBounds(110, 565, 250, 25);

        leftPanel.add(demo);

        // ================= RIGHT PANEL =================

        JPanel rightPanel = new JPanel();

        rightPanel.setBounds(470, 0, 630, 650);

        rightPanel.setBackground(new Color(10, 14, 24));

        rightPanel.setLayout(null);

        add(rightPanel);

        // ================= IMAGE CARD =================

        JPanel imageCard = new JPanel();

        imageCard.setBounds(80, 85, 470, 470);

        imageCard.setBackground(new Color(20, 26, 38));

        imageCard.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,15),
                        1
                )
        );

        imageCard.setLayout(null);

        rightPanel.add(imageCard);

        // ================= IMAGE =================

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/second.jpg")
        );

        Image i2 = i1.getImage().getScaledInstance(
                360,
                360,
                Image.SCALE_SMOOTH
        );

        JLabel image = new JLabel(new ImageIcon(i2));

        image.setBounds(55, 35, 360, 360);

        imageCard.add(image);

        // ================= TEXT =================

        JLabel sideText = new JLabel(
                "Employee Management Portal"
        );

        sideText.setForeground(Color.WHITE);

        sideText.setFont(new Font("Segoe UI", Font.BOLD, 24));

        sideText.setHorizontalAlignment(SwingConstants.CENTER);

        sideText.setBounds(30, 410, 400, 30);

        imageCard.add(sideText);

        setVisible(true);
    }

    // ================= TEXTFIELD STYLE =================

    private void styleTextField(JTextField tf) {

        tf.setBackground(new Color(25, 30, 40));

        tf.setForeground(Color.WHITE);

        tf.setCaretColor(Color.WHITE);

        tf.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(255,255,255,20),
                                1
                        ),
                        BorderFactory.createEmptyBorder(5, 14, 5, 14)
                )
        );

        tf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    }

    // ================= ACTION =================

    public void actionPerformed(ActionEvent ae) {

        try {

            String username = tfusername.getText();

            String password =
                    String.valueOf(tfpassword.getPassword());

            Conn c = new Conn();

            String query =
                    "select * from login where username = '" +
                    username +
                    "' and password = '" +
                    password + "'";

            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {

                setVisible(false);

                new Home();

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Username or Password"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}