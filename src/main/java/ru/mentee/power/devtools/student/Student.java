package ru.mentee.power.devtools.student;

public record Student(String name, String city) {

  public String getFullName() {
    return name;  // Просто возвращаем имя из record
  }

  // Для совместимости с тестами, где используется city()
  public String city() {
    return city;
  }
}
