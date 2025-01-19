package br.com.fabiokusaba.blog.services;

import br.com.fabiokusaba.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID id);
}
