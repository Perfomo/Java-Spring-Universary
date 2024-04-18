package com.toleyko.dao;

public interface CollectionSearchDAO {
    public String findInfo(String key);
    public void changeInfo(String key, String info);
}
