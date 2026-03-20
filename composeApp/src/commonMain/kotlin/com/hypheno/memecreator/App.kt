package com.hypheno.memecreator

import androidx.compose.runtime.Composable
import com.hypheno.memecreator.core.presentation.NavigationRoot
import com.hypheno.memecreator.core.theme.MemeCreatorTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MemeCreatorTheme {
        NavigationRoot()
    }
}
