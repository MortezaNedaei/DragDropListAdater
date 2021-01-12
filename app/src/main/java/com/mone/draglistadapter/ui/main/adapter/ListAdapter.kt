package com.mone.draglistadapter.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mone.draglistadapter.R
import com.mone.draglistadapter.data.DataModel
import com.mone.draglistadapter.databinding.ItemListBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

/**********************************
 * Usage:

 * Example of Usage:

 * Note:

 * Parameters:

 * @author Morteza Nedaei on 2021

 ******************************************************************************/

@FragmentScoped
class MainListAdapter @Inject constructor() :
    ListAdapter<DataModel, MainListAdapter.ViewHolder>(
        ListDiffCallback()
    ) {

    var onLongClickListener: ((RecyclerView.ViewHolder) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    inner class ViewHolder internal constructor(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DataModel) = item.run {
            val res = binding.root.context.resources

            binding.txtTitle.text =
                res.getString(R.string.item_text, bindingAdapterPosition)

            binding.img.setBackgroundResource(color)

            binding.root.setOnLongClickListener {
                onLongClickListener?.invoke(this@ViewHolder)

                true
            }
        }
    }
}

class ListDiffCallback : DiffUtil.ItemCallback<DataModel>() {

    override fun areItemsTheSame(
        oldItem: DataModel,
        newItem: DataModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: DataModel,
        newItem: DataModel
    ): Boolean {
        return oldItem == newItem
    }
}
