package rs.ac.uns.ftn.sep.nc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping({"/"})
    public String getFrontendPage() {
        return "index.html";
    }

}
