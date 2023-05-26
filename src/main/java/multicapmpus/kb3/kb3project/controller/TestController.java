package multicapmpus.kb3.kb3project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/jspTest")
    public String test() {
        System.out.println("test성공");
        return "jspTest";
    }

}
