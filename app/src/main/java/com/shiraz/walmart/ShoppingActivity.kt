
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.GridView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.shiraz.walmart.R
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var myDataSet: Array<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        initData()

        //get username from Main Activity
        val intent = getIntent();
        val username = intent.getStringExtra("username")

        //show Username as "Welcome <username>" at the top of ShoppingActivity
        var welcomeMsg = findViewById<TextView>(R.id.showUsernameInWelcome)
        welcomeMsg.text = "Welcome " + username

        /*//Find View By Id for GridView
        val gridView = findViewById<GridView>(R.id.shoppingGridView)

        //ShoppingCategory Adapter
        val adapter = ShoppingCategoryAdapter()
        shoppingGridView.adapter = adapter*/

        //list the product category
        viewManager = GridLayoutManager(this, 2)
        viewAdapter = ShoppingCategoryAdapter(this, myDataSet)

        shoppingGridView.apply {
            //use a grid layout manager
            layoutManager = viewManager

            //specify a viewAdapter
            adapter = viewAdapter
        }
    }

    fun initData() {

       var category1 = Category("Electronics", R.drawable.product1)
        category1.productList = arrayOf(
            Product("Product 1", 450.0, "Black", R.drawable.product1, "P1", "A very good product"),
            Product("Product 2", 400.0, "Silver", R.drawable.product1, "P2", "A very good product"),
            Product("Product 3", 500.0, "Gold", R.drawable.product1, "P3", "A very good product"),
            Product("Product 4", 420.0, "Matt Black", R.drawable.product1, "P4", "A very good product"),
            Product("Product 5", 130.0, "Red", R.drawable.product1, "P5", "A very good product")
        )

       var category2 = Category("Clothing", R.drawable.product2)
        category2.productList = arrayOf(
            Product("Product 1", 450.0, "Black", R.drawable.product2, "P1", "A very good product"),
            Product("Product 2", 400.0, "Silver", R.drawable.product2, "P2", "A very good product"),
            Product("Product 3", 500.0, "Gold", R.drawable.product2, "P3", "A very good product"),
            Product("Product 4", 420.0, "Matt Black", R.drawable.product2, "P4", "A very good product"),
            Product("Product 5", 130.0, "Red", R.drawable.product2, "P5", "A very good product")
        )

       var category3 = Category("Beauty", R.drawable.product3)
        category3.productList = arrayOf(
            Product("Product 1", 450.0, "Black", R.drawable.product3, "P1", "A very good product"),
            Product("Product 2", 400.0, "Silver", R.drawable.product3, "P2", "A very good product"),
            Product("Product 3", 500.0, "Gold", R.drawable.product3, "P3", "A very good product"),
            Product("Product 4", 420.0, "Matt Black", R.drawable.product3, "P4", "A very good product"),
            Product("Product 5", 130.0, "Red", R.drawable.product3, "P5", "A very good product")
        )

       var category4 = Category("Food", R.drawable.product4)
        category1.productList = arrayOf(
            Product("Product 1", 450.0, "Black", R.drawable.product4, "P1", "A very good product"),
            Product("Product 2", 400.0, "Silver", R.drawable.product4, "P2", "A very good product"),
            Product("Product 3", 500.0, "Gold", R.drawable.product4, "P3", "A very good product"),
            Product("Product 4", 420.0, "Matt Black", R.drawable.product4, "P4", "A very good product"),
            Product("Product 5", 130.0, "Red", R.drawable.product4, "P5", "A very good product")
        )

        myDataSet = arrayOf(category1, category2, category3, category4)

    }
}
