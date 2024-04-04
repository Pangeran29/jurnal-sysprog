package org.d3if3030.jurnal_sysprog.ui.screen

import org.d3if3030.model.Journal

object MainViewModel {
    var data = mutableListOf<Journal>(
        Journal(
            "Chapter 1: Getting Started",
            """
                On Windows, go to https://www.rust-lang.org/tools/install and follow the instructions for installing Rust. At some point in the installation, you’ll receive a message explaining that you’ll also need the MSVC build tools for Visual Studio 2013 or later.
            """.trimIndent(),
            "Yes"
        ),
        Journal(
            "Chapter 2: Programming a Guessing Game",
            """
                Let’s jump into Rust by working through a hands-on project together! This chapter introduces you to a few common Rust concepts by showing you how to use them in a real program. You’ll learn about let, match, methods, associated functions, external crates, and more! In the following chapters, we’ll explore these ideas in more detail. In this chapter, you’ll just practice the fundamentals.
            """.trimIndent(),
            "Yes"
        ),
        Journal(
            "Chapter 3: Common Programming Concepts",
            """
                This chapter covers concepts that appear in almost every programming language and how they work in Rust. Many programming languages have much in common at their core. None of the concepts presented in this chapter are unique to Rust, but we’ll discuss them in the context of Rust and explain the conventions around using these concepts.
            """.trimIndent(),
            "Yes"
        )
    )
}