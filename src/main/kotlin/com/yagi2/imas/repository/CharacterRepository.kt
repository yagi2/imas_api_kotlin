package com.yagi2.imas.repository

import com.yagi2.imas.model.Character
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository : JpaRepository<Character, Int> {
    fun findByName(name: String): List<Character>
}