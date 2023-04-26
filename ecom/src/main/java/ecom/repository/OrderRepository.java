package ecom.repository;

import ecom.domain.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderRepository {
    private SessionFactory sessionFactory;

    public OrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Order> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> orderTypedQueryTypedQuery = session.createQuery("from Order", Order.class);
        return orderTypedQueryTypedQuery.getResultList();
    }

    public boolean create(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        return true;
    }

    public Order get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    public boolean update(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
        return true;
    }

    public boolean delete(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(order);
        return true;
    }
}
