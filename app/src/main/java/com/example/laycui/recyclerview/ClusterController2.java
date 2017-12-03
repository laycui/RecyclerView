package com.example.laycui.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class ClusterController2 implements ClusterController {
  private Context mContext;
  private Adapter22 mAdapter22;
  RecyclerView mRecyclerView;

  ClusterController2(Context context) {
    mContext = context;
    mAdapter22 = new Adapter22();
    mRecyclerView = new RecyclerView(mContext);
    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
    mRecyclerView.setAdapter(mAdapter22);
  }

  @Override
  public void bindView() {
    mAdapter22.notifyDataSetChanged();
  }


  class Adapter22 extends RecyclerView.Adapter<Holder22> {
    @Override
    public Holder22 onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(mContext);
      View view = layoutInflater.inflate(R.layout.second_level_holder2, parent, false);
      return new Holder22(view);
    }

    @Override
    public void onBindViewHolder(Holder22 holder, int position) {
      holder.bindView(position);
    }

    @Override
    public int getItemCount() {
      return Data.getData().getTexts().size();
    }
  }

  static class Holder22 extends RecyclerView.ViewHolder {
    TextView mTextView;

    Holder22(View itemView) {
      super(itemView);
      mTextView = itemView.findViewById(R.id.second_level_title2);
    }

    void bindView(int position) {
      mTextView.setText(Data.getData().getTexts().get(position));
    }
  }
}
