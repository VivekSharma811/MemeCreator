package com.hypheno.memecreator.editor.data

import com.hypheno.memecreator.editor.domain.SaveToStorageStrategy

expect class CacheStorageStrategy: SaveToStorageStrategy {
    override fun getFilePath(fileName: String): String
}
