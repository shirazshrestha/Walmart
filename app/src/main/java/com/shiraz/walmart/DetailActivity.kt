
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shiraz.walmart.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intent = intent
        var product = intent.getSerializableExtra("product") as Product

        detail_color.text = "color: "+product.color
        detail_desc.text = "description: "+product.desc
        detail_price.text = "price: "+product.price.toString()
        detail_title.text = "title: "+product.title
        detail_image.setImageResource(product.image)
    }
}
