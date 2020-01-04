package main.java.com.efrei;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name="Controller" urlPatterns={"/Controller"})
public class Controller extends HttpServlet {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//So that we can access the user type in both welcome and details

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param session
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, "Entered Controller successfully");
    	  String prevAction = request.getParameter("action");
          if (prevAction != null) {
                  if(prevAction.equals("Connect"))
                  {
                	  request.setAttribute("calcul", new Calculator().sum(request.getParameter("a"),request.getParameter("b")));
                	  request.getRequestDispatcher("WEB-INF\\result.jsp").forward(request, response);
                  }
                  else
                  {
                      request.getRequestDispatcher("WEB-INF\\hello.jsp").forward(request, response);
                  }
          }
          else
          {
              request.getRequestDispatcher("WEB-INF\\hello.jsp").forward(request, response);
          }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException e) {
	          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e.getStackTrace());
		}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException e) {
	          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e.getStackTrace());
		}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
