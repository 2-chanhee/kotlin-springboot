package com.example.mvc.controller.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exception")
class ExceptionApiController {

    @GetMapping("/hello")
    fun hello(){
        val arr = mutableListOf<String>()
        val asdf = arr[0]
    }

    // class 내부 발생 시 에러 잡음
    @ExceptionHandler(value =[IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: RuntimeException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("index error")
    }
}