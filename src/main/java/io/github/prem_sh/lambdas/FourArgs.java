package io.github.prem_sh.lambdas;

@FunctionalInterface
public interface FourArgs<T extends Number> {
    int operation(T a, T b, T c, T d);
}
