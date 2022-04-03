package info.justinthought.example.views.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.justinthought.example.common.row.ExampleRow
import info.justinthought.redactable.Loadable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private var _loadable = MutableStateFlow<Loadable<List<ExampleRow>>>(
        Loadable.Loading(listOf(ExampleRow.placeholder))
    )
    val loadable = _loadable.asStateFlow()

    fun loadData() = viewModelScope.launch(Dispatchers.IO) {
        _loadable.value = Loadable.Loading(listOf(ExampleRow.placeholder))
        delay(5000)
        _loadable.value = Loadable.Loaded(ExampleRow.data)
    }

}