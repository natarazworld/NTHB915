package com.nt.dao;

public interface OneToOnePKDAO {
    public void saveDataUsingParent();
    public void  loadDataUsingChild();
    public void  removeDataUsingChild();
    
    
}
