package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest {
    @Test
    void testCalculate() {
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        int year = 2024;

        //when
        double result = new AnnualBonusServiceImpl().calculate(position, salary, bonus, workDays, year);

        //thn
        double expected = 361481.48148148146;
        assertThat(result).isEqualTo(expected);
    }
    AnnualBonusServiceImpl bonusService = new AnnualBonusServiceImpl();

    @Test
    void testCalculateQuarterBonusForManager() {
        // Arrange
        Positions position = Positions.TL; // Team Lead, управленец
        double salary = 100000;
        double bonus = 0.2; // 10% премия

        // Act
        double result = bonusService.calculateQuarterBonus(position, salary, bonus);

        // Assert
        assertEquals(52000, result, 0.001, "Квартальная премия рассчитана неверно для менеджера");
    }

    @Test
    void testCalculateQuarterBonusForNonManager() {
        // Arrange
        Positions position = Positions.DEV; // Developer, не управленец
        double salary = 100000;
        double bonus = 0.2; // 10% премия

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bonusService.calculateQuarterBonus(position, salary, bonus);
        });

        String expectedMessage = "Премия рассчитывается только для менеджеров и управленцев.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Сообщение об ошибке не соответствует ожидаемому");
    }

}