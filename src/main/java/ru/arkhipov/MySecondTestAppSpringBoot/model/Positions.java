package ru.arkhipov.MySecondTestAppSpringBoot.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, true),
    ZAMDEV(3.0, false),
    BUGGAL(2.1, false),
    STD(0.3, false);

    private final double positionCoefficient;
    private final boolean isManager;

    Positions(double positionCoefficient, boolean isManager) {
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
        // Проверка на инициализацию
        System.out.println(this.name() + " isManager: " + isManager);
    }
}
