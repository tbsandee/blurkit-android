package com.wonderkiln.blurkit.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wonderkiln.blurkit.BlurLayout;

/**
 * Created by tsandee on 11/29/16.
 */

public class TestFragment extends Fragment {
  final private Handler mHandler = new Handler();
  public TestFragment() {
  }

  private BlurLayout mBlurLayout;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mBlurLayout = (BlurLayout)getView().findViewById(R.id.blurlayout);
    mBlurLayout.pauseBlur();
  }

  @Override
  public void onResume() {
    super.onResume();

    mHandler.postDelayed(new Runnable() {
      @Override
      public void run() {
        mBlurLayout.startBlur();

        mHandler.post(new Runnable() {
          @Override
          public void run() {
            mBlurLayout.lockView();
          }
        });
      }
    }, 350);
  }
}
