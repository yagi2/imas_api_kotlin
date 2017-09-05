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

    @RequestMapping(value = "/search", method = arrayOf(RequestMethod.GET))
    fun search(@RequestParam(value = "name",   required = false) name: String?,
               @RequestParam(value = "cvName", required = false) cvName: String?,
               @RequestParam(value = "age",    required =  false) age: Int?): List<Character> {

        val redundantList = mutableListOf<MutableList<Character>>()

        name?.let {
            redundantList.add(mutableListOf())
            redundantList[redundantList.size - 1].addAll(service.findByNameContains(name))
        }

        cvName?.let {
            redundantList.add(mutableListOf())
            redundantList[redundantList.size - 1].addAll(service.findByCvNameContains(cvName))
        }

        age?.let {
            redundantList.add(mutableListOf())
            redundantList[redundantList.size - 1].addAll(service.findByAge(age))
        }

        val result = mutableListOf<Character>()

        redundantList.forEach {
            it.forEach { character ->
                if (redundantList.all { it.contains(character) } && result.contains(character).not()) {
                    result.add(character)
                }
            }
        }

        return result
    }
}