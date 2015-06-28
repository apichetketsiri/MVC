package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hsqldb.rights.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Admin on 6/22/2015.
 */
@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl() {
       logger.info("UserDAO");
    }

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public List<Users> getAllUser() {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "from users";
        List<Users> personsList = session.createQuery("from Users").list();
        for(Users p : personsList){
            logger.info("User List::"+p.getId());
        }
        return personsList;


    }

    @Override
    public void insertUser(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
