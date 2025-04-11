import java.sql.*;
import javax.swing.JOptionPane;
import project.ConnectionProvider;

public class ReturnBook extends javax.swing.JFrame {

    public ReturnBook() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabelBookId = new javax.swing.JLabel();
        jLabelStudentId = new javax.swing.JLabel();
        jLabelIssueDate = new javax.swing.JLabel();
        jLabelDueDate = new javax.swing.JLabel();

        textBookId = new javax.swing.JTextField();
        textStudentId = new javax.swing.JTextField();
        textIssueDate = new javax.swing.JTextField();
        textDueDate = new javax.swing.JTextField();

        buttonSearch = new javax.swing.JButton();
        buttonReturn = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();

        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 150));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBookId.setText("Book ID");
        getContentPane().add(jLabelBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabelStudentId.setText("Student ID");
        getContentPane().add(jLabelStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabelIssueDate.setText("Issue Date");
        getContentPane().add(jLabelIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jLabelDueDate.setText("Due Date");
        getContentPane().add(jLabelDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        getContentPane().add(textBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 319, -1));
        getContentPane().add(textStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 319, -1));
        getContentPane().add(textIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 319, -1));
        getContentPane().add(textDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 319, -1));

        buttonSearch.setText("Search");
        buttonSearch.addActionListener(evt -> searchBookRecord());
        getContentPane().add(buttonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        buttonReturn.setText("Return");
        buttonReturn.addActionListener(evt -> returnBook());
        getContentPane().add(buttonReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        buttonClose.setText("Close");
        buttonClose.addActionListener(evt -> setVisible(false));
        getContentPane().add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, -1, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/123456.png")));
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        pack();
    }

    private void searchBookRecord() {
        String bookId = textBookId.getText();
        String studentId = textStudentId.getText();

        try (Connection conn = ConnectionProvider.getCon();
             PreparedStatement pst = conn.prepareStatement("SELECT * FROM issue WHERE bookID = ? AND studentID = ?")) {

            pst.setString(1, bookId);
            pst.setString(2, studentId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                textIssueDate.setText(rs.getString("issueDate"));
                textDueDate.setText(rs.getString("dueDate"));
                textBookId.setEditable(false);
                textStudentId.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "No issued book found for this student.");
                resetForm();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while fetching data: " + e.getMessage());
        }
    }

    private void returnBook() {
        String bookId = textBookId.getText();
        String studentId = textStudentId.getText();

        if (bookId.isEmpty() || studentId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Both Book ID and Student ID are required.");
            return;
        }

        try (Connection conn = ConnectionProvider.getCon();
             PreparedStatement pst = conn.prepareStatement("UPDATE issue SET returnBook = ? WHERE bookID = ? AND studentID = ?")) {

            pst.setString(1, "YES");
            pst.setString(2, bookId);
            pst.setString(3, studentId);

            int updated = pst.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(null, "Book returned successfully.");
                resetForm();
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while returning book: " + e.getMessage());
        }
    }

    private void resetForm() {
        setVisible(false);
        new ReturnBook().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ReturnBook().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JLabel jLabelBookId;
    private javax.swing.JLabel jLabelStudentId;
    private javax.swing.JLabel jLabelIssueDate;
    private javax.swing.JLabel jLabelDueDate;
    private javax.swing.JLabel backgroundLabel;

    private javax.swing.JTextField textBookId;
    private javax.swing.JTextField textStudentId;
    private javax.swing.JTextField textIssueDate;
    private javax.swing.JTextField textDueDate;

    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonReturn;
    private javax.swing.JButton buttonClose;
}
