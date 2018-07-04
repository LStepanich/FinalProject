package service;

import domain.Order;
import domain.OrderId;
import domain.Status;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("orderService")
@Transactional
public class OrderService {

    protected static Logger logger = Logger.getLogger("orderService");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Order> getAll() {
        logger.debug("Getting all orders");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order");
        return query.list();
    }

    public Order get(OrderId orderId) {
        logger.debug("Getting order: " + orderId.toString());
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, orderId);
    }

    public void create(Order order) {
        logger.debug("New order: " + order.toString());
        Session session = sessionFactory.getCurrentSession();
        session.save(order);


    }

    public void changeStatus(OrderId orderId, Status status) {
        logger.debug("Changing status: " + orderId.toString() + " to " + status);
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderId);
        order.setStatus(status);
        session.save(order);
    }

}
