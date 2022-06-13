package com.ivanvelev.repositories;

import com.ivanvelev.models.User;
import com.ivanvelev.util.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserRepositoryTests {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    public void test() {
        User one = Util.user("Ivan", "Velev", "i.velev99@gmail.com", "ivanv99", "asdfghjkl");
        User two = Util.user("Georgi", "Ivanov", "g.ivanov@gmail.com", "givanov", "asdfghjkl");
        User three = Util.user("Daniel", "Nikolov", "d.nikolov@gmail.com", "dnikolov", "asdfghjkl");
        User four = Util.user("Ivan", "Ivanov", "i.ivanov@gmail.com", "iivanov", "asdfghjkl");
        User five = Util.user("Aleksandar", "Stoyanov", "a.stoqnov@gmail.com", "astoyanov", "asdfghjkl");

        userRepository.createUser(one);
        userRepository.createUser(two);
        userRepository.createUser(three);
        userRepository.createUser(four);
        userRepository.createUser(five);

        Assert.assertEquals(5, userRepository.getAllUsers().size());
        Assert.assertEquals("i.velev99@gmail.com", userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue()).getEmail());

        User userToChange = userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue());
        userToChange.setPassword("parola");
        userRepository.updateUser(userToChange);

        User changedUser = userRepository.getUserById(userRepository.getAllUsers().get(userRepository.getAllUsers().size() - 1).getId().intValue());

        Assert.assertEquals("parola", changedUser.getPassword());

        userRepository.deleteUser(one);
        userRepository.deleteUser(two);
        userRepository.deleteUser(three);
        userRepository.deleteUser(four);
        userRepository.deleteUser(five);

        Assert.assertEquals(0, userRepository.getAllUsers().size());
    }
}
