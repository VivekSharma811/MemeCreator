package com.hypheno.memecreator.di

import com.hypheno.memecreator.editor.data.CacheStorageStrategy
import com.hypheno.memecreator.editor.data.PlatformMemeExporter
import com.hypheno.memecreator.editor.domain.MemeExporter
import com.hypheno.memecreator.editor.domain.SaveToStorageStrategy
import com.hypheno.memecreator.editor.presentation.util.PlatformShareSheet
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformAppModule = module {
    factoryOf(::PlatformMemeExporter) bind MemeExporter::class
    factoryOf(::CacheStorageStrategy) bind SaveToStorageStrategy::class
    factoryOf(::PlatformShareSheet)
}
