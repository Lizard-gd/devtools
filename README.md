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


## Правило веток: feature/DVT-X

В проекте используется следующее правило именования веток:

- **master** (или `main`) — основная стабильная ветка. Содержит готовый к релизу код. Прямые коммиты в `master` запрещены, изменения попадают только через слияние (merge) из других веток.
- **feature/DVT-X** — ветки для разработки новых функций или задач.
    - `DVT` — префикс проекта/задачи (может означать, например, "DevTools").
    - `X` — номер задачи или тикета в системе отслеживания (Jira, Trello и т.д.).

### Примеры:
- `master`
- `feature/DVT-3`

Все разработка ведется в ветках `feature/*`. После завершения работы над задачей, ветка `feature/DVT-X` сливается с `master`.

## Git локальный цикл: шаги и команды
1. git checkout master          # перейти в основную ветку
2. git pull                     # обновить (если есть удалённый репозиторий)
3. git checkout -b feature/новая-функция  # создать новую ветку
4. После: # внести изменения в код
5. git add .                    # добавить изменения
6. git commit -m "описание"      # закоммитить
7. git checkout master          # вернуться в master
8. git merge feature/новая-функция  # слить изменения

## Сценарий ручной проверки DVT-6

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)
