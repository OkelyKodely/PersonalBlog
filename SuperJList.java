package ui.helpers;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class SuperJList extends JList {
    public SuperJList() {}
    public SuperJList(DefaultListModel ll) { setModel(ll); }
}