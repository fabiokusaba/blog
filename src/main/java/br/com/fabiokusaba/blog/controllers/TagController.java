package br.com.fabiokusaba.blog.controllers;

import br.com.fabiokusaba.blog.domain.dtos.CreateTagsRequest;
import br.com.fabiokusaba.blog.domain.dtos.TagDTO;
import br.com.fabiokusaba.blog.domain.entities.Tag;
import br.com.fabiokusaba.blog.mappers.TagMapper;
import br.com.fabiokusaba.blog.services.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagDTO>> getAllTags() {
        List<Tag> tags = tagService.getTags();
        List<TagDTO> tagsResponses = tags.stream().map(tagMapper::toTagResponse).toList();
        return ResponseEntity.ok(tagsResponses);
    }

    @PostMapping
    public ResponseEntity<List<TagDTO>> createTags(@Valid @RequestBody CreateTagsRequest createTagsRequest) {
        List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());
        List<TagDTO> createdTagRespons = savedTags.stream().map(tagMapper::toTagResponse).toList();
        return new ResponseEntity<>(
                createdTagRespons,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
