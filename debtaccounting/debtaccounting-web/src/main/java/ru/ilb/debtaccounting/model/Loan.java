/**
 * This file was generated by the JPA Modeler
 */
package ru.ilb.debtaccounting.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

/**
 * @author slavb
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@DiscriminatorValue("1")
public class Loan extends Debt implements Serializable {

}