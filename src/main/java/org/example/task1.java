package org.example;

import java.util.LinkedList;

public class task1 {
    static LinkedList<Integer> LL(LinkedList<Integer> a){    //метод принимающий LinkedList,  переворачивающий, отдающий
        int index_add = a.size() - 1;   // переменная которая имеет информацию куда вставлять элемент
        for (int i = 0; i < a.size() - 1; i++) {     // берем 1 элемент и вставляем его по индексу index_add
            a.add(index_add, a.remove(0));
            index_add--;  // уменьшаем индекс
        }
        return a;
    }

}
