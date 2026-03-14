# 📝 Mentee Progress Tracker
Проект для отслеживания прогресса учеников по спринтам.

## 🚀 Quick Start

```bash
./gradlew run
./gradlew test
```
---
# DevTools Project

[![Java CI with Checkstyle and Tests](https://github.com/Lizard-gd/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/Lizard-gd/devtools/actions/workflows/ci.yml)

Описание:
Рабочий CI-пайплайн для автоматической проверки кода при каждом push и PR

---

# 🔧 Технологический стек проекта

## 🎯 Языки и платформы
* ☕ Java 25 LTS — основной язык разработки
* 🏗️ Gradle 8.x — система сборки (через Gradle Wrapper)

## 🛠️ Инструменты качества кода
#### ✅ Checkstyle — статический анализ стиля кода
- Конфигурация: config/checkstyle/checkstyle.xml 
- Запуск: ./gradlew checkstyleMain
#### 🧪 JUnit 5 — фреймворк тестирования
- Запуск: ./gradlew test
#### 📊 JaCoCo - Анализ покрытия кода тестами	
- Запуск: ./gradlew jacocoTestReport

## 🔄 CI/CD
#### GitHub Actions — автоматическая проверка PR
* ✅ Checkstyle на каждый коммит
* ✅ Тесты на каждый коммит
* Конфигурация: .github/workflows/

## 📋 Правила кода
* Стиль: Google Java Style Guide (через Checkstyle)
* Коммиты: Conventional Commits (feat:, fix:, docs:)
* Ветки: feature/DVT-X для задач, master — основная
* Pull Request: обязателен для слияния в master

---

## Continuous Integration (CI)

В проекте настроен GitHub Actions CI/CD процесс, который автоматически проверяет код при каждом push в pull request:

**Что проверяется:**
- ✅ **Checkstyle** — проверка стиля кода (`./gradlew checkstyleMain`)
- ✅ **Тесты** — запуск всех unit-тестов (`./gradlew test`)
- ✅ **Сборка** — успешная компиляция проекта (`./gradlew build`)

**Статус CI:** [![Java CI with Checkstyle and Tests](https://github.com/Lizard-gd/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/Lizard-gd/devtools/actions/workflows/ci.yml)

#### **!!!Важно!!!**
Все проверки должны проходить успешно перед слиянием PR.

---

## Code Review Checklist

Чеклист для само-ревью перед запросом ревью у ментора:

### Функциональность
- [ ] Код решает поставленную задачу полностью
- [ ] Обработаны граничные случаи (null, пустые данные, экстремальные значения)
- [ ] Обработка ошибок реализована корректно

### Тесты
- [ ] Добавлены тесты для нового функционала (или обновлены существующие)
- [ ] Все тесты проходят локально: `./gradlew test`
- [ ] Покрыты позитивные и негативные сценарии
- [ ] JaCoCo coverage ≥ 80% для нового кода

### Читаемость и стиль
- [ ] Имена переменных, методов и классов отражают назначение
- [ ] Нет дублирования кода (DRY principle)
- [ ] Checkstyle проходит без ошибок: `./gradlew checkstyleMain`
- [ ] Нет закомментированного кода или отладочного вывода (`System.out.println`)

### Документация
- [ ] README обновлён (если добавлена новая функциональность)
- [ ] Публичные методы имеют JavaDoc (если применимо)
- [ ] Примеры использования актуальны
- [ ] Runbook обновлён (если изменились команды запуска/проверки)

### Производительность и безопасность
- [ ] Нет очевидных проблем производительности
- [ ] Нет хардкода паролей, токенов или конфиденциальных данных

---
## Примеры Code Review комментариев

### Хорошие комментарии (конструктивные)

**Пример 1:**

**Проблема:** Метод `calculateDiscount` (строка 45) имеет 3 вложенных if-else и 40 строк.

**Почему это важно:** Сложная логика плохо тестируется и тяжело поддерживается.

**Предложение:** Вынести каждое условие в отдельный метод (например, `isEligibleForBonusDiscount()`)
и использовать паттерн Strategy для разных типов скидок.

**Пример 2:**

**Проблема:** Тест `testProcessOrder` (строка 78) проверяет только успешный сценарий.

**Почему это важно:** Не проверена обработка ошибок при недостаточном балансе.

**Предложение:** Добавить тест `testProcessOrder_InsufficientBalance_ThrowsException()`
с использованием `assertThatThrownBy()`.


### Плохие комментарии (неконструктивные)

**Пример 1:**
Этот код ужасен, полностью переписать.

**Почему плохо:** Нет конкретики (что именно плохо), нет предложения (как исправить),
токсичный тон (демотивирует автора).

**Пример 2:**
"Здесь лучше использовать Stream API."

**Почему плохо:** Нет объяснения почему лучше, нет примера как переписать,
неясно какую проблему это решает.
---
## Результаты само-ревью DVT-9

### Найденные проблемы

#### 1. В README отсутствует корректное описание, что проверяет CI
**Файл:** README.md (начало файла)
**Проблема:** Нет обозначения, как настроен CI/CD процесс, какие проверки выполняются.
**Почему важно:** Новые члены команды могут не понять, как устроен процесс автоматической проверки кода.
**Исправление:** Добавить секцию "Continuous Integration (CI)" в README с описанием workflow.

#### 2. Отсутствует документация (Runbook)
**Файл:** проект в целом
**Проблема:** В проекте отсутствует файл runbook.md с инструкциями по запуску и проверке проекта.
**Почему важно:** Без runbook новые разработчики не знают, как запустить проект локально и какие команды использовать для проверки.
**Исправление:** Создать файл RUNBOOK.md в корне проекта с базовой информацией.

#### 3. Закомментированный код
**Файл:** src/test/java/ru/mentee/power/devtools/student/StudentListTest.java (строка 44-50)
**Проблема:** Закомментированы 6 строк ненужного тест-кода
**Почему важно:** Закомментированный код создаёт путаницу: непонятно зачем он сохранён и актуален ли. Если нужна история изменений — она в Git.
**Исправление:** Удалить закомментированный код.
---
## Информационный поиск — результаты DVT-11

### Запросы и источники

| № | Запрос                        | Операторы                                                                    | Официальный источник                                                                         | Альтернатива                                                                       | Статус   | Дата проверки |
|---|-------------------------------|------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------|----------|---------------|
| 1 | Lombok Gradle Short           | site:search.maven.org "lombok" filetype:* OR site:mvnrepository.com "lombok" | https://central.sonatype.com/artifact/org.projectlombok/lombok/1.18.44                       | https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.44                | 200 (Ок) | 12.03.2026    |
| 2 | Java Stream API документация  | site:docs.oracle.com "stream api" intitle:api java 25                        | https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/Gatherers.html | https://www.baeldung.com/java-8-streams                                            | 200 (Ок) | 12.03.2026    |
| 3 | IntelliJ IDEA горячие клавиши | site:www.jetbrains.com/help "keymap" "intellij idea"                         | https://www.jetbrains.com/help/idea/settings-keymap.html                                     | https://resources.jetbrains.com/storage/products/datagrip/docs/DataGrip_keymap.pdf | 200 (Ок) | 12.03.2026    |

## AI-промпты и сравнение ассистентов

### Промпт 1: План решения

1. **Задача:**
Исправить ошибку `Unable to create Root Module` при запуске `./gradlew checkstyleMain`
2. **Контекст:**
- Java 25, проект на Gradle
- Плагин Checkstyle подключён в `build.gradle`
- Конфигурационный файл `checkstyle.xml` находится в `config/checkstyle/`
- При выполнении задачи `checkstyleMain` возникает ошибка:
Task :checkstyleMain FAILED
Unable to create Root Module
3. **Ограничения:**
- Не отключать Checkstyle полностью
- Нужно понять причину ошибки и исправить конфигурацию
- Сохранить работоспособность проверок стиля кода
4. **Ожидаемый результат:**
План диагностики и исправления ошибки из 3 шагов. Для каждого шага объяснить, почему он нужен и что проверяем. Код не писать — только план действий.
5. **Критерии успеха:**
- После выполнения плана `./gradlew checkstyleMain` выполняется без ошибок
- Checkstyle продолжает проверять код (не отключён)
- Понятна причина, по которой ошибка возникала

**Ответы AI:**

### **AI-1 ([DeepSeek]):**
```
Шаг 1: Проверка синтаксической валидности и структуры checkstyle.xml
Действие: Необходимо открыть файл config/checkstyle/checkstyle.xml и проверить его на соответствие DTD (Document Type Definition) Checkstyle, а также убедиться в наличии обязательного корневого элемента <module>.
Почему это нужно: Ошибка Unable to create Root Module в первую очередь указывает на то, что парсер Checkstyle не может разобрать конфигурационный файл или найти в нем корневой модуль. Это может быть вызвано синтаксической ошибкой (например, незакрытый тег), поврежденной кодировкой файла или отсутствием обязательной декларации модуля в начале файла.
Что конкретно проверить:
Наличие корректного XML-пролога (обычно <?xml version="1.0"?>).
Наличие корневого элемента <module name="Checker"> (или реже TreeWalker, но стандартно корневым идет Checker).
Отсутствие типографских символов (например, неразрывных пробелов) или BOM-маркеров в начале файла.

Шаг 2: Валидация содержимого иерархии модулей
Действие: Проверить, что внутри корневого модуля <module name="Checker"> корректно объявлены дочерние модули (как минимум TreeWalker) и что имена всех модулей написаны без опечаток.
Почему это нужно: Иногда ошибка возникает не на самом корневом элементе, а на первом же вложенном. Если Checkstyle встречает внутри корня неизвестный ему атрибут или несуществующее имя модуля (например, опечатка в TreeWalker), процесс создания структуры правил прерывается.
Что конкретно проверить:
Наличие и правильность написания модуля <module name="TreeWalker"/>.
Отсутствие лишних символов или некорректных атрибутов у модулей.
Валидность путей, если используются FileSetFilter (например, исключения для файлов).

Шаг 3: Проверка версионной совместимости и путей
Действие: Убедиться, что версия плагина Checkstyle в Gradle и используемая конфигурация checkstyle.xml совместимы, а также проверить, не пытается ли Checkstyle загрузить несуществующие внешние файлы (например, файлы с правилами по URL или относительным путям).
Почему это нужно: Разные версии Checkstyle имеют разный набор модулей. Если в checkstyle.xml используется модуль, который появился только в версии 10.0, а Gradle-плагин тянет старую версию 8.0 (или наоборот), загрузка корневого модуля может провалиться. Также причиной может быть ссылка на несуществующий файл с набором правил (import control).
Что конкретно проверить:
Версию Checkstyle, указанную в build.gradle (например, checkstyle { toolVersion = '...' }), и сопоставить её с требованиями вашего конфигурационного файла (если вы скачали готовый конфиг под конкретную версию).
Наличие в файле конструкции <property name="cacheFile" value="..."/> и доступность указанного пути.
Если используются модули типа ImportControl, проверить, что указанные файлы существуют по заданному пути.
```
### **AI-2 ([Алиса AI]):**
```
Шаг 1. Проверка корректности конфигурационного файла checkstyle.xml
Что делаем:
Открываем файл config/checkstyle/checkstyle.xml.
Проверяем его синтаксис на валидность XML (отсутствие незакрытых тегов, корректность кавычек и т. д.).
Убеждаемся, что файл содержит корректный модуль TreeWalker и объявлены необходимые правила (checks).
Сверяем версию Checkstyle, указанную в файле (атрибут version в корневом теге), с версией плагина Checkstyle в проекте.

Почему это нужно:
Ошибка «Unable to create Root Module» часто возникает из‑за проблем с конфигурационным файлом:
невалидный XML не может быть прочитан парсером;
отсутствие или некорректная настройка модуля TreeWalker приводит к тому, что Checkstyle не может построить дерево анализа кода;
несовместимость версий файла конфигурации и плагина может вызвать ошибки инициализации.

Что проверяем:
Файл открывается и читается без ошибок синтаксиса.
В файле присутствует секция с TreeWalker.
Версия Checkstyle в конфигурации соответствует версии плагина.

Шаг 2. Проверка конфигурации плагина Checkstyle в build.gradle
Что делаем:
В файле build.gradle находим блок конфигурации плагина checkstyle.
Проверяем, правильно ли указан путь к конфигурационному файлу:
путь должен быть относительным от корня проекта;
должен соответствовать реальному расположению файла (config/checkstyle/checkstyle.xml).
Убеждаемся, что в настройках плагина не заданы конфликтующие или устаревшие параметры.
Проверяем версию плагина Checkstyle — она должна быть совместима с Java 25 и Gradle.

Почему это нужно:
Некорректная конфигурация плагина — частая причина ошибки:
если Gradle не может найти файл checkstyle.xml, он не сможет создать корневой модуль;
устаревшая или несовместимая версия плагина может не поддерживать синтаксис конфигурации или особенности новой версии Java.

Что проверяем:
Путь к checkstyle.xml указан верно.
Версия плагина актуальна и совместима.
Настройки плагина не содержат устаревших или конфликтующих параметров.

Шаг 3. Запуск с подробным логированием и анализ вывода
Что делаем:
Выполняем команду с включённым подробным выводом: ./gradlew checkstyleMain --info или ./gradlew checkstyleMain --debug.
Анализируем вывод консоли: ищем сообщения об ошибках, которые предшествуют «Unable to create Root Module».
Обращаем внимание на строки, указывающие на:
проблемы с загрузкой классов;
исключения при парсинге XML;
конфликты версий библиотек;
недоступность файлов или путей.
На основе логов уточняем причину ошибки и вносим соответствующие исправления (например, обновляем зависимости, корректируем конфигурацию).

Почему это нужно:
Режим подробного логирования даёт максимально полную информацию о процессе выполнения задачи:
позволяет точно определить этап, на котором возникает ошибка;
выводит детали исключений, которые не отображаются в обычном режиме;
помогает выявить скрытые проблемы (например, отсутствие зависимостей или конфликты версий).

Что проверяем:
В логах есть конкретная причина ошибки (класс исключения, строка в XML, отсутствующий файл и т. п.).
После устранения причины команда ./gradlew checkstyleMain выполняется без ошибок.
```
### **Сравнение:**

- Что совпало в ответах:
Обе нейросети предлагают проверить корректность синтаксиса и структуры checkstyle.xml. А также проверить путь и совместимость версий. Также, проверить правильность написания модуля TreeWalker.

- Что различалось:
Алиса предложила проанализировать вывод командами: ./gradlew checkstyleMain --info, ./gradlew checkstyleMain --debug.

- Что выбрал и почему:
При возникновении ошибки пользовался DeepSeek, и он предлагал посмотреть вывод, но сейчас присмотрелся бы к Алисе, потому что тогда именно вывод помог мне решить проблему.

### Промпт 2: Проверка кода

**Код для проверки:**
```java
public List<Student> getStudentList() {
return new ArrayList<>(studentList);
}

public List<Student> getStudentsByCity(String city) {
return studentList.stream()
.filter(s -> s.city().equals(city))
.toList();
}
```
**Что проверить:**
1. Логические ошибки
2. Соответствие Code Conventions
3. Производительность

**Ответы AI:**

### **AI-1 ([DeepSeek]):**

Проверил код и нашел несколько моментов, которые стоит улучшить:

1. Логические ошибки
   Потенциальная NPE (NullPointerException):

```java
.filter(s -> s.city().equals(city))
Если city() вернет null, а параметр city не null, или наоборот - будет NPE. Лучше использовать безопасное сравнение:
```
```java
.filter(s -> Objects.equals(s.city(), city))
```
2. Code Conventions
   Нарушения:

Отсутствуют аннотации @Nullable/@NotNull для документирования контракта

Нет JavaDoc для публичных методов

Для лучшей читаемости можно добавить переносы в stream

Улучшенный вариант:

```java
/**
* Returns a defensive copy of the student list.
*
* @return new ArrayList containing all students
  */
  @NotNull
  public List<Student> getStudentList() {
  return new ArrayList<>(studentList);
  }

/**
* Returns students from the specified city.
*
* @param city the city to filter by
* @return unmodifiable list of students from the given city
  */
  @NotNull
  public List<Student> getStudentsByCity(@Nullable String city) {
  return studentList.stream()
  .filter(student -> Objects.equals(student.city(), city))
  .toList();
  }
```
3. Производительность
   Текущие проблемы:

getStudentList() создает копию всего списка при каждом вызове, даже если список не будет изменяться

getStudentsByCity() каждый раз фильтрует весь список заново

Улучшения:

```java
// Если нужна неизменяемая копия:
public List<Student> getStudentList() {
return Collections.unmodifiableList(studentList);
}

// Если нужна изменяемая копия, но список большой:
public List<Student> getStudentList() {
return studentList.stream()
.map(Student::new) // если Student immutable
.collect(Collectors.toList());
}

// Для частых запросов по городам - добавить кэширование:
private Map<String, List<Student>> studentsByCity;

@PostConstruct
private void buildCityIndex() {
studentsByCity = studentList.stream()
.collect(Collectors.groupingBy(Student::city));
}

@NotNull
public List<Student> getStudentsByCity(@Nullable String city) {
return studentsByCity.getOrDefault(city, List.of());
}
```
Основные рекомендации:

Определитесь с иммутабельностью и документируйте это

Добавьте null-safety

Если метод вызывается часто - рассмотрите кэширование или индексацию

### **AI-2 ([Алиса AI]):**
```
Разберу код по трём запрашиваемым пунктам.

1. Логические ошибки
   В коде нет явных логических ошибок. Методы выполняют заявленные функции:
getStudentList() возвращает копию списка студентов — это предотвращает внешнее изменение исходного studentList.
getStudentsByCity(String city) фильтрует студентов по городу и возвращает новый список.
Потенциальные проблемы:
Null‑значения. Если city в параметре метода или в поле s.city() равно null, возникнет NullPointerException.
Чувствительность к регистру. Сравнение через equals() учитывает регистр букв. Студент из «Moscow» не попадёт в выборку по запросу «moscow».
Отсутствие обработки отсутствующего города. Метод вернёт пустой список, если ни один студент не живёт в указанном городе. Это ожидаемое поведение, но оно должно быть документировано.

2. Соответствие Code Conventions
   Код в целом соответствует общепринятым Java Code Conventions, но есть нюансы:

Соблюдено:
Именование методов в стиле camelCase: getStudentList(), getStudentsByCity().
Отступы и форматирование кода корректны.
Использование лямбда‑выражения для фильтрации (s -> s.city().equals(city)) соответствует современным практикам.
Рекомендации по улучшению:
Javadoc‑комментарии. Добавьте документацию к методам, описывающую их назначение, параметры и возвращаемое значение.
Проверка входных параметров. В методе getStudentsByCity() стоит явно проверить параметр city на null и либо выбросить осмысленное исключение, либо обработать этот случай.
Согласованность имён. Имя параметра city понятно, но можно уточнить: targetCity или requestedCity подчеркнёт, что это искомое значение.

3. Производительность
   Анализ текущего кода:

getStudentList(). Создание новой ArrayList из studentList — операция с временной сложностью O(n), где n — размер списка. Это оправдано, если нужно защитить исходный список от изменений.
getStudentsByCity(). Использование Stream API (stream().filter().toList()) удобно и читаемо, но имеет накладные расходы:
Создание потока.
Промежуточные операции.
Автоматическое создание и заполнение нового списка.
Возможные оптимизации:
Кэширование для getStudentList(). Если исходный список редко меняется, а метод вызывается часто, можно кэшировать его копию и обновлять её только при изменении studentList. Это снизит сложность до O(1) для последующих вызовов.
Оптимизация getStudentsByCity() для частых запросов по городу:
Создайте карту Map<String, List<Student>>, где ключ — город, а значение — список студентов. Построение карты — O(n), но последующие запросы — O(1).
Используйте ConcurrentHashMap, если приложение многопоточное.
Упрощение Stream для простых случаев. Если логика фильтрации останется простой, Stream оптимален по читаемости. Для сложных сценариев рассмотрите цикл for с предварительной оценкой размера списка (через size()), чтобы избежать перераспределения памяти в ArrayList.
Нормализация данных. При создании карты городов или в конструкторе студентов приведите названия городов к единому регистру (например, toLowerCase()). Это устранит проблемы с регистром и ускорит сравнение.

Итоговые рекомендации
Для исправления и улучшения:
Добавьте проверку на null для параметра city в getStudentsByCity() и выбросьте IllegalArgumentException с понятным сообщением.
Приведите названия городов к единому регистру либо в методе фильтрации (с помощью equalsIgnoreCase()), либо при сохранении данных.
Добавьте Javadoc‑комментарии к обоим методам.
Если запросы по городам выполняются часто, рассмотрите создание индекса (карты) городов для ускорения поиска.
Если getStudentList() вызывается очень часто, а studentList меняется редко, реализуйте кэширование его копии.
```
### **Сравнение:**

- Что совпало в ответах:
Обе нейросети советуют добавить проверку на null, сделать кэширование метода, если вызывается часто и редко редактируется, создать аннотации и комментарии.
- Что различалось:
Алиса, в отличие от DeepSeek заметила, что явных логических ошибок нет, расписала проблемы и рекомендации по исправлению без приведения блоков кода в пример. Расширенно расписала, что соблюдено и что можно оптимизировать. DeepSeek дал блоки кода, всё дал сжато, без явного анализа "Что? Зачем? Почему?". 
- Что выбрал и почему:
Я бы выбрал объяснения Алисы и выдержки кода из DeepSeek, поскольку в части "перевода на русский" Алиса хорошо справляется, а DeepSeek демонстрирует код на который можно опереться для наглядности.
---
# 📚Личный глоссарий терминов Dev Tools

### Структура глоссария

Каждый термин содержит:
- **RU / EN** — русское и английское название
- **Определение** — краткое (1-2 предложения) объяснение термина
- **Контекст использования** — где и когда применяется
- **Пример** — конкретное применение в коде/команде/документации
- **Источник** — ссылка на официальную документацию

## ☕Категория: Java-экосистема

#### JDK — Java Development Kit
* **Определение:** Development environment for building Java applications, including compiler (javac), tools, and runtime.
* **Контекст использования:** Используется для компиляции и сборки Java-проектов.
* **Пример:** Для сборки проекта Gradle использует установленный JDK 25.
* **Источник:** https://docs.oracle.com/en/java/javase/21/docs/

#### JRE — Java Runtime Environment
* **Определение:** Environment required to run Java applications, including JVM and standard libraries.
* **Контекст использования:** Нужен только для запуска Java-приложений без компиляции.
* **Пример:** Запуск .jar файла на сервере без инструментов разработки.
* **Источник:** https://docs.oracle.com/javase/8/docs/technotes/guides/
 
#### JVM — Java Virtual Machine
* **Определение:** Virtual machine that executes Java bytecode and provides platform independence.
* **Контекст использования:** Выполняет байт-код, сгенерированный компилятором Java.
* **Пример:** JVM запускается при выполнении команды java Main.
* **Источник:** https://docs.oracle.com/javase/specs/index.html

## ⚙️Категория: Инструменты разработки

#### IDE — Integrated Development Environment
* **Определение:** Software application that provides comprehensive facilities to computer programmers for software development (code editor, debugger, build tools).
* **Контекст использования:** Используется как основная среда для написания, отладки и управления кодом.
* **Пример:** IntelliJ IDEA позволяет писать код, запускать тесты и коммитить изменения в Git через графический интерфейс.
* **Источник:** https://www.jetbrains.com/idea/

#### SDK — Software Development Kit
* **Определение:** A collection of software development tools in one installable package. They facilitate the creation of applications for a specific platform or framework.
* **Контекст использования:** Устанавливается для разработки под конкретную платформу (например, Android, Java, AWS).
* **Пример:** JDK — это SDK для платформы Java. Android SDK содержит инструменты для создания приложений под Android.
* **Источник:** https://jdk.java.net/

#### Gradle Wrapper — Gradle Wrapper
* **Определение:** A script that invokes a declared version of Gradle, downloading it beforehand if necessary.
* **Контекст использования:** Используется в проектах, чтобы гарантировать, что сборка выполняется одной и той же версией Gradle на всех машинах.
* **Пример:** Запуск ./gradlew build скачает нужную версию Gradle (если её нет) и выполнит сборку.
* **Источник:** https://docs.gradle.org/current/userguide/gradle_wrapper.html

#### Git — Git
* **Определение:** A distributed version control system (VCS) designed to handle everything from small to very large projects with speed and efficiency. It tracks changes in source code during software development.
* **Контекст использования:** Используется для управления версиями кода, координации работы команды, создания веток для новых функций и слияния изменений обратно в основную ветку.
* **Пример:** Команда git commit -m "feat: add user authentication" создает снимок текущего состояния проекта с описанием внесенных изменений, сохраняя их в истории репозитория.
* **Источник:** https://git-scm.com/doc

#### Build Tool — Build Tool
* **Определение:** A program that automates the process of creating executable applications from source code (compilation, testing, packaging, dependency management).
* **Контекст использования:** Используется для автоматизации рутинных задач сборки и управления зависимостями проекта.
* **Пример:** Gradle, Maven, Ant. В нашем проекте используется Gradle.
* **Источник:** https://gradle.org/

#### Dependency — Зависимость (Внешняя библиотека в Gradle)
* **Определение:** An external library, framework, or module that a project requires to compile, test, or run correctly. Dependencies are managed by build tools like Gradle or Maven.
* **Контекст использования:** Объявляется в файле конфигурации сборки (например, build.gradle). Инструмент сборки автоматически скачивает указанную библиотеку из центрального репозитория (Maven Central) и подключает её к проекту.
* **Пример:** В build.gradle добавляется строка testImplementation 'org.junit.jupiter:junit-jupiter:5.9.2' — это объявление зависимости от библиотеки JUnit 5 для написания тестов.
* **Источник:** https://docs.gradle.org/current/userguide/core_dependency_management.html

#### Maven — Maven
* **Определение:** A build automation and project management tool primarily used for Java projects. It uses a Project Object Model (POM) file to manage project builds, dependencies, and documentation.
* **Контекст использования:** Используется для автоматизации сборки проектов, управления зависимостями (вместе с Gradle является стандартом в Java-мире) и создания артефактов.
* **Пример:** Файл pom.xml содержит конфигурацию проекта: groupId, artifactId, version и список зависимостей. Сборка запускается командой mvn clean install.
* **Источник:** https://maven.apache.org/

#### Merge — Слияние
* **Определение:** The operation in Git that integrates changes from one branch into another. It takes the contents of a source branch and incorporates them into a target branch.
* **Контекст использования:** Выполняется после завершения работы в фиче-ветке, чтобы перенести все изменения в основную ветку (например, master или main). Часто выполняется через Pull Request.
* **Пример:** После того как Pull Request из ветки feature/DVT-12 прошел Code Review, нажимаем кнопку "Merge pull request" на GitHub — это выполняет слияние изменений в ветку master.
* **Источник:** https://git-scm.com/docs/git-merge

#### Repository — Репозиторий (Git context)
* **Определение:** A data structure used by Git to store metadata for a set of files and directories. It contains the history of changes, branches, and tags.
* **Контекст использования:** Хранит весь код проекта и историю его изменений, может быть локальным или удаленным.
* **Пример:** Папка .git в корне проекта — это локальный репозиторий. GitHub — это сервис для хранения удаленных репозиториев.
* **Источник:** https://git-scm.com/doc

#### Commit — Коммит
* **Определение:** An individual change to a file (or set of files) in Git. It's like a "snapshot" of the project at a specific point in time, identified by a unique SHA hash.
* **Контекст использования:** Фиксирует изменения в локальном репозитории после их подготовки (git add).
* **Пример:** git commit -m "docs: add glossary to README" создает коммит с сообщением.
* **Источник:** https://git-scm.com/docs/git-commit

#### Branch — Ветка
* **Определение:** A lightweight, movable pointer to a specific commit. It allows parallel development on different features or fixes without affecting the main codebase.
* **Контекст использования:** Создается для изолированной работы над новой функциональностью.
* **Пример:** Ветка feature/DVT-12 создана для выполнения задачи по созданию глоссария.
* **Источник:** https://git-scm.com/docs/git-branch

#### Pull Request — Pull Request
* **Определение:** A method of submitting contributions to a Git repository. It is a request to merge changes from one branch into another, often used for code review.
* **Контекст использования:** Создается в веб-интерфейсе GitHub/GitLab после пуша фиче-ветки, чтобы предложить свои изменения команде.
* **Пример:** После завершения работы над глоссарием создается Pull Request из ветки feature/DVT-12 в ветку master.
* **Источник:** https://docs.github.com/en/pull-requests

#### Artifact — Артефакт
* **Определение:** A file or package produced as a result of a build process. In Java projects, a common artifact is a JAR (Java ARchive) file, which contains compiled bytecode (.class files), resources, and metadata. Other examples include WAR, ZIP, or executable files .
* **Контекст использования:** Конечный результат работы сборочного инструмента (Maven, Gradle). Артефакты публикуются в репозиторий артефактов (например, Nexus, Artifactory, Maven Central) для дальнейшего использования другими проектами в качестве зависимостей или для развертывания в среде выполнения.
* **Пример:** После успешного выполнения команды ./gradlew build в папке build/libs/ появляется артефакт — файл my-awesome-app-1.0.0.jar. Этот JAR-файл можно скопировать на сервер и запустить командой java -jar my-awesome-app-1.0.0.jar.
* **Источник:** https://maven.apache.org/guides/introduction/introduction-to-the-pom.html (POM Reference — описывает артефакт через groupId, artifactId, version)

## 🔄Категория: Процессы и практики

#### Code Review — Code Review
* **Определение:** A systematic examination of source code by one or more developers to find bugs, improve code quality, and share knowledge.
* **Контекст использования:** Проводится в рамках Pull Request перед слиянием изменений в основную ветку.
* **Пример:** Другой разработчик оставляет комментарии в нашем PR, указывая на возможные улучшения кода.
* **Источник:** https://google.github.io/eng-practices/review/reviewer/

#### CI/CD — CI/CD
* **Определение:** Continuous Integration and Continuous Delivery (or Deployment) — a practice of automating the building, testing, and deployment of applications.
* **Контекст использования:** Настраивается в репозитории для автоматической проверки каждого коммита и PR (CI) и автоматического развертывания (CD).
* **Пример:** GitHub Actions автоматически запускает ./gradlew checkstyleMain и ./gradlew test при каждом пуше в наш PR.
* **Источник:** https://docs.github.com/en/actions

#### Checkstyle — Checkstyle
* **Определение:** A static code analysis tool used in Java development to check if the source code adheres to a defined coding standard (e.g., Google Java Style).
* **Контекст использования:** Интегрируется в процесс сборки (например, в Gradle) для автоматической проверки стиля кода.
* **Пример:** Конфигурация config/checkstyle/checkstyle.xml задает правила, а команда ./gradlew checkstyleMain запускает проверку.
* **Источник:** https://checkstyle.org/

#### Runbook — Сборник инструкций / Регламент
* **Определение:** Runbooks are a collection of documented procedures that explain how to carry out a particular process, be it starting, stopping, debugging, or troubleshooting a particular system.
* **Контекст использования:** Используется для объяснения последовательности выполнения задач, снижения количества ошибок при ручных операциях и сохранения знаний о процессах. Хранятся в централизованном месте, например, в Wiki или в системе контроля версий.
* **Пример:** При падении сервера дежурный инженер открывает runbook "Сбой веб-сервера", в котором по шагам описано: 1. Проверить доступность сервиса. 2. Подключиться по SSH. 3. Проверить логи в /var/log/. 4. Если ошибка "disk full", выполнить скрипт очистки. 5. Если не помогло, эскалировать тимлиду.
* **Источник:** https://docs.gitlab.com/user/project/clusters/runbooks/ (AWS Well-Architected Framework)

## 🐞Категория: Отладка

#### Debug — Debug
* **Определение:** The process of identifying and removing errors (bugs) from computer programs.
* **Контекст использования:** Выполняется в IDE для пошагового выполнения кода и анализа состояния программы.
* **Пример:** В IntelliJ IDEA можно запустить программу в режиме отладки (Shift+F9) вместо обычного запуска.
* **Источник:** https://www.jetbrains.com/help/idea/debugging-code.html

#### Breakpoint — Точка остановки
* **Определение:** An intentional stopping or pausing place in a program, put in place for debugging purposes. It suspends program execution to allow the developer to inspect the program's state.
* **Контекст использования:** Устанавливается в IDE на нужной строке кода. При запуске в режиме отладки выполнение остановится на этой строке.
* **Пример:** Чтобы понять, почему переменная count равна нулю, ставим точку останова на строке, где она используется, и запускаем отладку.
* **Источник:** https://www.jetbrains.com/help/idea/using-breakpoints.html

---

## ❓ Вопросы по сложным терминам

### Вопрос 1: Разница между JDK, JRE и JVM
* **Задача:** Не могу понять, в чём принципиальная разница между JDK, JRE и JVM. Кажется, что всё это просто "Java", но зачем тогда три разных термина?
* **Контекст:** Изучил определения в глоссарии: JDK — для разработки, JRE — для запуска, JVM — виртуальная машина. Но на практике я просто устанавливаю JDK и пишу код, а всё остальное происходит само. В чём реальное разделение?
* **Ограничения:** Пробовал искать на форумах, но там часто обсуждают устаревшую Java 8, где JDK не включала JRE отдельно. Хочу понять актуальную ситуацию для Java 21.
* **Ожидаемый результат:** Чёткое иерархическое понимание: JVM — это "двигатель", который выполняет байт-код. JRE — это JVM + стандартные библиотеки для запуска. JDK — это JRE + инструменты разработчика (компилятор, отладчик, документатор). Важно: в современных версиях при установке JDK вы получаете всё необходимое и для разработки, и для запуска.
* **Критерии успеха:** Могу объяснить коллеге на пальцах: "JVM запускает программу, JRE даёт ей библиотеки, JDK позволяет эту программу собрать. Пользователю нужна JRE, разработчику — JDK. JVM живёт внутри обоих".

---

### Вопрос 2: Разница между Runbook и README
* **Задача:** Не понимаю, почему нужно разделение на Runbook и README. В README тоже есть инструкции по запуску и настройке. Чем они принципиально отличаются?
* **Контекст:** В проекте есть README.md с разделами "Как запустить", "Настройка", "Тестирование". Runbook в глоссарии определён как "сборник инструкций для операций". Получается дублирование?
* **Ограничения:** Представляю оба документа как текстовые файлы с инструкциями. Не вижу чёткой границы, когда что писать и кто за что отвечает.
* **Ожидаемый результат:** Понимание разной целевой аудитории и назначения:
- **README** — для **разработчиков**, которые будут **развивать** проект. Там: архитектура, как собрать, как запустить локально, как писать тесты.
- **Runbook** — для **операторов/девопсов**, которые будут **эксплуатировать** систему в проде. Там: как обнаружить сбой, как диагностировать проблему, какие команды выполнить для восстановления, контакты ответственных.
* **Критерии успеха:** Могу однозначно определить, в какой документ писать информацию: "Если я хочу объяснить, как работает модуль аутентификации — это в README. Если я пишу инструкцию 'Что делать, если упал сервер аутентификации' — это в Runbook".
---

## Структура пакета

Все классы находятся в пакете `ru.mentee.power`:

- `ProgressDemo` — точка входа в приложение (main-класс)
- `MenteeProgress` — запись (record), представляющая прогресс ученика

Технологии:
* Java 25 (toolchain)
* Gradle
* JUnit 5 (тестирование)
* AssertJ (проверки в тестах)

### Таблица полей record MenteeProgress:

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

---

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

---

## Кодстайл-гайд проекта devtools (Checkstyle)

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used#

# CI-пайплайн настроен