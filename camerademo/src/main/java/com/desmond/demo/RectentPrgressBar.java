package com.desmond.demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/9/21.
 */
public class RectentPrgressBar extends View
{
	Paint mPaint;
	Path mPath = new Path();
	int width, height;
	private boolean isInitPath = false;
	long duration = 10*1000;
	PathMeasure measure;
	Path dst=new Path();
	ProgressCallBack mCallBack;
	public RectentPrgressBar(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
		setLayerType(View.LAYER_TYPE_SOFTWARE, null);
	}

	private void init()
	{
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.BLACK);
		mPaint.setStrokeWidth(15);
		//mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setAntiAlias(true);
	}

	public void setDuration(int second)
	{
		this.duration = second;
	}
	ValueAnimator ani;
	public void stopAnimator()
	{
		if(ani!=null)
		{
			ani.cancel();
			dst.reset();
			ani=null;
		}
	}
	public void startAnimator()
	{
		stopAnimator();
		ani=ValueAnimator.ofFloat(0, duration);
		final float pathLength=measure.getLength();
		ani.setDuration(duration);
		ani.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
		{
			@Override
			public void onAnimationUpdate(ValueAnimator animation)
			{
				float value= (float) animation.getAnimatedValue();
				dst.reset();
				measure.getSegment(0,value/duration*pathLength,dst,true);
				invalidate();
			}
		});
		ani.addListener(new AnimatorListenerAdapter()
		{
			@Override
			public void onAnimationEnd(Animator animation)
			{
				super.onAnimationEnd(animation);
				if(mCallBack!=null)
				{
					mCallBack.animateEnd();
				}
			}
		});
		ani.start();
	}
	private void initPath()
	{
		if (!isInitPath && (width != 0 && height != 0))
		{
			mPath.reset();
			mPath.addRect(0, 0, width, height, Path.Direction.CW);
			measure=new PathMeasure(mPath,false);
//			mPath.moveTo(0,0);
//			mPath.lineTo(width,0);
//			mPath.lineTo(width,height);
//			mPath.lineTo(0,height);
//			mPath.close();
			isInitPath = true;

		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		initPath();
	}


	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawPath(dst, mPaint);
	}
	public interface ProgressCallBack
	{
		void animateEnd();
	}
}
