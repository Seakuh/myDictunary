package ctr;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Application {

	private static Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Dictionary:");
		Application.start();

	}

	private static void start() throws IOException, InterruptedException {

		Map<String, String> map = new HashMap<String, String>();
		Scanner section = new Scanner(System.in);

		System.out.println("Slection:\n1 PrintDictunary\n2 Insert Word\n3 Print file in German\n4 printMap");
		int sectionString = section.nextInt();
		switch (sectionString) {
		case 1: {
			Application.printDictunary();
		}
		case 2: {
			Application.addWords();
		}
		case 3: {
			Application.printFileGerman();
		}
		case 4: {
			Application.printMap();
		}
		}

		Application.start();

	}

	private static void printMap() {
		for (Entry<String, String> s : map.entrySet()) {
			System.out.println("German: " + s.getValue() + "\tEnglisch: " + s.getKey());
		}

	}

	private static void printFileGerman() throws IOException, InterruptedException {
		System.out.println("FileName:\t");
		@SuppressWarnings("resource")
		Scanner section = new Scanner(System.in);

		// write to file : "fileone"
		try {
			File fileOne = new File(section.next());
			FileOutputStream fos = new FileOutputStream(fileOne);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
		}
		Application.start();

	}

	public static void addWords() throws IOException, InterruptedException {
		@SuppressWarnings("resource")
		Scanner scannerEng = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner scannerGer = new Scanner(System.in);
		System.out.print("German WOrd:\t");
		String gerWord = scannerGer.next();
		System.out.print("Englisch Word:\t");
		String engWord = scannerEng.next();

		map.put(engWord, gerWord);
		Application.start();

	}

	private static void printDictunary() throws IOException, InterruptedException {

		Scanner filname = new Scanner(System.in);
		Scanner selection = new Scanner(System.in);
		System.out.print("In PrintDictunary\nName of File:\t" + "");

		String fileNameString = filname.next();

//		try {
//			File myObj = new File(fileNameString);
//			if (myObj.createNewFile()) {
//				System.out.println("File created: " + myObj.getName());
//			} else {
//				System.out.println("File already exists...");
//			}
//			
//		
//		} catch (IOException e) {
//			System.out.println("An error occurred..");
//			e.printStackTrace();
//		}

		FileWriter f1;
		try {
			f1 = new FileWriter("DDDDDDDDDDDDDDDDDDDDDD");
			f1.write("Dictunary Test:\n");
			for (Entry<String, String> s : map.entrySet()) {
				f1.write(s.getValue()+"\t"+s.getKey()+"\n");
			}
			f1.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Erstellen der Datei");
		}

		Thread.sleep(1000);
		@SuppressWarnings("resource")
		BufferedWriter writer = new BufferedWriter(new FileWriter("WriteTESTTest"));
		System.out.print("File will be written...\n");

		FileOutputStream outputStream = new FileOutputStream(fileNameString);
//		DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(outputStream));
//		for (Entry<String, String> s : map.entrySet()) {
//			writer.write(s.getKey() + "\t" + s.getValue());
//			outputStream.wri
//
//		}

		// String fileNameStringIn = filname.next();

		// BufferedReader br = new BufferedReader(fileNameStringIn);
		writer.write("Dictunary Output:df" + "");

		for (Entry<String, String> s : map.entrySet()) {
			writer.write(s.getValue());
		}

		Application.start();

	}

	private static boolean writeLine(String s) {

		return true;
	}

	private static void translateFile() {
		System.out.println("which file should be translated:\t");
		Scanner filnameIn = new Scanner(System.in);
		String fileNameInString = filnameIn.next();
	}

}
