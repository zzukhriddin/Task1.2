package com.epam.esm.controller;

import com.epam.esm.entity.Tag;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.TagDto;
import com.epam.esm.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/api/tag")
public class TagController {

    private final TagService tagService;

    /**
     * @param id
     * @return Tag object
     */
    @SneakyThrows
    @GetMapping("/{id}")
    public Tag getById(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    /**
     * @return all Tag lists
     */
    @GetMapping
    public List<Tag> getTag() {
        return tagService.getAllTag();
    }

    /**
     * @param tagDto
     * @return
     */
    @PostMapping
    public HttpEntity<?> saveTag(@RequestBody TagDto tagDto) {
        ApiResponse apiResponse = tagService.saveTag(tagDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteTagById(@PathVariable Long id) {
        ApiResponse apiResponse = tagService.deleteTagById(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }
}
