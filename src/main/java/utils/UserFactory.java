package utils;

import dto.User;
import net.datafaker.Faker;
// каждый раз создает рандомальные данные (вероятность повторения менбше 10 процентов)
// - про библиотеку faker

public class UserFactory {

    static Faker faker = new Faker ();
//        String name = faker.name ().fullName ();
//        String firstName = faker.name ().firstName ();
//        String lastName = faker.name ().lastName ();
//
//        String email = faker.internet ().emailAddress ();
//        System.out.println (name);
//        System.out.println (firstName);
//        System.out.println (lastName);
//        System.out.println (email);
//    }

    public static User positiveUser() {
        User user = User.builder ()
                .username (faker.internet ().emailAddress ())
                .password ("Karina29!$")
                .build ();
        return user;
    }
}
