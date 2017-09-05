package com.yagi2.imas.repository

import com.yagi2.imas.model.Character
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository : JpaRepository<Character, Int> {
    fun findByName(name: String): List<Character>
    fun findByNameContainsOrderByIdAsc(name: String): List<Character>

    fun findByCvName(cvName: String): List<Character>
    fun findByCvNameContainsOrderByIdAsc(name: String): List<Character>

    fun findByAge(age: Int): List<Character>
}