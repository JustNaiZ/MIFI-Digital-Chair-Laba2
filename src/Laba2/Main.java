package Laba2;

/*
    Здравствуйте. Lombok у меня не работает, поэтому решил сделать по старинке, то есть через конструктор и геттеры.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Alice", "Brown", 25, "USA"),
                new User(2, "Bob", "Smith", 30, "Canada"),
                new User(3, "Charlie", "Adams", 31, "Russia"),
                new User(4, "Diana", "White", 35, "UK"),
                new User(5, "Eva", "Jones", 18, "Australia"),
                new User(6, "Artem", "Maslennikov", 20, "Russia")
        );

        //вывести всех пользователей, отсортированных по lastName;
        System.out.println("\n1) Отсортирован по Фамилии:");
        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);

        //вывести всех пользователей, отсортированных по age;
        System.out.println("\n2) Отсортирован по Возрасту:");
        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);

        //проверить, что для всех пользователей age > 7;
        System.out.println("\n3) Все ли пользователи старше 7?");
        Boolean booleanGetAge = users.stream()
                .allMatch(user -> user.getAge() > 7);
        System.out.println(booleanGetAge);

        //вычислить средний возраст всех пользователей;
        System.out.println("\n4) Средний возраст всех пользователей:");
        OptionalDouble average = users.stream()
                .mapToInt(User::getAge)
                .average();
        System.out.println(average.getAsDouble());

        //вывести количество разных стран проживания (country) среди заданных пользователей
        System.out.println("\n5) Количество разных стран проживания (country) среди заданных пользователей:");
        Long countUniqueCountry = users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
        System.out.println(countUniqueCountry);

    }
}
