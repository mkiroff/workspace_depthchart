

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String position = request.getParameter("position");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String string = request.getParameter("string");

        Connection connection = null;
        String insertSql = "INSERT INTO rosterTable (id, FIRSTNAME, LASTNAME, POSITION, HEIGHT, WEIGHT, STRING) values (default, ?, ?, ?, ?, ?, ?)";

        try {
           DBConnection.getDBConnection();
           connection = DBConnection.connection;
           PreparedStatement preparedStmt = connection.prepareStatement(insertSql);
           preparedStmt.setString(1, firstName);
           preparedStmt.setString(2, lastName);
           preparedStmt.setString(3, position);
           preparedStmt.setString(4, height);
           preparedStmt.setString(5, weight);
           preparedStmt.setString(6, string);
           preparedStmt.execute();
           connection.close();
        } catch (Exception e) {
           e.printStackTrace();
        }

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Insert Data to DB table";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType + //
              "<html>\n" + //
              "<head><title>" + title + "</title></head>\n" + //
              "<body bgcolor=\"#f0f0f0\">\n" + //
              "<h2 align=\"center\">" + title + "</h2>\n" + //
              "<ul>\n" + //

              "  <li><b>First Name</b>: " + firstName + "\n" + //
              "  <li><b>Last Name</b>: " + lastName + "\n" + //
              "  <li><b>Position</b>: " + position + "\n" + //
              "  <li><b>Height</b>: " + height + "\n" + //
              "  <li><b>Weight</b>: " + weight + "\n" + //
              "  <li><b>String</b>: " + string + "\n" + //

              "</ul>\n");

        out.println("<a href=/depthchart/Manager.html>Go Back</a> <br>");
        out.println("</body></html>");
     }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
