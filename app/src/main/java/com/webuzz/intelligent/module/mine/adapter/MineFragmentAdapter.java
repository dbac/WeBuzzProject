package com.webuzz.intelligent.module.mine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.module.mine.bean.ScoreCategory;

import java.util.List;


public class MineFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

	OnLocalSceneItemClickListener mOnItemClickListener = null;
	private List<ScoreCategory> scoreCategory;
	private View view;

	public MineFragmentAdapter() {
	}

	public MineFragmentAdapter(List<ScoreCategory> scoreCategory) {
		this.scoreCategory = scoreCategory;
	}


	public void setOnItemClickListener(OnLocalSceneItemClickListener listener) {
		this.mOnItemClickListener = listener;
	}

	public void setData(List<ScoreCategory> devices) {
		this.scoreCategory = devices;
		notifyDataSetChanged();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_minefg_score, parent, false);
		ItemViewHolder holder = new ItemViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if (holder instanceof ItemViewHolder) {
			bind((ItemViewHolder) holder, position);
		}
	}

	@Override
	public int getItemCount() {
		return (scoreCategory != null) ? scoreCategory.size() : 0;
	}

	@Override
	public void onClick(View v) {
		if (mOnItemClickListener != null) {
			mOnItemClickListener.onLocalItemClick(v, (Integer) v.getTag());
		}
	}

	private void bind(ItemViewHolder holder, int position) {
		if (scoreCategory == null)
			return;
		holder.category.setText(scoreCategory.get(position).category);
		holder.score.setText(scoreCategory.get(position).score);
	}


	public interface OnLocalSceneItemClickListener {
		void onLocalItemClick(View view, int posistion);
	}

	private class ItemViewHolder extends RecyclerView.ViewHolder {
		private TextView category;
		private TextView score;

		private ItemViewHolder(View itemView) {
			super(itemView);
			category = (TextView) itemView.findViewById(R.id.category);
			score = (TextView) itemView.findViewById(R.id.score);
		}
	}

}
