package ru.java.exception;

import java.lang.reflect.Method;

public class SomeClass {
    private String str;

    public SomeClass() {}

    public SomeClass(String str) {
        this.str = str;
    }

    // если в методе указано, что он может генерировать исключение класса, то он также может генерировать исключения его подклассов
    public void Method() throws SomeClassStringIsEmptyException /* SomeClassException*/ {
        if (this.str == null) {
            throw new SomeClassStringIsEmptyException();
        }
        System.out.println("String is equal to " + this.str);
    }
}
