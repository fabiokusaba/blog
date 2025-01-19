package br.com.fabiokusaba.blog.services;

import br.com.fabiokusaba.blog.domain.entities.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllPosts(UUID categoryId, UUID tagId);
}
