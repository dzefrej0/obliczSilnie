package com.eonetworks;

import com.eonetworks.SilniaDatabase.SilniaDB;
import com.eonetworks.SilniaDatabase.SilniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SilniaController {
    @Autowired
    private SilniaService silniaService;
    @Autowired
    private SilniaRepository silniaRepository;

    public SilniaDB silniaDB;


    @RequestMapping("/db")
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        SilniaDB silniaDB = new SilniaDB()
                .setNumberForDB(23);
        silniaRepository.save(silniaDB);
        
        for (SilniaDB i : silniaRepository.findAll()) {
            response.append(i).append("<br>");
        }  return response.toString();
    }

    @RequestMapping(value = "silnia.s", method = RequestMethod.GET)
    public ModelAndView printAll(Model model) throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("silnia1");
        List<BigInteger> all = silniaService.getAll();
        model.addAttribute("message", "wyświetlenie tej wiadomości oznacza że thymeleaf działa!");
        model.addAttribute("title1", "Oblicz wartość silni");

        for (BigInteger result: all) {



        SilniaDB silniaDB = new SilniaDB()
             .withResult(result);
        silniaRepository.save(silniaDB);
    }
        try {
            Map<String, String> sampleDropdownMap = new HashMap<String, String>();
            sampleDropdownMap.put("wybierz metodę iteracyjną", "ChooseIterating");
            sampleDropdownMap.put("wybierz metodę rekurencyjną", "ChooseRecurency");

            mav = new ModelAndView("silnia1", "dropDownItems", sampleDropdownMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("silniaList", all);
        return mav;
    }

    @RequestMapping(value = "iterating.s", method = RequestMethod.POST)
    public ModelAndView liczIteracja(@RequestParam int n) throws ServletException, IOException {
        silniaService.liczIteracja(n);
        
        SilniaDB silniaDB = new SilniaDB()
                .setNumberForDB(n);
        silniaRepository.save(silniaDB);


        System.out.println("iteracja");
        return new ModelAndView("redirect:silnia.s");
    }

    @RequestMapping(value = "recursion.s", method = RequestMethod.POST)
    public ModelAndView obliczSilniaRekurencja(@RequestParam int n) throws ServletException, IOException {
        silniaService.obliczSilniaRekurencja(n);

        SilniaDB silniaDB = new SilniaDB()
                .setNumberForDB(n);
        silniaRepository.save(silniaDB);


        System.out.println("rekurencja");
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
