import java.io.Serializable

class Category:Serializable{

    lateinit var name: String
    var image: Int = 0

    var productList: Array<Product> = emptyArray()

    constructor(name: String, image: Int){
        this.name = name
        this.image = image
    }
}