package com.globallogic.orders.service;

import java.util.List;

import com.globallogic.orders.domain.Order;
import com.globallogic.orders.exception.EntityNotFoundException;

public interface OrderServices {

	Order add(Order pOrder);
	List<Order> getAll();
	void delete(String id) throws EntityNotFoundException;
	Order update(Order order, String id) throws EntityNotFoundException;
	Order get(String id)  throws EntityNotFoundException;
	Order increment(String id) throws EntityNotFoundException;
	Order decrement(String id) throws EntityNotFoundException;
}
