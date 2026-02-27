package ru.mentee.power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class MenteeProgressTest {

    @Test
    void shouldFormatSummary_whenProgressCreated() {
        MenteeProgress progress = new MenteeProgress("Gleb Druzhinini", 1, 8);

        String result = progress.summary();

        assertThat(result).isEqualTo("Sprint 1 → Gleb Druzhinini: planned 8 h");
    }

    @Test
    void shouldDetectReadiness_whenHoursAboveThreshold() {
        MenteeProgress progress = new MenteeProgress("Gleb Druzhinini", 1, 4);

        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
        MenteeProgress progress = new MenteeProgress("Gleb Druzhinini", 1, 2);

        assertThat(progress.readyForSprint()).isFalse();
    }
}