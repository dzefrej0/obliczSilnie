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
import java.util.*;


@Controller
public class SilniaController {
    @Autowired
    private SilniaService silniaService;
    @Autowired
    private SilniaRepository silniaRepository;

    public SilniaDB silniaDB;
BigInteger result;
    List<BigInteger> all = new ArrayList<>();




    @RequestMapping(value = "silnia.s", method = RequestMethod.GET)
    public ModelAndView printAll(Model model) throws ServletException, IOException {
        BigInteger zero = BigInteger.valueOf(0);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("silnia1");
        all = silniaService.getAll();
        model.addAttribute("message", "wyświetlenie tej wiadomości oznacza że thymeleaf działa!");
        model.addAttribute("title1", "Oblicz wartość silni");

        SilniaDB silniaDB = new SilniaDB();


//        all.forEach(result -> silniaDB.withResult(result));
//        silniaRepository.save(silniaDB);


        for (BigInteger result:all) {
            silniaDB.withResult(result);
        }
        silniaRepository.save(silniaDB);


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
int zero = 0;
        SilniaDB silniaDB = new SilniaDB();

        if(silniaDB.setNumberForDB(n).equals(BigInteger.ZERO)){
            System.out.println("zero zero");
        }else {
            silniaDB.setNumberForDB(n);
            silniaRepository.save(silniaDB);
        }

        System.out.println("iteracja");
        return new ModelAndView("redirect:silnia.s");
    }

    @RequestMapping(value = "recursion.s", method = RequestMethod.POST)
    public ModelAndView obliczSilniaRekurencja(@RequestParam int n) throws ServletException, IOException {
        silniaService.obliczSilniaRekurencja(n);

        SilniaDB silniaDB = new SilniaDB();

            silniaDB.setNumberForDB(n);
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
