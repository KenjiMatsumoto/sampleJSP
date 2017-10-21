package sample.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.dao.InvoiceDao;
import sample.dto.InvoiceDto;
import sample.util.EnumJspName;
import sample.validator.InvoiceValidator;

/**
 * Servlet implementation class editAction
 */
@WebServlet("/EditAction")
public class EditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao dao;

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAction() throws InstantiationException, IllegalAccessException {
		super();
		dao = new InvoiceDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
		InvoiceDto invoice = dao.selectById(invoiceId);
		request.setAttribute("invoice", invoice);
		RequestDispatcher view = request
				.getRequestDispatcher(EnumJspName.EDIT.toString());
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String token = (String) session.getAttribute("token");
		// トークンチェック
		if (token == null || !(token.equals(request.getParameter("token")))) {
			// エラー画面へ
			RequestDispatcher view = request.getRequestDispatcher(EnumJspName.ERROR.toString());
			view.forward(request, response);
		} else {
			request.setCharacterEncoding("UTF-8");
			InvoiceDto invoice = new InvoiceDto();
			invoice.setTitle(request.getParameter("title"));
			invoice.setDetail(request.getParameter("detail"));
			invoice.setTotalfee(request.getParameter("totalFee"));
			String invoiceid = request.getParameter("invoiceId");

			InvoiceValidator invoiceValidator = new InvoiceValidator();
			List<String> errors = invoiceValidator.validate(invoice);

			invoice.setInvoiceId(invoiceid);
			
			EnumJspName enumItem = EnumJspName.LIST;
			if (!errors.isEmpty()) {
				request.setAttribute("errors", errors);
				enumItem = EnumJspName.EDIT;
			} else {
				request.setAttribute("invoices", dao.selectAll());
				dao.update(invoice);
			}
			RequestDispatcher view = request
					.getRequestDispatcher(enumItem.toString());
			request.setAttribute("invoice", invoice);
			view.forward(request, response);
		}
	}
}
