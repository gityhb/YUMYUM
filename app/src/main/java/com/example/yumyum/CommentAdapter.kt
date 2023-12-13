import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyum.CommentItem
import com.example.yumyum.R

class CommentAdapter(val commentList: List<CommentItem>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_comment_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val commentItem = commentList[position]
        holder.writer.text = commentItem.writer
        holder.comment.text = commentItem.comment
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val writer: TextView = itemView.findViewById(R.id.comment_writer)
        val comment: TextView = itemView.findViewById(R.id.comment_content)
    }
}
