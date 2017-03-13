package tw.com.melvin.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Conn
 */
@WebServlet("/Conn")
public class Conn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(Conn.class);

    /**
     * Default constructor. 
     */
    public Conn() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
        Statement stmt = null;
        
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/virtualbusiness");
			
			
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user");

			while (rs.next()) {
				logger.debug(rs.getString("user_id"));
				logger.debug(rs.getString("user_name"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (NamingException e) {
			logger.debug(e.getMessage());
			logger.debug(e.getStackTrace());
		} catch (Exception e) {
			logger.debug(e.getMessage());
			logger.debug(e.getStackTrace());
		} finally {
			/*
             * close any jdbc instances here that weren't
             * explicitly closed during normal code path, so
             * that we don't 'leak' resources...
             */

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlex) {
                    // ignore, as we can't do anything about it here
                }

                stmt = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlex) {
                    // ignore, as we can't do anything about it here
                }

                conn = null;
            }
		}
		
		
	}

}
