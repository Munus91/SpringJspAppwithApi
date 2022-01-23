package com.nmironov.internetshop.repository.admin;

import com.nmironov.internetshop.model.Good;

import java.util.List;

public interface GoodRepository {

    Good getGoodById(Long id);

    List<Good> getAllGoods();

    void addGood(Good good);

    void deleteGood(Long goodId);

    void updateGood(Good good);
}

