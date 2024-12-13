package com.example.kotlin_classes.abschluss_abgabe.enums

enum class Genre (val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Informative and factual content"),
    SCIENCE("Scientific texts and resources"),
    HISTORY("Historical accounts and literature"),
    CHILDREN("Books and stories for children");

    /**
     * Prints the description of the genre.
     */
    fun printDescription() {
        println(description)
    }
}