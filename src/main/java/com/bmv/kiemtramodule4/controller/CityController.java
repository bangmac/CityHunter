package com.bmv.kiemtramodule4.controller;

import com.bmv.kiemtramodule4.model.City;
import com.bmv.kiemtramodule4.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public ModelAndView showList() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

//    public String search(@RequestParam("term") String term, Model model) {
//        if (StringUtils.isEmpty(term)) {
//            return "redirect:/city";
//        }
//
//        model.addAttribute("cities", cityService.findByNameContaining(term.get());
//        return "list";
//    }

    @GetMapping("/city/add")
    public ModelAndView add(){
        City city = new City();
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/city/save")
    public String save(@Valid City city, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        cityService.save(city);
        redirect.addFlashAttribute("successMessage", "Saved City successfully!");
        return "redirect:/city";
    }

    @GetMapping("/city/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("city", cityService.findById(id));
        return "form";
    }

    @GetMapping("/city/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        cityService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted City successfully!");
        return "redirect:/city";
    }
}