package com.example.kotlin_classes.abschluss_abgabe.data

import com.example.kotlin_classes.abschluss_abgabe.enums.Genre
import com.example.kotlin_classes.abschluss_abgabe.sealed_class.BookStatus

/**
 * Represents a book with a title, author, genre, and status.
 *
 * @param title The title of the book.
 * @param author The author of the book.
 * @param genre The genre of the book.
 * @param status The current status of the book (default is Available).
 */
data class Book(val title: String,
                val author: String,
                val genre: Genre,
                var status: BookStatus = BookStatus.Available
)