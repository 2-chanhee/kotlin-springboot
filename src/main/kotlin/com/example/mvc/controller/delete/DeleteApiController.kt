package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api")
@Validated // bean validate 사용을 위해 선언
class DeleteApiController {

    // 1. request param
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value=20, message ="20보다 커야함.")
        @RequestParam(value = "age") _age: Int
    ): String {
        println(_name)
        println(_age)

        return _name + "" + _age
    }

    // 2. path variable
    // value, name은 실제 들어오는 변수명과 다를 때 사용함
    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(@PathVariable(value = "age") _age: Int, @PathVariable(name = "name") _name: String): String {
        println(_name)
        println(_age)

        return _name + "" + _age
    }
}