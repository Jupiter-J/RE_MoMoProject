package com.example.momo.controller;

import com.example.momo.dto.question.QuestionDto;
import com.example.momo.dto.response.BaseResponse;
import com.example.momo.service.QuestionService;
import com.example.momo.service.QuestionServiceJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("api/v1/categories/{categoryId}/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionServiceJpa questionServiceJpa;

    @PostMapping()
    public ResponseEntity<BaseResponse<QuestionDto>> createQuestion(@PathVariable("categoryId") Long category_id,
                                                                   @RequestBody QuestionDto dto){
        QuestionDto result = this.questionServiceJpa.createQuestion(category_id, dto);
        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @GetMapping()
    public ResponseEntity<BaseResponse<Collection<QuestionDto>>> readAllQuestion(@PathVariable("categoryId")Long category_id){
       Collection<QuestionDto> questionDtoList = this.questionServiceJpa.readAllQuestion(category_id);
        if (questionDtoList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(BaseResponse.success(questionDtoList));
    }

    @GetMapping("{questionId}")
    public ResponseEntity<BaseResponse<QuestionDto>> readQuestion(@PathVariable("categoryId")Long category_id,
                                                    @PathVariable("questionId")Long questionId){
        QuestionDto questionDto = this.questionServiceJpa.readQuestion(category_id, questionId);
        if (questionDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(BaseResponse.success(questionDto));
    }

    @PutMapping("{questionId}")
    public ResponseEntity<BaseResponse<?>> updateQuestion(@PathVariable("categoryId") Long category_id,
                                            @PathVariable("questionId") Long questionId,
                                            @RequestBody QuestionDto dto){

        if (!questionServiceJpa.updateQuestion(category_id, questionId, dto))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{questionId}")
    public ResponseEntity<BaseResponse<?>> deleteQuestion(@PathVariable("categoryId") Long category_id,
                                            @PathVariable("questionId") Long questionId){

        if (!questionServiceJpa.deleteQuestion(category_id, questionId))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }



}
