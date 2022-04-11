package com.example.vmediatestapp.presentation.main_fragment

import androidx.lifecycle.*
import com.example.vmediatestapp.data.mapper.MapChannelAndProgramItem
import com.example.vmediatestapp.domain.ChannelAndProgram
import com.example.vmediatestapp.domain.channel.GetRemoteChannelsUseCase
import com.example.vmediatestapp.domain.programm.GetRemoteProgramItemsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getRemoteChannelsUseCase: GetRemoteChannelsUseCase,
    private val getRemoteProgramItemsUseCase: GetRemoteProgramItemsUseCase,
    private val mapper: MapChannelAndProgramItem
) : ViewModel() {

    private val _channel = MutableLiveData<List<ChannelAndProgram>>()
    val channel: LiveData<List<ChannelAndProgram>> = _channel

    init {
        viewModelScope.launch {

            val list = mapper.mapToChannelAndProgramItems(
                getRemoteChannelsUseCase.getRemoteChannels(),
                getRemoteProgramItemsUseCase.getRemoteProgramItems()
            )
            _channel.value = list
        }
    }

}