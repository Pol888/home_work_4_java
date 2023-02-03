package org.example;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task3 {
    static void task() throws IOException {
        Logger LOG = Logger.getLogger(task3.class.getName());  //  logging
        LOG.setLevel(Level.ALL);
        FileHandler fh = new FileHandler("log_task4.txt");
        LOG.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);


        ArrayDeque<Integer> list_order = new ArrayDeque<>(); // ArrayDeque

        boolean flag = false;// флаг для остановки программы
        while (!flag) {
                try {
                    if (list_order.size() == 0) {     // начало программы

                        Scanner a = new Scanner(System.in);

                        System.out.println("Введите оператор + или - :  ");
                        String ch = a.nextLine();

                        System.out.println("Введите число 1:  ");
                        int num1 = a.nextInt();

                        System.out.println("Введите число 2:  ");
                        int num2 = a.nextInt();

                        LOG.info(String.format("Все в норме"));

                        if (ch.equals("+")) {
                            System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
                            list_order.add(num1 + num2);
                        } else {
                            System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
                            list_order.add(num1 + num2);
                        }
                        System.out.println();
                        LOG.info(String.format("Все в норме"));
                    }
                    else {                                                       // второе действие программы
                        Scanner a = new Scanner(System.in);
                        System.out.println("Сделать отмену операции введите - 1");
                        System.out.println("Введите знак, продолжим счет");
                        System.out.println("Введите 'stop', программа завершится");
                        String ch = a.nextLine();

                        if(Objects.equals(ch, "1")){
                            list_order.remove();    // удаляем первый в очереди элемент
                            System.out.println(String.format("Последнее значение %d", list_order.getFirst()));

                        }else if(Objects.equals(ch, "+")){
                            System.out.println("Введите число");
                            int num = a.nextInt();
                            System.out.println(String.format("Ответ - %d", list_order.getFirst() + num));
                            list_order.addFirst(list_order.getFirst() + num); // вставляем в первое место очереди
                        }else if(Objects.equals(ch, "-")){
                            System.out.println("Введите число");
                            int num = a.nextInt();
                            System.out.println(String.format("Ответ - %d", list_order.getFirst() - num));
                            list_order.addFirst(list_order.getFirst() - num); // вставляем в первое место очереди
                        }else if(Objects.equals(ch, "stop")){
                            flag = true;
                            System.out.println("Завершение программы");
                        }
                    }
                    } catch (Exception e) {
                    LOG.warning("Чтото не так!!!");
                }
            }
        }
    }
