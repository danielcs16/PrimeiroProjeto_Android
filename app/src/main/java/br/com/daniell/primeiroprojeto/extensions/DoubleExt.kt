package br.com.daniell.primeiroprojeto.extensions

fun Double.format(digitos: Int) = String.format("%.${digitos}f", this)