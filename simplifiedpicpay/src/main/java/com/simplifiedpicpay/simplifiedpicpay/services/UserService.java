package com.simplifiedpicpay.simplifiedpicpay.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplifiedpicpay.simplifiedpicpay.domain.user.User;
import com.simplifiedpicpay.simplifiedpicpay.domain.user.UserType;
import com.simplifiedpicpay.simplifiedpicpay.dtos.UserDTO;
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

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public User saveUser(User user) {
        return this.repository.save(user);
    }
}