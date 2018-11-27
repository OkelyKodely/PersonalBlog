package ui;

import utils.JListCellRenderer;
import data.Database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import ui.helpers.ButtonStyle1;

public class PersonalBlog extends javax.swing.JFrame {

    private Database da;
    private ImagePanel ip;

    private JTextArea entry;
    private JScrollPane jScrollPane0;
    private JLabel personall, blogg, personll, bogg, inswingg;
    private JLabel header;
    
    private JButton add, modify;
    private JButton put, pull;
    
    private JButton leave;
    
    private JScrollPane jScrollPane1;
    private JJList blogListing;
    
    private JLabel titleSelected;
    private JLabel emailSelected;
    
    private class JJList extends JList {

        private JJList(DefaultListModel ll) {
            setModel(ll);
        }
        private JJList() {}

    }

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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Daniel Cho's Personal Blog ..");
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
        titleSelected.setForeground(Color.lightGray);
        titleSelected.setBounds(25, 300, 400, 50);
        titleSelected.setFont(new Font("verdana", Font.BOLD, 12));
        this.ip.add(titleSelected);

        emailSelected = new JLabel();
        emailSelected.setForeground(Color.WHITE);
        emailSelected.setBounds(225, 300, 400, 50);
        emailSelected.setFont(new Font("arial", Font.ITALIC, 12));
        this.ip.add(emailSelected);
        header = new JLabel();
        header.setForeground(Color.LIGHT_GRAY);
        header.setBounds(20, 399, 400, 50);
        header.setFont(new Font("arial", Font.BOLD, 36));
        header.setText("Personal Blog ..");
        this.ip.add(header);
        entry = new JTextArea();
        entry.setForeground(Color.WHITE);
        entry.setText(" ");
        entry.setCaretPosition(0);
        entry.setBackground(Color.LIGHT_GRAY);
        entry.setBounds(20, 70, 400, 200);
        entry.setLineWrap(true);
        entry.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jScrollPane0 = new JScrollPane(entry);
        jScrollPane0.setBounds(20, 92, 300, 200);
        jScrollPane0.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.ip.add(jScrollPane0);
        ButtonStyle1 bh1 = new ButtonStyle1(this.ip);
        bh1.setAddButton(add);
        bh1.setModifyButton(modify);
        bh1.setLeaveButton(leave);
        Object[] obj = bh1.exec();
        add = (JButton) obj[0];
        modify = (JButton) obj[1];
        leave = (JButton) obj[2];
        personall = new JLabel();
        personall.setForeground(Color.LIGHT_GRAY);
        personall.setFont(new Font("arial", Font.PLAIN, 20));
        personall.setBounds(330, 109, 100, 25);
        personall.setText("Daniel");
        this.ip.add(personall);
        blogg = new JLabel();
        blogg.setForeground(Color.LIGHT_GRAY);
        blogg.setFont(new Font("arial", Font.PLAIN, 20));
        blogg.setBounds(420, 149, 100, 25);
        blogg.setText("Cho's");
        this.ip.add(blogg);
        personll = new JLabel();
        personll.setForeground(Color.LIGHT_GRAY);
        personll.setFont(new Font("arial", Font.PLAIN, 20));
        personll.setBounds(330, 209, 100, 25);
        personll.setText("Personal");
        this.ip.add(personll);
        bogg = new JLabel();
        bogg.setForeground(Color.LIGHT_GRAY);
        bogg.setFont(new Font("arial", Font.PLAIN, 20));
        bogg.setBounds(420, 249, 100, 25);
        bogg.setText("Blog ..");
        this.ip.add(bogg);
        inswingg = new JLabel();
        inswingg.setForeground(Color.LIGHT_GRAY);
        inswingg.setFont(new Font("arial", Font.PLAIN, 20));
        inswingg.setBounds(380, 120, 100, 25);
        inswingg.setText("");
        this.ip.add(inswingg);
        put = new JButton();
        put.setBounds(341, 150, 60, 25);
        put.setText("<");
        //this.ip.add(put);
        pull = new JButton();
        pull.setBounds(404, 150, 60, 25);
        pull.setText(">");
        //this.ip.add(pull);
        blogListing = new JJList();

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) blogListing.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        blogListing.setBackground(Color.LIGHT_GRAY);
        blogListing.setBounds(480, 70, 390, 400);
        this.ip.add(blogListing);
        blogListing.setEnabled(true);
        jScrollPane1 = new JScrollPane(blogListing);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        final JScrollBar scrollBar = jScrollPane1.getVerticalScrollBar();
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                //System.out.println("JScrollBar's current value = " + scrollBar.getValue());
            }
        });
        jScrollPane1.setBounds(480, 92, 390, 390);
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
        ResultSet res = da.query("SELECT inputdate, title FROM blog ORDER BY id DESC");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        try {
            int i = 0;
            while(res.next()) {
                try {
                    String spaces = "";
                    for(int j=0; j<20; j++)
                        spaces += " ";
                    listModel.add(i, res.getString("title") + spaces);
                    i++;
                } catch(Exception e) {}
            }
        } catch(SQLException exc) {}
        blogListing.setModel(listModel);
        blogListing.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    System.out.println(e.getX()+"");
                    if(e.getX() > 250) {
                        blogListing.setModel(listModel);
                        System.out.println("Recoqnizedt, a button click...");
                        int index = blogListing.locationToIndex(e.getPoint());
                        String item = (String) blogListing.getModel().getElementAt(index);
                        String sql = "DELETE FROM blog WHERE title = '" + item.trim() + "'";
                        Database db = new Database();
                        db.command(sql);
                        try {
                            ResultSet res = da.query("SELECT inputdate, title FROM blog ORDER BY id DESC");
                            DefaultListModel<String> listModel = new DefaultListModel<>();
                            try {
                                int i = 0;
                                while(res.next()) {
                                    String spaces = "";
                                    for(int j=0; j<20; j++)
                                        spaces += " ";
                                    listModel.add(i, res.getString("title") + spaces);
                                    i++;
                                }
                            } catch(SQLException exce) {}
                            blogListing.setModel(listModel);
                            JButton[] rem = new JButton[1];
                            try {
                                for(int i=0; i<blogListing.getModel().getSize(); i++) {
                                    Image i1 = ImageIO.read(new File("x.png"));
                                    ImageIcon imageMap1 = new ImageIcon(i1);
                                    rem[i] = new JButton();
                                    rem[i].setBackground(Color.WHITE);
                                    rem[i].setBounds(0, 0, 40, 30);
                                    rem[i].setIcon(imageMap1);
                                    rem[i].addMouseListener(new MouseListener() {
                                        public void mouseClicked(MouseEvent e) {
                                        }
                                        public void mouseExited(MouseEvent e) {
                                        }
                                        public void mouseEntered(MouseEvent e) {
                                        }
                                        public void mousePressed(MouseEvent e) {
                                        }
                                        public void mouseReleased(MouseEvent e) {
                                        }
                                    });
                                }
                            } catch(Exception exce) {}
                            JListCellRenderer r = new JListCellRenderer();
                            r.setRem(rem);
                            blogListing.setCellRenderer(r);
                            blogListing.setForeground(Color.LIGHT_GRAY);
                            blogListing.setBackground(Color.WHITE);
                        } catch(Exception e0) {}
                        db.closeConnect();
                    } else {
                        int index = blogListing.locationToIndex(e.getPoint());
                        String item = (String) blogListing.getModel().getElementAt(index);
                        try {
                            Database da = new Database();
                            ResultSet res = da.query("SELECT post, title, email FROM blog WHERE title = '" + item.trim() + "' order by id asc");
                            if(res.next()) {

                                setEntry(res.getString("post"));
                                PersonalBlog.this.titleSelected.setText(res.getString("title"));
                                PersonalBlog.this.emailSelected.setText("|" + res.getString("email"));
                            }
                            da.closeConnect();
                        } catch(SQLException exce) {}
                    }
                } catch(SQLException exce) {}
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
        JButton[] rem = new JButton[1];
        try {
            for(int i=0; i<blogListing.getModel().getSize(); i++) {
                Image i1 = ImageIO.read(new File("x.png"));
                ImageIcon imageMap1 = new ImageIcon(i1);
                rem[i] = new JButton();
                rem[i].setBackground(Color.WHITE);
                rem[i].setBounds(0, 0, 40, 30);
                rem[i].setIcon(imageMap1);
                rem[i].addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                    }
                    public void mouseExited(MouseEvent e) {
                    }
                    public void mouseEntered(MouseEvent e) {
                    }
                    public void mousePressed(MouseEvent e) {
                    }
                    public void mouseReleased(MouseEvent e) {
                    }
                });
            }
        } catch(Exception e) {}
        JListCellRenderer r = new JListCellRenderer();
        r.setRem(rem);
        blogListing.setCellRenderer(r);
        put.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(1==1)
                return;
                int index = blogListing.locationToIndex(e.getPoint());
                String item = (String) blogListing.getModel().getElementAt(index);
                try {
                    Database da = new Database();
                    ResultSet res = da.query("SELECT post, title, email FROM blog WHERE title = '" + item.trim() + "' order by id asc");
                    if(res.next()) {

                        setEntry(res.getString("post"));
                        PersonalBlog.this.titleSelected.setText(res.getString("title"));
                        PersonalBlog.this.emailSelected.setText("|" + res.getString("email"));

                        res = da.query("SELECT inputdate, title FROM blog ORDER BY id DESC");
                        DefaultListModel<String> listModel = new DefaultListModel<>();
                        try {
                            int i = 0;
                            while(res.next()) {
                                String spaces = "";
                                for(int j=0; j<20; j++)
                                    spaces += " ";
                                listModel.add(i, res.getString("title") + spaces);
                                i++;
                            }
                        } catch(SQLException exc) {}
                        ip = getContentPanel(GridBagConstraints.WEST);
                        blogListing.setModel(listModel);
                        blogListing.setForeground(Color.LIGHT_GRAY);
                        blogListing.setBackground(Color.WHITE);
                        
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
                if(1==1)
                return;
                setEntry("");
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        ip = getContentPanel(GridBagConstraints.WEST);
        blogListing.setForeground(new Color(138, 138, 138));
        blogListing.setBackground(Color.WHITE);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}