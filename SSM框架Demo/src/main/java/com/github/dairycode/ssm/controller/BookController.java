package com.github.dairycode.ssm.controller;

import com.github.dairycode.ssm.pojo.Books;
import com.github.dairycode.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    // controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部的书籍,并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = bookService.queryAllBooks();

        model.addAttribute("list", books);
        return "allBook";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPapper() {
        return "addBook";
    }

    // 添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";    // 重定向到我们的一个请求上
    }

    // 跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int bookID, Model model) {
        Books books = bookService.queryBookById(bookID);
        model.addAttribute("QBook", books);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook==>" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int bookID) {
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }

    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = bookService.queryBookName(queryBookName);

        List<Books> list = new ArrayList<>();
        list.add(books);
        if (books == null) {
            list = bookService.queryAllBooks();
            model.addAttribute("error", "未查到");
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
