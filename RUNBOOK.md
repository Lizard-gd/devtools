# Runbook: DevTools Project

## 📋 О проекте
Проект для автоматизации проверки домашних заданий в Mentee Power.

### Структура пакета
Все классы находятся в пакете `ru.mentee.power`:
- `ProgressDemo` — точка входа в приложение (main-класс)
- `MenteeProgress` — запись (record), представляющая прогресс ученика

### Технологии
- Java 25 (toolchain)
- Gradle
- JUnit 5 (тестирование)
- AssertJ (проверки в тестах)

### Модель данных (record MenteeProgress)
| Поле                  | Тип      | Описание               |
|-----------------------|----------|------------------------|
| `menteeName`          | `String` | Имя ученика            |
| `sprintNumber`        | `int`    | Номер спринта          |
| `plannedHoursPerWeek` | `int`    | Кол-во часов на спринт |

## 🚀 Локальный запуск и проверка

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: `devtools → Tasks → application → run`

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: `devtools → Tasks → verification → test`
3. Ожидаемый результат: `BUILD SUCCESSFUL`, все тесты зелёные

### Проверка стиля кода (Checkstyle)
```bash
./gradlew checkstyleMain
./gradlew checkstyleTest
Запуск всех проверок (как в CI) 
bash
./gradlew check
```
🔍 Отладка
Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress

Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'

Используйте Step Over (F8) для прохождения итераций

Проверьте Variables: counter, remainingHours должны изменяться корректно

Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2

Ожидаемый результат: 14 (для completedLessons=5, totalLessons=12)

🌿 Работа с Git
Правило веток
master (или main) — основная стабильная ветка. Прямые коммиты запрещены.

feature/DVT-X — ветки для разработки (например, feature/DVT-3)

Локальный цикл работы
bash
git checkout master          # перейти в основную ветку
git pull                     # обновить
git checkout -b feature/новая-функция  # создать новую ветку
Например: # внести изменения в код
git add .                    # добавить изменения
git commit -m "описание"     # закоммитить
git checkout master           # вернуться в master
git merge feature/новая-функция  # слить изменения
✅ Кодстайл-гайд (Checkstyle)
Проект следует правилам Google Java Style Guide.

1. Именование методов: camelCase
Неправильно: public void add_student(Student s) { }
Правильно: public void addStudent(Student student) { }

2. Пробелы после if/for/while
Неправильно: if(condition) {
Правильно: if (condition) {

3. Длина строки: максимум 120 символов
Длинные строки затрудняют чтение при code review.

4. Порядок импортов
Используйте Ctrl+Alt+O (Optimize Imports) в IDEA для автоматического форматирования.

5. Фигурные скобки для if
Неправильно: if (condition) doSomething();
Правильно: if (condition) { doSomething(); }
Источник

🤔 Что делать при ошибках
Если вывод некорректен: проверьте логику цикла через Debug

Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод

Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

Если Checkstyle падает: запустите ./gradlew checkstyleMain локально и исправьте ошибки

🔄 CI/CD процесс
При создании Pull Request автоматически запускается GitHub Actions:

✅ Checkstyle — проверка стиля кода

✅ Тесты — запуск всех unit-тестов

✅ Сборка — компиляция проекта

Статус CI: [![Java CI with Checkstyle and Tests](https://github.com/Lizard-gd/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/Lizard-gd/devtools/actions/workflows/ci.yml)

Если CI упал:

Перейти на вкладку "Actions" в GitHub

Найти упавший workflow

Посмотреть логи и исправить ошибку локально

Закоммитить исправление