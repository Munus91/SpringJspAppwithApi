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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin/goods")

public class AdminUpdateGoodController {

    private final GoodRepository goodRepository;
    private final CountryRepository countryRepository;

    private static final Logger logger = LoggerFactory.getLogger(AdminUpdateGoodController.class);


    @ModelAttribute("getAllCountries")
    public List<Country> getAllCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    public AdminUpdateGoodController(
            GoodRepository goodRepository,
            CountryRepository countryRepository) {
        this.goodRepository = goodRepository;
        this.countryRepository = countryRepository;
    }


    @GetMapping("/update_good/{goodId}")
    public String loadGood(@PathVariable("goodId") Long id, Model model) {

        model.addAttribute("good_for_update", goodRepository.getGoodById(id));

        return "update_good";

    }


    @RequestMapping(value = "/update_good/", method = RequestMethod.POST)
    public String updateGood(@ModelAttribute("good_for_update") @Valid final Good good,
                             final BindingResult result) {

        logger.info("ENTERED UPDATE GOOD CONTROLLER METHOD");
        if (result.hasErrors()) {
            logger.error("Error while binding result in updateGood!");
            return "update_good";
        }
        goodRepository.updateGood(good);
        return "redirect:/admin/goods/";
    }
}
