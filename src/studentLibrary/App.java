package studentLibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        // this is the multithreading book crossing app

        Student[] students = null;
        Book[] books = null;
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);

        try {
            books = new Book[Constants.NUMBER_OF_BOOKS];
            students = new Student[Constants.NUMBER_OF_STUDENTS];
            for (int i = 0; i < Constants.NUMBER_OF_BOOKS; i++) {
                books[i] = new Book(i);
            }
            for (int i = 0; i < Constants.NUMBER_OF_STUDENTS; i++) {
                students[i] = new Student(i, books);
                executorService.execute(students[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            executorService.shutdown();
        }finally {
            executorService.shutdown();
        }

    }
}
