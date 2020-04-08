package pl.nieporobieni.wujaapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.*;

@Controller
public class MainController {

    LocalDate arrivalDate = LocalDate.of(2020, 9, 12);

    public Long daysToArrival(){
        return DAYS.between(LocalDate.now(),arrivalDate);
    }

    @RequestMapping("/wuja/days")
    public String daysPage(Model model){
        model.addAttribute("daysToArrival", daysToArrival());
        return "days";
    }

    @RequestMapping("/wuja")
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/redirectToDays")
    public String redirectToDays(){
        return "redirect:/wuja/days";
    }


}
