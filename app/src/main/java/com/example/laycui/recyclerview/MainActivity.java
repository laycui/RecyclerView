package com.example.laycui.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
  RecyclerView mMainRecyclerView;
  RecyclerView.Adapter mAdapter;

  ClusterController1 mClusterController1;
  ClusterController2 mClusterController2;

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
          mClusterController1 = new ClusterController1(MainActivity.this);
          return new MainHolder(mClusterController1.mRecyclerView, mClusterController1);
        case 1:
          mClusterController2 = new ClusterController2(MainActivity.this);
          return new MainHolder(mClusterController2.mRecyclerView, mClusterController2);
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
    private ClusterController mClusterClusterController;

    MainHolder(View itemView, ClusterController clusterClusterController1) {
      super(itemView);
      mClusterClusterController = clusterClusterController1;
    }

    void bindView() {
      mClusterClusterController.bindView();
    }
  }
}
