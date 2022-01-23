package com.nmironov.internetshop.repository.customer;

import com.nmironov.internetshop.entity.GoodEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerGoodRepository
        extends PagingAndSortingRepository<GoodEntity, Long>, FilteringCustomerGoodRepository {

    //we connected functionality of repositories in one to inherrit
}
