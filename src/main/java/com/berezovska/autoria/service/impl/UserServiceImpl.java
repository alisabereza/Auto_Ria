package com.berezovska.autoria.service.impl;

import com.berezovska.autoria.controller.exception.UserAlreadyExistsException;
import com.berezovska.autoria.controller.exception.UserNotExistsException;
import com.berezovska.autoria.model.User;
import com.berezovska.autoria.model.UserRole;
import com.berezovska.autoria.model.UserStatus;
import com.berezovska.autoria.repository.UserRepository;
import com.berezovska.autoria.service.UserService;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public @Data
class UserServiceImpl implements UserService {
    private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAll() {
        LOG.debug("getAllUsers: ");
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        LOG.debug("getUser: id=" + id);
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotExistsException(String.format("User with id = %s not found", id)));
    }

    @Override
    public void save(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("There is an account with that email address: " + user.getEmail());
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.ROLE_CUSTOMER);
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }

    @Override
    public void saveAll(List<User> entities) {

    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User getByEmail(String email) {
        LOG.debug(String.format("getUser: email=%s", email));
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotExistsException("User not found by specified email"));
    }

    @Override
    public void setPassword(User user, String password) {
        String passwordHash = bCryptPasswordEncoder.encode(password);
        user.setPassword(passwordHash);
    }

}
