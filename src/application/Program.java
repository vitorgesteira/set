package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		/* o conjunto set � indicado para a solu��o pois o conjunto nao permite repeti�oes
		 * usou a instancia��o HashSet pois � mais rapido e no caso nao precisa de ordena��o*/

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>();//cria o conjunto set
			
			String line = br.readLine();//ler a primeira linha
			
			while(line != null) {//se line nao retornar null
				String[] fields = line.split(" ");//recorta a linha com base no espa�o em branco
				String username = fields[0];
				Date moments = Date.from(Instant.parse(fields[1]));//transforma o ISO 8601 em date normal
				
				set.add(new LogEntry(username, moments));//instancia o LogEntry add no conjunto set
				
				line = br.readLine();//ler a proxima linha
			}
			
			System.out.println("Total users: " + set.size());//imprimi o tamanho da lista
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
