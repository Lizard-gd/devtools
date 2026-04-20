package ru.mentee.power.devtools;

public class LiveCodingDemo {

}

// Версия с пересдачи:
/* Задание:
Найти сумму всех чисел их неотсортированного массива {2, 4, 6, 8, 10, 0}
Один статический метод main, разделить по ответственности
*/

/*
public class LiveCodingDemo {
  public int allSum (int[] numbers) {
    if (numbers == null) {
      System.out.println("Ошибка NPE, сумма чисел не может ровняться null");
      return 0;
    }
    int sum = 0;

    for (int number : numbers) {
      sum = sum + number;
    }
    return sum;
  }

  public void main(String[] args) {
    LiveCodingDemo liveCodingDemo = new LiveCodingDemo();
    int[] allSum = {2, 4, 5, 8, 10, 0};
    int result = liveCodingDemo.allSum(allSum);
    System.out.println("Сумма чисел = " + result);
  }
}
*/

// Первая попытка сдачи GATE-1:
/*
public class LiveCodingDemo {

    public int sumNumb(int[] numbers) {
    if (numbers == null) {
    System.out.println("Ошибка: массив null! Вывожу 0.");
    // или throw new IllegalArgumentException("Массив не может быть null")
    return 0;

    // Метод должен защищать себя от некорректных входных данных.
    // Проверка на null — это защитное программирование (defensive programming).
    Такой подход делает метод устойчивым к ошибкам.
    }

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) { //Думал, что для for нужно обязательное if
            sum = sum + numbers[i]; // Если без if, мы обозначаем, что sum должна ровняться 0
            + перечисленные для сложения числа
        }
        return sum; // возвращаем сумму после итерации
    }

    public static void main(String[] args) { // создание класса main для вывода
        LiveCodingDemo liveCodingDemo = new LiveCodingDemo(); // Создание объекта класса
        - только так получится вызвать нестатический метод.
        int[] sumAllNumb = {1,5,4,10};
        int result = liveCodingDemo.sumNumb(null);
        System.out.println("Сумма чисел: 1+5+4+10 = " + result);
    }

}
*/


/*
main метод, точка входа { текстура объектов, либо использовать как статическую,
массив числовых объектов,
не отсортированный. main не должен использовать другие статические методы}
из массива чисел нужно получить сумму, и вывести её на экран в методе main
*/

// ДОМАШНЕЕ ЗАДАНИЕ:
// нужно чётко знать где сигнатура метода, что это такое, прочитать первые главы HeadFirstJava,
// метод main, void и сигнатура
// Решить проблему с null, почему выбрал и как обосновать

/*
ДОГАДКА:
Нужна проверка на null? Как здесь:
❌ Опасно
for (int i = 0; i < leads.length; i++) {
    String email = leads[i].getEmail();  // NPE если leads[i] = null!
}
✅ Правильно
for (int i = 0; i < leads.length; i++) {
    if (leads[i] != null) {
        String email = leads[i].getEmail();
    }
}
*/

// Лайвкодинг из задания GATE-1:

/*
public class LiveCodingDemo {
    public static void main(String[] args) {
        printFizzBuzz(15);
    }
    public static void printFizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
*/
/*
public class LiveCodingDemo {
    public static int sumEven (int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                sum = sum + numbers[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6};
        int result = sumEven (testArray);
        System.out.println("Сумма чисел: " + result);
    }
}
*/

/*
public class LiveCodingDemo {
    public static int findMax(int[] numbers) {
        if (numbers.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] test1 = {3, 7, 2, 9, 1};
        System.out.println(findMax(test1));
        int[] test2 = {-5, -1, -10};
        System.out.println(findMax(test2));
        int[] test3 = {42};
        System.out.println(findMax(test3));
        int[] test4 = {};
        System.out.println(findMax(test4));
    }
}
*/