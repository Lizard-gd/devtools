```markdown
# Mentee Progress Tracker
Проект для отслеживания прогресса учеников по спринтам.

## Quick Start
```bash
./gradlew run
./gradlew test
```
### Структура пакета

Все классы находятся в пакете `ru.mentee.power`:

- `ProgressDemo` — точка входа в приложение (main-класс)
- `MenteeProgress` — запись (record), представляющая прогресс ученика

Технологии:
* Java 25 (toolchain)
* Gradle
* JUnit 5 (тестирование)
* AssertJ (проверки в тестах)

#### Таблица полей record MenteeProgress:

| Поле                  | Тип      | Описание               |
|-----------------------|----------|------------------------|
| `menteeName`          | `String` | Имя ученика            |
| `sprintNumber`        | `int`    | Номер спринта          |
| `plannedHoursPerWeek` | `int`    | Кол-во часов на спринт |

[Ссылка на урок](https://mentee-power.xl.ru/learn/MCIneBj4KkyH-GIRCspFvA/theory)