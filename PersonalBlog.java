package ui;

import utils.JListCellRenderer;
import data.Database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class PersonalBlog extends javax.swing.JFrame {

    private Database da;
    private ImagePanel ip;

    private JTextArea entry;
    private JScrollPane jScrollPane0;
    private JLabel personall, blogg, inswingg;
    private JLabel header;
    
    private JButton add, modify;
    private JButton put, pull;
    
    private JButton leave;
    
    private JScrollPane jScrollPane1;
    private JList blogListing;
    
    private JLabel titleSelected;
    private JLabel emailSelected;
    
    public PersonalBlog() {
        initDa();
        initComponents();
        setComponents();
        setInsertPost();
        setModifyPost();
        db();
    }
    
    private void initDa() {
        try {
            da = new Database();
        } catch(SQLException exce) {
            System.exit(0);
        }
    }
    
    private void setComponents() {
        try {
            Image image = ImageIO.read(new File("bg.png"));
            this.ip = new ImagePanel(image);
            this.ip.setBounds(0, 0, 877, 559);
            this.add(this.ip);
        } catch(Exception exce) {}
        this.setLayout(null);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.ip.setBackground(Color.WHITE);
        this.ip.setLayout(null);
        titleSelected = new JLabel();
        titleSelected.setForeground(Color.YELLOW);
        titleSelected.setBounds(25, 280, 400, 50);
        titleSelected.setFont(new Font("verdana", Font.BOLD, 12));
        this.ip.add(titleSelected);
        this.addWindowListener(getWindowAdapter());
        emailSelected = new JLabel();
        emailSelected.setForeground(Color.YELLOW);
        emailSelected.setBounds(245, 280, 400, 50);
        emailSelected.setFont(new Font("arial", Font.ITALIC, 12));
        this.ip.add(emailSelected);
        header = new JLabel();
        header.setForeground(Color.YELLOW);
        header.setBounds(20, 360, 400, 50);
        header.setFont(new Font("arial", Font.BOLD, 36));
        header.setText("Personal Blog");
        this.ip.add(header);
        entry = new JTextArea();
        entry.setForeground(Color.YELLOW);
        entry.setText(" ");
        entry.setCaretPosition(0);
        entry.setBackground(Color.RED);
        entry.setBounds(20, 70, 400, 200);
        entry.setLineWrap(true);
        entry.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jScrollPane0 = new JScrollPane(entry);
        jScrollPane0.setBounds(20, 70, 300, 200);
        jScrollPane0.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.ip.add(jScrollPane0);
        add = new JButton();
        add.setForeground(Color.RED);
        add.setBounds(20, 274, 70, 25);
        add.setText("add");
        this.ip.add(add);
        modify = new JButton();
        modify.setForeground(Color.RED);
        modify.setBounds(91, 274, 90, 25);
        modify.setText("modify");
        this.ip.add(modify);
        leave = new JButton();
        leave.setForeground(new Color(255, 255, 255));
        leave.setBounds(10, 480, 860, 75);
        leave.setFont(new Font("arial", Font.BOLD, 38));
        leave.setText("Log Off");
        leave.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.ip.add(leave);
        personall = new JLabel();
        personall.setForeground(Color.YELLOW);
        personall.setFont(new Font("arial", Font.PLAIN, 20));
        personall.setBounds(330, 70, 100, 25);
        personall.setText("Personal");
        this.ip.add(personall);
        blogg = new JLabel();
        blogg.setForeground(Color.YELLOW);
        blogg.setFont(new Font("arial", Font.PLAIN, 20));
        blogg.setBounds(420, 110, 100, 25);
        blogg.setText("Blog");
        this.ip.add(blogg);
        inswingg = new JLabel();
        inswingg.setForeground(Color.YELLOW);
        inswingg.setFont(new Font("arial", Font.PLAIN, 20));
        inswingg.setBounds(380, 120, 100, 25);
        inswingg.setText("");
        this.ip.add(inswingg);
        put = new JButton();
        put.setBounds(341, 150, 60, 25);
        put.setText("<");
        this.ip.add(put);
        pull = new JButton();
        pull.setBounds(404, 150, 60, 25);
        pull.setText(">");
        this.ip.add(pull);
        blogListing = new JList();
        blogListing.setBackground(Color.RED);
        blogListing.setBounds(480, 70, 390, 400);
        this.ip.add(blogListing);
        jScrollPane1 = new JScrollPane(blogListing);
        jScrollPane1.setBounds(480, 70, 390, 400);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.ip.add(jScrollPane1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setInsertPost() {
        add.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                new InsertBlog(PersonalBlog.this).setVisible(true);
            }

            public void mousePressed(MouseEvent e) {}

            public void mouseReleased(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {}

            public void mouseExited(MouseEvent e) {}
        });
    }
    
    private void setModifyPost() {
        modify.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                String email;
                String title;
                String post;
                String sql;
                sql = "SELECT email, title, post FROM blog WHERE title = '" + titleSelected.getText() + "'";
                ResultSet res = da.query(sql);
                try {
                    if(res.next()) {
                        email = res.getString("email");
                        title = res.getString("title");
                        post = res.getString("post");
                    } else {
                        email = null;
                        title = null;
                        post = null;
                    }
                } catch(SQLException exce) {
                        email = null;
                        title = null;
                        post = null;
                }
                if(email != null) {
                    new UpdateBlog(PersonalBlog.this, email, title, post).setVisible(true);
                }
            }

            public void mousePressed(MouseEvent e) {}

            public void mouseReleased(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {}

            public void mouseExited(MouseEvent e) {}
        });
    }

    public void setEntry(String entry) {
        this.entry.setText(entry);
        try {
            Thread.sleep(1000);
            Thread t = new Thread() {
                public void run() {
                    PersonalBlog.this.entry.setCaretPosition(0);
                }
            };
            t.start();
        } catch(InterruptedException exc) {}
    }
    
    public void db() {
        da.query("SELECT inputdate FROM blog");
        ResultSet res = da.query("SELECT inputdate, title FROM blog ORDER BY id ASC");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        try {
            int i = 0;
            while(res.next()) {
                listModel.addElement(res.getString("inputdate"));
                listModel2.addElement(res.getString("title"));
                i++;
            }
        } catch(SQLException exc) {}
        put.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                Object s = blogListing.getSelectedValue();
                String[] ss = (String[]) s;
                ss[1] = ss[1].trim();
                try {
                    Database da = new Database();
                    ResultSet res = da.query("SELECT post, title, email FROM blog WHERE title = '" + ss[1].replaceAll("_", "") + "'");
                    if(res.next()) {
                        setEntry(res.getString("post"));
                        PersonalBlog.this.titleSelected.setText(res.getString("title"));
                        PersonalBlog.this.emailSelected.setText("|" + res.getString("email"));

                        da.query("SELECT inputdate FROM blog");
                        res = da.query("SELECT inputdate, title FROM blog ORDER BY id ASC");
                        DefaultListModel<String> listModel = new DefaultListModel<>();
                        DefaultListModel<String> listModel2 = new DefaultListModel<>();
                        try {
                            int i = 0;
                            while(res.next()) {
                                listModel.addElement(res.getString("inputdate"));
                                listModel2.addElement(res.getString("title"));
                                i++;
                            }
                        } catch(SQLException exc) {}
                        String[][] columnData;
                        columnData = new String[listModel2.size()][2];
                        for(int i = 0; i < listModel.getSize(); i++) {
                            String spaces;
                            spaces = "";
                            for(int j = 0; j < 1200 - listModel2.get(i).length(); j++) {
                                spaces += "_";
                            }
                            columnData[i][0] = listModel.get(i);
                            columnData[i][1] = listModel2.get(i) + spaces;
                        }
                        ip = getContentPanel(GridBagConstraints.WEST);
                        blogListing.setListData(columnData);
                        blogListing.setCellRenderer(new JListCellRenderer());
                        blogListing.setForeground(Color.YELLOW);
                        blogListing.setBackground(new Color(13, 99, 54));
                        
                    }
                } catch(SQLException exc) {
                    System.exit(0);
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        pull.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                setEntry("");
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        String[][] columnData;
        columnData = new String[listModel2.size()][2];
        for(int i = 0; i < listModel.getSize(); i++) {
            String spaces;
            spaces = "";
            for(int j = 0; j < 1200 - listModel2.get(i).length(); j++) {
                spaces += "_";
            }
            columnData[i][0] = listModel.get(i);
            columnData[i][1] = listModel2.get(i) + spaces;
        }
        ip = getContentPanel(GridBagConstraints.WEST);
        blogListing.setListData(columnData);
        blogListing.setCellRenderer(new JListCellRenderer());
        blogListing.setForeground(new Color(138, 138, 138));
        blogListing.setBackground(new Color(13, 99, 54));
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalBlog().setVisible(true);
            }
        });
    }

    public void sendMessage_ForClose(String message) {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1);
                    JOptionPane.showMessageDialog(null, message);
                } catch(InterruptedException exce) {}
            }
        };
        t.start();
    }
        
    private ImagePanel getContentPanel(int anchor) {
        Image image;
        image = null;
        try {
            image = ImageIO.read(new File("bg.png"));
            this.ip = new ImagePanel(image);
            this.ip.setBounds(0, 0, 877, 559);
            this.add(this.ip);
        } catch(Exception exce) {}
        ImagePanel rtn = new ImagePanel(image);
        rtn.setLayout(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.gridx = 0;
        cs.anchor = anchor;
        cs.weightx = 1;
        return rtn;
    }

    private WindowAdapter getWindowAdapter() {

        return new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                super.windowClosing(we);
                JOptionPane.showMessageDialog(PersonalBlog.this, "Can't exit");
            }

            @Override
            public void windowIconified(WindowEvent we) {
                PersonalBlog.this.setState(PersonalBlog.this.NORMAL);
                JOptionPane.showMessageDialog(PersonalBlog.this, "Can't minimize");
            }
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}