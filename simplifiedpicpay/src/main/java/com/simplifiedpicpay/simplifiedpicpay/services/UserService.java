package com.simplifiedpicpay.simplifiedpicpay.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplifiedpicpay.simplifiedpicpay.domain.user.User;
import com.simplifiedpicpay.simplifiedpicpay.domain.user.UserType;
import com.simplifiedpicpay.simplifiedpicpay.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo lojista não está atutorizado a realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserBYId(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User saveUser(User user) {
        return this.repository.save(user);
    }
}