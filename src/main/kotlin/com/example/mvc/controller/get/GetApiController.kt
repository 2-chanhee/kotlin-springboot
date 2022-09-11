package com.example.mvc.controller.get

import com.example.mvc.controller.get.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// 해당 컨트롤러는 REST API로 동작
// request type이 object인 경우 자동으로 json으로 return
@RestController
@RequestMapping("/api") // 경로
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String{
        return "hello kotlin"
    }

    // HTTP Method와 상관없이 사용가능한 RequestMapping 어노테이션
    @RequestMapping(method = [RequestMethod.GET], path = ["request-mapping"])
    fun requestMapping(): String { // ALT + ENTER 자동완성
        return "request-mapping"
    }

    // path parameter
    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        return "$name $age"
    }

    // path parameter2
    // path parameter 이름과 함수 내부 PathVariable랑 같아야 함, value 속성으로 해결
    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable age: Int): String {
        val name = "chan" // 이미 path 파라미터 변수명과 같은 변수가 함수 내부에 있는 경우
        
        return "$name $_name $age"
    }
    
    // query parameter
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String, // query parameter 어노테이션
        @RequestParam(value = "age") age: Int
    ): String {
        return "$name $age"
    }

    // query parameter 2
    // object 받기
    @GetMapping("/get-mapping/query-param/object")
    fun queryParam2(
        userRequest: UserRequest
    ): UserRequest {
        return userRequest
    }

    // query parameter 3
    // map 받기
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        return map
    }
}