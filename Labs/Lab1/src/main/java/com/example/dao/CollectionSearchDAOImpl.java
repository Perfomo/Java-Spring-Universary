package com.toleyko.dao;

import java.util.concurrent.ConcurrentHashMap;

public class CollectionSearchDAOImpl implements CollectionSearchDAO {

    private ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    {
        concurrentHashMap.put("Kirill", "molodec");
        concurrentHashMap.put("Nastya", "kakashka");
        concurrentHashMap.put("Misha", "businessman");
        concurrentHashMap.put("Dima", "realMan");
    }
    @Override
    public String findInfo(String key) {
        return concurrentHashMap.get(key);
    }

    @Override
    public void changeInfo(String key, String info) {
        concurrentHashMap.replace(key, info);
    }
}
