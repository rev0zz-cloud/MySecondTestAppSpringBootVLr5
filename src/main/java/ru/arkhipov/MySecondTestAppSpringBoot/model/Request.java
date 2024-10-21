package ru.arkhipov.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Request {
    @Override
    public String toString(){
        return "{" +
                "uid=`" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName" + systemName + '\'' +
                ", systemTime" + systemTime + '\'' +
                ", source=`" + source + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", workDays='" + workDays + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                ", isManager=" + isManager +  // Выводим значение isManager
                "}";
    }

    /***
     * Уникальный идентификатор сообщения
     */
    @NotBlank
    @Size(max = 32)
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    @NotBlank
    @Size(max = 32)
    private String operationUid;
    /***
     * Имя системы отправителя
     */
    private Systems systemName;
    /***
     * Должность
     */
    private Positions position;
    /***
     * Время создания сообщения
     */
    @NotBlank
    private String systemTime;
    /***
     * Поле для хранения метки времени (для логов)
     */
    private long requestTime;
    /***
     * Наименование ресурса
     */
    private String source;
    /***
     * Уникальный идентификатор коммуникации
     */
    @Min(1)
    @Max(100000)
    private Integer communicationId;
    /***
     * Уникальный идентификатор шаблона
     */
    private Integer templateId;
    /***
     * Код продукта
     */
    private Integer productCode;
    /***
     * Смс код
     */
    private Integer smsCode;
    /***
     * Заработная плата
     */
    private Double salary;
    /***
     * Коэффициент бонуса
     */
    private Double bonus;
    /***
     * Количество рабочих дней
     */
    private Integer workDays;
    /***
     * Руководитель?
     */
    private Boolean isManager;
}