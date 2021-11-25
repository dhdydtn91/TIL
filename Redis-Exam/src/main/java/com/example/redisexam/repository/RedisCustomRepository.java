package com.example.redisexam.repository;

import com.example.redisexam.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RedisCustomRepository {

    @Autowired
    private final RedisTemplate<String, Object> redisTemplate;

    public void save(Book book) {
        redisTemplate.opsForValue().set(book.getTitle(), book);
    }

    public SetOperations<String, Object> save_Set(String title, List<Book> bookList) {
        SetOperations<String, Object> stringObjectSetOperations = redisTemplate.opsForSet();
        redisTemplate.delete(title);
        bookList.forEach(book ->
                stringObjectSetOperations.add(title, book.getTitle())
        );
        return stringObjectSetOperations;
    }

    public Book findById(String title) {
        return (Book) redisTemplate.opsForValue().get(title);
    }

    public void delete(String title) {
        if (redisTemplate.hasKey(title)) {
            redisTemplate.delete(title);
        }
    }
}
