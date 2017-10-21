package sample.dto;

import java.util.Date;

public class InvoiceDto {
	private String invoiceId;
	private String title;
	private String detail;
	private String totalfee;
	private Date update_date;

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(String totalfee) {
		this.totalfee = totalfee;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceid=" + invoiceId + ", title=" + title
				+ ", detail=" + detail + ", totalfee=" + totalfee
				+ ", update_date=" + update_date + "]";
	}
}
