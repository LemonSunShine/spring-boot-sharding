package com.sbw.springboot.demo.service;

import com.sbw.springboot.demo.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * AuthorService 测试
 * Created by sbw on 2017/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void addAuthorTest(){

    }

    @Test
    public void updateAuthorTest(){
        System.out.println(150623752017674240l%3/2);
    }

    @Test
    public void deleteAuthorTest(){

    }

    @Test
    public void findAuthorListTest(){

        List<Author> authors = initData();
        int size = authors.size();
        for(Author author : authors){
            authorService.add(author);
        }
        int curSize = authorService.findAuthorList().size();
        if(curSize>size){
            System.out.println("验证通过");
        }else{
            System.out.println("验证失败");
        }
    }

    /**
     * 初始化数据
     * @return
     */
    private List<Author> initData(){
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("zhongzhe","小胖子"));
        authors.add(new Author("saigang","污刚"));
        authors.add(new Author("bowei","小胖子的二大爷"));
        authors.add(new Author("shenjing","小静子"));
        return authors;
    }
}
