import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class LabTemplate{

  // All edits will be made to the main method
  public static void main(String[] args){
    // We can easily print out some arbitrary text here
    System.out.println("Hello, World");
    // But if we want to do something more interesting
    // we can retrieve content from some website here
    // We need to ensure that we use a url that starts with https
    String url = "https://api.github.com/octocat";
    // We can print out the contents of any https site now!
    System.out.println( enlightenMe(url) );
  }

  /****************************
   * Some url's to try
   * https://api.github.com/zen
   *         OR
   * https://api.github.com/octocat
   *
   ****************************
  */

  // You can safely ignore this method
  public static String enlightenMe(String url){
    try{
      URL zen = new URL(url);
      HttpsURLConnection conn = (HttpsURLConnection) zen.openConnection();
      BufferedReader in = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
      StringBuilder sb = new StringBuilder();
      String inputLine;
      String NEWLINE = System.getProperty("line.separator");
      while ( (inputLine = in.readLine()) != null ){
        sb.append(inputLine);
        sb.append(NEWLINE);
      }
      return sb.toString();
    } catch (ClassCastException e){
      return "Did you try to use a https url?";
    } catch (Exception e){
      System.out.println(e.toString());
      return "An error occurred";
    }
  }
}
