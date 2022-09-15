package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. request param
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
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