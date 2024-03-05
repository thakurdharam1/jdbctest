package in.co.rays.payment;

import java.util.Date;

public class PaymentBean {
	private int id=0;
	private Date paytmentDate=null;
	private String Description=null;
	private int amount=0;
	private String paymentMethod=null;
	private String status=null;
	private String payer=null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPaytmentDate() {
		return paytmentDate;
	}
	public void setPaytmentDate(Date paytmentDate) {
		this.paytmentDate = paytmentDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
}
