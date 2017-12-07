package com.desmond.demo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContranistActivity extends AppCompatActivity
{
	View banner;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_constraint);
		banner=findViewById(R.id.banner);
		findViewById(R.id.tab1).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ObjectAnimator ani =ObjectAnimator.ofFloat(banner,"transitionY",0,200);
				ani.setDuration(2000);
				ani.start();
			}
		});
	}
}
