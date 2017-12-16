package pl.java.projektzespolowy.befit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.java.projektzespolowy.befit.service.PageService;

@Controller
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/")
    public String welcome(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/kalkulator-bmi")
    public String bmi(){
        return "kalkulator-bmi";
    }

    @PostMapping("/kalkulator-bmi")
    public String postBmi(@RequestParam double waga, @RequestParam double wzrost, @RequestParam("group1") char plec, Model model){
        System.out.println(plec);
        double result = pageService.bmi(waga, wzrost, plec);

        model.addAttribute("resultBmi" , "Twoje BMI wynosi: " + result);

        return "kalkulator-bmi";
    }

    @GetMapping("/zapotrzebowanie-kcal")
    public String zapotrzebowanieKcal(){
        return "zapotrzebowanie-kcal";
    }

    @PostMapping("/zapotrzebowanie-kcal")
    public String postZapotrzebowanieKcal(@RequestParam double waga, @RequestParam double wzrost,
                                          @RequestParam("group1") char plec, @RequestParam int wiek, Model model){

        int result = pageService.zapotrzebowanieKcal(waga, wzrost,plec, wiek);

        model.addAttribute("resultZapotrzebowanieKcal", "Twoje zapotrzebowanie Kcal wynosi: " + result);

        return "zapotrzebowanie-kcal";
    }




    @GetMapping("/tkanka-tluszczowa")
    public String tkankaTluszczowa(){
        return "tkanka-tluszczowa";
    }

    @GetMapping("/typ-sylwetki")
    public String typSylwetki(){
        return "typ-sylwetki";
    }

    @GetMapping("/wspolczynnik-whr")
    public String whr(){
        return "wspolczynnik-whr";
    }

    @GetMapping("/tabela-produktow")
    public String tabelaProduktow(){
        return "tabela-produktow";
    }

    @GetMapping("/komponowanie-posilku")
    public String komponowaniePosilku(){
        return "komponowanie-posilku";
    }

    @GetMapping("/spalone-kalorie")
    public String spaloneKalorie(){
        return "spalone-kalorie";
    }

}
