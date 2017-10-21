package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sample.dto.InvoiceDto;
import sample.util.DBUtil;

public class InvoiceDao {
	private Connection connection;

	public InvoiceDao() throws InstantiationException, IllegalAccessException {
		connection = DBUtil.getConnection();
	}

	public void create(InvoiceDto invoice) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into invoices (title,detail,totalFee,deleteFlg,updated_at) values (?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, invoice.getTitle());
			preparedStatement.setString(2, invoice.getDetail());
			preparedStatement.setInt(3,
					Integer.parseInt(invoice.getTotalfee()));
			preparedStatement.setBoolean(4, false);
			preparedStatement.setDate(5,
					new java.sql.Date(new Date().getTime()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int invoiceId) {
		
	}

	public void update(InvoiceDto invoice) {

	}

	public List<InvoiceDto> selectAll() {
		List<InvoiceDto> invoices = new ArrayList<InvoiceDto>();
		try {
			// DBへの接続
			Statement statement = connection.createStatement();
			// データ取得のSQL発行
			ResultSet rs = statement
					.executeQuery("select * from invoices where deleteFlg=0");
			// 値の取得とリストへの追加
			while (rs.next()) {
				InvoiceDto invoice = new InvoiceDto();
				invoice.setInvoiceId(rs.getString("InvoiceId"));
				invoice.setTitle(rs.getString("title"));
				invoice.setDetail(rs.getString("detail"));
				invoice.setTotalfee(String.valueOf(rs.getInt("totalFee")));
				invoice.setUpdate_date(rs.getDate("update_date"));
				invoices.add(invoice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invoices;
	}

	public InvoiceDto selectById(int invoiceId) {
		InvoiceDto invoice = new InvoiceDto();
		return invoice;
	}

}
