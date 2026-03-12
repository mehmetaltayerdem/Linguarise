package com.linguarise.shared.domain;

public enum ExamType {
    YDS("YDS - Yabancı Dil Sınavı"),
    YOKDIL("YÖKDİL - Yükseköğretim Kurumları Yabancı Dil Sınavı"),
    IELTS("IELTS - International English Language Testing System");

    private final String fullName;

    ExamType(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
