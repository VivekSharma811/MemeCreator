package com.hypheno.memecreator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform