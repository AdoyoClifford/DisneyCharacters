package com.adoyo.orbitallibrarry.data.remote.mappers

import com.adoyo.orbitallibrarry.data.local.CharacterEntity
import com.adoyo.orbitallibrarry.data.remote.CharacterDto
import com.adoyo.orbitallibrarry.model.Character

fun CharacterDto.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = _id,
        name = name,
        imageUrl = imageUrl
    )
}

fun CharacterEntity.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}