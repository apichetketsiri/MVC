package model;


import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 6/22/2015.
 */

public interface UserDAO {

    public List<Users> getAllUser();
    public void insertUser(Users user);
}
