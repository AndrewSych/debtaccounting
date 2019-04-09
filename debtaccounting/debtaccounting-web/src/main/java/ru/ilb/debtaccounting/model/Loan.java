/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;
import ru.ilb.debtaccounting.exceptions.AlreadyDisbursedException;
import ru.ilb.debtaccounting.repositories.DebtStatusRepository;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@DiscriminatorValue("1")
public class Loan extends Debt implements Serializable {

    @Override
    public void disburse() {
        beforeDisburse();
        processDisburse();
        afterDisburse();
    }

    /**
     * Перед выдачей
     */
    protected void beforeDisburse() {
        if (getDebtStatus().getDisbursed()) {
            throw new AlreadyDisbursedException();
        }
    }

    /**
     * Выдача
     */
    protected void processDisburse() {
        createAccounts();
        executeEvents();
    }

    /**
     * Создат счета
     * 1. Создать счет основного долга
     */
    protected void createAccounts() {
        DebtBalance debtBalance = new DebtBalance();
        addDebtAccount(debtBalance);
        Account account = new Account();
        account.addDebtAccount(debtBalance);
    }

    /**
     * Исполнить события
     */
    protected void executeEvents() {
        DisbursementEvent disbursementEvent = new DisbursementEvent();
        addEvent(disbursementEvent);
        disbursementEvent.execute();
    }

    /**
     * После выдачи
     * 1. Установить статус Выдан
     */
    protected void afterDisburse() {
        setDebtStatus(DebtStatusRepository.DISBURSED);
    }

}