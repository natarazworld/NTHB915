package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import lombok.Data;

@Data
@Entity
@Table(name="INH_PAYMENT_TPSC_DISC")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PAYMENT_MODE",length = 20,
                                    discriminatorType = DiscriminatorType.STRING)
@Polymorphism(type = PolymorphismType.EXPLICIT)
public abstract class Payment {
	@Id
	@GeneratedValue
	private Integer pid;
	private Double amount;
	@CreationTimestamp
	private LocalDateTime pdate;

}
