package com.example.kotlin_classes.abschluss_abgabe

import com.example.kotlin_classes.abschluss_abgabe.data.Book
import com.example.kotlin_classes.abschluss_abgabe.enums.Genre
import com.example.kotlin_classes.abschluss_abgabe.nested_inner.Library

/**
 * Main function that simulates the functionality of a library system.
 * It adds books to the library, performs operations like checking out and reserving books,
 * and searches for books by title and author.
 *
 * Steps performed:
 * 1. Creates a Library instance and adds books (one from each genre, with two books by Grimm Brothers).
 * 2. Prints the genre descriptions of each book.
 * 3. Creates a LibraryAddress and prints it.
 * 4. Creates a LibraryMember and:
 *    - Checks out a book.
 *    - Reserves another book.
 * 5. Displays the current status of all books in the library.
 * 6. Searches for a book by its title and displays the result.
 * 7. Searches for books by a specific author ('Grimm Brothers') and lists the results.
 */
fun main() {
    val library = Library(mutableListOf())

    val book1 = Book("Grimm's Fairy Tales", "Grimm Brothers", Genre.FICTION)
    val book2 = Book("Learning Kotlin", "Jane Smith", Genre.NON_FICTION)
    val book3 = Book("Astrophysics 101", "Neil deGrasse Tyson", Genre.SCIENCE)
    val book4 = Book("World History", "Historian X", Genre.HISTORY)
    val book5 = Book("Fairy Tales", "Grimm Brothers", Genre.CHILDREN)

    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)
    library.addBook(book4)
    library.addBook(book5)

    println("Genres description of the books:")
    book1.genre.printDescription()
    book2.genre.printDescription()
    book3.genre.printDescription()
    book4.genre.printDescription()
    book5.genre.printDescription()

    val libraryAddress = Library.LibraryAddress("Berliner Pl. 12", "Heilbronn", "74072")
    println("\nLibrary Address:")
    println(libraryAddress.printAddress())

    val member = library.LibraryMember("Enrique", "M1337")

    println("\nCurrent status of all books:")
    library.currentStateOfAllBooks()

    println("\nMember 'Enrique' checks out a book:")
    member.checkoutBook(book1, "31.12.2024")

    println("\nMember 'Enrique' reserves a book:")
    member.reserveBook(book2)

    println("\nCurrent status of all books:")
    library.currentStateOfAllBooks()

    println("\nSearching for a book titled 'Astrophysics 101':")
    val searchResult = library.searchForTitle("Astrophysics 101")
    println(searchResult?.let { "Found: ${it.title} by ${it.author}" } ?: "Not found.")

    println("\nSearching for books by the author 'Grimm Brothers':")
    val booksByAuthor = library.searchForAuthor("Grimm Brothers")
    if (booksByAuthor.isNotEmpty()) {
        booksByAuthor.forEach { println("Found: ${it.title} by ${it.author}") }
    } else {
        println("No books found.")
    }
}