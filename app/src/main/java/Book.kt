import android.content.Intent
import java.text.DecimalFormat

public class Book(id: String?, name: String, author: String, price: String, imgSrc: String, description: String, code: String, favourite: Boolean, later: Boolean) {
    var Id = id
    var Name = name
    var Author = author
    var Price = price
    var ImgSrc = imgSrc
    var Description = description
    var Code = code
    var Favourite = favourite
    var Later = later

    fun addDataToIntent(intent: Intent) {
        intent.putExtra("id", this.Id)
        intent.putExtra("name", this.Name)
        intent.putExtra("imgSrc", this.ImgSrc)
        intent.putExtra("author" ,this.Author)
        intent.putExtra("description", this.Description)
        intent.putExtra("price", this.Price)
        intent.putExtra("favourite", this.Favourite)
        intent.putExtra("later", this.Later)
        intent.putExtra("code", this.Code)
    }
}