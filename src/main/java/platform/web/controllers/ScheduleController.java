package platform.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {


    @GetMapping("")
    String list(){
        return "";
    }


    String commit(){
        return "";
    }




}
