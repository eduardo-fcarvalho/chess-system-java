package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	void main() {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
			UI.clearScreen();
			UI.printMatch(chessMatch);
			IO.println();
			IO.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = chessMatch.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces(), possibleMoves);
			IO.println();
			IO.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch (ChessException e) {
				IO.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				IO.println(e.getMessage());
				sc.nextLine();
			}
		}
		
	}
 	
}
