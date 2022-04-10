package com.example.vmediatestapp.presentation.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vmediatestapp.domain.channel.GetRemoteChannelsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(

    private val getRemoteChannelsUseCase: GetRemoteChannelsUseCase

) : ViewModel() {

    init {
        viewModelScope.launch {
            getRemoteChannelsUseCase.getRemoteChannels()
        }
    }

}