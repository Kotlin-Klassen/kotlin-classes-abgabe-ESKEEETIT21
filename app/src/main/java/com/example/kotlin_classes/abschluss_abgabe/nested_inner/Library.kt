package com.example.kotlin_classes.abschluss_abgabe.nested_inner

import com.example.kotlin_classes.abschluss_abgabe.data.Book
import com.example.kotlin_classes.abschluss_abgabe.sealed_class.BookStatus

class Library(
    private val bookList: MutableList<Book> = mutableListOf()
) {
    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun printAddress() = "Street: $street, City: $city, Zip-Code: $zipCode"
    }

    inner class LibraryMember(val name: String, val memberID: String) {
        /**
         * Checks out a book if available.
         * @return `true` on success, `false` otherwise.
         */
        fun checkoutBook(book: Book, dueDate: String): Boolean {
            return if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("The book '${book.title}' was successfully checked out by $name (Member ID: $memberID). Due date: $dueDate.")
                true
            } else {
                println("The book '${book.title}' cannot be checked out. Current status: $book.status.")
                false
            }
        }

        /**
         * Reserves a book if it is available.
         *
         * @param book The book to be reserved.
         * @return True if the book was successfully reserved, false otherwise.
         */
        fun reserveBook(book: Book): Boolean {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("The book '${book.title}' was successfully reserved by $name (Member ID: $memberID).")
                return true
            } else {
                println("The book '${book.title}' cannot be reserved. Current status: $book.status.")
                return false
            }
        }
    }

    /**
     * Adds a book to the book list.
     *
     * @param book The book to be added.
     */
    fun addBook(book: Book) {
        bookList.add(book)
    }

    /**
     * Searches for a book by its title.
     *
     * @param title The title of the book to search for.
     * @return The book if found, null otherwise.
     */
    fun searchForTitle(title: String): Book? {
        for (book in bookList) {
            if (book.title == title) {
                return book
            }
        }
        return null
        /* Alternative
        return bookList.find {it.title == title}
         */
    }

    /**
     * Searches for books by a specific author.
     *
     * @param author The author of the books to search for.
     * @return A list of books by the specified author.
     */
    fun searchForAuthor(author: String): List<Book> {
        val authorBookList = mutableListOf<Book>()
        for (book in bookList) {
            if (book.author == author) {
                authorBookList.add(book)
            }
        }
        return authorBookList
        /* Alternative
        return bookList.filter { it.author == author }
         */
    }

    /**
     * Prints the current status of all books in the list.
     */
    fun currentStateOfAllBooks() {
        for (book in bookList) {
            val statusMessage = book.status.currentStatus().trim()
            println("${book.title} by ${book.author} is $statusMessage")
        }
    }
}
