

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
				"transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		
		int QB = 0;
		int RB = 0;
		int WR = 0;
		int TE = 0;
		int T = 0;
		int G = 0;
		int C = 0;
		int DE = 0;
		int DT = 0;
		int Sam = 0;
		int Mike = 0;
		int Will = 0; 
		int CB = 0;
		int S = 0;
		int injured = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
/*		try {
			DBConnection.getDBConnection();
	        connection = DBConnection.connection;
	        String selectSQL = "SELECT * FROM rosterTable";
			//String theUserName = "user%";
			response.getWriter().println(selectSQL + "<br>");
			response.getWriter().println("------------------------------------------<br>");
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			//preparedStatement.setString(1, theUserName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String number = rs.getString("ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String position = rs.getString("POSITION");
				String height = rs.getString("HEIGHT");
				String weight = rs.getString("WEIGHT");
				String string = rs.getString("STRING");
				response.getWriter().append("NUMBER: " + number + ", ");
				response.getWriter().append("FIRST NAME: " + firstname + ", ");
				response.getWriter().append("LAST NAME: " + lastname + ", ");
				response.getWriter().append("POSITION: " + position + ", ");
				response.getWriter().append("HEIGHT: " + height + ", ");
				response.getWriter().append("WEIGHT: " + weight + ", ");
				response.getWriter().append("STRING: " + string + "<br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

*/		
		out.println("<a href=/depthchart/Manager.html>Go Back</a> <br>");
		out.println("<br />");
		out.println("<br />");

		try {
			DBConnection.getDBConnection();
	        connection = DBConnection.connection;
	        String selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'QB' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	QB = rs.getInt("x");
	        }
			out.println("QB<br />");
			
			if(QB == 0)
				out.println("<br />");
			
	        for(int i=1; i<=QB; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'QB' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'RB' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	RB = rs.getInt("x");
	        }
			out.println("RB<br />");
			
			if(RB == 0)
				out.println("<br />");
			
	        for(int i=1; i<=RB; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'RB' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'WR' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	WR = rs.getInt("x");
	        }
			out.println("WR<br />");
			
			if(WR == 0)
				out.println("<br />");
			
	        for(int i=1; i<=WR; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'WR' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'TE' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	TE = rs.getInt("x");
	        }
			out.println("TE<br />");
			
			if(TE == 0)
				out.println("<br />");
			
	        for(int i=1; i<=TE; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'TE' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'T' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	T = rs.getInt("x");
	        }
			out.println("T<br />");
			
			if(T == 0)
				out.println("<br />");
			
	        for(int i=1; i<=T; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'T' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'G' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	G = rs.getInt("x");
	        }
			out.println("G<br />");
			
			if(G == 0)
				out.println("<br />");
			
	        for(int i=1; i<=G; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'G' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'C' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	C = rs.getInt("x");
	        }
			out.println("C<br />");
			
			if(C == 0)
				out.println("<br />");
			
	        for(int i=1; i<=C; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'C' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'DE' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	DE = rs.getInt("x");
	        }
			out.println("DE<br />");
			
			if(DE == 0)
				out.println("<br />");
			
	        for(int i=1; i<=DE; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'DE' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'DT' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	DT = rs.getInt("x");
	        }
			out.println("DT<br />");
			
			if(DT == 0)
				out.println("<br />");
			
	        for(int i=1; i<=DT; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'DT' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'Sam' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	Sam = rs.getInt("x");
	        }
			out.println("Sam<br />");
			
			if(Sam == 0)
				out.println("<br />");
			
	        for(int i=1; i<=Sam; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'Sam' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'Mike' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	Mike = rs.getInt("x");
	        }
			out.println("Mike<br />");
			
			if(Mike == 0)
				out.println("<br />");
			
	        for(int i=1; i<=Mike; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'Mike' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'Will' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	Will = rs.getInt("x");
	        }
			out.println("Will<br />");
			
			if(Will == 0)
				out.println("<br />");
			
	        for(int i=1; i<=Will; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'Will' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'CB' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	CB = rs.getInt("x");
	        }
			out.println("CB<br />");
			
			if(CB == 0)
				out.println("<br />");
			
	        for(int i=1; i<=CB; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'CB' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        
	        out.println("<br />");
	        
	        selectSQL = "SELECT COUNT(*) AS x FROM rosterTable WHERE POSITION LIKE 'S' AND STRING!=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	S = rs.getInt("x");
	        }
			out.println("S<br />");
			
			if(S == 0)
				out.println("<br />");
			
	        for(int i=1; i<=S; i++)
	        {
	        	selectSQL = "SELECT * FROM rosterTable WHERE POSITION LIKE 'S' AND STRING=" + Integer.toString(i);
	        	preparedStatement = connection.prepareStatement(selectSQL);
		        rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	int number = rs.getInt("ID");
		        	String firstname = rs.getString("FIRSTNAME").trim();
		        	String lastname = rs.getString("LASTNAME").trim();
		        	
					String height = rs.getString("HEIGHT").trim();
					int weight = rs.getInt("WEIGHT");
					out.println(number + " " + firstname + " " + lastname + " " + height + " " + weight+ "<br />");
		        }
		        
	        }
	        out.println("<br />");
	        
	        selectSQL = "SELECT * FROM rosterTable WHERE String=0";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        rs = preparedStatement.executeQuery();
	        
	        out.println("Injured<br />");
	        
	        while (rs.next()) {
	        	int number = rs.getInt("ID");
	        	String firstname = rs.getString("FIRSTNAME").trim();
	        	String lastname = rs.getString("LASTNAME").trim();
	        	String position = rs.getString("POSITION").trim();
				String height = rs.getString("HEIGHT").trim();
				int weight = rs.getInt("WEIGHT");
				out.println(number + " " + firstname + " " + lastname + " " + position + " " + height + " " + weight+ "<br />");
	        }
	        
	        
	      //out.println("<a href=/webproject/simpleFormSearch.html>Search Data</a> <br>");
			out.println("</body></html>");
			rs.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
