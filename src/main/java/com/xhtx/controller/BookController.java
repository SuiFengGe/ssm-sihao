package com.xhtx.controller;

import com.xhtx.pojo.Books;
import com.xhtx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model, HttpSession session){
        //List<Books> list = bookService.queryAllBook();
        Object loginUser = session.getAttribute("loginUser");
        System.out.println(loginUser);
        if (loginUser==null){
            return "redirect:/user/toLogin";
        }else {
            int totalCount = bookService.findTotalCount();
            System.out.println(totalCount);
            //根据总记录数算出总页数
            int totalPage = totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1;
            System.out.println(totalPage);
            //初始显示第一页
            List<Books> list = bookService.tenCount(0);
            System.out.println(list);
            model.addAttribute("list",list);
            int pageArray[] = new int[totalPage];//页数数组，供前端遍历
            for (int i = 1; i <= totalPage; i++) {
                pageArray[i-1] = i;
            }
            model.addAttribute("pageArray",pageArray);
            System.out.println("主页面");

            return "allBook";
        }


    }


    @RequestMapping("/pageController")
    public String pageController(Model model, HttpServletRequest request){
        String pageNum = request.getParameter("pageNum");//要查询的页数
        List<Books> list = new ArrayList<>();
        int startRow = (Integer.parseInt(pageNum) - 1) * 10;//当前页开始的行数
        list = bookService.tenCount(startRow);
        model.addAttribute("list", list);
        System.out.println(list.toString());

        int totalCount = bookService.findTotalCount();
        System.out.println(totalCount);
        //根据总记录数算出总页数
        int totalPage = totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1;
        System.out.println(totalPage);
        int pageArray[] = new int[totalPage];//页数数组，供前端遍历
        for (int i = 1; i <= totalPage; i++) {
            pageArray[i-1] = i;
        }
        model.addAttribute("pageArray",pageArray);
        return "allBook";
    }


    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        //重定向到@RequestMapping("/allBook")
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        //重定向到@RequestMapping("/allBook")
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookById(id);
        bookService.resetID1();
        bookService.resetID2();
        //重定向到@RequestMapping("/allBook")
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(Model model,HttpServletRequest request){
        String bookName = request.getParameter("bookName");
        request.getSession().setAttribute("bookName",bookName);
        int allResult = bookService.queryBookByLikeName(bookName);
        System.out.println(allResult);
        int allPage = allResult % 10 == 0 ? allResult / 10 : allResult / 10 + 1;
        System.out.println(allPage);

        //初始显示第一页
        List<Books> list2 = bookService.tenResult(bookName,0);
        System.out.println(list2);
        model.addAttribute("list2",list2);
        int pageArray2[] = new int[allPage];//页数数组，供前端遍历
        for (int i = 1; i <= allPage; i++) {
            pageArray2[i-1] = i;
        }
        model.addAttribute("pageArray2",pageArray2);
        return "queryBook";
    }

    @RequestMapping("/pageLikeController")
    public String pageLikeController(Model model, HttpServletRequest request){
        String pageNum2 = request.getParameter("pageNum2");//要查询的页数
        List<Books> list2 = new ArrayList<>();
        int startRow = (Integer.parseInt(pageNum2) - 1) * 10;//当前页开始的行数
        String bookName = (String) request.getSession().getAttribute("bookName");
        System.out.println(bookName);
        list2 = bookService.tenResult(bookName,startRow);
        model.addAttribute("list2", list2);
        System.out.println(list2.toString());

        int allResult = bookService.queryBookByLikeName(bookName);
        System.out.println(allResult);
        //根据总记录数算出总页数
        int allPage = allResult % 10 == 0 ? allResult / 10 : allResult / 10 + 1;
        System.out.println(allPage);
        int pageArray2[] = new int[allPage];//页数数组，供前端遍历
        for (int i = 1; i <= allPage; i++) {
            pageArray2[i-1] = i;
        }
        model.addAttribute("pageArray2",pageArray2);
        return "queryBook";
    }


}
