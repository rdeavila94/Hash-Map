import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class HashAssignment {

	
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		Hash<String, Integer> h = new Hash<String, Integer>(509);
		BufferedReader reader = new BufferedReader(new FileReader("players_homeruns.csv"));
		try {
			while (reader.ready()) {
				String x = reader.readLine();
				StringTokenizer st = new StringTokenizer(x, ",");
				h.insert(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String input;
		while (true)
		{
			System.out.println("Enter a players name to look for");
			input = sc.nextLine();
			if (input.equals("exit"))
				break;
			else {
				if (h.containsKey(input))
					System.out.println(h.find(input));
				else
					System.out.println("Key is not there.");
			}
				
		}
	}

}

