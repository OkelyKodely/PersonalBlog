package ui;

import data.Database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PersonalBlog extends javax.swing.JFrame {

    private Database da;
    private ImagePanel ip;

    private JTextArea entry;
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
        emailSelected = new JLabel();
        emailSelected.setBounds(245, 255, 400, 50);
        emailSelected.setFont(new Font("arial", Font.ITALIC, 12));
        this.ip.add(emailSelected);
        titleSelected = new JLabel();
        titleSelected.setBounds(25, 255, 400, 50);
        titleSelected.setFont(new Font("arial", Font.ITALIC, 12));
        this.ip.add(titleSelected);
        header = new JLabel();
        header.setBounds(20, 360, 400, 50);
        header.setFont(new Font("arial", Font.BOLD, 36));
        header.setText("Personal Blog in Swing");
        this.ip.add(header);
        entry = new JTextArea();
        entry.setBounds(20, 70, 400, 200);
        entry.setLineWrap(true);
        entry.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.ip.add(entry);
        add = new JButton();
        add.setBounds(140, 300, 70, 25);
        add.setText("add");
        this.ip.add(add);
        modify = new JButton();
        modify.setBounds(200, 300, 90, 25);
        modify.setText("modify");
        this.ip.add(modify);
        leave = new JButton();
        leave.setBounds(10, 480, 860, 75);
        leave.setFont(new Font("arial", Font.BOLD, 46));
        leave.setText("Leave");
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
        personall.setBounds(440, 70, 100, 25);
        personall.setText("Personal");
        this.ip.add(personall);
        blogg = new JLabel();
        blogg.setBounds(480, 95, 100, 25);
        blogg.setText("Blog");
        this.ip.add(blogg);
        inswingg = new JLabel();
        inswingg.setBounds(490, 120, 100, 25);
        inswingg.setText("in Swing");
        this.ip.add(inswingg);
        put = new JButton();
        put.setBounds(440, 180, 60, 25);
        put.setText("<");
        this.ip.add(put);
        pull = new JButton();
        pull.setBounds(510, 180, 60, 25);
        pull.setText(">");
        this.ip.add(pull);
        blogListing = new JList();
        blogListing.setBounds(580, 70, 290, 400);
        this.ip.add(blogListing);
        jScrollPane1 = new JScrollPane(blogListing);
        jScrollPane1.setBounds(580, 70, 290, 400);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.ip.add(jScrollPane1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                Object value = blogListing.getSelectedValue();
                String[] titleName = (String[]) value;
                sql = "SELECT email, title, post FROM blog WHERE title = '" + titleName[1] + "'";
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
    }
    
    public void db() {
        da.query("SELECT inputdate FROM blog");
        ResultSet res = da.query("SELECT inputdate, title FROM blog ORDER BY inputdate ASC");
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
                    ResultSet res = da.query("SELECT post, title, email FROM blog WHERE title = '" + ss[1] + "'");
                    if(res.next()) {
                        setEntry(res.getString("post"));
                        PersonalBlog.this.titleSelected.setText(res.getString("title"));
                        PersonalBlog.this.emailSelected.setText("|" + res.getString("email"));
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
                spaces += " ";
            }
            columnData[i][0] = listModel.get(i);
            columnData[i][1] = listModel2.get(i) + spaces;
        }
        blogListing.setListData(columnData);
        blogListing.setCellRenderer(new MyCellRenderer());
    }
    
    public class MyCellRenderer extends JPanel implements ListCellRenderer {

        private JLabel image1, image2, image3, image4, left, right;

        private MyCellRenderer() {
            image1    = new JLabel();
            image2    = new JLabel();
            image3    = new JLabel();
            image4    = new JLabel();
            left      = new JLabel();
            right      = new JLabel();
            add(image1);
            add(image2);
            add(image3);
            add(image4);
            add(left);
            add(right);
        }

        public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
            try {
                String v = index + "";
                String v1 = "", v2 = "", v3 = "", v4 = "";
                if(index > -1) {
                    v1 = v.substring(0, 1);
                }
                Image i = ImageIO.read(new File(v1 + ".jpg"));
                ImageIcon imageMap = new ImageIcon(i);
                image1.setIcon(imageMap);
                image1.setHorizontalTextPosition(JLabel.RIGHT);
                image1.setText("");
                if(index > 9) {
                    v2 = v.substring(1, 2);
                    i = ImageIO.read(new File(v2 + ".jpg"));
                    imageMap = new ImageIcon(i);
                    boolean wasNull = false;
                    if(image2 == null) {
                        image2    = new JLabel();
                        wasNull = true;
                    }
                    image2.setIcon(imageMap);
                    image2.setHorizontalTextPosition(JLabel.RIGHT);
                    image2.setText("");
                    if(wasNull)
                        add(image2);
                }
                else {
                    i = ImageIO.read(new File("cuang.jpg"));
                    imageMap = new ImageIcon(i);
                    boolean wasNull = false;
                    if(image2 == null) {
                        image2    = new JLabel();
                        wasNull = true;
                    }
                    image2.setIcon(imageMap);
                    image2.setHorizontalTextPosition(JLabel.RIGHT);
                    image2.setText("");
                    if(wasNull)
                        add(image2);
                }
                if(index > 99) {
                    v3 = v.substring(2, 3);
                    i = ImageIO.read(new File(v3 + ".jpg"));
                    imageMap = new ImageIcon(i);
                    image3.setIcon(imageMap);
                    image3.setHorizontalTextPosition(JLabel.RIGHT);
                    image3.setText("");
                }
                else {
                    i = ImageIO.read(new File("cuang.jpg"));
                    imageMap = new ImageIcon(i);
                    boolean wasNull = false;
                    if(image3 == null) {
                        image3    = new JLabel();
                        wasNull = true;
                    }
                    image3.setIcon(imageMap);
                    image3.setHorizontalTextPosition(JLabel.RIGHT);
                    image3.setText("");
                    if(wasNull)
                        add(image3);
                }
                if(index > 999) {
                    v4 = v.substring(3, 4);
                    i = ImageIO.read(new File(v4 + ".jpg"));
                    imageMap = new ImageIcon(i);
                    image4.setIcon(imageMap);
                    image4.setHorizontalTextPosition(JLabel.RIGHT);
                    image4.setText("");
                }
                else {
                    i = ImageIO.read(new File("cuang.jpg"));
                    imageMap = new ImageIcon(i);
                    boolean wasNull = false;
                    if(image4 == null) {
                        image4    = new JLabel();
                        wasNull = true;
                    }
                    image4.setIcon(imageMap);
                    image4.setHorizontalTextPosition(JLabel.RIGHT);
                    image4.setText("");
                    if(wasNull)
                        add(image4);
                }
                String leftData      = ((String[])value)[0];
                String rightData      = ((String[])value)[1];
                left.setText(leftData);
                right.setText(rightData);
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
            } catch(Exception exce) {}
            return this;
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalBlog().setVisible(true);
            }
        });
    }

    class ImagePanel extends JPanel{
        Image image;
        public ImagePanel(Image image){
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0,0, this);
        }
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
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}