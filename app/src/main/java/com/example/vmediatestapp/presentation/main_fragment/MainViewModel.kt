package com.example.vmediatestapp.presentation.main_fragment

import androidx.lifecycle.*
import com.example.vmediatestapp.domain.model.ChannelAndProgram
import com.example.vmediatestapp.domain.use_case.GetLocalUseCase
import com.example.vmediatestapp.domain.use_case.GetRemoteChannelsUseCase
import com.example.vmediatestapp.domain.use_case.GetRemoteProgramItemsUseCase
import com.example.vmediatestapp.domain.use_case.InsertToLocalUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getRemoteChannelsUseCase: GetRemoteChannelsUseCase,
    private val getRemoteProgramItemsUseCase: GetRemoteProgramItemsUseCase,
    private val localUseCase: GetLocalUseCase,
    private val insertToLocalUseCase: InsertToLocalUseCase,
) : ViewModel() {

    private val _channel = MutableLiveData<List<ChannelAndProgram>>()
    val channel: LiveData<List<ChannelAndProgram>> = _channel

    init {
        viewModelScope.launch {

            insertToLocalUseCase.insert(
                getRemoteChannelsUseCase.getRemoteChannels(),
                getRemoteProgramItemsUseCase.getRemoteProgramItems()
            )
            _channel.value = localUseCase.getLocal()
        }
    }

}