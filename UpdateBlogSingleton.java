package data.managers;

import javax.swing.JTextField;

public class UpdateBlogSingleton {
 
    private String title;
    private JTextField insertEmail;
    private static UpdateBlogSingleton singl;
    
    private UpdateBlogSingleton() {}
    
    public static UpdateBlogSingleton getInstance() {
        if(singl == null) {
            singl = new UpdateBlogSingleton();
        }
        return singl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JTextField getInsertEmail() {
        return insertEmail;
    }

    public void setInsertEmail(JTextField insertEmail) {
        this.insertEmail = insertEmail;
    }
}