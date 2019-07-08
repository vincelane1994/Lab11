
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieApp {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<String> genres = new ArrayList<>();
		genres.add("Animation");
		genres.add("Drama");
		genres.add("Horror");
		genres.add("Sci-fi");
		genres.add("Musical");
		
		ArrayList<Movie> movies = new ArrayList<>();
		ArrayList<String> horror = new ArrayList<>();
		ArrayList<String> drama = new ArrayList<>();
		ArrayList<String> scifi = new ArrayList<>();
		ArrayList<String> animation = new ArrayList<>();
		ArrayList<String> musical = new ArrayList<>();
		
		for ( int i = 0; i < 100; i++) {
			movies.add(Movie.getMovie(i));
		}
		
		for (Movie movie: movies) {
			if(movie.getCategory().equalsIgnoreCase("horror")) {
				horror.add(movie.getTitle());
			}else if(movie.getCategory().equalsIgnoreCase("drama")) {
				drama.add(movie.getTitle());
			}else if(movie.getCategory().equalsIgnoreCase("animation") || movie.getCategory().equalsIgnoreCase("animated")) {
				animation.add(movie.getTitle());
			}else if(movie.getCategory().equalsIgnoreCase("scifi")) {
				scifi.add(movie.getTitle());
			}else if(movie.getCategory().equalsIgnoreCase("musical")) {
				musical.add(movie.getTitle());
			}
		}
		
		Collections.sort(horror);
		Collections.sort(scifi);
		Collections.sort(drama);
		Collections.sort(animation);
		Collections.sort(musical);
	
		
		
		do {
			for (int i = 0; i < genres.size(); i++) {
				System.out.println((i + 1) + ". " + genres.get(i));
			}

			System.out.print("What genre of movie would you like to watch? ");
			int selection;
			try {
				selection = scnr.nextInt();
				scnr.nextLine();
			} catch(InputMismatchException ex) {
				System.out.println("Please enter a number between 1-5");
				scnr.nextLine();
				continue;
			}

			switch (selection) {
			case 1:
				System.out.println("\nAnimation Movies\n==========================");
				for (int i = 0; i < animation.size(); i++) {
					System.out.println(animation.get(i));
				}
				System.out.println("==========================");
				break;
			case 2:
				System.out.println("\nDrama Movies\n==========================");
				for (int i = 0; i < drama.size(); i++) {
					System.out.println(drama.get(i));
				}
				System.out.println("==========================");
				break;
			case 3:
				System.out.println("\nHorror Movies\n==========================");
				for (int i = 0; i < horror.size(); i++) {
					System.out.println(horror.get(i));
				}
				System.out.println("==========================");
				break;
			case 4:
				System.out.println("\nSci-fi Movies\n==========================");
				for (int i = 0; i < scifi.size(); i++) {
					System.out.println(scifi.get(i));
				}
				System.out.println("==========================");
				break;
			case 5:
				System.out.println("\nMusical Movies\n==========================");
				for (int i = 0; i < musical.size(); i++) {
					System.out.println(musical.get(i));
				}
				System.out.println("==========================");
				break;
			default:
				System.out.println("Invalid choice. Please use a number between 1-4");
				break;
			}
			
		} while (doAgain(scnr, "Continue? (y/n)"));
		System.out.println("Goodbye!");
		scnr.close();
	}

	public static boolean doAgain(Scanner scnr, String prompt) {
		boolean isValid = false;
		boolean decision = false;
		do {
			System.out.println(prompt);
			String userInput = scnr.nextLine();
			if (userInput.matches("[yYnN][eEoO]{0,1}[sS]{0,1}")) {
				isValid = true;
				if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
					decision = true;
					isValid = true;
				} else if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")) {
					decision = false;
					isValid = true;
				}
			} else {
				isValid = false;
				System.out.println("\"" + userInput + "\""
						+ " is not a valid option. You can type \"Y\" or \"Yes\" to continue or  \"N\" and \"No\" to exit");
			}
			// System.out.println(isValid);
		} while (!isValid);

		return decision;

	}

	public static boolean isYORN(Scanner scnr, String userInput) {
		boolean yorn = false;
		boolean isValid = false;
		do {
			if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
				yorn = true;
				isValid = true;
			} else if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")) {
				yorn = false;
				isValid = true;
			}

		} while (!isValid);
		return yorn;
	}
}
