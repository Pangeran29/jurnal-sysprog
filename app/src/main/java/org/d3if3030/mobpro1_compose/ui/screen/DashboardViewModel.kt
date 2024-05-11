package org.d3if3030.mobpro1_compose.ui.screen

import org.d3if3030.mobpro1_compose.R
import org.d3if3030.model.Track

object DashboardViewModel {
    val learningPath = listOf(
        Track(
            topic = "Understanding Basics",
            book = "The Rust Programming Language",
            description = "Start with the official Rust book, which covers all the basics of the language. It introduces concepts like ownership, borrowing, lifetimes, and more.",
            imageResId = R.drawable.the_rust_programming_language
        ),
        Track(
            topic = "Exploring Low-Level Concepts",
            book = "Programming Rust: Fast, Safe Systems Development",
            description = "This book delves deeper into low-level concepts while also providing practical examples. It covers topics like concurrency, FFI (Foreign Function Interface), unsafe Rust, and working with system programming.",
            imageResId = R.drawable.programming_rust
        ),
        Track(
            topic = "System Programming and Operating Systems",
            book = "Operating Systems: Three Easy Pieces",
            description = "While not a Rust-specific book, it provides an excellent foundation for understanding operating systems concepts. You can start implementing some basic OS components in Rust based on the knowledge gained from this book.",
            imageResId = R.drawable.os_three_easy_pieces
        ),
        Track(
            topic = "Advanced Topics",
            book = "Rust Programming By Example",
            description = "This book provides advanced examples and projects to deepen your understanding of Rust. It covers topics like async programming, network programming, creating CLI tools, and more.",
            imageResId = R.drawable.rust_programming_by_example
        ),
        Track(
            topic = "Contributing to Rust Ecosystem",
            book = "The Rustonomicon: The Dark Arts of Advanced and Unsafe Rust Programming",
            description = "This book explores the unsafe aspects of Rust and how to use them properly. Understanding this aspect is crucial if you plan to contribute to or work with low-level Rust libraries and projects.",
            imageResId = R.drawable.rusto
        )
    )

    fun getAll(): List<Track> {
        return learningPath
    }

    fun getByBook(book: String) : Track {
        for (i in learningPath) {
            if (i.book == book) {
                return i
            }
        }
        return learningPath.get(0)
    }
}