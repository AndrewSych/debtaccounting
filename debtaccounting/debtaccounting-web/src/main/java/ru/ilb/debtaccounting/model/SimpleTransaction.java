/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@DiscriminatorValue("1")
public class SimpleTransaction extends Transaction implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private Account debit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account credit;

    public SimpleTransaction(Account debit, Account credit) {
        this.debit = debit;
        this.credit = credit;
    }

    public SimpleTransaction() {
    }

    public Account getDebit() {
        return debit;
    }

    public void setDebit(Account debit) {
        this.debit = debit;
    }

    public SimpleTransaction withDebit(Account debit) {
        this.debit = debit;
        return this;
    }

    public Account getCredit() {
        return credit;
    }

    public void setCredit(Account credit) {
        this.credit = credit;
    }

    public SimpleTransaction withCredit(Account credit) {
        this.credit = credit;
        return this;
    }

    @Override
    public void execute() {
        if (debit != null) {
            
        }
        
    }

}