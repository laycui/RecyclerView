package com.example.laycui.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

class ClusterController1 implements ClusterController {
  private Context mContext;
  private Adapter11 mAdapter11;
  RecyclerView mRecyclerView;

  ClusterController1(Context context) {
    mContext = context;
    mAdapter11 = new Adapter11();
    mRecyclerView = new RecyclerView(mContext);
    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
    mRecyclerView.setAdapter(mAdapter11);
  }

  @Override
  public void bindView() {
    mAdapter11.notifyDataSetChanged();
  }


  class Adapter11 extends RecyclerView.Adapter<Holder11> {
    @Override
    public Holder11 onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(mContext);
      View view = layoutInflater.inflate(R.layout.second_level_holder1, parent, false);
      return new Holder11(view);
    }

    @Override
    public void onBindViewHolder(Holder11 holder, int position) {
      holder.bindView(position);
    }

    @Override
    public int getItemCount() {
      return Data.getData().getButtons().size();
    }
  }

  static class Holder11 extends RecyclerView.ViewHolder {
    Button mButton;

    Holder11(View itemView) {
      super(itemView);
      mButton = itemView.findViewById(R.id.second_level_title1);
    }

    void bindView(int position) {
      mButton.setText(Data.getData().getButtons().get(position));
    }
  }
}
