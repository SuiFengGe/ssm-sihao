import com.xhtx.pojo.Author;
import com.xhtx.pojo.Books;
import com.xhtx.service.AuthorService;
import com.xhtx.service.BookService;
import com.xhtx.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        List<Books> books = bookServiceImpl.queryAllBook();
        for (Books book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        AuthorService authorServiceImpl = context.getBean("AuthorServiceImpl", AuthorService.class);
        Author author = authorServiceImpl.getAuthorByID(1);
        System.out.println(author);

    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        List<Books> list = bookServiceImpl.tenCount(0);
        for (Books books : list) {
            System.out.println(books);
        }
    }
}
