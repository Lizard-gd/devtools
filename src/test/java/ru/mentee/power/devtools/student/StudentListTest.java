package ru.mentee.power.devtools.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentListTest {

  private StudentList studentList;
  private Student student1;
  private Student student2;
  private Student student3;

  @BeforeEach
    void setUp() {
    studentList = new StudentList();
    student1 = new Student("Иван Петров", "Москва");
    student2 = new Student("Мария Иванова", "Санкт-Петербург");
    student3 = new Student("Алексей Сидоров", "Москва");
  }

  @Test
  @DisplayName("Добавление студента в список")
    void addStudentShouldAddStudentToList() {
    studentList.addStudent(student1);
    assertEquals(1, studentList.getStudentList().size());
    assertTrue(studentList.getStudentList().contains(student1));
  }

  @Test
  @DisplayName("Добавление null не должно изменять список")
    void addStudentShouldNotAddNullStudent() {
    studentList.addStudent(null);
    assertEquals(0, studentList.getStudentList().size());
  }
/*
*   @Test
  @DisplayName("Добавление рюкзаков студентов")
    void addStudentShouldAddMultipleStudents() {
    studentList.addStudent(student1);
    assertEquals(3, studentList.getStudentList().size());
  }*/
  @Test
  @DisplayName("Добавление нескольких студентов")
    void addStudentShouldAddMultipleStudents() {
    studentList.addStudent(student1);
    studentList.addStudent(student2);
    studentList.addStudent(student3);
    assertEquals(3, studentList.getStudentList().size());
  }

  @Test
  @DisplayName("Удаление студента из списка")
    void removeStudentShouldRemoveStudent() {
    studentList.addStudent(student1);
    studentList.addStudent(student2);

    boolean result = studentList.removeStudent(student1);

    assertTrue(result);
    assertEquals(1, studentList.getStudentList().size());
    assertFalse(studentList.getStudentList().contains(student1));
    assertTrue(studentList.getStudentList().contains(student2));
  }

  @Test
  @DisplayName("Удаление несуществующего студента")
    void removeNonExistentStudentShouldReturnFalse() {
    studentList.addStudent(student1);

    boolean result = studentList.removeStudent(student2);

    assertFalse(result);
    assertEquals(1, studentList.getStudentList().size());
  }

  @Test
  @DisplayName("Удаление null должно возвращать false")
    void removeNullShouldReturnFalse() {
    studentList.addStudent(student1);

    boolean result = studentList.removeStudent(null);

    assertFalse(result);
    assertEquals(1, studentList.getStudentList().size());
  }

  @Test
  @DisplayName("Поиск студента по имени")
    void findStudentByNameShouldReturnCorrectStudent() {
    studentList.addStudent(student1);
    studentList.addStudent(student2);

    Student found = studentList.findStudentByName("Иван Петров");

    assertNotNull(found);
    assertEquals("Иван Петров", found.getFullName());
    assertEquals("Москва", found.city());
  }

  @Test
  @DisplayName("Поиск несуществующего студента")
    void findNonExistentStudentShouldReturnNull() {
    studentList.addStudent(student1);

    Student found = studentList.findStudentByName("Неизвестный Студент");

    assertNull(found);
  }

  @Test
  @DisplayName("Поиск с null именем")
    void findStudentByNullNameShouldReturnNull() {
    studentList.addStudent(student1);

    Student found = studentList.findStudentByName(null);

    assertNull(found);
  }

  @Test
  @DisplayName("Очистка списка")
    void clearListShouldRemoveAllStudents() {
    studentList.addStudent(student1);
    studentList.addStudent(student2);
    studentList.addStudent(student3);

    studentList.clearList();

    assertEquals(0, studentList.getStudentList().size());
    assertTrue(studentList.getStudentList().isEmpty());
  }

  @Test
  @DisplayName("Очистка пустого списка")
    void clearEmptyListShouldDoNothing() {
    studentList.clearList();

    assertEquals(0, studentList.getStudentList().size());
  }

  @Test
  @DisplayName("Проверка количества студентов")
    void getStudentCountShouldReturnCorrectNumber() {
    assertEquals(0, studentList.getStudentCount());

    studentList.addStudent(student1);
    assertEquals(1, studentList.getStudentCount());

    studentList.addStudent(student2);
    assertEquals(2, studentList.getStudentCount());

    studentList.removeStudent(student1);
    assertEquals(1, studentList.getStudentCount());
  }

  @Test
  @DisplayName("Проверка на пустоту")
    void isEmptyShouldWorkCorrectly() {
    assertTrue(studentList.isEmpty());

    studentList.addStudent(student1);
    assertFalse(studentList.isEmpty());

    studentList.removeStudent(student1);
    assertTrue(studentList.isEmpty());
  }

  @Test
  @DisplayName("Получение списка студентов")
    void getStudentListShouldReturnCopyOfList() {
    studentList.addStudent(student1);

    List<Student> returnedList = studentList.getStudentList();

    assertNotNull(returnedList);
    assertEquals(1, returnedList.size());

    returnedList.clear();
    assertEquals(1, studentList.getStudentList().size(),
                "Оригинальный список не должен меняться");
  }
}