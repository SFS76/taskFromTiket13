package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Необходимо реализовать следующий метод:
//  На вход получаем список названий книг.
//  Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
//  Все книги должны быть отсортированы по алфавиту с первой до последней полки.
//  Количество полок константное — 5 штук.
//  Вернуть книги, распределенные по полкам.


public class Main {
    public static void main(String[] args) {

        List<String> books = new ArrayList<>();
        books.add("Java в действии");
        books.add("Повесть о настоящем человеке");
        books.add("Аэропорт");
        books.add("Сказки");
        books.add("Война и мир");
        books.add("Собака Баскервилей");
        books.add("Игра престолов");
        books.add("Том Сойер");
        books.add("Мастер и Маргарита");
        books.add("Цитадель");
        books.add("Цитадель");

        List<ArrayList<String>> ret = getShelvesOfBooks(books);

        ret.stream().forEach(System.out::println);
    }

    private static List<ArrayList<String>> getShelvesOfBooks(List<String> books) {

        books = books.stream()
                .sorted()
                .collect(Collectors.toList());

        List<ArrayList<String>> shelves = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }

        int ind = 0;

        int perShelf = books.size() / shelves.size();
        int remainder = books.size() % shelves.size();

        for (List<String> shelve : shelves) {
            for (int i = 0; i < perShelf; i++)
                shelve.add(books.get(ind++));
            if (remainder-- > 0)
                shelve.add(books.get(ind++));
        }

        return shelves;
    }

}