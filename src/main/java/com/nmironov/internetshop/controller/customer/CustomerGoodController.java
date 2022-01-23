package com.nmironov.internetshop.controller.customer;


import com.nmironov.internetshop.dto.customer.GoodFilterDto;
import com.nmironov.internetshop.entity.GoodEntity;
import com.nmironov.internetshop.service.customer.GoodsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



/*
SOURCE URL
http://localhost:8080/customer/goods/?limit=10&pageNo=1&name=iPhone&category=Smartphones&minPrice=50000&maxPrice=150000&brand=Apple&orderBy=price.desc


MY URL
http://localhost:8080/customer/goods/?limit=10&pageNo=1&name=iPhone&category=Smartphones&minPrice=50000&maxPrice=150000&trademark=Apple&sortBy=price.desc

http://localhost:8080/customer/goods/?limit=10&pageNo=1&minPrice=50000&maxPrice=150000

http://localhost:8080/customer/goods/filter?limit=10&&minPrice=50000&maxPrice=150000&pageNo=1


http://localhost:8080/customer/goods/filter?limit=10&&minPrice=50000&maxPrice=150000&sortBy=ASC&pageNo=1
 */

@RestController
@RequestMapping("/customer/goods")
public class CustomerGoodController {

    private final GoodsService goodsService;

    public CustomerGoodController(
            GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping(value = "/filter")
    public List<GoodEntity> getGoods(
            @RequestParam("minPrice") BigDecimal minPrice,
            @RequestParam("maxPrice") BigDecimal maxPrice,
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("limit") Integer limit

    ) {

        var pageRequest = PageRequest.of(pageNo, limit);

        var filter =
                new GoodFilterDto(minPrice, maxPrice,
                        pageRequest);
        return this.goodsService.getGoodsByFilter(filter);
    }


}

