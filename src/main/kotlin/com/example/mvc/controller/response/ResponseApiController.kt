package com.example.mvc.controller.response

import com.example.mvc.controller.get.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    @GetMapping()
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> { //@RequestParam(required = true) -> default

        // let: fun <T, R> T.let(block: (T) -> R): R
        return age?.let {
            // age not null
            if(it < 20){
                 return ResponseEntity.status(400).body("20 fail")
            }
            return ResponseEntity.ok("ok")
        }?: kotlin.run {
            // age is null
            return ResponseEntity.status(400).body("fail age")
        }

        /*
        JAVA CODE
        // 1. age == null -> 400
        if(age == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail age")
        }

        // 2. age < 20 -> 400
        if(age < 20){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("20 fail")
        }

        return ResponseEntity.ok("ok")
        */

    }

    // 2. post 200
    @PostMapping()
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {

        return ResponseEntity.status(200).body(userRequest) // object mapper 로 json 변환
    }

    // 3. put 201
    @PutMapping()
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 1. 기존 데이터가 없어서 새로 생성
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.status(500).body(null)
    }
}