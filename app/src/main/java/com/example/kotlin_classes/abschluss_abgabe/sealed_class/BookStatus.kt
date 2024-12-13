package com.example.kotlin_classes.abschluss_abgabe.sealed_class

sealed class BookStatus {
    data class CheckedOut(val dueDate: String) : BookStatus()
    data class Reserved(val reservedBy: String) : BookStatus()
    object Available : BookStatus()

    /**
     * Returns a string representation of the current status of the book.
     *
     * @return A descriptive message indicating:
     *         - The due date if the book is checked out.
     *         - The name of the person who reserved the book if it's reserved.
     *         - Availability status if the book is available.
     */
    fun currentStatus(): String {
        return when (this) {
            is CheckedOut -> " checked out until: ${this.dueDate}.\n"
            is Reserved -> " reserved by: ${this.reservedBy}.\n"
            Available -> " available."
        }
    }

}