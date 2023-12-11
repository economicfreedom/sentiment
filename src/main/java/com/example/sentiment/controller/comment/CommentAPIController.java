package com.example.sentiment.controller.comment;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-comment")
@Slf4j
@RequiredArgsConstructor
public class CommentAPIController {


    @PostMapping("/create")
    public ResponseEntity<?> create() {

        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<?> update() {

        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {

        return null;
    }


}
