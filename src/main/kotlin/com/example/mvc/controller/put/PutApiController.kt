package com.example.mvc.controller.put

import com.example.mvc.controller.get.model.http.Result
import com.example.mvc.controller.get.model.http.UserRequest
import com.example.mvc.controller.get.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

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
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        // apply: 함수를 호출하는 객체를 이어지는 블록의 리시버 로 전달하고, 객체 자체를 반환합니다.

        // 1. Response
        return UserResponse().apply {
            // 2. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 3. description
            this.description = "~~~"
        }.apply {
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email ="a@asdf.com"
                this.address = "zz"
                this.phoneNumber = "010-123-123"
            })
            userList.add(UserRequest().apply {
                this.name = "n"
                this.age = 101
                this.email ="a@asdf.cdom"
                this.address = "zzz"
                this.phoneNumber = "0110-123-123"
            })

            // 4. user mutable list
            this.userRequest = userList
        }
    }
}