package com.hypheno.memecreator.editor.data

import androidx.compose.ui.unit.IntSize
import com.hypheno.memecreator.editor.domain.MemeExporter
import com.hypheno.memecreator.editor.domain.SaveToStorageStrategy
import com.hypheno.memecreator.editor.presentation.MemeText

expect class PlatformMemeExporter: MemeExporter {
    override suspend fun exportMeme(
        backgroundImageBytes: ByteArray,
        memeTexts: List<MemeText>,
        templateSize: IntSize,
        saveToStorageStrategy: SaveToStorageStrategy,
        fileName: String
    ): Result<String>
}
