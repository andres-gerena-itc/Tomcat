package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DataPlaceHolderServlet
 */
/**
 * @author preetham
 *
 */
public class DataPlaceHolderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataPlaceHolderServlet() {
        super();
        System.out.println("DataPlaceHolderServlet constructor called");
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DataPlaceHolder doPost method called");
		//get the values from request
		String requestValue  = (String)request.getParameter("requestKey");
		String sessionvalue  = (String)request.getParameter("sessionKey");
		String servletContextValue  = (String)request.getParameter("servletContextKey");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if(session!=null)
		{
			System.out.println("Values stored in request,session and servletcontext");
			out.write("<html><body><h1>Values stored in request,session and servletcontext</h1></body></html>");
			
		}
		ServletContext context = getServletContext();
		//set the values in request,session and servlet context
		request.setAttribute("requestKey", requestValue);
		session.setAttribute("sessionKey", sessionvalue);
		context.setAttribute("servletContextKey", servletContextValue);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/testDataPlaceHolderServlet");
		//include whatever response was added in this servlet and forward the control to "/testDataPlaceHolderServlet" url
		requestDispatcher.include(request, response);
		
	}

}
