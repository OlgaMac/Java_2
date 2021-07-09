package Lambda;

import javax.persistence.UniqueConstraint;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppFindTask {
    public static void main(String[] args) {
        Set<String> doing = new HashSet<>();
        doing.add("#doing");
        Set<String> english = new HashSet<>();
        english.add("#english");
        Set<String> books = new HashSet<>();
        books.add("#books");
        Set<String> java = new HashSet<>();
        java.add("#java");
        Task taskForExample = new Task("1", "Cleaning", TaskType.WRITING,
                LocalDate.of(2021, 07, 07), false, doing,
                LocalDate.of(2021, 07, 12));
        List<Task> list = new ArrayList<>();
        list.add(new Task("1", "Cleaning", TaskType.WRITING,
                LocalDate.of(2021, 07, 07), false, doing,
                LocalDate.of(2021, 07, 12)));
        list.add(new Task("2", "ReadJavaBook", TaskType.READING,
                LocalDate.of(2021, 07, 8), true, books,
                LocalDate.of(2021, 07, 8)));
        list.add(new Task("3", "ReadDostoevskiy", TaskType.READING,
                LocalDate.of(2021, 07, 1), false,books,
                LocalDate.of(2021, 07, 8)));
        list.add(new Task("4", "LetterInEnglish", TaskType.WRITING,
                LocalDate.of(2021, 06, 30), true, english,
                LocalDate.of(2021, 07, 7)));
        list.add(new Task("5", "DoPet-Project", TaskType.CODING,
                LocalDate.of(2021, 05, 25), true, java,
                LocalDate.of(2021, 06, 15)));
        list.add(new Task("6", "ReadNewspaper", TaskType.READING,
                LocalDate.of(2021, 06, 16), false, books,
                LocalDate.of(2021, 07, 20)));
        list.add(new Task("7", "DoHomeWork", TaskType.CODING,
                LocalDate.of(2021, 06, 30), false, java,
                LocalDate.of(2021, 07, 31)));
        // Задание 1
        List<Task> filteredList = list.stream()
                .filter(task -> task.getType() == TaskType.READING )
                .sorted((t1,t2) -> t1.getCreatedOn().compareTo(t2.getCreatedOn()))
                .collect(Collectors.toList());
        System.out.println(filteredList);
        System.out.println();
        // Задание 3
        List<Task> filteredList3 = list.stream()
                .filter(task -> task.getType() == TaskType.READING )
                .sorted((t1,t2) -> t1.getCreatedOn().compareTo(t2.getCreatedOn()))
                .limit(1).collect(Collectors.toList());
        System.out.println(filteredList3);
        // Задание 4
        List<Task> filteredList4 = list.stream()
                .filter(task -> task.getType() == TaskType.CODING)
                .collect(Collectors.toList());

        long total = filteredList4.stream().count();
        System.out.println(total);

        // Задание 5

        List<Task> filteredList5 = list.stream()
                .filter(task -> task.getType() == TaskType.READING)
                .collect(Collectors.toList());
            boolean answer = filteredList5.stream()
                    .allMatch(task -> task.getTags() == books);

        System.out.println(answer);

        // Задание 6

        String titles = Stream.of("Cleaning", "ReadJavaBook","ReadDostoevskiy",
                "LetterInEnglish","DoPet-Project","ReadNewspaper","DoHomeWork", taskForExample.getTitle())
                .collect(Collectors.joining(" *** "));
        System.out.println(titles);
    }
}
