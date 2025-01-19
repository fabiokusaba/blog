package br.com.fabiokusaba.blog.services;

import br.com.fabiokusaba.blog.domain.entities.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getTags();
}
