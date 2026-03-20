package com.hypheno.memecreator.editor.data

import android.content.Context
import com.hypheno.memecreator.editor.domain.SaveToStorageStrategy
import java.io.File

actual class CacheStorageStrategy(
    private val context: Context
) : SaveToStorageStrategy {

    actual override fun getFilePath(fileName: String): String {
        return File(context.cacheDir, fileName).absolutePath
    }
}
