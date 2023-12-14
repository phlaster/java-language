package ru.java.innerClass;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

// Внутренний класс - класс, который определен внутри другого класса
// Зачем:
// 1. Объект внутреннего класса имеет доступ ко всем (включая закрытые) данным объекта, в котором он определен.
// 2. Внутренний класс можно скрыть от других классов того же пакета
// 3. Анонимный внутренний класс можно использовать для обратного вызова (не нужно писать много кода)
public class LInnerClass {
    public static void main(String[] args) {

        // 1. Использование внутреннего класса
        // Так нельзя, потому что требуется наличия экземпляра внешнего класса
//        LInnerClass1 lic1 = new LInnerClass.LInnerClass1();

        LInnerClass lic = new LInnerClass();
        lic.MyMethod();

        // Посмотреть в директории как сохраняются внутренние классы


        // внутренние классы можно объявить и внутри блока
        class MIC {
            private int i = 123;
            public void printI() { System.out.println(i);}
        }

        MIC mic = new MIC();
        mic.printI();
    }

    private int value = 12;
    private LInnerClass1 lic1 = null;
    private LInnerInterface lic2 = null;

    public LInnerClass() {
        this.lic1 = new LInnerClass1();
        // можно использовать анонимные внутренние классы
        this.lic2 = new LInnerInterface () {
          public void MyInterfaceMethod() {
              System.out.println("LInnerClass1::MyInetrfaceMethod()");
          }
        };
    }

    public void MyMethod() {
        this.lic1.Method();
        this.lic2.MyInterfaceMethod();
    }

    public class LInnerClass1 {

        public void Method() {
            System.out.println("LInnerClass1::Method() -> " + LInnerClass.this.value);
        }
    }

    public interface LInnerInterface {
        public void MyInterfaceMethod();
    }
}
