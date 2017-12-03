package com.example.laycui.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class Data {

  private List<String> mButtons;
  private List<String> mTexts;

  private static Data sData;

  public static Data getData() {
    if (sData == null) {
      sData = new Data();
    }
    return sData;
  }

  public Data() {
    mButtons = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      mButtons.add("Button " + i);
    }

    mTexts = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      mTexts.add("Text " + i);
    }
  }

  List<String> getButtons() {
    return mButtons;
  }

  List<String> getTexts() {
    return mTexts;
  }
}
