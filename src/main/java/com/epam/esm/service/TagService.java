package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.TagDto;
import com.epam.esm.repository.TagRepositoryDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    TagRepositoryDAOImpl tagRepository = new TagRepositoryDAOImpl();

    public Tag getTagById(Long id) {
        return tagRepository.getById(id);
    }
    public List<Tag> getAllTag() {
       return tagRepository.getAll();
    }
    public ApiResponse saveTag(TagDto tagDto) {
        try {
            tagRepository.save(tagDto);
            return new ApiResponse("successfully saved",true);
        }
        catch (Exception e){
            return new ApiResponse("failed",false);
        }
    }
    public ApiResponse deleteTagById(Long id) {
        try {
            tagRepository.deleteById(id);
            return new ApiResponse("successfully deleted",true);
        }
        catch (Exception e){
            return new ApiResponse("failed",false);
        }
    }
}
