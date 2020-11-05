package com.finzly.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finzly.loan.model.PaymentSchedule;


/**
 * @author USER
 *
 *DAO for Payment Schedule entity entity
 */
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule,Integer>{

}