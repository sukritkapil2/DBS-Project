package BookPack;
class Book {
private String title;
private String author;
private int pubDate;
Book(String t, String a, int d) {
title = t;
author = a;
pubDate = d;
}
void show() {
System.out.println(title);
System.out.println(author);
System.out.println(pubDate);
System.out.println();
}
}
class BookDemo {
public static void main(String args[]) {
Book books[] = new Book[5];
books[0] = new Book("Java 2: A Beginner's Guide", "Schildt", 2002);
books[1] = new Book("Java 2 Programmers Reference", "Schildt", 2000);
books[2] = new Book("HTML Programmers Reference", "Powell and Whitworth", 1998);
books[3] = new Book("Red Storm Rising", "Clancy", 1986);
books[4] = new Book("On the Road", "Kerouac", 1955);
for(int i=0; i < books.length; i++)
books[i].show();
}
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sneh Lohia
 */
