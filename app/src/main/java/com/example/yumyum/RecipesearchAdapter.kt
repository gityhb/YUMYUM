package com.example.yumyum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipesearchAdapter(val recipeList: ArrayList<RecipeItem>, private val onItemClick: (RecipeItem) -> Unit) : RecyclerView.Adapter<RecipesearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recipesearch_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipeItem = recipeList[position]
        holder.recipe.text = recipeItem.recipe
        holder.ingredient.text = recipeItem.ingredient
        holder.time.text = recipeItem.time
    }

    fun updateList(newList: List<RecipeItem>) {
        recipeList.clear()
        recipeList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipe: TextView = itemView.findViewById(R.id.recipe_name)
        val ingredient: TextView = itemView.findViewById(R.id.recipe_ingredient)
        val time: TextView = itemView.findViewById(R.id.recipe_time)

        init {
            // 아이템 클릭 리스너 설정
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(recipeList[position])
                }
            }
            fun bind(item: RecipeItem) {
                recipe.text = item.recipe
                ingredient.text = item.ingredient
                time.text = item.time
            }
        }
    }
}