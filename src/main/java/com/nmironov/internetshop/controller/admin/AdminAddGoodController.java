package com.nmironov.internetshop.controller.admin;

import com.nmironov.internetshop.model.Country;
import com.nmironov.internetshop.model.Good;
import com.nmironov.internetshop.repository.admin.CountryRepository;
import com.nmironov.internetshop.repository.admin.GoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;



@Controller
@RequestMapping("/admin/goods")
public class AdminAddGoodController {

    private final GoodRepository goodRepository;
    private final CountryRepository countryRepository;

    private static final Logger logger = LoggerFactory.getLogger(AdminUpdateGoodController.class);

    private static final String GOODS_URL = "admin_page_goods";

    public AdminAddGoodController(
            GoodRepository goodRepository,
            CountryRepository countryRepository) {
        this.goodRepository = goodRepository;
        this.countryRepository = countryRepository;
    }

    @ModelAttribute("getAllCountries")
    public List<Country> getAllCountries() {
        return (List<Country>) countryRepository.findAll();
    }


    @GetMapping("/add_good/")
    public String loadGood(Model model) {

        model.addAttribute("good_for_add", new Good());

        return "add_good";

    }


    @RequestMapping(value = "/add_good/", method = RequestMethod.POST)
    public String addGood(@ModelAttribute("good_for_add") @Valid final Good good,
                          final BindingResult result, Model model) {
        logger.info("ENTERED ADD GOOD CONTROLLER METHOD");
        if (result.hasErrors()) {
            logger.error("Error while binding result in addGood!");
            return "add_good";
        }
        goodRepository.addGood(good);

        return "redirect:/admin/goods/";
    }
}
