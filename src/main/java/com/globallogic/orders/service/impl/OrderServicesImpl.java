package com.globallogic.orders.service.impl;

import com.globallogic.orders.domain.Order;
import com.globallogic.orders.exception.EntityNotFoundException;
import com.globallogic.orders.repository.OrderRepository;
import com.globallogic.orders.service.OrderServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.codec.binary.Base64;

/**
 * @author facundo.ferro
 */
@Service
@Transactional
public class OrderServicesImpl implements OrderServices {

    private static final Logger log = LoggerFactory.getLogger(OrderServicesImpl.class);

    @Inject
    OrderRepository orderRepository;


    @Override
    public Order add(Order pOrder) {
        Base64 base64 = new Base64();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String id = pOrder.getUserId() + df.format(pOrder.getDate());
        pOrder.setId(new String(base64.encode(id.getBytes())));
        return orderRepository.save(pOrder);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order get(String id) throws EntityNotFoundException {
        Order order = orderRepository.findOne(id);
        if (order == null) {
            throw new EntityNotFoundException("Order with id: " + id + " not exists");
        }
        return order;
    }

    @Override
    public Order increment(String id) throws EntityNotFoundException {
        Order order = this.get(id);
        if (order == null) {
            throw new EntityNotFoundException("Order with id: " + id + " not exists");
        }
        order.incrementOccur();
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order decrement(String id) throws EntityNotFoundException {
        Order order = this.get(id);
        if (order == null) {
            throw new EntityNotFoundException("Order with id: " + id + " not exists");
        }
        order.decrementOccur();
        orderRepository.save(order);
        return order;
    }

    @Override
    public void delete(String id) throws EntityNotFoundException {
        Order order = this.get(id);
        if (order == null) {
            throw new EntityNotFoundException("Order with id: " + id + " not exists");
        }
        orderRepository.delete(id);
    }

    @Override
    public Order update(Order order, String id) throws EntityNotFoundException {
        Order o = this.get(id);
        if (o == null) {
            throw new EntityNotFoundException("Order with id: " + id + " not exists");
        }
        order.setId(id);
        orderRepository.save(order);
        return order;
    }

}
