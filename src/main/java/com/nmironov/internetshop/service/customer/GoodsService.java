package com.nmironov.internetshop.service.customer;


import com.nmironov.internetshop.dto.customer.GoodFilterDto;
import com.nmironov.internetshop.entity.GoodEntity;
import com.nmironov.internetshop.repository.customer.CustomerGoodRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    private final CustomerGoodRepository filteringCustomerGoodRepository;

    public GoodsService(
            CustomerGoodRepository filteringCustomerGoodRepository) {
        this.filteringCustomerGoodRepository = filteringCustomerGoodRepository;
    }


    public List<GoodEntity> getGoodsByFilter(GoodFilterDto goodFilterDto) {

        return filteringCustomerGoodRepository.findByFilter(goodFilterDto);
    }

    public Page<GoodEntity> getAllGoods(PageRequest request) {
        return filteringCustomerGoodRepository.findAll(request);
    }


}

