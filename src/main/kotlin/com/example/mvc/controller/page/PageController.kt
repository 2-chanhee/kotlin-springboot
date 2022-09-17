package com.example.mvc.controller.page

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller // 특정한 html 페이지를 내릴 때 사용하는 어노테이션
// static 하위에 있는 페이지를 찾음
class PageController {

    @GetMapping("/main")
    fun main(): String{
        println("init main")
        return "main.html"

    }

    @ResponseBody() // Controller 어노테이션이 붙은 class에서 object와같은 response를 내려줄때 사용
    @GetMapping("/test")
    fun response(): String {
        return "main.html"
    }
}