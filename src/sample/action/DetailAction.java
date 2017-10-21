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
 * Servlet implementation class DetailAction
 */
@WebServlet("/DetailAction")
public class DetailAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDao dao;
    
    /**
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @see HttpServlet#HttpServlet()
     */
    public DetailAction() throws InstantiationException, IllegalAccessException {
        super();
        // TODO Auto-generated constructor stub
        dao = new InvoiceDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
        request.setAttribute("invoice", dao.selectById(invoiceId));
        RequestDispatcher view = request.getRequestDispatcher("detail.jsp");
        view.forward(request, response);
    }

}