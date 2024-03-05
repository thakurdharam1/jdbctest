package in.co.rays.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentModel {
	
	public Integer nextPk() throws Exception {
		int pk=0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		PreparedStatement ps=conn.prepareStatement("select max(id) from payment");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
		}
		return pk+1;
		
		
	}
	public void add(PaymentBean bean) throws Exception {
        int pk=nextPk();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		PreparedStatement ps=conn.prepareStatement("insert into payment values(?,?,?,?,?,?,?) ");
		ps.setInt(1, pk);
		ps.setDate(2, new java.sql.Date(bean.getPaytmentDate().getTime()));
		ps.setString(3, bean.getDescription());
		ps.setInt(4, bean.getAmount());
		ps.setString(5, bean.getPaymentMethod());
		ps.setString(6, bean.getStatus());
		ps.setString(7, bean.getPayer());
		int i=ps.executeUpdate();
		System.out.println("added");
				
		
		
	}
	public void update(PaymentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		PreparedStatement ps=conn.prepareStatement("update payment set payment_date=?,description=?,amount=?,payment_method=?,status=?,payer=? where id=?");
	
		ps.setDate(1, new java.sql.Date(bean.getPaytmentDate().getTime()));
		ps.setString(2, bean.getDescription());
		ps.setInt(3, bean.getAmount());
		ps.setString(4, bean.getPaymentMethod());
		ps.setString(5, bean.getStatus());
		ps.setString(6, bean.getPayer());
		ps.setInt(7, bean.getId());
		int i=ps.executeUpdate();
		System.out.println("updated");
		
	} 
	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		PreparedStatement ps=conn.prepareStatement("delete from payment where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		System.out.println("deleted");
		
	}
	public PaymentBean findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		PreparedStatement ps=conn.prepareStatement("select * from payment where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		PaymentBean bean=new PaymentBean();
		while(rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setAmount(rs.getInt(4));
			bean.setDescription(rs.getString(3));
			bean.setPayer(rs.getString(7));
			bean.setPaytmentDate(rs.getDate(2));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
		}
		
		
		
		
		return bean;
		
	}
	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		PreparedStatement ps=conn.prepareStatement("select * from payment ");
		List list =new ArrayList();
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			PaymentBean bean =new PaymentBean();
			bean.setId(rs.getInt(1));
			bean.setAmount(rs.getInt(4));
			bean.setDescription(rs.getString(3));
			bean.setPayer(rs.getString(7));
			bean.setPaytmentDate(rs.getDate(2));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
			list.add(bean);
			
			
			
		}
		return list;
		
	}

}
