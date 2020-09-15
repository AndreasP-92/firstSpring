package com.example.demo.controllers;
import com.example.demo.services.DayOfWeek;
import com.example.demo.services.worldSimplestCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
public class myFirstController{
    @GetMapping("/")
    @ResponseBody
    public String frontPage(){
        return "Front page";
    }
    @GetMapping("/Hello")
    @ResponseBody
    public String HelloWorld(){
        return "Hello World";
    }
    @GetMapping("/world")
    @ResponseBody
    public String world(){
        return "worldworldworldworld";
    }



    @GetMapping("/echo")
    @ResponseBody
    public String echo(@RequestParam String phraseToEcho){

        return phraseToEcho;
//        ech?phraseToEcho=Hello
    }

    @GetMapping("/calc")
    @ResponseBody
    public int calc(@RequestParam int inputFromURL){
        worldSimplestCalculator calculator = new worldSimplestCalculator();
        int result = calculator.returnProduct(inputFromURL);
        return result;
//        ech?inputFromURL=10
    }

    @GetMapping("/fredag")
    @ResponseBody
    public String friday(){
        Calendar today = Calendar.getInstance();
        int day = today.get(Calendar.DATE);
        int month = today.get(Calendar.MONTH) + 1;
        int year = today.get(Calendar.YEAR);



        if (month < 3) {
            month += 12;
            year -= 1;
        }

        int k = year % 100;
        int j = year / 100;

// 0 = Lørdag, 1 = Søndag, osv...
        int dayOfWeek = ((day + (((month + 1) * 26) / 10) +
                k + (k / 4) + (j / 4)) + (5 * j)) % 7;
        if(dayOfWeek == 6){
            return "yes";
        }
        return "no";
    }
    @GetMapping("/dayOfTheWeek")
    @ResponseBody
    public String dayOfWeek (){
        DayOfWeek dayObj = new DayOfWeek();
        int day = dayObj.returnDayOfTheWeek();
        if(day == 0){
            return "Lørdag";
        }
        if(day == 1){
            return "Søndag";
        }
        if(day == 2){
            return "Mandag";
        }
        if( day == 3){
            return "Tirsdag";
        }
        if( day == 4){
            return "Onsday";
        }
        if( day == 5){
            return "Torsdag";
        }

        return "Fredag";



    }
}
