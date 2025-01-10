package br.com.fabiokusaba.blog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabiokusaba.blog.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
