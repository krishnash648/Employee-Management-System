package employee.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;

    Choice cemployeeId;

    JButton search, print, update, back, refresh;

    JLabel totalEmployees;

    ViewEmployee() {

        setTitle("View Employees");

        setSize(1400, 820);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(new Color(5, 8, 15));

        // ================= MAIN CARD =================

        JPanel card = new JPanel();

        card.setLayout(null);

        card.setBounds(55, 35, 1270, 700);

        card.setBackground(new Color(14, 18, 28));

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(255,255,255,20),
                                1
                        ),
                        BorderFactory.createEmptyBorder(10,10,10,10)
                )
        );

        add(card);

        // ================= HEADING =================

        JLabel heading = new JLabel("Employee Details");

        heading.setBounds(0, 25, 1270, 50);

        heading.setForeground(Color.WHITE);

        heading.setHorizontalAlignment(SwingConstants.CENTER);

        heading.setFont(new Font("Segoe UI", Font.BOLD, 42));

        card.add(heading);

        // ================= SUBTITLE =================

        JLabel subtitle = new JLabel(
                "Manage, search and update employee records"
        );

        subtitle.setBounds(0, 75, 1270, 30);

        subtitle.setForeground(new Color(0, 200, 255));

        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        card.add(subtitle);

        // ================= FILTER PANEL =================

        JPanel filterPanel = new JPanel();

        filterPanel.setLayout(null);

        filterPanel.setBounds(70, 130, 1120, 90);

        filterPanel.setBackground(new Color(20, 25, 38));

        filterPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,15),
                        1
                )
        );

        card.add(filterPanel);

        // ================= SEARCH LABEL =================

        JLabel searchlbl = new JLabel("Employee ID");

        searchlbl.setBounds(35, 28, 150, 30);

        searchlbl.setForeground(Color.WHITE);

        searchlbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        filterPanel.add(searchlbl);

        // ================= CHOICE =================

        cemployeeId = new Choice();

        cemployeeId.setBounds(180, 28, 230, 34);

        cemployeeId.setBackground(new Color(40, 45, 60));

        cemployeeId.setForeground(Color.WHITE);

        filterPanel.add(cemployeeId);

        try {

            Conn c = new Conn();

            ResultSet rs =
                    c.s.executeQuery("select empId from employee");

            while (rs.next()) {

                cemployeeId.add(rs.getString("empId"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        // ================= TOTAL LABEL =================

        totalEmployees = new JLabel();

        totalEmployees.setBounds(930, 28, 160, 30);

        totalEmployees.setForeground(new Color(200,200,200));

        totalEmployees.setHorizontalAlignment(SwingConstants.RIGHT);

        totalEmployees.setFont(new Font("Segoe UI", Font.BOLD, 15));

        filterPanel.add(totalEmployees);

        updateEmployeeCount();

        // ================= BUTTONS =================

        search = createButton(
                "Search",
                new Color(37, 99, 235)
        );

        search.setBounds(450, 23, 120, 42);

        search.addActionListener(this);

        filterPanel.add(search);

        refresh = createButton(
                "Refresh",
                new Color(0, 170, 120)
        );

        refresh.setBounds(590, 23, 120, 42);

        refresh.addActionListener(this);

        filterPanel.add(refresh);

        print = createButton(
                "Print",
                new Color(75, 85, 99)
        );

        print.setBounds(730, 23, 120, 42);

        print.addActionListener(this);

        filterPanel.add(print);

        update = createButton(
                "Update",
                new Color(8, 145, 178)
        );

        update.setBounds(870, 23, 120, 42);

        update.addActionListener(this);

        filterPanel.add(update);

        // ================= TABLE =================

        table = new JTable();

        styleTable();

        loadTableData(
                "select empId, name, phone, email, designation, salary from employee"
        );

        JScrollPane jsp = new JScrollPane(table);

        jsp.setBounds(70, 255, 1120, 340);

        jsp.getViewport().setBackground(new Color(10, 14, 24));

        jsp.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,20),
                        1
                )
        );

        jsp.getVerticalScrollBar().setBackground(
                new Color(20, 25, 35)
        );

        card.add(jsp);

        // ================= INFO PANEL =================

        JPanel infoPanel = new JPanel();

        infoPanel.setLayout(null);

        infoPanel.setBounds(70, 615, 1120, 50);

        infoPanel.setBackground(new Color(20, 25, 38));

        infoPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255,255,255,15),
                        1
                )
        );

        card.add(infoPanel);

        JLabel info = new JLabel(
                "Showing employee records with essential details only"
        );

        info.setBounds(25, 10, 500, 30);

        info.setForeground(new Color(180,180,180));

        info.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        infoPanel.add(info);

        // ================= BACK BUTTON =================

        back = createButton(
                "Back",
                new Color(185, 28, 28)
        );

        back.setBounds(970, 8, 120, 34);

        back.addActionListener(this);

        infoPanel.add(back);

        setVisible(true);
    }

    // ================= TABLE STYLE =================

    private void styleTable() {

        table.setBackground(new Color(10, 14, 24));

        table.setForeground(Color.WHITE);

        table.setGridColor(new Color(255,255,255,10));

        table.setRowHeight(52);

        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        table.setSelectionBackground(new Color(0, 120, 170));

        table.setSelectionForeground(Color.WHITE);

        table.setShowVerticalLines(false);

        table.setIntercellSpacing(new Dimension(0, 1));

        table.setFocusable(false);

        JTableHeader header = table.getTableHeader();

        header.setBackground(new Color(25, 32, 45));

        header.setForeground(Color.WHITE);

        header.setFont(new Font("Segoe UI", Font.BOLD, 15));

        header.setPreferredSize(new Dimension(100, 48));

        header.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        new Color(255,255,255,20)
                )
        );
    }

    // ================= LOAD DATA =================

    private void loadTableData(String query) {

        try {

            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));

            DefaultTableCellRenderer centerRenderer =
                    new DefaultTableCellRenderer();

            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            centerRenderer.setBackground(new Color(10, 14, 24));

            centerRenderer.setForeground(Color.WHITE);

            for (int i = 0; i < table.getColumnCount(); i++) {

                table.getColumnModel()
                        .getColumn(i)
                        .setCellRenderer(centerRenderer);
            }

            // ================= COLUMN WIDTH =================

            table.getColumnModel().getColumn(0).setPreferredWidth(110);

            table.getColumnModel().getColumn(1).setPreferredWidth(220);

            table.getColumnModel().getColumn(2).setPreferredWidth(160);

            table.getColumnModel().getColumn(3).setPreferredWidth(320);

            table.getColumnModel().getColumn(4).setPreferredWidth(240);

            table.getColumnModel().getColumn(5).setPreferredWidth(130);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ================= EMPLOYEE COUNT =================

    private void updateEmployeeCount() {

        try {

            Conn c = new Conn();

            ResultSet rs =
                    c.s.executeQuery(
                            "select count(*) from employee"
                    );

            if (rs.next()) {

                totalEmployees.setText(
                        "Total : " + rs.getInt(1)
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ================= BUTTON DESIGN =================

    private JButton createButton(String text, Color color) {

        JButton button = new JButton(text);

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

        return button;
    }

    // ================= ACTIONS =================

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            loadTableData(
                    "select empId, name, phone, email, designation, salary " +
                    "from employee where empId = '" +
                    cemployeeId.getSelectedItem() + "'"
            );

        } else if (ae.getSource() == refresh) {

            loadTableData(
                    "select empId, name, phone, email, designation, salary from employee"
            );

        } else if (ae.getSource() == print) {

            try {

                table.print();

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {

            setVisible(false);

            new UpdateEmployee(
                    cemployeeId.getSelectedItem()
            );

        } else {

            setVisible(false);

            new Home();
        }
    }

    public static void main(String[] args) {

        new ViewEmployee();
    }
}