package com.springboot.app.fekuAPI.data;

import com.springboot.app.fekuAPI.model.Book;
import com.springboot.app.fekuAPI.util.UtilHelper;

import java.util.ArrayList;
import java.util.List;

public class BookData {

    public static List<Book> generateBookData(int count) {

        List<Book> bookList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {

            bookList.add(new Book(
                    (long) i,
                    UtilHelper.faker().book().title(),
                    UtilHelper.faker().book().author(),
                    UtilHelper.faker().book().genre(),
                    UtilHelper.faker().book().publisher()
            ));
        }
        return bookList;

    }
}
