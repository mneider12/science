package com.nydev

import com.nydev.models.molecule.formula.Formula
import com.nydev.models.molecule.Molecule
import com.nydev.calculations.MolecularWeight

fun main() {
    println("Welcome to the Science Console App")
    
    while (true) {
        println("\nMenu:")
        println("1. Parse Formula")
        println("2. Calculate Molecular Weight")
        println("3. Exit")
        print("Select an option: ")
        
        val input = readlnOrNull() ?: break
        when (input) {
            "1" -> parseFormula()
            "2" -> calculateMolecularWeight()
            "3" -> {
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

fun calculateMolecularWeight() {
    print("Enter a chemical formula: ")
    val input = readlnOrNull() ?: return

    val formula = Formula.create(input)
    val molecule = Molecule(formula)
    val calculator = MolecularWeight()
    val weight = calculator.calculate(molecule)

    println("Molecular Weight of $input: $weight")
}