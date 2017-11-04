package test;

import java.io.IOException;
import java.util.prefs.Preferences;


public class Testt {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Preferences userNodeForPackage = Preferences.userNodeForPackage(Testt.class);
        userNodeForPackage.put("name", "lis");
        userNodeForPackage.putInt("age", 11);
        String string = userNodeForPackage.get("name", null);
        int int1 = userNodeForPackage.getInt("age", 0);
        int1++;
        System.out.println(int1);
    }
}
