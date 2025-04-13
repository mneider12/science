package com.nydev

import com.nydev.models.atom.Symbol

fun main() {
    Symbol.entries.forEach {println(it.display)}
}