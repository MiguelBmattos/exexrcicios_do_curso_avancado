package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		Comment c1 = new Comment("Have a nice trip");
		Comment c2 = new Comment("Wow that's awesome!");

		LocalDateTime moment1 = LocalDateTime.parse("21/06/2025 13:05:44", fmt);
		String title1 = ("Traveling to New Zealand");
		String content1 = ("I'm going to travel to this wonderful country!");
		int likes1 = 12;
		Post post1 = new Post(moment1, title1, content1, likes1);
		post1.addComments(c1);
		post1.addComments(c2);

		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the Force be with you");

		LocalDateTime moment2 = LocalDateTime.parse("26/07/1025 23:14:19", fmt);
		String title2 = ("Good night guys");
		String content2 = ("See you tomorrow");
		int likes2 = 5;
		Post post2 = new Post(moment2, title2, content2, likes2);
		post2.addComments(c3);
		post2.addComments(c4);

		System.out.println(post1);
		System.out.println();
		System.out.println(post2);
	}
}
