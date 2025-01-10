package br.com.fabiokusaba.blog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabiokusaba.blog.domain.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

}
