package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestOrders {

	@Test
	public void testOrders() {
		OrderOperation operation = new OrderOperation();
		assertEquals(1, operation.getOrderData(1).get(0).getId());
		assertEquals("2018-08-17 22:48:19", operation.getOrderData(1).get(0)
				.getOrderdate());
		assertEquals(200000, operation.getOrderData(1).get(0).getTotalcost());
	}

	@Test
	public void testOrders2() {
		OrderOperation operation = new OrderOperation();
		assertEquals(2, operation.getOrderData(2).get(0).getId());
		assertEquals("2018-08-17 22:48:19", operation.getOrderData(2).get(0)
				.getOrderdate());
		assertEquals(900000, operation.getOrderData(2).get(0).getTotalcost());
	}

	@Test
	public void testOrders3() {
		OrderOperation operation = new OrderOperation();
		assertEquals(3, operation.getOrderData(3).get(0).getId());
		assertEquals("2018-08-17 22:48:19", operation.getOrderData(3).get(0)
				.getOrderdate());
		assertEquals(10000, operation.getOrderData(3).get(0).getTotalcost());
	}

	@Test
	public void testOrders4() {
		OrderOperation operation = new OrderOperation();
		assertEquals(4, operation.getOrderData(4).get(0).getId());
		assertEquals("2018-08-17 22:48:19", operation.getOrderData(4).get(0)
				.getOrderdate());
		assertEquals(6750, operation.getOrderData(4).get(0).getTotalcost());
	}

	@Test
	public void testOrders5() {
		OrderOperation operation = new OrderOperation();
		assertEquals(5, operation.getOrderData(5).get(0).getId());
		assertEquals("2018-08-17 22:48:19", operation.getOrderData(5).get(0)
				.getOrderdate());
		assertEquals(5750, operation.getOrderData(5).get(0).getTotalcost());
	}
}
