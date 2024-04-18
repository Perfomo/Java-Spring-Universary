package com.toleyko.dao;

import java.io.IOException;

public interface FileSearchDAO {
    public int findAndGetWordFrequence(String word) throws IOException;
}
