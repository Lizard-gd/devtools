package ru.mentee.power;

public class ProgressDemo {
    static void main() {
        var progress = new MenteeProgress("Gleb Druzhinin", 2, 7);
        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
        System.out.println("Текущая ветка Git: feature/DVT-4");
    }
}