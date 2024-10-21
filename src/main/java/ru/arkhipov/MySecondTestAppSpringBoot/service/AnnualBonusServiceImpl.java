package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays, int year) {
        int daysInYear = isLeapYear(year) ? 366 : 365;
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    // Метод для вычисления квартальной премии для менеджеров
    public double calculateQuarterBonus(Positions position, double salary, double bonus) {
        // Проверка, является ли сотрудник менеджером
        if (!position.isManager()) {
            throw new IllegalArgumentException("Премия рассчитывается только для менеджеров и управленцев.");
        }

        // Если менеджер, то расчет квартальной премии
        double quarterBonus = salary * bonus * position.getPositionCoefficient();
        return quarterBonus;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
