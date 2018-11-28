package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import data.Database;
import java.sql.SQLException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import data.managers.UpdateBlogMgr;
import data.managers.UpdateBlogSingleton;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class UpdateBlog extends javax.swing.JFrame {

    private PersonalBlog pers;
    private Database da;
    private String sql;
    private String email;
    private String title;
    private String entry;
    
    public UpdateBlog(PersonalBlog pers, String email, String title, String entry) {
        this.pers = pers;
        this.email = email;
        this.title = title;
        this.entry = entry;
        initComponents();
        init();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    private void init() {
        this.insertEmail.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UpdateBlogSingleton s = UpdateBlogSingleton.getInstance();
                s.setInsertEmail(UpdateBlog.this.insertEmail);
                s.setTitle(UpdateBlog.this.title);
                new UpdateBlogMgr().getUpd();
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
        this.insertName.setText(this.title);
        this.insertPost.setText(this.entry);
        this.save.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(UpdateBlog.this.pers != null && !UpdateBlog.this.insertEmail.getText().equals("")) {
                    try {
                        da = new Database();
                        String email;
                        String name;
                        String post;
                        email = insertEmail.getText();
                        name = insertName.getText();
                        post = insertPost.getText();
                        sql = "UPDATE blog SET email = '" + email + "', title = '" + name + "', post = '" + post + "' WHERE title = '" + title + "'";
                        da.command(sql);
                        da.closeConnect();
                        UpdateBlog.this.pers.setEntry(post);
                        UpdateBlog.this.pers.db();
                        UpdateBlog.this.pers.sendMessage_ForClose("Updated my personal blog finished");
                        UpdateBlog.this.dispose();
                    } catch (SQLException sQLException) {}
                } else {
                    JOptionPane.showMessageDialog(null, "Steps 1 through 3 are missing something(s)");
                }
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            JLabel do1 = new JLabel();
            do1.setBounds(10, 30, 50, 20);
            JLabel do2 = new JLabel();
            do2.setBounds(175, 30, 50, 20);
            JLabel do3 = new JLabel();
            do3.setBounds(10, 230, 50, 20);
            JLabel do4 = new JLabel();
            do4.setBounds(10, 270, 50, 20);
            java.awt.Image i1 = javax.imageio.ImageIO.read(new File("do1.jpg"));
            java.awt.Image i2 = javax.imageio.ImageIO.read(new File("do2.jpg"));
            java.awt.Image i3 = javax.imageio.ImageIO.read(new File("do3.jpg"));
            java.awt.Image i4 = javax.imageio.ImageIO.read(new File("do4.jpg"));
            ImageIcon ii1 = new ImageIcon(i1);
            ImageIcon ii2 = new ImageIcon(i2);
            ImageIcon ii3 = new ImageIcon(i3);
            ImageIcon ii4 = new ImageIcon(i4);
            do1.setIcon(ii1);
            do2.setIcon(ii2);
            do3.setIcon(ii3);
            do4.setIcon(ii4);
            this.add(do1);
            this.add(do2);
            this.add(do3);
            this.add(do4);
        } catch (IOException exce) {}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        insertPost = new javax.swing.JTextArea();
        insertName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        insertEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        save.setText("Update");

        insertPost.setColumns(20);
        insertPost.setLineWrap(true);
        insertPost.setRows(5);
        jScrollPane1.setViewportView(insertPost);

        jLabel1.setText("Title:");

        jLabel2.setText("Type your post:");

        jLabel3.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(insertName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(insertEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(save)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField insertEmail;
    private javax.swing.JTextField insertName;
    private javax.swing.JTextArea insertPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}