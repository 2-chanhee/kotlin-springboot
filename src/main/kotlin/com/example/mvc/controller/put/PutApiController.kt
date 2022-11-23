package com.example.mvc.controller.put

import com.example.mvc.controller.get.model.http.Result
import com.example.mvc.controller.get.model.http.UserRequest
import com.example.mvc.controller.get.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @PutMapping(path=["/put-mapping/object"])
    // Valid : 해당 func에만 적용한다.
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {
        // apply: 함수를 호출하는 객체를 이어지는 블록의 리시버 로 전달하고, 객체 자체를 반환합니다.

        // 특정 필드(프로퍼티)의 메세지를 받을 수 있다.
        val msg = StringBuilder()
        if(bindingResult.hasErrors()){
            // 500 error
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage

                msg.append("${field.field} : $message\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }
        return ResponseEntity.ok("ok")

//        // 1. Response
//        return UserResponse().apply {
//            // 2. result
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "성공"
//            }
//        }.apply {
//            // 3. description
//            this.description = "~~~"
//        }.apply {
//            val userList = mutableListOf<UserRequest>()
//
//            userList.add(userRequest)
//            userList.add(UserRequest().apply {
//                this.name = "a"
//                this.age = 10
//                this.email ="a@asdf.com"
//                this.address = "zz"
//                this.phoneNumber = "010-123-123"
//            })
//            userList.add(UserRequest().apply {
//                this.name = "n"
//                this.age = 101
//                this.email ="a@asdf.cdom"
//                this.address = "zzz"
//                this.phoneNumber = "0110-123-123"
//            })
//
//            // 4. user mutable list
//            this.userRequest = userList
//        }
    }
}