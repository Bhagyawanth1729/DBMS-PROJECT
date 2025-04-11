import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginWindow extends javax.swing.JFrame {

    public LoginWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        usernameLabel.setText("Username");
        getContentPane().add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        passwordLabel.setText("Password");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 68, -1));

        usernameField.setBackground(new java.awt.Color(255, 255, 204));
        usernameField.setFont(new java.awt.Font("Segoe UI", 1, 14));
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 200, -1));

        loginBtn.setBackground(new java.awt.Color(255, 255, 204));
        loginBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/login.png")));
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnAction(evt);
            }
        });
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, -1, -1));

        closeBtn.setBackground(new java.awt.Color(255, 255, 204));
        closeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/red-x-mark-transparent-background-3.png")));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnAction(evt);
            }
        });
        getContentPane().add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, -1, -1));

        passwordField.setBackground(new java.awt.Color(255, 255, 204));
        passwordField.setFont(new java.awt.Font("Segoe UI", 1, 14));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 200, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Login background.PNG")));
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }

    private void loginBtnAction(java.awt.event.ActionEvent evt) {
        String enteredUser = usernameField.getText();
        String enteredPass = new String(passwordField.getPassword());

        if (enteredUser.equals("admin") && enteredPass.equals("admin")) {
            setVisible(false);
            new HomeScreen().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }

    private void closeBtnAction(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginWindow().setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration
}
