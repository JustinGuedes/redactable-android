package info.justinthought.redactable

import androidx.compose.runtime.Composable

@Composable
fun <T> LoadableView(
    loadable: Loadable<T>,
    loading: @Composable () -> Unit,
    loaded: @Composable (T) -> Unit,
    error: @Composable (Throwable) -> Unit
) {
    when (loadable) {
        is Loadable.Loading -> loading()
        is Loadable.Loaded -> loaded(loadable.result)
        is Loadable.Error -> error(loadable.error)
    }
}

@Composable
fun <T> LoadableView(
    loadable: Loadable<T>,
    loaded: @Composable (T) -> Unit,
    error: @Composable (Throwable) -> Unit
) {
    when (loadable) {
        is Loadable.Loading -> RedactableView { loaded(loadable.placeholder) }
        is Loadable.Loaded -> loaded(loadable.result)
        is Loadable.Error -> error(loadable.error)
    }
}

@Composable
fun <T> LoadableView(
    loadable: Loadable<T>,
    loading: @Composable () -> Unit,
    loaded: @Composable (T) -> Unit
) {
    when (loadable) {
        is Loadable.Loading -> loading()
        is Loadable.Loaded -> loaded(loadable.result)
        is Loadable.Error -> {}
    }
}

@Composable
fun <T> LoadableView(
    loadable: Loadable<T>,
    loaded: @Composable (T) -> Unit
) {
    when (loadable) {
        is Loadable.Loading -> RedactableView { loaded(loadable.placeholder) }
        is Loadable.Loaded -> loaded(loadable.result)
        is Loadable.Error -> {}
    }
}