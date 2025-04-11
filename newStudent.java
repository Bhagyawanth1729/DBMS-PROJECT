import java.sql.*;
import javax.swing.JOptionPane;
import project.ConnectionProvider;

public class NewStudent extends javax.swing.JFrame {

    public NewStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // UI Components Initialization
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 150));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Labels and Inputs
        jLabel1.setText("Student ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 92, -1));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 92, -1));
        jLabel3.setText("Email");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 92, -1));
        jLabel4.setText("Course Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 92, -1));
        jLabel5.setText("Branch Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        jTextField3.setBackground(new java.awt.Color(255, 255, 204));

        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 300, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 300, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 300, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"ICT"}));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"CSE", "IT", "MECHANICAL", "CIVIL"}));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 300, -1));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 300, -1));

        // Save Button
        jButton1.setText("Save");
        jButton1.addActionListener(evt -> saveStudent());
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        // Close Button
        jButton2.setText("Close");
        jButton2.addActionListener(evt -> setVisible(false));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/123456.png")));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        pack();
    }

    private void saveStudent() {
        String studentID = jTextField1.getText();
        String name = jTextField2.getText();
        String email = jTextField3.getText();
        String course = (String) jComboBox1.getSelectedItem();
        String branch = (String) jComboBox2.getSelectedItem();

        if (studentID.isEmpty() || name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please complete all fields.");
            return;
        }

        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();

            st.executeUpdate("INSERT INTO Student VALUES ('" + studentID + "', '" + name + "', '" + email + "', '" + course + "', '" + branch + "')");
            JOptionPane.showMessageDialog(null, "Student added successfully.");

            setVisible(false);
            new NewStudent().setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            setVisible(false);
            new NewStudent().setVisible(true);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new NewStudent().setVisible(true));
    }

    // Variable Declarations
    private javax.swing.JButton jButton1, jButton2;
    private javax.swing.JComboBox<String> jComboBox1, jComboBox2;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
    private javax.swing.JTextField jTextField1, jTextField2, jTextField3;
}
