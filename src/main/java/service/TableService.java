package service;

import domain.Table;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("tableService")
@Transactional
public class TableService {

    protected static Logger logger = Logger.getLogger("tableService");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Table> getAll() {
        logger.debug("Getting all tables");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cook");
        return query.list();
    }

    public Table get(Integer id) {
        logger.debug("Getting table: " + id);
        Session session = sessionFactory.getCurrentSession();
        Table table = session.get(Table.class, id);
        return table;
    }

    public void add(Table table) {
        logger.debug("Adding table: " + table.getId());
        Session session = sessionFactory.getCurrentSession();
        session.save(table);
    }

    public void delete(Integer id) {
        logger.debug("Deleting table: " + id);
        Session session = sessionFactory.getCurrentSession();
        Table table = session.get(Table.class, id);
        session.delete(table);
    }
}
