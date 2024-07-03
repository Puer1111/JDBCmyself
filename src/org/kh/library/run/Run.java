package org.kh.library.run;

import org.kh.library.view.LibraryView;

public class Run {
	public static void main(String [] args) {
		LibraryView view = new LibraryView();
		while(true) {
			int choice = view.mainMenu();
			switch(choice) {
			case 1:
				view.bookMenu();
				//System.out.println("1번");
				break;
			case 2:
				view.customerMenu();
				//System.out.println("2번");
				break;
			case 3:
				view.libraryMenu();
				//System.out.println("3번");
				break;
			}
		}
	}
}
