package com.example.mvc.advice

import com.example.mvc.controller.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//@RestControllerAdvice // RestController 가 붙은 곳의 에러를 모두 잡음
@RestControllerAdvice(basePackageClasses =  [ExceptionApiController::class]) // ExceptionApiController 에서의 오류만 잡는다
class GlobalControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e: RuntimeException): String {
        return "server error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: RuntimeException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("index error")
    }
}