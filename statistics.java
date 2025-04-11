import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import project.ConnectionProvider;

public class Statistics extends javax.swing.JFrame {

    public Statistics() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 150));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                displayTables(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setText("Books Issued");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 6, 98, -1));

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Column 1", "Column 2", "Column 3", "Column 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 38, 659, 150));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Books Returned");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 109, -1));

        jTable2.setBackground(new java.awt.Color(255, 255, 204));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Column 1", "Column 2", "Column 3", "Column 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 659, 170));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/red-x-mark-transparent-background-3.png")));
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindow(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/123456.png")));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void displayTables(java.awt.event.ComponentEvent evt) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();

            ResultSet issuedBooks = st.executeQuery(
                "SELECT issue.studentID, student.name, issue.bookID, book.name, issue.issueDate, issue.dueDate " +
                "FROM student " +
                "JOIN issue ON student.studentID = issue.studentID " +
                "JOIN book ON book.bookID = issue.bookID " +
                "WHERE issue.returnBook = 'No'"
            );
            jTable1.setModel(DbUtils.resultSetToTableModel(issuedBooks));

            ResultSet returnedBooks = st.executeQuery(
                "SELECT issue.studentID, student.name, issue.bookID, book.name, issue.issueDate, issue.dueDate " +
                "FROM student " +
                "JOIN issue ON student.studentID = issue.studentID " +
                "JOIN book ON book.bookID = issue.bookID " +
                "WHERE issue.returnBook = 'YES'"
            );
            jTable2.setModel(DbUtils.resultSetToTableModel(returnedBooks));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to retrieve data from the database.");
        }
    }

    private void closeWindow(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Statistics().setVisible(true);
        });
    }

    // Component declarations
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
}
