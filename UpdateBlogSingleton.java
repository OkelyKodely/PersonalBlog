package data.managers;

import javax.swing.JTextField;

public class UpdateBlogSingleton {
 
    private String title;
    private JTextField insertEmail;
    private static UpdateBlogSingleton tit;
    
    private UpdateBlogSingleton() {}
    
    public static UpdateBlogSingleton getInstance() {
        if(null == tit) {
            tit = new UpdateBlogSingleton();
        }
        return tit;
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