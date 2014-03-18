package com.example.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import com.example.tictactoe.R;

public class MainActivity extends Activity {

	private TicTacToeGame game;

	private MyImageButton boardImageButtons[];
	private ImageView managerImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		boardImageButtons = new MyImageButton[game.getBOARD_SIZE()];
		boardImageButtons[0]= (MyImageButton) findViewById(R.id.one);
		boardImageButtons[1]= (MyImageButton) findViewById(R.id.two);
		boardImageButtons[2]= (MyImageButton) findViewById(R.id.three);
		boardImageButtons[3]= (MyImageButton) findViewById(R.id.four);
		boardImageButtons[4]= (MyImageButton) findViewById(R.id.five);
		boardImageButtons[5]= (MyImageButton) findViewById(R.id.six);
		boardImageButtons[6]= (MyImageButton) findViewById(R.id.seven);
		boardImageButtons[7]= (MyImageButton) findViewById(R.id.eight);
		boardImageButtons[8]= (MyImageButton) findViewById(R.id.nine);

		managerImageView = (ImageView) findViewById(R.id.manager);

		startNewGame();
	}

	private void startNewGame()
	{
		game = new TicTacToeGame();

		for (int i = 0; i < boardImageButtons.length; i++)
		{
			boardImageButtons[i].setBackgroundResource(R.drawable.empty);
			boardImageButtons[i].setEnabled(true);
			boardImageButtons[i].setOnClickListener(new ImageButtonClickListener(i));
		}

		managerImageView.setBackgroundResource(R.drawable.xplay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void drawLine(int loc1, int loc2, int loc3, int resource) // loc is Loaction to draw
	{
		boardImageButtons[loc1].setImageResource(resource);
		boardImageButtons[loc2].setImageResource(resource);
		boardImageButtons[loc3].setImageResource(resource);
	}

	private class ImageButtonClickListener implements View.OnClickListener
	{
		int location;

		public ImageButtonClickListener(int location)
		{
			this.location = location;
		}

		public void onClick(View view)
		{
			if (boardImageButtons[location].isEnabled())
			{
				game.setMove(boardImageButtons[location]);

				int winner = game.checkForWinner(boardImageButtons);

				switch (winner) {
				case TicTacToeGame.GAME_IS_ON:
					if (game.getXTurn()) // X turn
					{
						boardImageButtons[location].setImageResource(R.drawable.x);
						managerImageView.setBackgroundResource(R.drawable.oplay);
					}
					else // O turn
					{
						boardImageButtons[location].setImageResource(R.drawable.o);
						managerImageView.setBackgroundResource(R.drawable.xplay);
					}
					break;
				case TicTacToeGame.TIE:
					managerImageView.setBackgroundResource(R.drawable.nowin);
					break;
				case TicTacToeGame.X_UP_HORIZONTAL:
					drawLine(0,1,2,R.drawable.horizontal);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.X_MIDDLE_HORIZONTAL:
					drawLine(3,4,5,R.drawable.horizontal);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.X_DOWN_HORIZONTAL:
					drawLine(6,7,8,R.drawable.horizontal);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.O_UP_HORIZONTAL:
					drawLine(0,1,2,R.drawable.horizontal);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				case TicTacToeGame.O_MIDDLE_HORIZONTAL:
					drawLine(3,4,5,R.drawable.horizontal);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				case TicTacToeGame.O_DOWN_HORIZONTAL:
					drawLine(6,7,8,R.drawable.horizontal);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				case TicTacToeGame.X_LEFT_VERTICAL:
					drawLine(0,3,6,R.drawable.vertical);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.X_MIDDLE_VERTICAL:
					drawLine(1,4,7,R.drawable.vertical);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.X_RIGHT_VERTICAL:
					drawLine(2,5,8,R.drawable.vertical);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.O_LEFT_VERTICAL:
					drawLine(0,3,6,R.drawable.vertical);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				case TicTacToeGame.O_MIDDLE_VERTICAL:
					drawLine(1,4,7,R.drawable.vertical);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				case TicTacToeGame.O_RIGHT_VERTICAL:
					drawLine(2,5,8,R.drawable.vertical);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				case TicTacToeGame.X_DIAGONAL_DOWN:
					drawLine(0,4,8,R.drawable.diagonal_down);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.X_DIAGONAL_UP:
					drawLine(2,4,6,R.drawable.diagonal_down);
					managerImageView.setBackgroundResource(R.drawable.xwin);
					break;
				case TicTacToeGame.O_DIAGONAL_DOWN:
					drawLine(0,4,8,R.drawable.diagonal_down);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				case TicTacToeGame.O_DIAGONAL_UP:
					drawLine(2,4,6,R.drawable.diagonal_down);
					managerImageView.setBackgroundResource(R.drawable.owin);
					break;
				}
			}
		}
	}
}
