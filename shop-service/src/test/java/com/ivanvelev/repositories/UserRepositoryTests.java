package com.ivanvelev.repositories;

import com.ivanvelev.models.User;
import com.ivanvelev.utils.HibernateTestsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRepositoryTests {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    public void createUser() {
        User one = HibernateTestsUtil.user("Ivan", "Velev", "i.velev99@gmail.com", "ivanv99", "asdfghjkl");
        userRepository.createUser(one);
    }

    @Test
    public void test() {
        User one = HibernateTestsUtil.user("Ivan", "Velev", "i.velev99@gmail.com", "ivanv99", "asdfghjkl");
        User two = HibernateTestsUtil.user("Georgi", "Ivanov", "g.ivanov@gmail.com", "givanov", "asdfghjkl");
        User three = HibernateTestsUtil.user("Daniel", "Nikolov", "d.nikolov@gmail.com", "dnikolov", "asdfghjkl");
        User four = HibernateTestsUtil.user("Ivan", "Ivanov", "i.ivanov@gmail.com", "iivanov", "asdfghjkl");
        User five = HibernateTestsUtil.user("Aleksandar", "Stoyanov", "a.stoqnov@gmail.com", "astoyanov", "asdfghjkl");

        userRepository.createUser(one);
        userRepository.createUser(two);
        userRepository.createUser(three);
        userRepository.createUser(four);
        userRepository.createUser(five);

        Assertions.assertEquals(5, userRepository.getAllUsers().size());
        Assertions.assertEquals("i.velev99@gmail.com", userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue()).getUserCredentials().getEmail());

        User userToChange = userRepository.getUserById(userRepository.getAllUsers().get(0).getId().intValue());
        userToChange.getUserCredentials().setPassword("parola");
        userRepository.updateUser(userToChange);

        User changedUser = userRepository.getUserById(userRepository.getAllUsers().get(userRepository.getAllUsers().size() - 1).getId().intValue());

        Assertions.assertEquals("parola", changedUser.getUserCredentials().getPassword());

        userRepository.deleteUser(one);
        userRepository.deleteUser(two);
        userRepository.deleteUser(three);
        userRepository.deleteUser(four);
        userRepository.deleteUser(five);

        Assertions.assertEquals(0, userRepository.getAllUsers().size());
    }
}
