import java.text.DecimalFormat

public class Book {
    constructor(name: String, author: String, price: String, imgSrc: String, description: String, favourite: Boolean, later: Boolean)
    {
        Name = name
        Author = author
        Price = price
        ImgSrc = imgSrc
        Description = description
        Favourite = favourite
        Later = later
    }

    public var Name: String = ""
    public var Author: String = ""
    public var Price: String = ""
    public var ImgSrc: String = ""
    public var Description = ""
    public var Favourite: Boolean = false
    public  var Later: Boolean = false
}