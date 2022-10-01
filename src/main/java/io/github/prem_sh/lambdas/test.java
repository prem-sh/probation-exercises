package io.github.prem_sh.lambdas;

public class test {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->task());
        t1.start();
        Thread t2 = new Thread(test::task);
        t2.start();
    }
    public static void task(){
        for (int i=0; i<10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}