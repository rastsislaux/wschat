package me.leepsky.wschat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WschatApplication

fun main(args: Array<String>) {
	runApplication<WschatApplication>(*args)
}
