package com.yagi2.imas.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class IndexController {

    @RequestMapping(value = "", method = arrayOf(RequestMethod.GET))
    fun index(): String = "Hello, imas API!"
}