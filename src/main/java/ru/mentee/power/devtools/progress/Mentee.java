package ru.mentee.power.devtools.progress;

/**
 * Record для представления mentee с информацией о прогрессе обучения.
 * Автоматически создаёт конструктор и геттеры: name(), city(), goal(), completedLessons(), totalLessons().
 *
 * @param name             Имя mentee
 * @param city             Город mentee
 * @param goal             Цель обучения
 * @param completedLessons Количество пройденных уроков
 * @param totalLessons     Общее количество уроков в курсе
 */
public record Mentee(
        String name,
        String city,
        String goal,
        int completedLessons,
        int totalLessons
) {
    /**
     * Компактный конструктор с валидацией данных.
     * Проверяет корректность значений прогресса.
     *
     * @throws IllegalArgumentException если значения прогресса некорректны
     */
    public Mentee {
        if (completedLessons < 0 || totalLessons <= 0 || completedLessons > totalLessons) {
            throw new IllegalArgumentException("Некорректные значения прогресса");
        }
    }
}