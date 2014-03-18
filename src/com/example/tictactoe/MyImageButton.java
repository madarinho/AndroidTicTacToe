package com.example.tictactoe;

import android.content.Context;
import android.widget.ImageButton;

public class MyImageButton extends ImageButton {

	private int imageResource = 0;
	
    public MyImageButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//imageResource = 0;
	}

	

    @Override
    public void setImageResource (int resId) {
        imageResource = resId;
        super.setBackgroundResource(resId);
    }

    public int getImageResource() {
        return imageResource;
    }
}
