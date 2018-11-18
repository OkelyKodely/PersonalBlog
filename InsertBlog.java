package ui;

import data.Database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InsertBlog extends javax.swing.JFrame {

    private Database da;
    private PersonalBlog pers;
    private String sql;
    
    public InsertBlog(PersonalBlog pers) {
        this.pers = pers;
        initComponents();
        init();
    }
    
    private void init() {
        this.post.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(InsertBlog.this.pers != null) {
                    try {
                        da = new Database();
                        String email;
                        String name;
                        String post;
                        email = insertEmail.getText();
                        name = insertName.getText();
                        post = insertPost.getText();
                        sql = "INSERT INTO blog (email, title, post, inputdate) VALUES ('" + email + "','" + name + "','" + post + "',current_timestamp)";
                        da.command(sql);
                        da.closeConnect();
                        InsertBlog.this.pers.db();
                        InsertBlog.this.pers.sendMessage_ForClose("New entry to my personal blog finished");
                        InsertBlog.this.dispose();
                    } catch (SQLException sQLException) {}
                }
            }

            public void mousePressed(MouseEvent e) {}

            public void mouseReleased(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {}

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

        post = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        insertPost = new javax.swing.JTextArea();
        insertName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        insertEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        post.setText("Post");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(insertName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(insertEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(post)
                                    .addGap(267, 267, 267))))))
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
                .addComponent(post)
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
    private javax.swing.JButton post;
    // End of variables declaration//GEN-END:variables
}