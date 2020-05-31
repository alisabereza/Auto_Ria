package com.berezovska.autoria.service;

import com.berezovska.autoria.model.User;

public interface UserService extends BaseService<User> {

    User getByEmail(String email);
    void setPassword(User user, String password);
}
