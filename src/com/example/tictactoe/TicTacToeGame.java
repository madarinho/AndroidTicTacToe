package com.example.tictactoe;

public class TicTacToeGame {

	private final int BOARD_SIZE = 9;
	//END OF GAME RESULTS
	public static final int TIE = 1111;
	public static final int X_UP_HORIZONTAL = 1112;
	public static final int X_DOWN_HORIZONTAL = 1113;
	public static final int X_LEFT_VERTICAL = 1114;
	public static final int X_RIGHT_VERTICAL = 1115;
	public static final int X_MIDDLE_HORIZONTAL = 1116;
	public static final int X_MIDDLE_VERTICAL = 1117;
	public static final int X_DIAGONAL_DOWN = 1118;
	public static final int X_DIAGONAL_UP = 1119;
	public static final int O_UP_HORIZONTAL = 1120;
	public static final int O_DOWN_HORIZONTAL = 1121;
	public static final int O_LEFT_VERTICAL = 1122;
	public static final int O_RIGHT_VERTICAL = 1123;
	public static final int O_MIDDLE_HORIZONTAL = 1124;
	public static final int O_MIDDLE_VERTICAL = 1125;
	public static final int O_DIAGONAL_DOWN = 1126;
	public static final int O_DIAGONAL_UP = 1127;
	public static final int GAME_IS_ON = 2222;

	private Boolean xTurn; 
	private int counter;

	public TicTacToeGame(){
		setXTurn(true);
		resetCounter();
	}

	public void setMove(MyImageButton ib) {
		if (getXTurn()) // X turn
		{
			ib.setImageResource(R.drawable.x);
			setXTurn(false);
			ib.setEnabled(false);
		}
		else // O turn
		{
			ib.setImageResource(R.drawable.o);
			setXTurn(true);
			ib.setEnabled(false);
		}
	}

	public int checkForWinner(MyImageButton[] IB)
	{
		if (getCounter() <= 4) //no winner before the 5th turn
		{
			return GAME_IS_ON;
		}
		if (IB[0].getImageResource() == R.drawable.x && IB[1].getImageResource() == R.drawable.x && IB[2].getImageResource() == R.drawable.x)
		{
			return X_UP_HORIZONTAL;
		}
		if (IB[3].getImageResource() == R.drawable.x && IB[4].getImageResource() == R.drawable.x && IB[5].getImageResource() == R.drawable.x)
		{
			return X_MIDDLE_HORIZONTAL;
		}
		if (IB[6].getImageResource() == R.drawable.x && IB[7].getImageResource() == R.drawable.x && IB[8].getImageResource() == R.drawable.x)
		{
			return X_DOWN_HORIZONTAL;
		}
		if (IB[0].getImageResource() == R.drawable.o && IB[1].getImageResource() == R.drawable.o && IB[2].getImageResource() == R.drawable.o)
		{
			return O_UP_HORIZONTAL;
		}
		if (IB[3].getImageResource() == R.drawable.o && IB[4].getImageResource() == R.drawable.o && IB[5].getImageResource() == R.drawable.o)
		{
			return O_MIDDLE_HORIZONTAL;
		}
		if (IB[6].getImageResource() == R.drawable.o && IB[7].getImageResource() == R.drawable.o && IB[8].getImageResource() == R.drawable.o)
		{
			return O_DOWN_HORIZONTAL;
		}


		for (int i = 0; i <= 2; i++) // checking for X/O vertical winner
		{
			if (IB[0].getImageResource() == R.drawable.x && IB[3].getImageResource() == R.drawable.x && IB[6].getImageResource() == R.drawable.x)
			{
				return X_LEFT_VERTICAL;
			}
			if (IB[1].getImageResource() == R.drawable.x && IB[4].getImageResource() == R.drawable.x && IB[7].getImageResource() == R.drawable.x)
			{
				return X_MIDDLE_VERTICAL;
			}
			if (IB[2].getImageResource() == R.drawable.x && IB[5].getImageResource() == R.drawable.x && IB[8].getImageResource() == R.drawable.x)
			{
				return X_RIGHT_VERTICAL;
			}
			if (IB[0].getImageResource() == R.drawable.o && IB[3].getImageResource() == R.drawable.o && IB[6].getImageResource() == R.drawable.o)
			{
				return O_LEFT_VERTICAL;
			}
			if (IB[1].getImageResource() == R.drawable.o && IB[4].getImageResource() == R.drawable.o && IB[7].getImageResource() == R.drawable.o)
			{
				return O_MIDDLE_VERTICAL;
			}
			if (IB[2].getImageResource() == R.drawable.o && IB[5].getImageResource() == R.drawable.o && IB[8].getImageResource() == R.drawable.o)
			{
				return O_RIGHT_VERTICAL;
			}
		}

		if (IB[0].getImageResource() == R.drawable.x &&
				IB[4].getImageResource() == R.drawable.x &&
				IB[8].getImageResource() == R.drawable.x)
		{
			return X_DIAGONAL_DOWN;
		}
		if (IB[2].getImageResource() == R.drawable.x &&
				IB[4].getImageResource() == R.drawable.x &&
				IB[6].getImageResource() == R.drawable.x)
		{
			return X_DIAGONAL_UP;
		}
		if (IB[0].getImageResource() == R.drawable.o &&
			IB[4].getImageResource() == R.drawable.o &&
			IB[8].getImageResource() == R.drawable.o) 
		{
			return O_DIAGONAL_DOWN;
		}
		if (IB[2].getImageResource() == R.drawable.o &&
			IB[4].getImageResource() == R.drawable.o &&
			IB[6].getImageResource() == R.drawable.o)
		{
			return O_DIAGONAL_UP;
		}

		if (getCounter()<9) // keep playing because no winner yet
		{
			return GAME_IS_ON;
		}

		return TIE;
	}

	public int getBOARD_SIZE() {
		return BOARD_SIZE;
	}

	public Boolean getXTurn() {
		return xTurn;
	}

	public void setXTurn(Boolean xTurn) {
		this.xTurn = xTurn;
	}

	public void incrementCounter()
	{
		++counter;
	}

	public void resetCounter() {
		counter = 0;
	}

	public int getCounter()
	{
		return counter;
	}
}