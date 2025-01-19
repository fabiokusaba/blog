package br.com.fabiokusaba.blog.domain.dtos;

import br.com.fabiokusaba.blog.domain.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {

    private UUID id;
    private String title;
    private String content;
    private AuthorDTO author;
    private CategoryDTO category;
    private Set<TagDTO> tags;
    private Integer readingTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PostStatus status;
}
