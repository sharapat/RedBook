package com.texnopos.redbook.ui.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.texnopos.redbook.R
import com.texnopos.redbook.data.model.Animal
import kotlinx.android.synthetic.main.item_animal.view.*

class FavoriteListAdapter : RecyclerView.Adapter<FavoriteListAdapter.FavoriteViewHolder>()  {

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: Animal) {
            itemView.tvEngName.text = model.nameEng
            itemView.tvRusName.text = model.nameRus
            itemView.tvUzbName.text = model.nameUzb
            val imageResName = "picture${model.id}"
            Glide
                .with(itemView)
                .load(itemView.context.resources.getIdentifier(imageResName, "drawable", itemView.context.packageName))
                .into(itemView.ivAnimal)

            itemView.setOnClickListener {
                onItemClick(model.id)
            }
        }
    }

    private var onItemClick: (id: Int) -> Unit = {}

    fun setOnItemClickListener(onItemClick: (id: Int) -> Unit) {
        this.onItemClick = onItemClick
    }

    var models : List<Animal> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
}