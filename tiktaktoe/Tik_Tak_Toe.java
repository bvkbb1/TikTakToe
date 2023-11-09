package com.games.tiktaktoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tik_Tak_Toe {
	
	public static List<Integer> playerPositions = new ArrayList<Integer>();
	public static List<Integer> cpuPositions = new ArrayList<Integer>();
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		
		char[][] gameBoard = {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				};
		
		
		printBoard(gameBoard);
		
		while (true) {
			System.out.println("Player choice.....");
			int playerChoice = sc.nextInt();
			if (playerChoice >=1 && playerChoice <= 9) {
				while (playerPositions.contains(playerChoice) || cpuPositions.contains(playerChoice)) {
					System.out.println("hey player already taken...");
					playerChoice = sc.nextInt();
				}
			}
			else {
				System.out.println("please enter the valid number... :(");
				playerChoice = sc.nextInt();
			}
			System.out.println("player choose : "+playerChoice);
			occupy(gameBoard, playerChoice, "player");
			
			String winner = checkWinner();
			if (winner.length() > 0) {
				printBoard(gameBoard);
				System.out.println(winner);
				break;
			}
			
			
			
			
			
			
			
			
			int systemChoice = rand.nextInt(9+1);
			if (systemChoice == 0) {
				systemChoice+=1;
			}
			while (playerPositions.contains(systemChoice) || cpuPositions.contains(systemChoice)) {
				System.out.println("hey cpu already taken...");
				systemChoice = rand.nextInt(9)+1;
			}
			System.out.println("cpu choose : "+systemChoice);
			occupy(gameBoard, systemChoice, "system");
			printBoard(gameBoard);
			
			winner = checkWinner();
			if (winner.length() > 0) {
				printBoard(gameBoard);
				System.out.println(winner);
				break;
			}
			
		}
	}
	


	public static void printBoard(char[][] gameBoard) {
		for (char[] row : gameBoard)
		{
			for (char c : row)
			{
				System.out.print(c);
			}
			System.out.println();
		}	
	}
	
	public static void occupy(char[][] gameBoard, int choice, String player) {
		char ch = ' ';
		if (player.equals("player")) {
			ch = 'X';
			playerPositions.add(choice);
		}
		else {
			ch = 'O';
			cpuPositions.add(choice);
		}
		
		
		switch (choice) {
			case 1: gameBoard[0][0] = ch; break;
			case 2: gameBoard[0][2] = ch; break;
			case 3: gameBoard[0][4] = ch; break;
			case 4: gameBoard[2][0] = ch; break;
			case 5: gameBoard[2][2] = ch; break;
			case 6: gameBoard[2][4] = ch; break;
			case 7: gameBoard[4][0] = ch; break;
			case 8: gameBoard[4][2] = ch; break;
			case 9: gameBoard[4][4] = ch; break;
			default: break;
		}
	}
	
	
	public static String checkWinner()
	{

		// winning chances in a List
		List<List> winner = new ArrayList<>();
		
		winner.add(Arrays.asList(1,2,3));
		winner.add(Arrays.asList(4,5,6));
		winner.add(Arrays.asList(7,8,9));
		
		winner.add(Arrays.asList(1,4,7));
		winner.add(Arrays.asList(2,5,8));
		winner.add(Arrays.asList(3,6,9));
		
		winner.add(Arrays.asList(1,5,9));
		winner.add(Arrays.asList(3,5,7));
		
		for (List l : winner)
		{
			if (playerPositions.containsAll(l))
			{
				return "You won the game :)";
			}
			else if (cpuPositions.containsAll(l))
			{
				return "cpu won the game :-(";
			}
			else if (playerPositions.size()+cpuPositions.size() == 9)
			{
				return "CAT :-)";
			}
		}
		
		return "";
	}
}
