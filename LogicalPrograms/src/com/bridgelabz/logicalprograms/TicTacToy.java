package com.bridgelabz.logicalprograms;

import java.util.Scanner;

public class TicTacToy {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// creating instance of game
		Game game = new Game();
		game.intializeBoard();
		System.out.println("tictoktoy....");
		do {
			game.printBoard();
			int row;// declaring row and col variable
			int col;
			do {
				System.out
						.println("player " + game.currentPlayer() + " enter in empty row and column to place a mark ");
				row = sc.nextInt();// assigning the value to row and col
				col = sc.nextInt();
				sc.close();

			} while (!game.placeMark(row, col));
			game.changePlayer();

		} while (!(game.isWinner()) && !(game.isBoardFull()));// checking wheather player has won or not
																// board is full or not
		if (game.isBoardFull() && !game.isWinner()) {
			System.out.println("The game was a tie!");
		}
		System.out.println("Current board layout:");
		game.printBoard();
		game.changePlayer();
		System.out.println(Character.toUpperCase(game.currentPlayer()) + " Wins!");

	}

}
