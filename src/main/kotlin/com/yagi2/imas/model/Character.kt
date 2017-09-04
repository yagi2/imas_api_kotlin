package com.yagi2.imas.model

import javax.persistence.*

@Entity
@Table(name="character")
data class Character(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name="name")
        val name: String,

        @Column(name="phonetic")
        val phonetic: String,

        @Column(name="age")
        val age: Int,

        @Column(name="cv_name")
        val cvName: String,

        @Column(name="cv_phonetic")
        val cvPhonetic: String
)