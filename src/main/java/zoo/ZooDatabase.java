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

}
