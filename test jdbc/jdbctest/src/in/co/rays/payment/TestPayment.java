package in.co.rays.payment;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestPayment {
	public static void main(String[] args) throws Exception {
		//testNextPk();
		//testAdd();
		//testUpdate();
		//testDeleted();
		testFindByPk();
		//testSearch();
	}

	private static void testSearch() throws Exception {
		PaymentModel model=new PaymentModel();
		List list=model.search();
		Iterator it=list.iterator();
		while(it.hasNext()) {
			PaymentBean bean=(PaymentBean)it.next();
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getAmount());
			System.out.print("\t"+bean.getStatus());
			System.out.print("\t"+bean.getPayer());
			System.out.print("\t"+bean.getDescription());
			System.out.print("\t"+bean.getPaytmentDate());
			System.out.print("\t"+bean.getPaymentMethod());
		}
		
	}

	private static void testFindByPk() throws Exception {
		PaymentBean bean=new PaymentBean();
		bean.getAmount();
		bean.getDescription();
		bean.getId();
		bean.getPayer();
		bean.getPaymentMethod();
		bean.getPaytmentDate();
		bean.getStatus();
		PaymentModel model=new PaymentModel();
		model.findByPk(1);
		
		
		
	
		
	}

	private static void testDeleted() throws Exception {
		PaymentModel model=new PaymentModel();
		model.delete(3);
		
	
		
	}

	private static void testUpdate() throws Exception {
		PaymentBean bean=new PaymentBean();
		bean.setId(2);
		bean.setAmount(5000);
		bean.setDescription("done");
		bean.setPayer("raj");
		bean.setPaytmentDate(new Date());
		bean.setPaymentMethod("online");
		bean.setStatus("gone");
		PaymentModel model=new PaymentModel();
		model.update(bean);
		
		
	}

	private static void testAdd() throws Exception {
		PaymentBean bean=new PaymentBean();
		bean.setAmount(5000);
		bean.setDescription("done");
		bean.setPayer("raj");
		bean.setPaytmentDate(new Date());
		bean.setPaymentMethod("online");
		bean.setStatus("gone");
		PaymentModel model=new PaymentModel();
		model.add(bean);
		
	}

	private static void testNextPk() throws Exception {
		PaymentModel model=new PaymentModel();
		model.nextPk();
		
	}

}
