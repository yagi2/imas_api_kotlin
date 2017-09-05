package com.yagi2.imas.service

import com.yagi2.imas.model.Character
import com.yagi2.imas.repository.CharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CharacterService {

    @Autowired
    lateinit var repository: CharacterRepository

    fun selectAll(): List<Character> = repository.findAll(Sort(Sort.Direction.ASC, "id"))

    fun findByName(name: String): List<Character> = repository.findByName(name)
    fun findByNameContains(name: String): List<Character> = repository.findByNameContainsOrderByIdAsc(name)

    fun findByCvName(cvName: String): List<Character> = repository.findByCvName(cvName)
    fun findByCvNameContains(cvName: String): List<Character> = repository.findByCvNameContainsOrderByIdAsc(cvName)

    fun findByAge(age: Int): List<Character> = repository.findByAge(age)
}