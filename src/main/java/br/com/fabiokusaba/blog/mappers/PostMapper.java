package br.com.fabiokusaba.blog.mappers;

import br.com.fabiokusaba.blog.domain.CreatePostRequest;
import br.com.fabiokusaba.blog.domain.UpdatePostRequest;
import br.com.fabiokusaba.blog.domain.dtos.CreatePostRequestDTO;
import br.com.fabiokusaba.blog.domain.dtos.PostDTO;
import br.com.fabiokusaba.blog.domain.dtos.UpdatePostRequestDTO;
import br.com.fabiokusaba.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDTO toPostDTO(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDTO dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDTO dto);
}
