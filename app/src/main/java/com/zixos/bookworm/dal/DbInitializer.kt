package com.zixos.bookworm.dal

import Book
import java.lang.Exception

class DbInitializer {

    fun InitDB(db: DbContext)
    {
        if (db.getBooks().count() < 1)
        {
            InitBooks(db)
        }
    }

    fun InitBooks(db: DbContext)
    {
        val books = getBooks()
        for(book in books) {
            db.addBook(book)
        }
    }

    fun getBooks(): Collection<Book> {
        return setOf(
            Book(null, "Book1", "Author1", "100", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000001",
                favourite = false,
                later = false
            ),
            Book(null,"Book2", "Author2", "99", "https://cdn1.ozone.ru/multimedia/1007119597.jpg", "SFafafaf", "0000002",
                favourite = false,
                later = false
            ),
            Book(null,"Book3", "Author3", "101", "https://static-cse.canva.com/blob/231917/%D0%A3%D1%81%D0%BF%D0%B5%D1%82%D1%8C-%D0%B4%D0%BE-%D0%B2%D0%BE%D1%81%D1%85%D0%BE%D0%B4%D0%B0.png", "arhgghrehregrwgrhrhrwwgwegew", "0000003",
                favourite = false,
                later = false
            ),
            Book(null, "Book4444444444444444444444444444444444444444444444444444444444444444444444", "Author3", "101", "https://kbimages1-a.akamaihd.net/fa69eb0d-9706-4d70-bd94-7f0d3a3dbba3/1200/1200/False/harry-potter-the-complete-collection-1-7-1.jpg", "egGGAGAGWGWERGEGSG", "0000004",
                favourite = false,
                later = false
            ),
            Book(null, "Harry Potter", "J. K. Rowling", "100", "https://images-na.ssl-images-amazon.com/images/I/910ityjoncL.jpg", "Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns Harry's struggle against Lord Voldemort, a dark wizard who intends to become immortal, overthrow the wizard governing body known as the Ministry of Magic and subjugate all wizards and Muggles (non-magical people).", "0000005",
                favourite = false,
                later = false
            ),
            Book(null, "Book6", "Author1", "100", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000006",
                favourite = false,
                later = false
            ),
            Book(null, "Book17", "Author2", "120", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000007",
                favourite = false,
                later = false
            ),
            Book(null, "Book8", "Author3", "100", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000008",
                favourite = false,
                later = false
            ),
            Book(null, "Book9", "Author6", "100", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000009",
                favourite = false,
                later = false
            ),
            Book(null, "Book10", "Author12", "135", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "000010",
                favourite = false,
                later = false
            ),
            Book(null, "Book11", "Author51", "110", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000011",
                favourite = false,
                later = false
            ),
            Book(null, "Book12", "Author112", "60", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000012",
                favourite = false,
                later = false
            ),
            Book(null, "Book13", "Author15", "100", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000013",
                favourite = false,
                later = false
            ),
            Book(null, "Book14", "Author51512", "90", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000014",
                favourite = false,
                later = false
            ),
            Book(null, "Book15", "Author12", "100", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Books-aj.svg_aj_ashton_01f.svg/2310px-Books-aj.svg_aj_ashton_01f.svg.png", "Description", "0000015",
                favourite = false,
                later = false
            ),
        )
    }
}