package com.example.laycui.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  RecyclerView mMainRecyclerView;
  RecyclerView.Adapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mMainRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
    mMainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mAdapter = new MainAdapter();
    mMainRecyclerView.setAdapter(mAdapter);
  }


  private class MainAdapter extends RecyclerView.Adapter<MainHolder> {
    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      switch (viewType) {
        case 0:
          RecyclerView mRecyclerView1 = new RecyclerView(MainActivity.this);
          mRecyclerView1.setLayoutManager(
              new LinearLayoutManager(
                  MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
          ClusterController1 clusterController1 =
              new ClusterController1(getApplicationContext());
          return new MainHolder(mRecyclerView1, clusterController1);
        case 1:
          RecyclerView mRecyclerView2 = new RecyclerView(MainActivity.this);
          mRecyclerView2.setLayoutManager(
              new LinearLayoutManager(
                  MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
          ClusterController2 clusterController2 =
              new ClusterController2(getApplicationContext());
          return new MainHolder(mRecyclerView2, clusterController2);
        default:
          return null;
      }
    }

    @Override
    public int getItemViewType(int position) {
      return position % 2;
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
      holder.bindView();
    }

    @Override
    public int getItemCount() {
      return 100;
    }
  }

  private class MainHolder extends RecyclerView.ViewHolder {
    RecyclerView mSubRecyclerView;
    RecyclerView.Adapter mSubAdapter;

    MainHolder(View itemView, RecyclerView.Adapter adapter) {
      super(itemView);
      mSubAdapter = adapter;
      mSubRecyclerView = (RecyclerView) itemView;
      mSubRecyclerView.setAdapter(mSubAdapter);
    }

    void bindView() {
      mSubRecyclerView.getAdapter().notifyDataSetChanged();
    }
  }
}
