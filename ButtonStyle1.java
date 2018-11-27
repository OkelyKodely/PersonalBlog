package ui.helpers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonStyle1 {
    
    private JPanel pane;
    private JButton add, modify, leave;

    public ButtonStyle1(JPanel pane) {
        this.pane = pane;
    }
    
    public Object[] exec() {
        add = new JButton();
        add.setForeground(Color.GREEN);
        add.setBounds(20, 290, 70, 25);
        add.setText("add");
        add.setFont(new Font("helvetica", Font.ITALIC, 11));
        add.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                add.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                add.setForeground(Color.GREEN);
            }
        });
        this.pane.add(add);
        modify = new JButton();
        modify.setForeground(Color.GREEN);
        modify.setBounds(91, 290, 90, 25);
        modify.setText("modify");
        modify.setFont(new Font("helvetica", Font.ITALIC, 11));
        modify.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                modify.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                modify.setForeground(Color.GREEN);
            }
        });
        this.pane.add(modify);
        leave = new JButton();
        leave.setBackground(Color.LIGHT_GRAY);
        leave.setForeground(Color.WHITE);
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

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leave.setBackground(new Color(31, 51, 31));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                leave.setBackground(Color.LIGHT_GRAY);
            }
        });
        this.pane.add(leave);
        
        Object[] obj = new Object[]{add, modify, leave};
        return obj;
    }
    
    public JButton getAdd() {
        return add;
    }

    public void setAddButton(JButton add) {
        this.add = add;
    }

    public JButton getModify() {
        return modify;
    }

    public void setModifyButton(JButton modify) {
        this.modify = modify;
    }

    public JButton getLeave() {
        return leave;
    }

    public void setLeaveButton(JButton leave) {
        this.leave = leave;
    }
}