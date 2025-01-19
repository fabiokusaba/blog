package br.com.fabiokusaba.blog.repositories;

import java.util.List;
import java.util.UUID;

import br.com.fabiokusaba.blog.domain.entities.Category;
import br.com.fabiokusaba.blog.domain.entities.Tag;
import br.com.fabiokusaba.blog.domain.entities.User;
import br.com.fabiokusaba.blog.domain.enums.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabiokusaba.blog.domain.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);
    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);
    List<Post> findAllByStatusAndTagsContaining(PostStatus status, Tag tag);
    List<Post> findAllByStatus(PostStatus status);
    List<Post> findAllByAuthorAndStatus(User author, PostStatus status);
}
