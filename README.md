# Redactable

A convenient library to show a shimmer effect while loading data. Easily convert your current view with a slick skeleton loading animation just by wrapping your view.

![Redactable Example](/example.gif)

## Installation

### Gradle

Using [JitPack](https://jitpack.io), you'll need to add to your `repositories`:

```gradle
maven { url 'https://jitpack.io' }
```

Then add the dependency:

```gradle
implementation 'com.github.JustinGuedes:redactable-android:0.1.0'
```

## Usage

Firstly, ensure your data class has a way to return a placeholder version of the class, i.e. dummy data so the library can show a redacted version of the view:

```kotlin
data class Object(...) {
  ...
  companion object {
    val placeholder: Object
      get() = Object(...) // Dummy data
  }
  ...
}
```
<br>

Secondly, create a loadable property which allows you to control the state of the loading view:

```kotlin
private var _loadable = MutableStateFlow<Loadable<Object>>(Object.placeholder)
val loadable = _loadable.asStateFlow()
```
> **_NOTE:_** The possible values for `loadable` are: `Loading(Object), Loaded(Object), error(Error)`.
<br>

Lastly, wrap your composable in a `LoadableView`:

```kotlin
val loadable = viewModel.loadable.collectAsState()

LoadableView(loadable.value) { data ->
  // Use data
}
```

## License

Redactable is released under the MIT license. [See LICENSE](https://github.com/JustinGuedes/redactable-android/blob/main/LICENSE) for details.
