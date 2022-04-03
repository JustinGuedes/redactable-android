package info.justinthought.redactable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun RedactableView(loading: Boolean = true, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalRedaction provides loading) {
        content()
    }
}