package en10dre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        int floor = 0;
        int position = 0;
        boolean firstEnteredBasement = false; // To track if the basement is entered

        // Load the file from resources using the class loader
        try (InputStream inputStream = App.class.getClassLoader().getResourceAsStream("puzzle_input");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                System.out.println("File not found!");
                return;
            }

            String line;

            // Process each line of the file
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    position++;
                    if (ch == '(') {
                        floor++;
                    } else if (ch == ')') {
                        floor--;
                    }

                    // Check if the floor is -1 and record the position if it's the first time
                    if (floor == -1 && !firstEnteredBasement) {
                        System.out.println("First position entering the basement: " + position);
                        firstEnteredBasement = true; // Prevent further prints
                    }
                }
            }

            System.out.println("Final floor: " + floor);
        } catch (

        IOException e) {
            e.printStackTrace();
        }

    }
}
