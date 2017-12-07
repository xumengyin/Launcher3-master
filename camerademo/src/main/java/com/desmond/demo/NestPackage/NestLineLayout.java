package com.desmond.demo.NestPackage;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/10/12.
 */
public class NestLineLayout extends LinearLayout implements NestedScrollingParent
{
	private static final String TAG = "NestLineLayout";
	public NestLineLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	void logMsg(String msg)
	{
		Log.d(TAG, "Msg:--"+msg);
	}
	int a;
	@Override
	public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes)
	{
		logMsg("onStartNestedScroll--"+child+"---"+target+"---"+nestedScrollAxes);
		return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
	}

	@Override
	public void onNestedScrollAccepted(View child, View target, int axes)
	{
		a=axes;
		logMsg("onNestedScrollAccepted--"+child+"---"+target+"---"+axes);
		//super.onNestedScrollAccepted(child, target, axes);
	}
	int subHeight;
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		subHeight=getChildAt(0).getMeasuredHeight();
//		getChildAt(1).getLayoutParams().height=getMeasuredHeight();
//		setMeasuredDimension(getMeasuredWidth(),getMeasuredHeight()+subHeight);
	}
	@Override
	public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed)
	{
		logMsg("onNestedScroll--"+target+"---dxConsumed"+dxConsumed+"---dyConsumed:"+dyConsumed+"----dxUnconsumed"+dxUnconsumed+"----dyUnconsumed"+dyUnconsumed);
	}

	int curdy;
	@Override
	public void onNestedPreScroll(View target, int dx, int dy, int[] consumed)
	{
		//super.onNestedPreScroll(target,dx,dy,consumed);
//		curdy=curdy+dy;
//		boolean hiden=dy>0&&getScrollY()<subHeight;
//		boolean show=getScrollY()>0&&dy<0&&!ViewCompat.canScrollVertically(target, -1);
//		if(hiden||show)
//		{
			//这里消耗掉dy的话，recycleView就不会滑动了
//			consumed[1]=0;
//			getChildAt(0).offsetTopAndBottom(-dy);
			//scrollBy(0,dy/2);
		//}
		logMsg("onNestedPreScroll--"+target+"---dx"+dx+"---dy"+dy+"consumed[0]:"+consumed[0]+"consumed[1]"+consumed[1]);
	}

	@Override
	public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed)
	{
		logMsg("onNestedFling--"+target+"---velocityX"+velocityX+"---velocityY"+velocityY+"consumed"+consumed);
		//return super.onNestedFling(target, velocityX, velocityY, consumed);
		return false;
	}

	@Override
	public boolean onNestedPreFling(View target, float velocityX, float velocityY)
	{
		logMsg("onNestedPreFling--"+target+"---velocityX:"+velocityX+"---velocityY:"+velocityY);
		//return super.onNestedPreFling(target, velocityX, velocityY);
		return false;
	}

	@Override
	public void onStopNestedScroll(View child)
	{
		logMsg("onStopNestedScroll--"+child);
		//super.onStopNestedScroll(child);
	}

	@Override
	public int getNestedScrollAxes()
	{
		logMsg("getNestedScrollAxes");
		//return super.getNestedScrollAxes();
		return a;
	}
}
