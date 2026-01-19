package com.nydev

import com.nydev.models.molecule.formula.Formula

fun main() {
    println("Welcome to the Science Console App")
    
    while (true) {
        println("\nMenu:")
        println("1. Parse Formula")
        println("2. Exit")
        print("Select an option: ")
        
        val input = readlnOrNull() ?: break
        when (input) {
            "1" -> parseFormula()
            "2" -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid option, please try again.")
        }
    }
}

fun parseFormula() {
    print("Enter a chemical formula: ")
    val input = readlnOrNull() ?: return
    
    try {
        val formula = Formula.create(input)
        println("Parsed Formula: $input")
        println("Fragments:")
        formula.fragments.forEach { fragment ->
            println("- $fragment")
        }
    } catch (e: Exception) {
        println("Error parsing formula: ${e.message}")
    }
}