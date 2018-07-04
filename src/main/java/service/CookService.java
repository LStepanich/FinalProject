package service;

import domain.Cook;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("cookService")
@Transactional
public class CookService {

    protected static Logger logger = Logger.getLogger("cookService");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Cook> getAll() {
        logger.debug("Getting all cookers");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cook");
        return query.list();
    }

    public Cook get(Integer id) {
        logger.debug("Getting cooker " + id);
        Session session = sessionFactory.getCurrentSession();
        Cook cook = (Cook) session.get(Cook.class, id);
        return cook;
    }

    public void add(Cook cook) {
        logger.debug("Adding new cooker " + cook.getId() + " " + cook.getLastName());
        Session session = sessionFactory.getCurrentSession();
        session.save(cook);
    }

    public void delete(Integer id) {
        logger.debug("Deleting cooker: " + id);
        Session session = sessionFactory.getCurrentSession();
        Cook cook = (Cook) session.get(Cook.class, id);
        session.delete(cook);
    }
}
