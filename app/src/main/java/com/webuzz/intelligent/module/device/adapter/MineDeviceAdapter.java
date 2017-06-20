package com.webuzz.intelligent.module.device.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.module.device.bean.DeviceInfo;

import java.util.List;


public class MineDeviceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

	OnLocalSceneItemClickListener mOnItemClickListener = null;
	private List<DeviceInfo> deviceInfos;
	private View view;

	public MineDeviceAdapter() {
	}

	public MineDeviceAdapter(List<DeviceInfo> scoreCategory) {
		this.deviceInfos = scoreCategory;
	}


	public void setOnItemClickListener(OnLocalSceneItemClickListener listener) {
		this.mOnItemClickListener = listener;
	}

	public void setData(List<DeviceInfo> devices) {
		this.deviceInfos = devices;
		notifyDataSetChanged();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_minedevice, parent, false);
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
		return (deviceInfos != null) ? deviceInfos.size() : 0;
	}

	@Override
	public void onClick(View v) {
		if (mOnItemClickListener != null) {
			mOnItemClickListener.onLocalItemClick(v, (Integer) v.getTag());
		}
	}

	private void bind(ItemViewHolder holder, int position) {
		if (deviceInfos == null)
			return;
		holder.devicenum.setText(deviceInfos.get(position).num);
		holder.status.setText("设备状态：" + deviceInfos.get(position).state);
		holder.baterry.setText("电量" + deviceInfos.get(position).beterry);
		holder.devicestate.setText(deviceInfos.get(position).state);


	}


	public interface OnLocalSceneItemClickListener {
		void onLocalItemClick(View view, int posistion);
	}

	private class ItemViewHolder extends RecyclerView.ViewHolder {
		private TextView devicenum;
		private TextView status;
		private TextView baterry;
		private TextView devicestate;


		private ItemViewHolder(View itemView) {
			super(itemView);
			devicenum = (TextView) itemView.findViewById(R.id.devicenum);
			status = (TextView) itemView.findViewById(R.id.status);
			baterry = (TextView) itemView.findViewById(R.id.baterry);
			devicestate = (TextView) itemView.findViewById(R.id.devicestate);


		}
	}

}
