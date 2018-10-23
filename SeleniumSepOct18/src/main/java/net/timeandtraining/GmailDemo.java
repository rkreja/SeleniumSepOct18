package net.timeandtraining;

import java.util.List;

import com.rkreja.Gmail;


public class GmailDemo {

	public static void main(String[] args) {
		
		
		Gmail gmail = new Gmail("qa.diamonds@gmail.com", "time&training");
//		gmail.ComposeEmail("qa.diamonds@gmail.com", "Hello", "http://www.timeandtraining.net");
		
//		List<String> s=gmail.get_link_from_email("qa.diamonds@gmail.com");
//		System.out.println(s.get(0));
		
		
		
		String s=gmail.get_most_recent_email();
		System.out.println(s.contains("timeandtraining"));
		
		
//		String msg=gmail.get_most_recent_email();
//		System.out.println(msg);
		
		

		
		

	}

}
