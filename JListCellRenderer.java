package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class JListCellRenderer extends JPanel implements ListCellRenderer {

    private JLabel image1, image2, image3, image4, left;

    private JButton[] rem;

    public JListCellRenderer() {
        image1    = new JLabel();
        image2    = new JLabel();
        image3    = new JLabel();
        image4    = new JLabel();
        left      = new JLabel();
        add(image1);
        add(image2);
        add(image3);
        add(image4);
        add(left);
    }
    
    public void setRem(JButton[] rem) {
        this.rem = rem;
    }

    public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
        try {
            add(this.rem[0]);
            String v = index + "";
            String v1 = "", v2 = "", v3 = "", v4 = "";
            if(index > -1) {
                v1 = v.substring(0, 1);
            }
            Image i = ImageIO.read(new File(v1 + ".jpg"));
            ImageIcon imageMap = new ImageIcon(i);
            image1.setIcon(imageMap);
            image1.setHorizontalTextPosition(JLabel.LEFT);
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
                image2.setHorizontalTextPosition(JLabel.LEFT);
                image2.setText("");
                if(wasNull)
                    add(image2);
            }
            else {
                i = ImageIO.read(new File("empty.jpg"));
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
                image3.setHorizontalTextPosition(JLabel.LEFT);
                image3.setText("");
            }
            else {
                i = ImageIO.read(new File("empty.jpg"));
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
                image4.setHorizontalTextPosition(JLabel.LEFT);
                image4.setText("");
            }
            else {
                i = ImageIO.read(new File("empty.jpg"));
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
            String leftData      =  (String) value;
            left.setText(leftData);
            left.setForeground(new Color(238, 238, 238));
            if(isSelected) {
                left.setForeground(Color.CYAN);
            }
            setBackground(Color.BLACK);
            image1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
            image2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
            image3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
            image4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
            left.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
            this.rem[0].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
        } catch(Exception exce) {}
        return this;
    }
}