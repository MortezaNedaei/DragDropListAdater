package com.mone.draglistadapter.data

import com.mone.draglistadapter.R
import kotlin.random.Random


/**********************************
 * Usage:

 * Example of Usage:

 * Note:

 * Parameters:

 * @author Morteza Nedaei on 2021

 ******************************************************************************/

data class DataModel(
    val id: String = Random.nextInt().toString(),
    var color: Int
)
