import java.util.Scanner;

public class LabScanner {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // создаем объект Scanner для стандартного ввода

        System.out.println("Введите произвольное количество слов (символов, разделенных пробелами):");
        int counter = 1;
        while(inputScanner.hasNext()){ // пока есть следующее слово для считывания
            String word = inputScanner.next(); // считываем слово
            System.out.println("Слово " + counter + ":\n" + word); // выводим считанное слово
            counter++;
        }

        inputScanner.close();
    }
}
