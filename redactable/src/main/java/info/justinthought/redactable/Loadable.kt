package info.justinthought.redactable

sealed class Loadable<out T> {
    data class Loading<out T>(val placeholder: T) : Loadable<T>()
    data class Loaded<out T>(val result: T) : Loadable<T>()
    data class Error<out T>(val error: Throwable) : Loadable<T>()

    companion object {
        fun <T> from(result: Result<T>): Loadable<T> {
            return try {
                Loaded(result.getOrThrow())
            } catch (error: Throwable) {
                Error(error)
            }
        }
    }
}
