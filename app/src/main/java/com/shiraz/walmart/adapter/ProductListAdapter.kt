
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shiraz.walmart.R


class ProductListAdapter(var context: Context, private val productList: Array<Product>) :
    RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    //Class ViewHolder which will take View as an argument
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.productImage)
        val title = itemView.findViewById<TextView>(R.id.productTitle)
        val color = itemView.findViewById<TextView>(R.id.productColor)
        val price = itemView.findViewById<TextView>(R.id.productPrice)

        var parentLayout = itemView

    }

    //creates View Holder, for this we will use 'product_list_layout.xml'
    //This product_list_layout will be generated for each Item in our recyclerView
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.MyViewHolder {
        val productView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_layout, parent, false)  // ? is used to handle the null
        return ProductListAdapter.MyViewHolder(productView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    //We bind data to our RecyclerView here
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.image.setImageResource(productList[position].image)
        holder.color.text = "color: " + productList[position].color
        holder.title.text = "title: " + productList[position].title
        holder.price.text = "price: " + productList[position].price.toString()

        holder.itemView.setOnClickListener {
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("product", productList)
            context.startActivity(intent)
        }
    }

}
