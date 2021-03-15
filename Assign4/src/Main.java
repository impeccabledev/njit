

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      Connection con = DriverManager.getConnection(
		        "jdbc:mysql://localhost/njit?user=root&password=root");
		      Statement stmt = con.createStatement();
		      try{
//		    	  String SQL = "DROP TABLE simple";
//		    	  stmt.execute(SQL);
		      }catch(Exception e){
		      }
//		      stmt.execute("CREATE TABLE IF NOT EXISTS simple( name char(30))");
//		      stmt.execute("Insert into simple values('John Doe')");
//			stmt.execute("Insert into simple values('Jane Doe')");
		      ResultSet rs = stmt.executeQuery("Select * from courses where semester='Spring2022'");
		      ResultSetMetaData rsmd = rs.getMetaData();
		      int column_count = rsmd.getColumnCount();
		      System.out.println(column_count);
		      
		      
		      
//		      while ( rs.next())
//		    	  for (int i=1;i<=column_count;i++) {
//		        System.out.println(rs.getString(i));
//		      }
		      
		      System.out.println("CourseID  Semester    Course");
		      
		      while (rs.next()) {
		          String  courseID = rs.getString("CourseID");
		          String Semester = rs.getString("Semester");
		          String Course = rs.getString("Course");
		          System.out.println(courseID+"   "+Semester+"    "+Course);
		       }
		      
		    } catch (Exception ex) {
		      System.out.println("Message: " + ex.getMessage());
		      System.exit(0);
		    }
//		    System.out.println("Program terminated with no error.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
