package com.nt.dao;

public interface OneToManyBiDAO {
    public void saveDataUsingParent();
    public void saveDataUsingChilds();
    public  void loadDataUsingParent();
}
