package com.hypheno.memecreator.editor.domain

interface SaveToStorageStrategy {
    fun getFilePath(fileName: String): String
}
