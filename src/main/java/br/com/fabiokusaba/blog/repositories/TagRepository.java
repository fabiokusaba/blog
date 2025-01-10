package br.com.fabiokusaba.blog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabiokusaba.blog.domain.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

}
