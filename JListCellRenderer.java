package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class JListCellRenderer extends JPanel implements ListCellRenderer {

    private JLabel image1, image2, image3, image4, left, right;

    public JListCellRenderer() {
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
                image3.setHorizontalTextPosition(JLabel.RIGHT);
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
                image4.setHorizontalTextPosition(JLabel.RIGHT);
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
            String leftData      = ((String[])value)[0];
            String rightData      = ((String[])value)[1];
            left.setText(leftData);
            left.setForeground(new Color(138, 138, 138));
            if(isSelected) {
                left.setForeground(Color.RED);
            }
            right.setText(rightData);
            right.setForeground(new Color(138, 138, 138));
            if(isSelected) {
                right.setForeground(Color.RED);
            }
            setBackground(new Color(13, 99, 54));
            setForeground(Color.YELLOW);
        } catch(Exception exce) {}
        return this;
    }
}