package main;

import controller.BoardController;
import model.board.Board;
import model.board.Cell;
import model.player.Player;
import view.BoardView;

public class Facade {

//private 	Board board;
//	BoardView boardview;
	
	public Facade(){
	
	//	boardView =new BoardView(null);
		
	}
	
	
	public void   initializeBoard(){
		
		Board board = new Board();
		BoardView boardView = new BoardView(board);
		BoardController boardController = new BoardController(board, boardView);
	}
	
/*
public Board copyBoard()
	{
	return board.copyBoard();
	}
	
	public void placeUnits(Player[] players)
	{
		board.placeUnits(players);	
		
	}
	
	public int getX()
	{
		return board.getX();
	}
	
	public int getY()
	{
		return board.getY();
	}
	
	public Cell getCell(int x, int y)
	{
	          return  board.getCell(x, y);
	}
	
	public Cell[][] getAllCells()
	{
		
		
		return board.getAllCells();
	}
	
	public void setAllCells(Cell[][] cells)
	{
		board.setAllCells(cells);
	}*/
	
	
	
	
	
	
}
