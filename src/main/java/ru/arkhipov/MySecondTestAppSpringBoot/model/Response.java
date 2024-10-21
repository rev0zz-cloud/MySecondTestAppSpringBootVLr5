package ru.arkhipov.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class Response {
    /***
     * Уникальный идентификатор сообщение
     */
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    private String operationUid;
    /***
     * Время создания сообщения
     */
    private String systemTime;
    /***
     * результат обработки запроса «success», «failed»
     */
    private Codes code;
    /***
     * вывод размера бонуса
     */
    private Double annualBonus;
    /***
     * вывод кода ошибки
     */
    private ErrorCodes errorCode;
    /***
     * вывод наименования ошибки
     */
    private ErrorMessages errorMessage;
}



