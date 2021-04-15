package com.nt.dao;

public interface MToODAO {
   public void saveData();
   public  void deletingAllChildsAndItsParent();
   public   void  deletingOneChildFromCollectionOfChildsBelonginToAParent();
   public void loadDataUsingChild();

}
