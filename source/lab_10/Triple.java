public class Triple<T extends Comparable<T>> {
    private T first;
    private T second;
    private T third;

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }

    public T min() {
        if (first == null || second == null || third == null) {
            throw new IllegalArgumentException("One of the elements in the Triple is null");
        }
        return minOfThree(first, second, third);
    }

    public T max() {
        if (first == null || second == null || third == null) {
            throw new IllegalArgumentException("One of the elements in the Triple is null");
        }
        return maxOfThree(first, second, third);
    }

    public double mean() {
        if (first instanceof Number && second instanceof Number && third instanceof Number) {
            return (((Number) first).doubleValue() + ((Number) second).doubleValue() + ((Number) third).doubleValue()) / 3;
        } else {
            throw new ArithmeticException("Cannot calculate mean for non-numeric values");
        }
    }

    private T minOfThree(T a, T b, T c) {
        T min = a;
        if (b.compareTo(min) < 0) {
            min = b;
        }
        if (c.compareTo(min) < 0) {
            min = c;
        }
        return min;
    }

    private T maxOfThree(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
