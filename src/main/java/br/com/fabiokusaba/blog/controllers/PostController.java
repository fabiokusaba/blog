package br.com.fabiokusaba.blog.controllers;

import br.com.fabiokusaba.blog.domain.CreatePostRequest;
import br.com.fabiokusaba.blog.domain.UpdatePostRequest;
import br.com.fabiokusaba.blog.domain.dtos.CreatePostRequestDTO;
import br.com.fabiokusaba.blog.domain.dtos.PostDTO;
import br.com.fabiokusaba.blog.domain.dtos.UpdatePostRequestDTO;
import br.com.fabiokusaba.blog.domain.entities.Post;
import br.com.fabiokusaba.blog.domain.entities.User;
import br.com.fabiokusaba.blog.mappers.PostMapper;
import br.com.fabiokusaba.blog.services.PostService;
import br.com.fabiokusaba.blog.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId) {

        List<Post> posts = postService.getAllPosts(categoryId, tagId);
        List<PostDTO> postDTOS = posts.stream().map(postMapper::toPostDTO).toList();
        return ResponseEntity.ok(postDTOS);
    }

    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostDTO>> getDrafts(@RequestAttribute UUID userId) {

        User loggedInUser = userService.getUserById(userId);
        List<Post> draftPosts = postService.getDraftPosts(loggedInUser);
        List<PostDTO> draftPostsDTO = draftPosts.stream().map(postMapper::toPostDTO).toList();
        return ResponseEntity.ok(draftPostsDTO);
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(
            @Valid @RequestBody CreatePostRequestDTO createPostRequestDTO,
            @RequestAttribute UUID userId) {

        User loggedInUser = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestDTO);
        Post createdPost = postService.createPost(loggedInUser, createPostRequest);
        PostDTO createdPostDTO = postMapper.toPostDTO(createdPost);
        return new ResponseEntity<>(createdPostDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PostDTO> updatePost(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePostRequestDTO updatePostRequestDTO) {

        UpdatePostRequest updatePostRequest = postMapper.toUpdatePostRequest(updatePostRequestDTO);
        Post updatedPost = postService.updatePost(id, updatePostRequest);
        PostDTO updatedPostDTO = postMapper.toPostDTO(updatedPost);
        return ResponseEntity.ok(updatedPostDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable UUID id) {
        Post post = postService.getPost(id);
        PostDTO postDTO = postMapper.toPostDTO(post);
        return ResponseEntity.ok(postDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
