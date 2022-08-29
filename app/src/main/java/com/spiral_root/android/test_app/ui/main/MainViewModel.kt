package com.spiral_root.android.test_app.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.spiral_root.android.domain.interaction.ExampleInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val savedStateHandle: SavedStateHandle,
	private val interactor: ExampleInteractor,
	program: Application
) : AndroidViewModel(program) {

	private val _lastActionTime = MutableStateFlow<LocalDateTime?>(null)
	val lastActionTime: StateFlow<LocalDateTime?> = _lastActionTime.asStateFlow()

	fun doAction() = viewModelScope.launch {
		val result = interactor.getObject()
		_lastActionTime.emit(LocalDateTime.now())
	}
}