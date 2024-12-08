package com.example.maploca


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _mapEntriesState = mutableStateOf(MapDataState())
    val mapEntriesState: State<MapDataState> = _mapEntriesState

    init {
        fetchMapLocoData()
    }

    private fun fetchMapLocoData() {
        viewModelScope.launch {
            try {
                val response = mapLocaService.getMapEntriesData()
                _mapEntriesState.value = _mapEntriesState.value.copy(
                    loading = false,
                    list = response,
                    error = null
                )

            } catch (e: Exception) {
                e.printStackTrace() // Log the stack trace for debugging
                _mapEntriesState.value = _mapEntriesState.value.copy(
                    loading = false,
                    error = "Error fetching data: ${e.message}"
                )
            }
        }
    }

    data class MapDataState(
        val loading: Boolean = true,
        val list: List<MapEntries> = emptyList(),
        val error: String? = null
    )
}
