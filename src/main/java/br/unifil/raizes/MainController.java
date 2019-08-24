package br.unifil.raizes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    public static final String EQUACAO = "equacao";

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute(EQUACAO, new Equacao());
        return "index";
    }

}
