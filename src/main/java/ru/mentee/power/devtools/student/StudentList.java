package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

// нарушение: неправильное имя класса
class StudentList {
  private List<Student> studentList;  // нарушение: snake_case
  public StudentList() {
    studentList = new ArrayList<>();
  }

  private int temp1;
  private int temp2;
  private int temp3;
  private int temp4; // нарушение4: Лучше объявлять каждую на отдельной строке

  private static final int MAX_SIZE = 10; // нарушение: Должно быть MAX_SIZE

  // нарушение: имя метода
  public void addStudent(Student student) {
    if (student != null) { // нарушение: нет пробела после if
      studentList.add(student);
    }
  }

  // нарушение: длинная строка (>120 символов)
  public List<Student> getStudentsByCity(String city) {
    return studentList.stream().filter(s -> s.city().equals(city)).toList();
  }

  // нарушение: tab для индентации)
  public void method() {
  }

  public void processStudentData(String studentName, int studentAge) {
      // нарушение: параметры в snake_case
    System.out.println(studentName + " is " + studentAge + " years old");
  }

  // Нарушение: NeedBraces (error) отсутствуют фигурные скобки
  boolean isEmpty() {
    if (studentList.size() == 0) {
      return true; // нужно добавить {}
    }
    return false;
  }

  public void demonstrateEmptyCatch() {
    try {
      int result = 10 / 0;
    } catch (ArithmeticException e) {
    // нарушение: пустой catch блок -  EmptyCatchBlock
    }
  }
}
