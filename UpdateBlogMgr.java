package data.managers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import data.Database;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdateBlogMgr {

    public void getUpd() {
        final JFrame logIn = new JFrame();
        logIn.setLayout(null);
        logIn.setBounds(0, 0, 400, 300);
        JPanel p = new JPanel();
        p.setBounds(logIn.getBounds());
        JLabel uname = new JLabel();
        uname.setBounds(10, 10, 100, 20);
        uname.setText("E-mail:");
        final JTextField username = new JTextField();
        username.setBounds(113, 10, 100, 24);
        JLabel pword = new JLabel();
        pword.setBounds(10, 40, 100, 20);
        pword.setText("Password:");
        final JPasswordField password = new JPasswordField();
        password.setBounds(113, 40, 100, 24);
        JButton lgin = new JButton();
        lgin.setBounds(200, 70, 70, 20);
        lgin.setText("Log In");
        p.setLayout(null);
        p.add(uname);
        p.add(username);
        p.add(pword);
        p.add(password);
        p.add(lgin);
        logIn.add(p);
        logIn.setVisible(true);
        lgin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Database db = new Database();
                    String sql1 = "SELECT email FROM blog WHERE title = '" + UpdateBlogSingleton.getInstance().getTitle() + "'";
                    ResultSet res1 = db.query(sql1);
                    if(res1.next()) {
                        String sql2 = "SELECT email FROM blog_signup WHERE email = '" + username.getText() + "'"
                                + " AND password = '" + password.getSelectedText() + "'";
                        ResultSet res2 = db.query(sql2);
                        if(res2.next()) {
                            UpdateBlogSingleton.getInstance().getInsertEmail().setText(res2.getString("email"));

                            logIn.dispose();
                        }
                    }
                } catch(SQLException exce) {}
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public void getNew() {
        final JFrame logIn = new JFrame();
        logIn.setLayout(null);
        logIn.setBounds(0, 0, 400, 300);
        JPanel p = new JPanel();
        p.setBounds(logIn.getBounds());
        JLabel uname = new JLabel();
        uname.setBounds(10, 10, 100, 20);
        uname.setText("E-mail:");
        final JTextField username = new JTextField();
        username.setBounds(113, 10, 100, 24);
        JLabel pword = new JLabel();
        pword.setBounds(10, 30, 100, 20);
        pword.setText("Password:");
        final JTextField password = new JTextField();
        password.setBounds(113, 30, 100, 24);
        JButton lgin = new JButton();
        lgin.setBounds(200, 70, 70, 20);
        lgin.setText("Log In");
        p.setLayout(null);
        p.add(uname);
        p.add(username);
        p.add(pword);
        p.add(password);
        p.add(lgin);
        logIn.add(p);
        logIn.setVisible(true);
        lgin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Database db = new Database();
                    String sql2 = "SELECT email FROM blog_signup WHERE email = '" + username.getText() + "'"
                            + " AND password = '" + password.getText() + "'";
                    ResultSet res2 = db.query(sql2);
                    if(res2.next()) {
                        UpdateBlogSingleton.getInstance().getInsertEmail().setText(res2.getString("email"));

                        logIn.dispose();
                    }
                } catch(SQLException exce) {}
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
}