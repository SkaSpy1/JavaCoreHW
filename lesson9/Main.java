package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Main
{
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Иван",
                Arrays.asList(new Course("SMM"),
                        new Course( "Data Science"),
                        new Course("Тестирование ПО"),
                        new Course("Разработка игр"))));

        studentList.add(new Student("Пётр",
                Arrays.asList(new Course("SMM"),
                        new Course("Тестирование ПО"),
                        new Course("Photoshop"))));

        studentList.add(new Student("Александр",
                Arrays.asList(new Course("SMM"),
                        new Course( "Веб-дизайн"),
                        new Course("Objective C"))));

        studentList.add(new Student("Сергей",
                Arrays.asList(new Course("Photoshop"),
                        new Course( "Data Science"))));


        System.out.println("\nЗадание №1");
        System.out.println("Список курсов :\n" + studentList.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .distinct()
                .collect(Collectors.toList()));

        System.out.println("\nЗадание №2");
        System.out.println("Список трёх самых любознательных студентов: \n" + studentList.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println("\nЗадание №3");
        Course course = new Course("Тестирование ПО");
        System.out.println("Студенты с курса " + course + ": \n" + studentList.stream()
                .collect(Collectors.groupingBy(s -> s.getCourses().contains(course))));
    }
}