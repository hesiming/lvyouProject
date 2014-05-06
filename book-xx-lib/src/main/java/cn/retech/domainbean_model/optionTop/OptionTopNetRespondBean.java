package cn.retech.domainbean_model.optionTop;

import java.util.ArrayList;

public class OptionTopNetRespondBean {
  private ArrayList<Operation> mArrayList;

  public OptionTopNetRespondBean(ArrayList<Operation> arrayList) {
    this.mArrayList = arrayList;
  }

  public ArrayList<Operation> getOperationList() {
    return mArrayList;
  }

  public void setOperationList(ArrayList<Operation> arrayList) {
    this.mArrayList = arrayList;
  }
}
