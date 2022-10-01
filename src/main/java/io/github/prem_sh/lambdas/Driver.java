package io.github.prem_sh.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;


public class Driver {
    public static void main(String[] args) {
        System.out.println("============== Custom functional interface ===========");

        FourArgs<Integer> addition = (a,b,c,d)->a+b+c+d;
        FourArgs<Integer> subtraction = (a,b,c,d)->a-b-c-d;
        FourArgs<Integer> multiplication = (a,b,c,d)->a*b*c*d;

        System.out.println("addition       : "+operate4args(addition));
        System.out.println("subtraction    : "+operate4args(subtraction));
        System.out.println("multiplication : "+operate4args(multiplication));

        System.out.println("\n\n============== Predicate Interface ====================");
        Apples apples = new Apples();
        apples.add(new Apple("Kashmir",120,AppleColour.RED));
        apples.add(new Apple("Kashmir",125,AppleColour.RED));
        apples.add(new Apple("Kashmir",150,AppleColour.RED));
        apples.add(new Apple("Kashmir",130,AppleColour.RED));
        apples.add(new Apple("Kashmir",135,AppleColour.RED));
        apples.add(new Apple("Madurai",120,AppleColour.RED));
        apples.add(new Apple("Madurai",125,AppleColour.RED));
        apples.add(new Apple("Madurai",150,AppleColour.RED));
        apples.add(new Apple("Italy",130,AppleColour.RED));
        apples.add(new Apple("Italy",135,AppleColour.RED));
        apples.add(new Apple("Kashmir",120,AppleColour.GREEN));
        apples.add(new Apple("Kashmir",125,AppleColour.RED_YELLOW));
        apples.add(new Apple("Kashmir",150,AppleColour.RED_YELLOW));
        apples.add(new Apple("Kashmir",130,AppleColour.GREEN));
        apples.add(new Apple("Kashmir",135,AppleColour.RED_YELLOW));
        apples.add(new Apple("Madurai",120,AppleColour.GREEN));
        apples.add(new Apple("Madurai",125,AppleColour.RED_YELLOW));
        apples.add(new Apple("Italy",150,AppleColour.GREEN));
        apples.add(new Apple("Italy",130,AppleColour.GREEN));
        apples.add(new Apple("Italy",135,AppleColour.GREEN));
        System.out.print("List of apples : ");
        apples.print();

        final Predicate<Apple> maduraiApples = (apple)->apple.verity.equals("Madurai");
        final Predicate<Apple> largeApples = (apple)->apple.weight>133;
        final Predicate<Apple> greenApples = (apple)->apple.colour.equals(AppleColour.GREEN);
        final Predicate<Apple> italianGreenApples = (apple)->apple.colour.equals(AppleColour.GREEN)&&apple.verity.equals("Italy");

        System.out.println("\nApples from Madurai                : "+apples.filter(maduraiApples));
        System.out.println("Green Apples                       : "+apples.filter(greenApples));
        System.out.println("Large Apples                       : "+apples.filter(largeApples));
        System.out.println("Italian Green Apples               : "+apples.filter(italianGreenApples));
        System.out.println("Madurai non Green Apples               : "+apples.filter(maduraiApples.and(greenApples.negate())));

        System.out.println("\n\n============== Consumer Interface ===========");
        Consumer<Apple> printOneByOne = (a)-> System.out.println("consumed --> "+a);

        List<Apple> redYellows = new ArrayList<>();
        List<Apple> others = new ArrayList<>();

        apples.doSomethingOfAll(printOneByOne);

        apples.doSomethingOfAll((a)-> {
            if(a.colour.equals(AppleColour.RED_YELLOW)) redYellows.add(a);
            else others.add(a);
        });

        System.out.println("RedYellows : "+redYellows);
        System.out.println("Others     : "+others);

        System.out.println("\n\n============== Function Interface ===========");
        Function<Apple, AppleColour> extractColors = (apple)->apple.colour;
        Function<Apple, Integer> extractWeights = (apple)->apple.weight;

        System.out.print("Extracted colours from apples : ");
        apples.showSomethingOfAll(extractColors);
        System.out.print("Extracted weights from apples : ");
        apples.showSomethingOfAll(extractWeights);

        System.out.println("\n\n============== Supplier Interface ===========");
        System.out.print("Supplied Hybrid apple to apples list : ");
        apples.recieveApple(()->new Apple("Hybrid", 125, AppleColour.RED_YELLOW));
        apples.print();

        System.out.println("\n\n============== Chaining comparators ==========");
        List<Apple> newSet = apples.getList();
        newSet.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getVerity));
        System.out.println(newSet);

    }
    public static int operate4args(FourArgs<Integer> args){
        return args.operation(1,2,3,4);
    }

    List<Integer> ints = Arrays.asList(1,2,3);
    List<Integer> ints2 = Arrays.asList(1,2,3);

    Predicate<Integer> lessthan3 = (i)->i<3;


}
