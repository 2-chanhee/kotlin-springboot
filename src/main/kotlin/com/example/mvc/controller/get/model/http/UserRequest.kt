package com.example.mvc.controller.get.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class) // 해당 클래스의 프로퍼티는 snake_case로 동작한다는 것을 명시
data class UserRequest(
    var name: String?=null,
    var age: Int?=null,
    var email: String?=null,
    var address: String?=null,
    var phoneNumber: String?=null // phone_number
    
//    @JsonProperty("phone_number") // 요청 시 이 프로퍼티명으로 할것이라는 것을 명시
//    var phoneNumber: String?=null // phone_number
)

