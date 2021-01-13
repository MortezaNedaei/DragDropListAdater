package com.mone.draglistadapter.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.mone.draglistadapter.R
import com.mone.draglistadapter.data.DataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

/**********************************
 * Usage:

 * Example of Usage:

 * Note:

 * Parameters:

 * @author Morteza Nedaei on 2021

 ******************************************************************************/


class MainViewModel @ViewModelInject constructor() : ViewModel() {

    private val _data: MutableLiveData<MutableList<DataModel>> = MutableLiveData(mutableListOf())
    val data: LiveData<List<DataModel>> = _data.map { it.toList() }

    init {
        repeat(100) { epoch ->
            _data.value?.add(DataModel(id = epoch.toString(), color = getRandomColor()))
        }
    }

    private fun getRandomColor(): Int {
        return listOf(
            R.color.purple_500,
            R.color.teal_200,
            R.color.black,
            R.color.green,
            R.color.red,
            R.color.orange,
            R.color.yellow
        ).random()
    }

    /**
     * Reordering the list
     */
    fun move(from: Int, to: Int) {
        _data.value?.let { list ->
            val item = list.removeAt(from)
            list.add(to, item)
            _data.value = list
        }
    }

}