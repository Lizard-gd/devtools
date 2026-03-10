package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

// нарушение: неправильное имя класса
class StudentList {
  private List<Student> studentList;  // нарушение: snake_case
  public StudentList() {
    studentList = new ArrayList<>();
  }

  private int temp1 ;
  private int temp2;
  private int temp3;
  private int temp4; // нарушение4: Лучше объявлять каждую на отдельной строке

  private static final int MAX_SIZE = 10; // нарушение: Должно быть MAX_SIZE

  // нарушение: имя метода
  public void addStudent(Student student) {
    if (student != null) {
      studentList.add(student);
    }
  }

  public List<Student> getStudentList() {
    return new ArrayList<>(studentList);
  }

  public List<Student> getStudentsByCity(String city) {
    return studentList.stream()
            .filter(s -> s.city().equals(city))
            .toList();
  }

  public void processStudentData(String studentName, int studentAge) {
    System.out.println(studentName + " is " + studentAge + " years old");
  }

  // Нарушение: NeedBraces (error) отсутствуют фигурные скобки
  boolean isEmpty() {
    return studentList.isEmpty();
  }

  public boolean removeStudent(Student student1) {
    if (student1 == null) {
      return false;
    }
    return studentList.remove(student1);
  }

  public int getStudentCount() {
    return studentList.size();
  }

  public void clearList() {
    studentList.clear();;
  }

  public Student findStudentByName(Object o) {
    if (o == null || studentList.isEmpty()) {
      return null;
    }

    String searchName = o.toString();

    for (int i = 0; i < studentList.size(); i++) {
      Student currentStudent = studentList.get(i);
      if (currentStudent != null && searchName.equals(currentStudent.getFullName())) {
        return currentStudent;
      }
    }

    return null;
  }

}
