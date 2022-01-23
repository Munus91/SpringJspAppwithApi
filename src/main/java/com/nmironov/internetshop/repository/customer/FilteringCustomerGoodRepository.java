package com.nmironov.internetshop.repository.customer;

import com.nmironov.internetshop.dto.customer.GoodFilterDto;
import com.nmironov.internetshop.entity.GoodEntity;

import java.util.List;

public interface FilteringCustomerGoodRepository {
    List<GoodEntity> findByFilter(GoodFilterDto filter);

}
