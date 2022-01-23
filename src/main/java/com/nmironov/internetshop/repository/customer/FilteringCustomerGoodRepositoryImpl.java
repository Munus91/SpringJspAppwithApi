package com.nmironov.internetshop.repository.customer;


import com.nmironov.internetshop.dto.customer.GoodFilterDto;
import com.nmironov.internetshop.entity.GoodEntity;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;



@Repository
public class FilteringCustomerGoodRepositoryImpl implements FilteringCustomerGoodRepository {

    @PersistenceContext
    private EntityManager em;

    public List<GoodEntity> findByFilter(GoodFilterDto goodfilterDto) {

        var cb = em.getCriteriaBuilder();
        var criteriaQuery = cb.createQuery(GoodEntity.class);
        var root = criteriaQuery.from(GoodEntity.class);


        //filtering by price
        Predicate predicateForPrice =
                cb.between(root.get("price"), goodfilterDto.getMinPrice(), goodfilterDto.getMaxPrice());


        Predicate finalPredicate = cb.and(predicateForPrice);

        criteriaQuery.where(finalPredicate);

        var query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

}

