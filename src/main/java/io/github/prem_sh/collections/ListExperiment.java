package io.github.prem_sh.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Logger;

public class ListExperiment {

    public static void main(String[] args) {
        System.out.println("========== ArrayList  ==========");

        ArrayList<String> list = new ArrayList<>();
        list.add("Mahatma Gandhi");
        list.add("Elizabeth Queen");
        list.add("Alexander");
        list.add("Bell labs");
        System.out.println("Initial value              : "+list);
        list.remove("Bell labs");
        System.out.println("After removal of bell labs : "+list);
        list.set(1,"Monolithic");
        System.out.println("list.set(1,\"Monolithic\")   : "+list);
        list.remove(1);
        System.out.println("list.remove(1);            : "+list);
        System.out.println("list.size();               : "+list.size());
        list.sort((a,b)->a.compareTo(b));
        System.out.println("list.sort()                : "+list);
        ArrayList<String> cloned = (ArrayList<String>) list.clone();
        cloned.add("Cloned List");
        System.out.println("cloned                     : "+cloned);
        System.out.println("cloned.contains('Alexander')          : "+cloned.contains("Alexander"));
        cloned.clear();
        System.out.println("cloned.clear()                          : "+cloned);
        System.out.println("Array                                   : "+ Arrays.toString(list.toArray()));
        System.out.println("indexOf Alexander                       : "+ list.indexOf("Alexander"));

        System.out.println("\n\n========== LinkedList ==========");
        LinkedList<String> llst = new LinkedList<>(list);
        System.out.println("Linked list : "+list);
        llst.addFirst("Prem");
        llst.add("Geetha");
        llst.addLast("Siemens");
        System.out.println(llst);
        System.out.println(llst.getFirst());
        System.out.println(llst.getLast());
        System.out.println(llst);

        System.out.println("\n\n========== Stack      ==========");

        Stack<String> stk = new Stack<>();
        stk.push("DI");
        stk.push("Junit");
        stk.push("Eureka");
        stk.push("Security");
        System.out.println("Stack : "+stk);
        System.out.println("pop   : "+stk.pop());
        System.out.println("pop   : "+stk.pop());
        System.out.println("peek  : "+stk.peek());
        System.out.println("Stack : "+stk);
    }
}
