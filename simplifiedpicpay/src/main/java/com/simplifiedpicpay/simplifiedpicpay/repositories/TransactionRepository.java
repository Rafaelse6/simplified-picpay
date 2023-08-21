package com.simplifiedpicpay.simplifiedpicpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplifiedpicpay.simplifiedpicpay.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
