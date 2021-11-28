import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream
import java.lang.Exception
import java.net.URL
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

    @SuppressLint("StaticFieldLeak")
    @Suppress("DEPRECATION")
    inner class SetImageFromInternet(var imageView: ImageView) : AsyncTask<Void?, Void, Drawable?>() {

        override fun doInBackground(vararg p0: Void?): Drawable? {
            var drawable: Drawable? = null
            try {
                val `is`: InputStream = URL(ImgSrc).content as InputStream
                drawable = Drawable.createFromStream(`is`, "src name")
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
            return drawable
        }

        override fun onPostExecute(result: Drawable?) {
            imageView.clearColorFilter()
            imageView.setImageDrawable(result)
        }
    }

}