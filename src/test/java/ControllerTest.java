package test.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import main.java.com.efrei.Controller;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	@Test
	public void processRequestTest() {
		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final Controller contr = new Controller();
        when(request.getParameter("a")).thenReturn("1");
        when(request.getParameter("b")).thenReturn("2");
        when(request.getParameter("action")).thenReturn("Connect");

        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("WEB-INF\\result.jsp")).thenReturn(rd);
        try {
            final StringWriter stringWriter = new StringWriter();
            final PrintWriter writer = new PrintWriter(stringWriter);
            when(response.getWriter()).thenReturn(writer);
			contr.processRequest(request, response);
	        assertTrue(stringWriter.toString().contains("add result.jsp"));
	        Logger.getLogger(Controller.class.getName()).log(Level.INFO, "Calcul page condition correct");
		} catch (IOException | NullPointerException | ServletException e) {
			e.printStackTrace();
		}

	  assertNotNull(new Controller().getServletInfo());
	}
	
	@Test
	public void multiplyLogicTest() {
		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final Controller contr = new Controller();
        when(request.getParameter("a")).thenReturn("1");
        when(request.getParameter("b")).thenReturn("2");
        when(request.getParameter("action")).thenReturn("Multiply");

        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("WEB-INF\\result.jsp")).thenReturn(rd);
        try {
            final StringWriter stringWriter = new StringWriter();
            final PrintWriter writer = new PrintWriter(stringWriter);
            when(response.getWriter()).thenReturn(writer);
			contr.processRequest(request, response);
	        assertTrue(stringWriter.toString().contains("mul result.jsp"));
	        Logger.getLogger(Controller.class.getName()).log(Level.INFO, "Calcul page condition correct");
		} catch (IOException | NullPointerException | ServletException e) {
			e.printStackTrace();
		}

	  assertNotNull(new Controller().getServletInfo());
	}
	
	
	@Test
	public void processRequestNullLogicTest() {
		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final Controller contr = new Controller();
        when(request.getParameter("a")).thenReturn("1");
        when(request.getParameter("b")).thenReturn("2");
        when(request.getParameter("action")).thenReturn(null);

        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("WEB-INF\\hello.jsp")).thenReturn(rd);
        try {
            final StringWriter stringWriter = new StringWriter();
            final PrintWriter writer = new PrintWriter(stringWriter);
            when(response.getWriter()).thenReturn(writer);
			contr.processRequest(request, response);
	        assertTrue(stringWriter.toString().contains("hello.jsp"));
	        Logger.getLogger(Controller.class.getName()).log(Level.INFO, "Null argument action handled");
		} catch (IOException | NullPointerException | ServletException e) {
			e.printStackTrace();
		}

	  assertNotNull(new Controller().getServletInfo());
	}
	
	@Test
	public void doPostTest() throws IOException{
		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter writer = new PrintWriter(stringWriter);
        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        when(request.getParameter("a")).thenReturn("1");
        when(request.getParameter("b")).thenReturn("2");
        when(request.getParameter("action")).thenReturn("Connect");
        when(response.getWriter()).thenReturn(writer);
        when(request.getRequestDispatcher("WEB-INF\\result.jsp")).thenReturn(rd);;
		new Controller().doPost(request, response);
		assertTrue(stringWriter.toString().contains("add result.jsp"));
	}
	
	@Test
	public void doGetTest() throws IOException{
		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter writer = new PrintWriter(stringWriter);
        RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
        when(request.getParameter("a")).thenReturn("1");
        when(request.getParameter("b")).thenReturn("2");
        when(request.getParameter("action")).thenReturn("Connect");
        when(response.getWriter()).thenReturn(writer);
        when(request.getRequestDispatcher("WEB-INF\\result.jsp")).thenReturn(rd);
		new Controller().doGet(request, response);
        assertTrue(stringWriter.toString().contains("add result.jsp"));
	}
	
	@Test
	public void servletInfoTest(){
		assertNotNull(new Controller().getServletInfo());
	}
}
