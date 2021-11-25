package com.example.redisexam;


import com.example.redisexam.model.Book;
import com.example.redisexam.repository.RedisCustomRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.SetOperations;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    RedisCustomRepository redisCustomRepository;

    List<Book> bookList;
    Book book;
    Book book2;
    Book book3;

    @BeforeEach
    public void setup() {
        book = new Book("토비의 스프링", "스프링 동작원리");
        book2 = new Book("Real Mysql", "Mysql 동작원리");
        book3 = new Book("토비의 스프링", "스프링 동작원리");
        bookList = List.of(book, book2, book3);
    }

    @Test
    @DisplayName("레디스 저장 테스트")
    void save() {
        redisCustomRepository.save(book);
        Book savedBook = redisCustomRepository.findById(book.getTitle());

        assertThat(book.getTitle()).isEqualTo(savedBook.getTitle());
        assertThat(book.getContents()).isEqualTo(savedBook.getContents());
    }

    @Test
    @DisplayName("레디스 저장구조 set 저장 테스트")
    void save2() {
        // 초기화
        bookList.forEach(book -> redisCustomRepository.delete(book.getTitle()));

        String title = "BookList";
        SetOperations<String, Object> stringObjectSetOperations = redisCustomRepository.save_Set(title, bookList);
        Set<Object> savedBookList = stringObjectSetOperations.members("BookList");

        assertThat(savedBookList.size()).isEqualTo(2);
        assertThat(savedBookList).containsExactly(bookList.get(1).getTitle(), bookList.get(0).getTitle());
    }

    @Test
    @DisplayName("레디스 저장구조 set 저장 테스트")
    void save3() {
        // 초기화
        bookList.forEach(book -> redisCustomRepository.delete(book.getTitle()));

        String title = "BookList";
        SetOperations<String, Object> stringObjectSetOperations = redisCustomRepository.save_Set(title, bookList);
        Set<Object> savedBookList = stringObjectSetOperations.members("BookList");

        assertThat(savedBookList.size()).isEqualTo(2);
        assertThat(savedBookList).containsExactly(bookList.get(1).getTitle(), bookList.get(0).getTitle());
    }
}
