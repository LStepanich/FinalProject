package service;

import domain.Order;
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
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order");
        return query.list();
    }


}
