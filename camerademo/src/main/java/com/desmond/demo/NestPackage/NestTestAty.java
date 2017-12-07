package com.desmond.demo.NestPackage;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desmond.demo.R;

import java.util.ArrayList;
import java.util.List;

public class NestTestAty extends AppCompatActivity
{
	RecyclerView vRecycleview;
	MyAdapter adapter;
	List<String>stringList=new ArrayList<>();
	private void logMsg(String msg)
	{
		Log.i("xu",msg);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nest_test_aty);
		vRecycleview= (RecyclerView) findViewById(R.id.recycleview);
		vRecycleview.setLayoutManager(new LinearLayoutManager(this));
		adapter=new MyAdapter();
		vRecycleview.addItemDecoration(new Docration());
		vRecycleview.setAdapter(adapter);
		init();
	}
	void init()
	{
		for(int i=0;i<500;i++)
		{
			stringList.add("data"+i);
		}
		adapter.setData(stringList);
	}
	static class Holder extends RecyclerView.ViewHolder
	{
		TextView textView;
		public Holder(View itemView)
		{
			super(itemView);
			textView= (TextView) itemView.findViewById(android.R.id.text1);
		}
	}
	class MyAdapter extends RecyclerView.Adapter<Holder>
	{
		List<String>stringList=new ArrayList<>();
		@Override
		public Holder onCreateViewHolder(ViewGroup parent, int viewType)
		{
			View view =getLayoutInflater().inflate(android.R.layout.simple_list_item_1,parent,false);
			Holder holder =new Holder(view);
			return holder;
		}

		@Override
		public void onBindViewHolder(Holder holder, int position)
		{
			holder.textView.setText(stringList.get(position));
			holder.itemView.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					ComponentName componetName = new ComponentName(
							//这个是另外一个应用程序的包名
							"cpsdna.roadcloud",
							//这个参数是要启动的Activity
							"cpsdna.roadalbum.activity.HomeActivity");
					Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.addCategory(Intent.CATEGORY_LAUNCHER);
					intent.setComponent(componetName);
					startActivity(intent);
				}
			});
		}
		public void setData(List<String>stringList)
		{
			this.stringList=stringList;
			notifyDataSetChanged();
		}
		@Override
		public int getItemCount()
		{
			return stringList.size();
		}
	}
	class Docration extends RecyclerView.ItemDecoration
	{
		Rect mRect=new Rect();
		Paint mPaint =new Paint();
		public Docration()
		{
			mPaint.setColor(Color.RED);
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
		{
			super.getItemOffsets(outRect, view, parent, state);
			outRect.set(0,100,0,0);
		}

		@Override
		public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state)
		{
			super.onDrawOver(c, parent, state);
			int count =parent.getChildCount();
			for(int i=0;i<count;i++)
			{
				View view=parent.getChildAt(i);
				mRect.set(view.getLeft(),view.getTop()-100,view.getRight(),view.getTop());
				c.drawRect(mRect,mPaint);
				final int adapterPosition = parent.getChildAdapterPosition(view);
				logMsg("view "+i+"top:"+view.getTop()+"--adapterPosition:"+adapterPosition+"height:"+view.getHeight()+"transtionY:"+view.getTranslationY());
			}
		}

		@Override
		public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state)
		{
			super.onDraw(c, parent, state);
		}
	}
}
