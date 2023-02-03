package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class task2 {
    static void sub_main() {
        Queue<Integer> QLL = new LinkedList<>();   // создали  Queue LinkedList
        QLL.offer(2);
        QLL.add(4);
        QLL.offer(7);
        QLL.add(4);
        QLL.offer(0);
        System.out.println("Здравствуйте, что прикажете сделать с QLL");
        System.out.println("Если введете 1 поместим нужный элемент в конец очереди");
        System.out.println("Если 2 то первый элемент очереди будет удален и выведен на экран");
        System.out.println("Если 3 то первый элемент очереди выведеться на экран");
        System.out.println("4 - выход");

        boolean flag = false; // если пользователь выберет "4" flag = true и программа stop
        while (!flag) {
            System.out.printf("QLL- %s%n", QLL);
            Scanner sc = new Scanner(System.in);
            System.out.println("Вводите сейчас:  ");
            String command = sc.nextLine();

            switch (command) {
                case "1" -> {
                    enqueue(QLL);
                }
                case "2" -> {
                    System.out.print("удалили элемент - ");
                    int returned_element = (int) dequeue(QLL);
                    System.out.println(returned_element);
                }
                case "3" -> {
                    System.out.print("первый в очереди элемент - ");
                    int returned_element = first(QLL);
                    System.out.println(returned_element);
                }
                case "4" -> {
                    flag = true;
                    System.out.println("Конец связи");
                }
                default -> System.out.println("Неверная команда");
            }
        }
    }

    static void enqueue(Queue<Integer> a) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Вводите Integer элемент для добавления в конец очереди:  ");
            Integer el = sc.nextInt();
            a.offer(el);
        } catch (Exception e) {
            System.out.println("Integer - это важно");
        }
    }

    static Integer dequeue(Queue<Integer> a) {
        try {
            return a.remove();
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }

    static Integer first(Queue<Integer> a) {
        try {
            return a.element();
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }
}