package zoo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZooDatabase {

  private static Connection conn = null;

  public ZooDatabase(String filename) {
    try {
      Class.forName("org.sqlite.JDBC");
      String urlToDB = "jdbc:sqlite:" + filename;

      // This is a check so we don't create files that don't exist
      if (new File(filename).exists()) {
        conn = DriverManager.getConnection(urlToDB);
      } else {
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<String> getAgeRange(String minAge, String maxAge) {
    try {
      // SQL search
      PreparedStatement prep = conn
          .prepareStatement("SELECT id, animal from zoo WHERE age BETWEEN ? AND ?");
      prep.setString(1, minAge);
      prep.setString(2, maxAge);
      // Gather data
      ResultSet result = prep.executeQuery();
      List<String> ages = new ArrayList<>();
      while (result.next()) {
        String temp = result.getString(1) + " : " + result.getString(2);
        ages.add(temp);
      }
      result.close();
      prep.close();
      return ages;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String getWithID(String id) {
    try {
      // SQL search
      PreparedStatement prep = conn
          .prepareStatement("SELECT animal, age, height from zoo WHERE id = ?");
      prep.setString(1, id);

      // Gather data
      ResultSet result = prep.executeQuery();
      String output = "";
      while (result.next()) {
        output = "This " + result.getString(1) + " is " + result.getString(2)
            + " years old. Its normalized height is equal to " + result.getString(3);

      }
      result.close();
      prep.close();
      return output;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
