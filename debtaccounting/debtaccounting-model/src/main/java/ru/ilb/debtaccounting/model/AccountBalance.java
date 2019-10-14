/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class AccountBalance implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Дата остатка
     */
    @Basic
    private LocalDate date;

    /**
     * Остаток
     */
    @Basic
    @Column(scale = 2, precision = 15)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountBalance withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get дата остатка
     *
     * @return {@link #date}
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set дата остатка
     *
     * @param date {@link #date}
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Set дата остатка
     *
     * @param date {@link #date}
     * @return {@link #AccountBalance}
     */
    public AccountBalance withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * Get остаток
     *
     * @return {@link #balance}
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Set остаток
     *
     * @param balance {@link #balance}
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Set остаток
     *
     * @param balance {@link #balance}
     * @return {@link #AccountBalance}
     */
    public AccountBalance withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountBalance withAccount(Account account) {
        this.account = account;
        return this;
    }

}