package com.example.yumyum

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyum.recipe.R1StartActivity

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
        holder.recipeimg.setImageResource(recipeItem.recipeimg)
        holder.levelimg.setImageResource(recipeItem.levelimg)
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
        val recipeimg: ImageView = itemView.findViewById(R.id.recipe_img)
        val levelimg: ImageView = itemView.findViewById(R.id.level_img)

        val itemLinearLayout: LinearLayout = itemView.findViewById(R.id.click_part)

        init {
            itemLinearLayout.setOnClickListener {
                // 리니어 레이아웃 클릭 이벤트 처리
                val currentPosition = adapterPosition

                if (currentPosition != RecyclerView.NO_POSITION) {
                    val clickedItem = recipeList[currentPosition]
                    val intent = Intent(itemView.context, R1StartActivity::class.java)
                    intent.putExtra("number", clickedItem.number)
                    intent.putExtra("Recipe", clickedItem.recipe)
                    intent.putExtra("Ingredient", clickedItem.ingredient)
                    intent.putExtra("Time", clickedItem.time)
                    intent.putExtra("Utensil", clickedItem.utensil)
                    intent.putExtra("RecipeImg", clickedItem.recipeimg)
                    intent.putExtra("Step", clickedItem.step)

                    itemView.context.startActivity(intent)
                }
            }
        }

    }
}