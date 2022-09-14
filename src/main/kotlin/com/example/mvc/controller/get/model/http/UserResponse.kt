package com.example.mvc.controller.get.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse (
    var result: Result?=null,
    var description: String?=null,

    @JsonProperty("user") // user 라는 property 이름으로 사용
    var userRequest: MutableList<UserRequest>?=null // 배열(list)
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Result(
    var resultCode: String?=null,
    var resultMessage: String?=null
)