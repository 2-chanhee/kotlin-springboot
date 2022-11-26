package com.example.mvc.controller.get.model.http

import com.example.mvc.annotation.StringFormatDateTime
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.Size

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class) // 해당 클래스의 프로퍼티는 snake_case로 동작한다는 것을 명시
data class UserRequest(
    // field: 각 프로퍼티에만 적용하고 싶을 때 사용
    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String?=null,

    @field:PositiveOrZero // 0 <= age 검증
    var age: Int?=null,

    @field:Email // 이메일
    var email: String?=null,

    @field:NotBlank // 공백
    var address: String?=null,

    @field:Pattern(regexp = "") // 정규식
    var phoneNumber: String?=null, // phone_number

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴 틀림")
    var createdAt: String?=null // yyyy-mm-dd hh:mm:ss
    
//    @JsonProperty("phone_number") // 요청 시 이 프로퍼티명으로 할것이라는 것을 명시
//    var phoneNumber: String?=null // phone_number
){
}

