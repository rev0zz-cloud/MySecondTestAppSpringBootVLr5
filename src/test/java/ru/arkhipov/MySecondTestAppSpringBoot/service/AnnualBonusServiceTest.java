package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnnualBonusServiceTest {

    @Test
    void calculate() {
        //given
        Positions position = Positions.TL; // Team Lead, управленец
        double salary = 100000;
        double bonus = 0.2; // 20% премия

        AnnualBonusServiceImpl bonusService = new AnnualBonusServiceImpl();
        double quarterBonus = bonusService.calculateQuarterBonus(position, salary, bonus);

        System.out.println("Квартальная премия: " + quarterBonus);
    }
}
