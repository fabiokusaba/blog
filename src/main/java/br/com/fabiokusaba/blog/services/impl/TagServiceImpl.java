package br.com.fabiokusaba.blog.services.impl;

import br.com.fabiokusaba.blog.domain.entities.Tag;
import br.com.fabiokusaba.blog.repositories.TagRepository;
import br.com.fabiokusaba.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }
}
