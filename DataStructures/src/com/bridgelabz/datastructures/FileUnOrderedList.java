/*
*Purpose : Read the elements from the file and add into the list, 
* after take the user input and compare with the elements  within the list and 
* if u find any element remove from the list and if u not find any element just
* add that element into the list and finally save all the list elements into file
* 
* @author kishorereddy
*/
package com.bridgelabz.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.util.UnOrderedList;

public class FileUnOrderedList {
	/*
	 * main function to test the class
	 */
	public static void main(String[] args) {

		UnOrderedList<String> list = new UnOrderedList<String>();

		try {
			File file = new File("/home/bridgelabsz/Desktop/unordered.txt");
			// create the file
			Scanner scannerfile = new Scanner(file);

			while (scannerfile.hasNext()) {

				list.addElement(scannerfile.next());
				// adding elements to the list from file
			}
			// printing the list

			list.printList();
			FileWriter filewriter = new FileWriter(file);

			// fileWriter to write the content into the file
			System.out.println("the size of list :" + list.sizeOfList());

			System.out.println("enter the word to search :");

			String find = list.scanner.nextLine();
			// taking the user input element for searching in list
			if (list.searchElement(find)) {

				// if u find the element it will return
				list.removeElement(find);
				// it will remove the element from the list
				int n = 0;
				while (n < list.sizeOfList()) {
					// it will fetch the element from the list and write into file
					// it will clear the stream by flush
					filewriter.write(list.pop(0) + " ");
					filewriter.flush();
					n++;
				}
				System.out.println("item was founded and deleted ");
			} else {

				list.addElement(find);
				// if the element not found in the list it will add to
				// the list
				int n = 0;
				while (n < list.sizeOfList()) {
					filewriter.write(list.pop(0) + " ");
					filewriter.flush();
					n++;
				}
				System.out.println("item was added ");
			}
			list.scanner.close();
			scannerfile.close();
			filewriter.close();

		} catch (FileNotFoundException e) {

			System.out.println("file was not found ");
			// if file was not found this exception will raise
		} catch (IOException e) {

			System.out.println("io exception raised");

		}

	}

}
