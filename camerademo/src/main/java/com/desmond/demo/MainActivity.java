package com.desmond.demo;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.desmond.squarecamera.CameraActivity;
import com.desmond.squarecamera.ImageUtility;


public class MainActivity extends AppCompatActivity
{

	private static final int REQUEST_CAMERA = 0;
	private static final int REQUEST_CAMERA_PERMISSION = 1;
	private Point mSize;
	View cover;
	RectentPrgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Display display = getWindowManager().getDefaultDisplay();
		mSize = new Point();
		display.getSize(mSize);
		cover = findViewById(R.id.cover);
//		progressBar= (RectentPrgressBar) findViewById(R.id.progressbar);
//		progressBar.post(new Runnable()
//		{
//			@Override
//			public void run()
//			{
//				progressBar.startAnimator();
//			}
//		});
//		progressBar.setOnClickListener(new View.OnClickListener()
//		{
//			@Override
//			public void onClick(View v)
//			{
//				progressBar.startAnimator();
//			}
//		});
//		new Handler().postDelayed(new Runnable()
//		{
//			@Override
//			public void run()
//			{
//				ObjectAnimator ani=ObjectAnimator.ofFloat(cover, "translationY", 0, 400).setDuration(1000);
//				ani.setInterpolator(new LinearInterpolator());
//				ani.start();
//			}
//		}, 5000);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (resultCode != RESULT_OK) return;

		if (requestCode == REQUEST_CAMERA)
		{
			Uri photoUri = data.getData();
			// Get the bitmap in according to the width of the device
			Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(photoUri.getPath(), mSize.x, mSize.x);
			((ImageView) findViewById(R.id.image)).setImageBitmap(bitmap);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void requestForCameraPermission(View view)
	{
		final String permission = Manifest.permission.CAMERA;
		if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
				!= PackageManager.PERMISSION_GRANTED)
		{
			if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission))
			{
				showPermissionRationaleDialog("Test", permission);
			} else
			{
				requestForPermission(permission);
			}
		} else
		{
			launch();
		}
	}

	private void showPermissionRationaleDialog(final String message, final String permission)
	{
		new AlertDialog.Builder(MainActivity.this)
				.setMessage(message)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						MainActivity.this.requestForPermission(permission);
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{

					}
				})
				.create()
				.show();
	}

	private void requestForPermission(final String permission)
	{
		ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, REQUEST_CAMERA_PERMISSION);
	}

	private void launch()
	{
		Intent startCustomCameraIntent = new Intent(this, CameraActivity.class);
		startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
	{
		switch (requestCode)
		{
			case REQUEST_CAMERA_PERMISSION:
				final int numOfRequest = grantResults.length;
				final boolean isGranted = numOfRequest == 1
						&& PackageManager.PERMISSION_GRANTED == grantResults[numOfRequest - 1];
				if (isGranted)
				{
					launch();
				}
				break;

			default:
				super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		}
	}
}
