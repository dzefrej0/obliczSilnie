package com.eonetworks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Controller
public class SilniaController {
private SilniaService silniaService;



    @RequestMapping(value = "silnia.s")
    public ModelAndView printAll() throws ServletException, IOException {
//        List<BigInteger> all = silniaService.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("silnia1");
//        mav.addObject("silniaList", all);
        return mav;
    }


    @RequestMapping(value  = "/index")
    public ModelAndView wypisz(Model model){
        model.addAttribute("message", "wyświetlenie tej wiadomości oznacza że thymeleaf działa!");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }


}
