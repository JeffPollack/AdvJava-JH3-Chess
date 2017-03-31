package jh3_jdpollac;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;

public class ChessProgram extends JFrame{

	ChessProgram()
	{
		super("Chess Program");
		setSize(800, 600);
		ChessPiece.readInImages(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void paint(Graphics g)
	{      
		super.paint(g);
		Insets insets = getInsets();
		int top = insets.top;
		int bottom = insets.bottom;
		int left = insets.left;
		int right = insets.right;

		int height = getHeight();
		int width = getWidth();

		int cell_h = (height-top-bottom)/8;
		int cell_w = (width-left-right)/8;

		BoardDimensions boardDimensions = new BoardDimensions(left, top, cell_w, cell_h);

		int x,y;

		for (int row=0; row < 8; row++)
		{
			y = top + row*cell_h;
			for (int col=0; col < 8; col++)
			{
				x = left + col*cell_w;
				boolean greenColor = (row+col) %2 == 1;
				if (greenColor)
				{
					g.setColor(Color.green);
				}
				else
				{
					g.setColor(Color.white);
				}
				g.fillRect(x, y, cell_w, cell_h);
			}
		}

		for (int col=0; col < 8; col++)
		{
			Piece p = new Piece(PieceType.Pawn, ColorType.black, col, 1);
			p.drawInPosition(g, boardDimensions);
		}

		for (int col=0; col < 8; col++)
		{
			Piece p = new Piece(PieceType.Pawn, ColorType.white, col, 6);
			p.drawInPosition(g, boardDimensions);
		}

		/*Piece p = new Piece(PieceType.King, ColorType.black, 4, 0);
       p.drawInPosition(g, boardDimensions);
       p = new Piece(PieceType.Queen, ColorType.black, 3, 0);
       p.drawInPosition(g, boardDimensions);
       p = new Piece(PieceType.King, ColorType.white, 4, 7);
       p.drawInPosition(g, boardDimensions);
       p = new Piece(PieceType.Queen, ColorType.white, 3, 7);
       p.drawInPosition(g, boardDimensions);*/
		
		PieceType[] kingRow = {PieceType.Rook, PieceType.Knight, PieceType.Bishop, PieceType.Queen,
				PieceType.King, PieceType.Bishop, PieceType.Knight, PieceType.Rook};
		//ColorType[] color = {ColorType.black, ColorType.white};
		
		
			Piece p = new Piece(kingRow[0],ColorType.white, 0, 7);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[0],ColorType.white, 7, 7);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[1],ColorType.white, 1, 7);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[1],ColorType.white, 6, 7);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[2],ColorType.white, 2, 7);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[2],ColorType.white, 5, 7);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[3],ColorType.white, 3, 7);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[4],ColorType.white, 4, 7);
			p.drawInPosition(g, boardDimensions);
			

			p = new Piece(kingRow[0],ColorType.black, 0, 0);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[0],ColorType.black, 7, 0);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[1],ColorType.black, 1, 0);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[1],ColorType.black, 6, 0);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[2],ColorType.black, 2, 0);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[2],ColorType.black, 5, 0);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[3],ColorType.black, 3, 0);
			p.drawInPosition(g, boardDimensions);
			p = new Piece(kingRow[4],ColorType.black, 4, 0);
			p.drawInPosition(g, boardDimensions);
	

	}

	public static void main(String[] args) {
		ChessProgram cp = new ChessProgram();

	}

}