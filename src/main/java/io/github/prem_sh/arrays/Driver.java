package io.github.prem_sh.arrays;

import io.github.prem_sh.arrays.sorting_algorithms.BubbleSort;
import io.github.prem_sh.arrays.sorting_algorithms.InsertionSort;
import io.github.prem_sh.arrays.sorting_algorithms.QuickSort;

import java.util.Arrays;
import java.util.Comparator;

public class Driver {
    public static void main(String[] args) {
        ArrayAdt.help();

        System.out.println(">>> Array Creation With Integer type");
        ArrayAdt<Integer> arr = new ArrayAdtImpl<Integer>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.print();

        System.out.println("\n>>> Insert on tail varients");
        arr.print();
        arr.insertTail(6);
        System.out.println("insertTail(6)                                    "+arr);
        arr.insertTail(new Integer[]{11,21,31});
        System.out.println("insertTail(new Integer[]{11,21,31})              "+arr);
        arr.insertTail(new ArrayAdtImpl<Integer>(1,11,111));
        System.out.println("insertTail(new ArrayAdtImpl<Integer>(1,11,111))  "+arr);


        System.out.println("\n>>> Insert on head varients");
        arr.print();
        arr.insertHead(61);
        System.out.println("insertHead(61)                                   "+arr);
        arr.insertHead(new Integer[]{9,99,999});
        System.out.println("insertHead(new Integer[]{9,99,999})              "+arr);
        arr.insertHead(new ArrayAdtImpl<Integer>(2,22,222));
        System.out.println("insertHead(new ArrayAdtImpl<Integer>(2,22,222))  "+arr);

        System.out.println("\n>>> length and size");
        System.out.println("length : "+arr.length());
        System.out.println("size : "+arr.size());

        System.out.println("\n>>> get, set and trim");
        arr.print();
        System.out.println("> get 2nd element : "+ arr.get(1));
        arr.set(1,111);
        System.out.println("> after setting 2nd element to (111)");
        arr.print();
        arr.trim();
        System.out.println("> Trimmed array : ");
        arr.print();

        System.out.println("\n>>> Remove from head");
        arr.print();
        System.out.println("Removed element from head : "+arr.removeHead()+"                    >>--> "+arr);
        System.out.println("Removed multiple elements from head: "+ Arrays.toString(arr.removeHead(2))+"    >>--> "+arr);

        System.out.println("\n>>> Remove from tail");
        arr.print();
        System.out.println("Removed element from tail : "+arr.removeTail()+"                 >>--> "+arr);
        System.out.println("Removed multiple elements from tail: "+ Arrays.toString(arr.removeTail(2))+"    >>--> "+arr);
        arr.print();

        System.out.println("\n>>> head and tail");
        arr.print();
        System.out.println("Head : "+arr.head());
        System.out.println("Tail : "+arr.tail());

        System.out.println("\n>>> Insert 100 at 3");
        System.out.println("Before : "+arr);
        arr.insertAt(3,100);
        System.out.println("After  : "+arr);

        System.out.println("\n>>> Rotate Right and Left");
        System.out.println("Before rotateRight: "+arr);
        arr.rotateRight();
        System.out.println("After rotateRight : "+arr);
        arr.rotateLeft();
        System.out.println("After leftRotate : "+arr);

        System.out.println("\n>>> Sorting Ascending");
        System.out.println("Before sorting : "+arr);
        arr.sort();
        System.out.println("After sorting :  "+arr);

        System.out.println("\n>>> Sorting Descending");
        System.out.println("Before sorting : "+arr);
        arr.sort(true);
        System.out.println("After sorting :  "+arr);

        System.out.println("\n\n======================================================");

        System.out.println(">>> Creating Employee Array");
        ArrayAdt<Employee> employees = new ArrayAdtImpl<>();
        employees.add(new Employee(3,"Ajay", 100000L));
        employees.add(new Employee(1,"Zoran", 900000L));
        employees.add(new Employee(5,"Vicky", 50000L));
        System.out.println(employees);

        System.out.println("\n\n-------------------- Selection sort performance --------------------");

        long start = System.nanoTime();

        System.out.println("STRATEGY USED : "+employees.getSortingStrategy());
        System.out.println("\nBefore Sorting  : "+employees);
        employees.sort();
        System.out.println("Sort by ID      : "+employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.salary-o2.salary);
            }
        });
        System.out.println("Sort by Salary  : "+employees);
        employees.sort((e1, e2)->e1.name.compareTo(e2.name));
        System.out.println("Sort by Name    : "+employees);
        employees.sort(true);
        System.out.println("Sort by ID (reverse)  : "+ employees);

        long end = System.nanoTime();

        System.out.println("\n$$$ Time taken for Selection sort to complete all above operations : "+(end-start));

        //reset
        employees.clear();
        employees.add(new Employee(3,"Ajay", 100000L));
        employees.add(new Employee(1,"Zoran", 900000L));
        employees.add(new Employee(5,"Vicky", 50000L));
        
        
        System.out.println("\n\n-------------------- Bubble sort performance --------------------");

        start = System.nanoTime();

        employees.setSortingStrategy(new BubbleSort<>());
        System.out.println("STRATEGY USED : "+employees.getSortingStrategy());
        System.out.println("\nBefore Sorting  : "+employees);
        employees.sort();
        System.out.println("Sort by ID      : "+employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.salary-o2.salary);
            }
        });
        System.out.println("Sort by Salary  : "+employees);
        employees.sort((e1, e2)->e1.name.compareTo(e2.name));
        System.out.println("Sort by Name    : "+employees);
        employees.sort(true);
        System.out.println("Sort by ID (reverse)  : "+ employees);

        end = System.nanoTime();

        System.out.println("\n$$$ Time taken for Bubble sort to complete all above operations : "+(end-start));

        //reset
        employees.clear();
        employees.add(new Employee(3,"Ajay", 100000L));
        employees.add(new Employee(1,"Zoran", 900000L));
        employees.add(new Employee(5,"Vicky", 50000L));
        employees.add(new Employee(3,"Ajay", 100000L));
        employees.add(new Employee(1,"Zoran", 900000L));
        employees.add(new Employee(5,"Vicky", 50000L));
        employees.add(new Employee(3,"Ajay", 100000L));
        employees.add(new Employee(1,"Zoran", 900000L));
        employees.add(new Employee(5,"Vicky", 50000L));


        
        System.out.println("\n\n-------------------- Insertion sort performance --------------------");

        start = System.nanoTime();

        employees.setSortingStrategy(new InsertionSort<>());
        System.out.println("STRATEGY USED : "+employees.getSortingStrategy());
        System.out.println("\nBefore Sorting  : "+employees);
        employees.sort();
        System.out.println("Sort by ID      : "+employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.salary-o2.salary);
            }
        });
        System.out.println("Sort by Salary  : "+employees);
        employees.sort((e1, e2)->e1.name.compareTo(e2.name));
        System.out.println("Sort by Name    : "+employees);
        employees.sort(true);
        System.out.println("Sort by ID (reverse)  : "+ employees);

        end = System.nanoTime();

        System.out.println("\n$$$ Time taken for Insertion sort to complete all above operations : "+(end-start));

        //reset
        employees.clear();
        employees.add(new Employee(3,"Ajay", 100000L));
        employees.add(new Employee(1,"Zoran", 900000L));
        employees.add(new Employee(5,"Vicky", 50000L));


        System.out.println("\n\n-------------------- Merge sort performance --------------------");

        start = System.nanoTime();

        employees.setSortingStrategy(new InsertionSort<>());
        System.out.println("STRATEGY USED : "+employees.getSortingStrategy());
        System.out.println("\nBefore Sorting  : "+employees);
        employees.sort();
        System.out.println("Sort by ID      : "+employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.salary-o2.salary);
            }
        });
        System.out.println("Sort by Salary  : "+employees);
        employees.sort((e1, e2)->e1.name.compareTo(e2.name));
        System.out.println("Sort by Name    : "+employees);
        employees.sort(true);
        System.out.println("Sort by ID (reverse)  : "+ employees);

        end = System.nanoTime();

        System.out.println("\n$$$ Time taken for Merge sort to complete all above operations : "+(end-start));


        System.out.println("\n\n-------------------- Quick sort performance --------------------");

        start = System.nanoTime();

        employees.setSortingStrategy(new QuickSort<>());
        System.out.println("STRATEGY USED : "+employees.getSortingStrategy());
        System.out.println("\nBefore Sorting  : "+employees);
        employees.sort();
        System.out.println("Sort by ID      : "+employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.salary-o2.salary);
            }
        });
        System.out.println("Sort by Salary  : "+employees);
        employees.sort((e1, e2)->e1.name.compareTo(e2.name));
        System.out.println("Sort by Name    : "+employees);
        employees.sort(true);
        System.out.println("Sort by ID (reverse)  : "+ employees);

        end = System.nanoTime();

        System.out.println("\n$$$ Time taken for Quick sort to complete all above operations : "+(end-start));



        System.out.println("\n\n\n=============== [ Min Max variants ] ============");

        System.out.println("Array        : "+arr);
        System.out.println("Smallest     : "+ arr.min());
        System.out.println("Largest      : "+ arr.max());
        System.out.println("3rd Smallest : "+ arr.min(3));
        System.out.println("2nd Largest  : "+ arr.max(2));

        employees.add(new Employee(10,"Aarya", 500000L));
        employees.add(new Employee(9,"Yash", 5000000L));
        System.out.println("\n\nEmployees       : "+employees);

        System.out.println("\nSmallest name     : "+ employees.min((e1, e2)->e1.name.compareTo(e2.name)));
        System.out.println("Largest name        : "+ employees.max((e1, e2)->e1.name.compareTo(e2.name)));
        System.out.println("2nd Smallest name   : "+ employees.min(2,(e1, e2)->e1.name.compareTo(e2.name)));
        System.out.println("2nd Largest name    : "+ employees.max(2,(e1, e2)->e1.name.compareTo(e2.name)));

        System.out.println("Smallest salary     : "+ employees.min((e1, e2)->e1.salary.compareTo(e2.salary)));
        System.out.println("Largest salary      : "+ employees.max((e1, e2)->e1.salary.compareTo(e2.salary)));
        System.out.println("2nd Smallest salary : "+ employees.min(2,(e1, e2)->e1.salary.compareTo(e2.salary)));
        System.out.println("2nd Largest salary  : "+ employees.max(2,(e1, e2)->e1.salary.compareTo(e2.salary)));
    }
}

