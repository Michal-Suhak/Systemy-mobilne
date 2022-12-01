package com.example.zad_7;

import static com.example.zad_7.MainActivity.IMAGE_URL_BASE;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class BookDetails extends AppCompatActivity {
    public final static String EXTRA_BOOK_OBJ = "EXTRA_BOOK_OBJ";

    private TextView titleTextView;
    private TextView authorTextView;
    private TextView numberOfPagesTextView;
    private ImageView bookCover;

    private TextView publishYearTextView;
    private TextView bookLanguagesTextView;
    private TextView ebookAccessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_details);
        titleTextView = findViewById(R.id.book_title);
        authorTextView = findViewById(R.id.book_author);
        numberOfPagesTextView = findViewById(R.id.number_of_pages);
        bookCover = findViewById(R.id.img_cover);

        publishYearTextView = findViewById(R.id.publish_year);
        bookLanguagesTextView = findViewById(R.id.book_languages);
        ebookAccessTextView = findViewById(R.id.ebook_access);

        bookCover = findViewById(R.id.img_cover);

        Book book = (Book) getIntent().getSerializableExtra(EXTRA_BOOK_OBJ);

        titleTextView.setText(getString(R.string.title) + book.getTitle());
        authorTextView.setText(getString(R.string.author) + TextUtils.join(", ", book.getAuthors()));
        numberOfPagesTextView.setText(getString(R.string.pages_number) + book.getNumberOfPages());
        publishYearTextView.setText(getString(R.string.year_published) + String.valueOf(book.getPublishYear()));
        bookLanguagesTextView.setText(getString(R.string.languages) + TextUtils.join(", ", book.getLanguages()));
        ebookAccessTextView.setText(getString(R.string.ebook_access) + book.getEbookAccess());

        if (book.getCover() != null) {
            Picasso.with(getApplicationContext())
                    .load(IMAGE_URL_BASE + book.getCover() + "-L.jpg")
                    .placeholder(R.drawable.book).into(bookCover);
        } else {
            bookCover.setImageResource(R.drawable.book);
        }
    }
}