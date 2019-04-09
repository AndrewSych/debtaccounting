/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
public abstract class Transaction implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @OneToMany(mappedBy = "transaction")
    @XmlTransient
    private List<SemiTransaction> semiTransactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction withId(Long id) {
        this.id = id;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Transaction withEvent(Event event) {
        this.event = event;
        return this;
    }

    public List<SemiTransaction> getSemiTransactions() {
        if (semiTransactions == null) {
            semiTransactions = new ArrayList<>();
        }
        return semiTransactions;
    }

    public void setSemiTransactions(List<SemiTransaction> semiTransactions) {
        this.semiTransactions = semiTransactions;
    }

    public Transaction withSemiTransactions(List<SemiTransaction> semiTransactions) {
        this.semiTransactions = semiTransactions;
        return this;
    }

    public void addSemiTransaction(SemiTransaction semiTransaction) {
        getSemiTransactions().add(semiTransaction);
        semiTransaction.setTransaction(this);
    }

    public void removeSemiTransaction(SemiTransaction semiTransaction) {
        getSemiTransactions().remove(semiTransaction);
        semiTransaction.setTransaction(null);
    }

}