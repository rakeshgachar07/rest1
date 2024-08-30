package pkg1.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class R1 {
	public static List<String> readFile(String fName) throws FileNotFoundException {
		File f1 = new File(fName);
		Scanner sc1 = new Scanner(f1);
		List<String> list1 = new ArrayList<>();
		sc1.nextLine();
		while(sc1.hasNext()) {
			list1.add(sc1.nextLine());
		}
	    return list1;
	}
	
	@GetMapping("/hello")
	public static String printHello() {
		String str1 = "Hello";
		return str1;
	}
	
	@GetMapping("/universties/get")
	public static List<String> getUniversties() throws FileNotFoundException {
		String fName = "universities.txt";
		List<String> list1 = new ArrayList<>();
		list1 = readFile(fName);
		return list1;
	}
}
