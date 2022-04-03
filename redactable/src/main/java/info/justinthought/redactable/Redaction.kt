package info.justinthought.redactable

import androidx.compose.runtime.compositionLocalOf

enum class Redaction {
    PLACEHOLDER,
    FORCE,
    HIDDEN
}

val LocalRedaction = compositionLocalOf { false }