package com.sunhao.timu1;

import java.util.*;
import java.util.function.BiFunction;

public class BookManager {
    //3.图书管理类中定义存放儿童图书的Map容器，键为儿童图书对象 值为儿童图书适合阶段
    //键盘录入
    Scanner sc = new Scanner(System.in);
    //创建随机数对象
    Random random = new Random();
    HashMap<Book, String> map = new HashMap<>();

    boolean cunzai(String name) {
        for (Book book : map.keySet()) {
            if (book.getBookName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //(1)定义增加图书的方法addBook(Book b)用于将图书存储到Map容器中去，
    public boolean addBook() {
        System.out.println("请输入图书信息(鬼吹灯,天下霸唱,少年)");
        String str = sc.next();
        String[] split = str.split(",");
        if (cunzai(split[0])) {
            System.out.println("添加失败");
        } else {
            //随机数范围
            int i = random.nextInt(100, 999);
            map.put(new Book(i, split[0], split[1], split[2]), split[2]);
            System.out.println("添加成功");
        }
        return true;
        // 返回true或false表示图书是否增加成功（图书编号，书名，作者，适合阶段 相同会增加失败）。
        //(3)定义showBook(String level) 方法 根据传入的适合阶段 查询出容器中符合条件的图书对象

    }


    //(2)定义showAll()方法用于遍历输出容器中所有图书的详细信息。

    public void showAll() {
        if (map.isEmpty()) {
            System.out.println("集合为空");
        } else {
            for (Book book : map.keySet()) {
                System.out.println(book);
            }
        }
    }

    public void showBook(String level) {
        boolean b =false;
        Set<Map.Entry<Book, String>> entries = map.entrySet();
        Iterator<Map.Entry<Book, String>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<Book, String> next = it.next();
            if (next.getValue().equals(level)) {
                System.out.println(next.getKey());
                b=true;
            }
        }
        if (b){
        }else {
            System.out.println("没有该年龄图书");
        }
    }
}
