
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.shiraz.walmart.R
import kotlin.collections.ArrayList

/*
class ShoppingCategoryAdapter: BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

    //Layout Inflater
        val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.category_layout, null)

        //Get ImageView and TextView from category_layout.xml
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)

        //Display Categories
        val category: Category = getCategories()[position]
        imageView.setImageResource(category.image)
        textView.text = category.name

        //ImageView Click Action
        imageView.setOnClickListener{
          //  Toast.makeText(parent?.context, "You have chosen ${category.name} category of shopping.",Toast.LENGTH_SHORT).show()


          var intent = Intent(parent?.context, ProductListActivity::class.java)
          parent?.context.startActivity(intent)

        }

        return view

    }

    override fun getItem(position: Int): Any {
        return getCategories()[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return getCategories().size
    }

    //Make ArrayList of Categories
    private fun getCategories(): ArrayList<Category>{
        return arrayListOf(
            Category("Electronics", R.drawable.product1),
            Category("Clothing", R.drawable.product2),
            Category("Beauty", R.drawable.product3),
            Category("Food", R.drawable.product4)
        )
    }
}*/

class ShoppingCategoryAdapter(var context: Context, private val myDataset: Array<Category>):
        RecyclerView.Adapter<ShoppingCategoryAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //Get ImageView and TextView from category_layout.xml
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }

    //Create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCategoryAdapter.MyViewHolder {

        //create a new View
        val productView = LayoutInflater.from(parent.context).inflate(R.layout.category_layout, parent, false)

        return MyViewHolder(productView)
    }

    //get the size of dataSet
    override fun getItemCount() = myDataset.size

    //Replace the contents of a view (invoked by layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //get elements from your dataset at this position
        //replace the contents of the view with that element

        holder.imageView.setImageResource(myDataset[position].image)
        holder.textView.text = myDataset[position].name

        holder.imageView.setOnClickListener{
            var intent = Intent(context,ProductListActivity::class.java)
            intent.putExtra("category",myDataset[position])
            context.startActivity(intent)

        }
    }

}
