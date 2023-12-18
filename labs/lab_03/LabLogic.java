public class LabLogic {
    public static void main(String[] args) {

        System.out.println("--------------Логические------------------");
        boolean a = true;
        boolean b = false;

        // Логическое "и"
        boolean resultAnd1 = a && b; // false

        // Логическое "или"
        boolean resultOr1 = a || b; // true

        // Логическое "не"
        boolean resultNotA = !a; // false
        boolean resultNotB = !b; // true

        System.out.println("Результат логического 'и': " + resultAnd1);
        System.out.println("Результат логического 'или': " + resultOr1);
        System.out.println("Результат логического 'не' для a: " + resultNotA);
        System.out.println("Результат логического 'не' для b: " + resultNotB);


        System.out.println("-----------Тернарный оператор-------------");
        int x = 5;
        int y = 8;
        String result = (x < y) ? "x < y" : "x >= y";
        System.out.println("Результат тернарной операции: " + result);


        System.out.println("------------------Побитовые---------------");
        int m = 5; // 101 в двоичной системе счисления
        int n = 3; // 011 в двоичной системе счисления

        int resultAnd2 = m & n; // Результат: 1 (001)
        int resultOr2 = m | n; // Результат: 7 (111)
        int resultXor = m ^ n; // Результат: 6 (110)
        int resultNotM = ~m; // Результат: -6 (111...1010)

        System.out.println("Результат поразрядного 'и': " + resultAnd2);
        System.out.println("Результат поразрядного 'или': " + resultOr2);
        System.out.println("Результат поразрядного 'исключающего или': " + resultXor);
        System.out.println("Результат поразрядного 'не' для m: " + resultNotM);


        System.out.println("-------------Битовые сдвиги---------------");
        int number = 8; // 1000 в двоичной системе
        int resultRightShift = number >> 2; // Результат: 2 (0010)
        int resultLeftShift = number << 1; // Результат: 16 (10000)
        System.out.println("Результат сдвига вправо: " + resultRightShift);
        System.out.println("Результат сдвига влево: " + resultLeftShift);
    }
}
