import java.sql.*;
import javax.swing.*;
import project.ConnectionProvider;

public class NewBook extends javax.swing.JFrame {

    public NewBook() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Component initialization
        JLabel labelBookId = new JLabel("Book ID");
        JLabel labelName = new JLabel("Name");
        JLabel labelPublisher = new JLabel("Publisher");
        JLabel labelPrice = new JLabel("Price");
        JLabel labelYear = new JLabel("Publication Year");

        JTextField textBookId = new JTextField();
        JTextField textName = new JTextField();
        JTextField textPublisher = new JTextField();
        JTextField textPrice = new JTextField();
        JTextField textYear = new JTextField();

        JButton btnSave = new JButton("Save");
        JButton btnClose = new JButton("Close");

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/Image/123456.png")));

        // Set window properties
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 125));
        setUndecorated(true);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Add components to frame
        add(labelBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 100, -1));
        add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 100, -1));
        add(labelPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 100, -1));
        add(labelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 100, -1));
        add(labelYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 120, -1));

        add(textBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 320, -1));
        add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 320, -1));
        add(textPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 320, -1));
        add(textPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 320, -1));
        add(textYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 320, -1));

        btnSave.setIcon(new ImageIcon(getClass().getResource("/Image/save-icon--1.png")));
        btnSave.addActionListener(e -> {
            String bookId = textBookId.getText();
            String name = textName.getText();
            String publisher = textPublisher.getText();
            String price = textPrice.getText();
            String year = textYear.getText();

            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO book VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, bookId);
                ps.setString(2, name);
                ps.setString(3, publisher);
                ps.setString(4, price);
                ps.setString(5, year);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Book details saved successfully.");
                setVisible(false);
                new NewBook().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                setVisible(false);
                new NewBook().setVisible(true);
            }
        });

        btnClose.setIcon(new ImageIcon(getClass().getResource("/Image/red-x-mark-transparent-background-3.png")));
        btnClose.addActionListener(e -> setVisible(false));

        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));
        add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewBook().setVisible(true));
    }
}
