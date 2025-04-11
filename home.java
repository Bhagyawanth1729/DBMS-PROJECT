/**
 * Main dashboard window for the Library Management System.
 * Provides access to key modules like adding students, books,
 * issuing/returning books, and viewing stats.
 */
public class HomeScreen extends javax.swing.JFrame {

    public HomeScreen() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="GUI Initialization">
    private void initComponents() {

        btnAddStudent = new javax.swing.JButton();
        btnAddBook = new javax.swing.JButton();
        btnStats = new javax.swing.JButton();
        btnIssue = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/member-add-on-300x300.png")));
        btnAddStudent.setText("Add Student");
        btnAddStudent.setPreferredSize(new java.awt.Dimension(159, 59));
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 22, -1, -1));

        btnAddBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/New book.png")));
        btnAddBook.setText("Add Book");
        btnAddBook.setPreferredSize(new java.awt.Dimension(159, 59));
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        btnStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Statics.png")));
        btnStats.setText("Reports");
        btnStats.setPreferredSize(new java.awt.Dimension(159, 59));
        btnStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsActionPerformed(evt);
            }
        });
        getContentPane().add(btnStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        btnIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/issue.png")));
        btnIssue.setText("Issue Book");
        btnIssue.setPreferredSize(new java.awt.Dimension(159, 59));
        btnIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssueActionPerformed(evt);
            }
        });
        getContentPane().add(btnIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/return-book-1-560407.png")));
        btnReturn.setText("Return Book");
        btnReturn.setPreferredSize(new java.awt.Dimension(159, 59));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, -1, -1));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png")));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 20, -1, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Library_Book_532388_1366x768.jpg")));
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        pack();
    }// </editor-fold>

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new LoginScreen().setVisible(true);
    }

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {
        new AddStudentForm().setVisible(true);
    }

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {
        new AddBookForm().setVisible(true);
    }

    private void btnIssueActionPerformed(java.awt.event.ActionEvent evt) {
        new IssueBookForm().setVisible(true);
    }

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {
        new ReturnBookForm().setVisible(true);
    }

    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {
        new StatisticsForm().setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }

    // Component variable declarations
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnStats;
    private javax.swing.JButton btnIssue;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel backgroundLabel;
}
