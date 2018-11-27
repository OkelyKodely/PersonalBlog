package data;

import java.sql.ResultSet;

public class DatabaseTest {

    public static void main(String[] args) {
        try {
            Database database = new Database();

            database.setDatabase("d89l9begjikklj");


            ResultSet res = database.query("SELECT * FROM blog");


            try {

                String val;
                val = "\tid\temail\ttitle\tpost"
                        + "\tinputdate";
                System.out.println(val);


                while(res.next()) {
                    val = res.getString("id") + "\t" + res.getString("email") + "\t" +
                            res.getString("title") + "\t" + res.getString("post") + "\t" + res.getString("inputdate") + "\t";
                    System.out.println(val);
                }

            } catch(Exception exc) {}



            database.closeConnect();
        } catch(Exception exce) {}
    }
}