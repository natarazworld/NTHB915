package com.nt.dao;

public interface OneToManyDAO {
       public void saveData();
       public  void loadDataUsingParent();
       public  void loadDataUsingParentAndQBC();
       public  void  deleteDataUsingParent();
       public  void deleteOnlyChildsOfAParent();
       public  void deleteOneChildFromCollectionChildsBelongingToAParent();
       public void  addNewChildForExistingParent();
       public void  TransferChildFromOneParentToAnotherParent();
}
