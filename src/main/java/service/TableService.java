package service;

import domain.Table;
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
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<Table> getAll(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cook");
        return query.list();
    }

    public Table get(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Table table = session.get(Table.class,id);
        return table;
    }

    public void add(Table table){
        Session session = sessionFactory.getCurrentSession();
        session.save(table);
    }

    public void delete(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Table table = session.get(Table.class,id);
        session.delete(table);
    }
}
