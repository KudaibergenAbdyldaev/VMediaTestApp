package com.example.vmediatestapp.presentation.main_fragment

import androidx.lifecycle.*
import com.example.vmediatestapp.domain.model.ChannelAndProgram
import com.example.vmediatestapp.domain.use_case.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getRemoteChannelsUseCase: GetRemoteChannelsUseCase,
    private val getRemoteProgramItemsUseCase: GetRemoteProgramItemsUseCase,
    private val localUseCase: GetLocalUseCase,
    private val insertToLocalUseCase: InsertToLocalUseCase,
    private val deleteLocalDBUseCase: DeleteLocalDBUseCase,
) : ViewModel() {

    private val _channel = MutableLiveData<List<ChannelAndProgram>>()
    val channel: LiveData<List<ChannelAndProgram>> = _channel

    init {

        viewModelScope.launch {
            val sdf = SimpleDateFormat("HH:mm")
            val time: String = sdf.format(Date())

            if (localUseCase.getLocal().isNullOrEmpty()) {
                insert()
            } else {
                if (time == "20:00") {
                    val scope = viewModelScope.launch(Dispatchers.IO) {
                        deleteLocalDBUseCase.deleteAll()
                        insert()
                    }
                    scope.join()
                    getLocal()
                } else {
                    getLocal()
                }
            }
        }
    }

    private suspend fun insert() {
        insertToLocalUseCase.insert(
            getRemoteChannelsUseCase.getRemoteChannels(),
            getRemoteProgramItemsUseCase.getRemoteProgramItems()
        )
    }

    private suspend fun getLocal() {
        _channel.value = localUseCase.getLocal()
    }

}