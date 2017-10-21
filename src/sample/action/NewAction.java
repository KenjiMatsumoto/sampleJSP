package sample.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.InvoiceDao;
import sample.dto.InvoiceDto;

/**
 * Servlet implementation class NewAction
 */
@WebServlet("/NewAction")
public class NewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvoiceDao dao;

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @see HttpServlet#HttpServlet()
	 */
	public NewAction() throws InstantiationException, IllegalAccessException {
		super();
		dao = new InvoiceDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("new.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 値を設定するオブジェクトの生成
		InvoiceDto invoice = new InvoiceDto();
		invoice.setTitle(request.getParameter("title"));
		invoice.setDetail(request.getParameter("detail"));
		invoice.setTotalfee(request.getParameter("totalFee"));
		
		// 実際の登録処理
		dao.create(invoice);
		RequestDispatcher view = request.getRequestDispatcher("new.jsp");
		request.setAttribute("invoice", invoice);
		view.forward(request, response);
	}

}
