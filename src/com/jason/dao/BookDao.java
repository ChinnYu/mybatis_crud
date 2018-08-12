package com.jason.dao;

import com.jason.model.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {

    @Select("select book_Id, book_title, book_typename, book_price, book_state from www_book where book_Id=#{book_Id}")
    public Book getBookById(int id);

    @Select("select * from www_book")
    public List<Book> getAllBooks();

    @Insert("insert into www_book (book_Id, book_title, book_typename, book_price, book_state) values (NULL,#{book_title}, #{book_typename}, #{book_price}, #{book_state})")
    public int add(Book book);//引響行數

    @Update("update www_book set book_title=#{book_title},book_typename=#{book_typename},book_price=#{book_price},book_state=#{book_state} where book_Id=#{book_Id}")
    public int update(Book book);

    @Delete("delete from www_book where book_Id=#{id}")
    public int deleteById(int id);

}