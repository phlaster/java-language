package ru.java.generic;

//
public class PairInt {
    private int first;
    private int second;

    public PairInt() {}

    public PairInt(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return this.first;
    }
    public int getSecond() {
        return this.second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
