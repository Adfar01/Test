package com.demo.Test.Controller;

import com.demo.Test.Entities.Book;
import com.demo.Test.Repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import  org.junit.runner.RunWith;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

  Book record1= new Book("1","Core Java","Basics of java",5);
 Book record2= new Book("2","Advance Java","Do the Implementation here",4);
 Book record3=new Book("3","Spring Boot","All about the spring boot",5);

 @Before
 public void setUp(){
     MockitoAnnotations.initMocks(this);
     this.mockMvc= MockMvcBuilders.standaloneSetup(bookController).build();
 }

 @Test
 public void getAllRecords_success() throws Exception{
     ArrayList<Book> records = new ArrayList<>(Arrays.asList(record1, record2, record3));

     Mockito.when(bookRepository.findAll()).thenReturn(records);
     mockMvc.perform(
             MockMvcRequestBuilders.get("/book")
                     .contentType(MediaType.APPLICATION_JSON))
                     .andExpect(status().isOk())
             .andExpect(jsonPath("$",hasSize(3)))

             .andExpect(jsonPath("$[2].name",is("Grokking Algorithms")));


   }

}
