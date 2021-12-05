package io.perfecting.microservices.perfectingmircroservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int countUsers = 4;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
        users.add(new User(4, "Edem", new Date()));
    }

//    find all users
    public List<User> findAll(){
        return users;
    }

//    save a user
    public User saveUser(User user){
       if( user.getId() == null){
           user.setId(++countUsers);
       }
         users.add(user);
       return user;
    }


//    find a single user
    public User findUser(int Id){
        for(User user: users){
            if(user.getId()==Id)
                return user;
        }
        return null;
    }


    public User deleteUser(int Id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user  = iterator.next();
            if(user.getId()==Id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }


    }


