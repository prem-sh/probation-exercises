package io.github.prem_sh.streams;

import io.github.prem_sh.lambdas.Apple;
import io.github.prem_sh.lambdas.AppleColour;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.prem_sh.streams.Dish.Type.NON_VEG;

public class Driver {
    public static void main(String[] args) {
        System.out.println("================ Conversions ===============");
        System.out.println("List to stream : ");
        Arrays.asList(1,2,3,4).stream().forEach(System.out::print);

        System.out.println("\n\nStream to List : ");
        Stream.of(1,2,3,4).collect(Collectors.toList()).forEach(System.out::print);
        Stream.of(new Apple("summa",120, AppleColour.RED)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("\n\nArray to stream : ");
        int[] arr = {1,2,3,4};
        Arrays.stream(arr).forEach(System.out::print);

        System.out.println("\n\nStream to Array : ");
        Integer[] arr1 = Stream.of(1,2,3,4).toArray(Integer[]::new);
        for (int i:arr1) {
            System.out.print(i+" >> ");
        }


        System.out.println("\n\nMap to stream : ");
        Map<String, String> map = new HashMap<>();
        map.put("name","Prem");
        map.put("phone","124567890");
        map.put("email","prem@p.io");
        map.put("address","8, 404 nagar, Anonymous sector, secret city, ***");

        map.entrySet().stream().forEach(System.out::print);

        System.out.println("\n\nStream to Map : ");
        int id = 0;

        Map<String, Apple> mapped = Stream.of(new Apple("kashmir",101,AppleColour.GREEN),
                new Apple("kashmir",120,AppleColour.RED),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",103,AppleColour.RED),
                new Apple("kashmir",155,AppleColour.GREEN)).collect(Collectors.toMap(a->a.getVerity()+a.getWeight().hashCode()+a.getColour().hashCode(), a->a, (a,b)->a));
        for (String k : mapped.keySet()) {
            System.out.println(k+" : "+mapped.get(k));
        }

        //Stream -> grouped map
        Map<String, List<Apple>> mapped1 = Stream.of(new Apple("kashmir",101,AppleColour.GREEN),
                new Apple("kashmir",120,AppleColour.RED),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",103,AppleColour.RED),
                new Apple("kashmir",155,AppleColour.GREEN)).collect(Collectors.groupingBy(Apple::getVerity));

        System.out.println("\n\nStream to Map grouping : ");
        for (String k : mapped1.keySet()) {
            System.out.println(k+" : "+mapped1.get(k));
        }

        System.out.println("\n\nCount based on colour of apples");
        Map<AppleColour, Long> mapCount = Stream.of(
                new Apple("kashmir",101,AppleColour.GREEN),
                new Apple("kashmir",120,AppleColour.RED),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",178,AppleColour.GREEN),
                new Apple("chennai",103,AppleColour.RED),
                new Apple("kashmir",155,AppleColour.GREEN)).collect(Collectors.groupingBy(apple->apple.colour, Collectors.counting()));
        mapCount.forEach((color, count)-> System.out.println(color+" : "+count));


        System.out.println("\n\nSet to stream : ");
        Set.of(1,2,3).stream().forEach(System.out::print);
        System.out.println("\n\nStream to Set : ");
        Set<Integer> set = Stream.of(1,2,3).collect(Collectors.toSet());
        set.forEach(System.out::print);

        System.out.println("\n\n============== Chaining operations ===================");
        List<Dish> dishes = Arrays.asList(
                new Dish("Idly", 100, Dish.Type.VEG),
                new Dish("Dosa", 180, Dish.Type.VEG),
                new Dish("Upma", 120, Dish.Type.VEG),
                new Dish("Paniyaram", 250, Dish.Type.VEG),
                new Dish("Sambar", 350, Dish.Type.VEG),
                new Dish("vada", 300, Dish.Type.VEG),
                new Dish("Chiken tikka", 400, NON_VEG),
                new Dish("Mutton chukka", 330, NON_VEG),
                new Dish("Chicken biriyani", 1120, NON_VEG),
                new Dish("Chilli chicken", 500, NON_VEG)
        );

        System.out.println("All veg dishes                             : "+
                dishes  .stream()
                        .filter(d->d.getType().equals(Dish.Type.VEG))
                        .map(Dish::getName)
                        .collect(Collectors.toList()));

        Comparator<Dish> byCalories = (d,e)->d.getCalories()-e.getCalories();
        Comparator<Dish> byName = (d,e)->d.getName().compareTo(e.getName());
        Comparator<Dish> byType = (d,e)->d.getType().compareTo(e.getType());

        System.out.println("All veg dishes with low calories ( < 250 ) : "+
                dishes  .stream()
                        .filter(d->d.getType().equals(Dish.Type.VEG))
                        .filter(d->d.getCalories()<250)
                        .sorted(byCalories)
                        .map(Dish::getName)
                        .collect(Collectors.toList()));

        System.out.println("All veg dishes with low calories ( < 250 ) : "+
                dishes  .stream()
                        .filter(d->d.getType().equals(Dish.Type.VEG))
                        .filter(d->d.getCalories()<250)
                        .sorted(byCalories)
                        .map(Dish::getName)
                        .collect(Collectors.toList()));

        System.out.println("\n\n===== filter, distinct, ========");

        System.out.println("Filters even numbers with distinct : ");
        Stream.of(1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7)
                .filter(i->i%2==0)
                .distinct()
                .forEach(System.out::print);

        System.out.println("\n\n======== Slicing and Truncate (takehile, dropwhile, limit, skip) =========");
        List<Dish> dishes2 = Arrays.asList(
                new Dish("Idly", 100, Dish.Type.VEG),
                new Dish("Dosa", 120, Dish.Type.VEG),
                new Dish("Upma", 130, Dish.Type.VEG),
                new Dish("Paniyaram", 250, Dish.Type.VEG),
                new Dish("Sambar", 350, Dish.Type.VEG),
                new Dish("vada", 360, Dish.Type.VEG),
                new Dish("Chiken tikka", 400, NON_VEG),
                new Dish("Mutton chukka", 430, NON_VEG),
                new Dish("Chicken biriyani", 1120, NON_VEG),
                new Dish("Chilli chicken", 5000, NON_VEG)
        );
        System.out.println("\nlists all dishes with low calories : ");
        dishes2.stream()
                .takeWhile(d->d.getCalories()<350)
                .map(d->d.getName())
                .forEach(System.out::println);

        System.out.println("\nlists all dishes with high calories : ");
        dishes2.stream()
                .dropWhile(d->d.getCalories()<350)
                .map(d->d.getName())
                .forEach(System.out::println);

        System.out.println("\n\n======== Skipping =========");
        dishes2.stream()
                .limit(5)
                .skip(2)
                .map(Dish::getName)
                .forEach(System.out::println);

        System.out.println("\n\n======== Mapping  =========");

        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(7,8);
        System.out.println("List 1        : "+l1);
        System.out.println("List 2        : "+l2);
        System.out.print("Pairs generated                     : ");

        //generating pairs
        List<List<Integer>> pairs = l1.stream()
                .flatMap(i -> l2.stream().map(j -> Arrays.asList(i,j)))
                .toList();

        System.out.print(pairs);

        List<List<Integer>> pairs2 = l1.stream()
                .flatMap(i->l2.stream()
                        .filter(j->i+j<9)
                        .map(j->Arrays.asList(i,j)
                        ))
                .toList();
        System.out.println("\nPairs of who's sum is less than 9   : "+pairs2);

        List<String> l3 = Arrays.asList("Hello", "World");

        List<String> distinct = l3.stream()
                .map(w->w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\n\nDistnict letters from multiple items : "+distinct);

    }
}
