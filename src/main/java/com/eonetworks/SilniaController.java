package com.eonetworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Controller
public class SilniaController {
private SilniaService silniaService;
@Autowired
public SilniaController(SilniaService silniaService) {this.silniaService = silniaService;}
    public List<BigInteger> outputx = new ArrayList<BigInteger>();


//    @ModelAttribute("allOpts")
//    public List<SilniaService> populateDropBox()
//    {
//        return Arrays.asList(silniaService.getAll());
//    }



    @RequestMapping(value = "silnia.s", method = RequestMethod.GET)
    public ModelAndView printAll(Model model) throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("silnia1");
        List<BigInteger> all = silniaService.getAll();
        mav.addObject("silniaList", all);
        model.addAttribute("message", "wyświetlenie tej wiadomości oznacza że thymeleaf działa!");
        model.addAttribute("title1", "Oblicz wartość silni");
        return mav;
    }



    @RequestMapping(value = "iterating.s", method = RequestMethod.POST)
    public ModelAndView liczIteracja(@RequestParam int n) throws ServletException, IOException {
        silniaService.liczIteracja(n);
        return new ModelAndView("redirect:silnia.s");
    }

    @RequestMapping(value = "recursion.s", method = RequestMethod.POST)
    public ModelAndView obliczSilniaRekurencja(@RequestParam int n) throws ServletException, IOException {
       silniaService.obliczSilniaRekurencja(n);
        if (n > 12000) {
            throw new ArithmeticException("maxymalna wartość dla metody rkurencyjnej to 12000");
        }
        return new ModelAndView("redirect:silnia.s");
    }

















    @RequestMapping(value  = "/index")
    public ModelAndView wypisz(Model model){
        model.addAttribute("message", "wyświetlenie tej wiadomości oznacza że thymeleaf działa!");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }


}
