package io.github.prem_sh.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Apples {
    private List<Apple> apples = new ArrayList<>();
    public void add (Apple a){
        apples.add(a);
    }
    public void remove (Apple a){
        apples.remove(a);
    }
    public void print (){
        System.out.println(apples);
    }

    public List<Apple> filter(Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple a: apples) {
            if(p.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    public void doSomethingOfAll(Consumer<Apple> applesConsumer){
        for (Apple a:apples) {
            applesConsumer.accept(a);
        }
    }

    public <R> void showSomethingOfAll(Function<Apple, R > fun){
        for (Apple a:apples) {
            System.out.println(fun.apply(a));
        }
    }

    public void recieveApple(Supplier<Apple> supplier){
        apples.add(supplier.get());
    }

    public List<Apple> getList(){
        return apples;
    }

}
