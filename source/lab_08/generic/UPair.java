package ru.java.generic;

public class UPair<T, U> {
    private T first;
    private U second;

    public UPair() {}

    public UPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }
    public U getSecond() {
        return this.second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}