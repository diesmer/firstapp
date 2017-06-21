package nl.hu.ipass.firstapp.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import nl.hu.ipass.application.persistence.User;

@WebServlet(urlPatterns = "/Login.do")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailadres = req.getParameter("email");
		String ww = req.getParameter("wachtwoord");
		
		
		

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println(" <title>Dynamic Example</title>");
		out.println(" <body>");
		out.println(" <h2>Dynamic webapplication example</h2>");
		out.println(" <h2>Hello " + emailadres +" je ww is " + ww + "!</h2>");
		out.println(" </body>");
		out.println("</html>");
	}
}