package com.nt.dao;

public interface OneToManyBiDAO {
    public void loadDataUsingParentToChildJoins();
    public void loadDataUsingChildToParentJoins();
    public  void  loadDataUsingParent();
    public  void  loadDataUsingParentUsingFetch();
    public  void  loadDataUsingParentAndQBC();
    public  void loadDataForDirtyCheck();
    
  
}
