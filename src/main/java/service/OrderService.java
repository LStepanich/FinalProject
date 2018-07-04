package service;

import domain.Order;
import domain.OrderId;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service("orderService")
@Transactional
public class OrderService {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order");
        return query.list();
    }

    public Order get(Integer waiterID, Integer tableID, Integer menuID, LocalDateTime dateTime){
        Session session = sessionFactory.getCurrentSession();
        OrderId orderId = new OrderId(waiterID,tableID,menuID,dateTime);
        Order order = session.get(Order.class,orderId);
        return order;
    }

}
