package com.yagi2.imas.controller

import com.yagi2.imas.model.Character
import com.yagi2.imas.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/character")
class CharacterController {
    @Autowired
    lateinit var service: CharacterService

    @RequestMapping(value = "/all", method = arrayOf(RequestMethod.GET))
    fun selectAll(): List<Character> = service.selectAll()

    @RequestMapping(value = "/name", method = arrayOf(RequestMethod.GET))
    fun findByName(@RequestParam("name") name: String): List<Character> = service.findByName(name)
}