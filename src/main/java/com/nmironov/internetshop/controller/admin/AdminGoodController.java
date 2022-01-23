package com.nmironov.internetshop.controller.admin;

import com.nmironov.internetshop.model.Good;
import com.nmironov.internetshop.repository.admin.GoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin/goods")
public class AdminGoodController {

    private static final String goodsUrl = "admin_page_goods";


    private final GoodRepository goodRepository;

    private static final Logger logger = LoggerFactory.getLogger(AdminGoodController.class);


    public AdminGoodController(
            GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }


    @GetMapping("/")
    public String adminPageGoods() {
        return goodsUrl;

    }

    @ModelAttribute("getAllGoods")
    public List<Good> getAllGoods() {
        return goodRepository.getAllGoods();
    }


    @PostMapping(value = "/delete_good/{id}")
    public String deleteGood(@PathVariable("id") Long id) {
        logger.info("DELETING GOOD with ID :{} ", id);
        goodRepository.deleteGood(id);
        return "redirect:/admin/goods/";
    }


}
