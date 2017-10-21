package sample.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.InvoiceDao;

/**
 * Servlet implementation class ListAction
 */
@WebServlet("/ListAction")
public class ListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao dao;
	/**
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAction() throws InstantiationException, IllegalAccessException {
		super();
		dao = new InvoiceDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("invoices", dao.selectAll());
		RequestDispatcher view = request.getRequestDispatcher("list.jsp");
		view.forward(request, response);
	}

}
