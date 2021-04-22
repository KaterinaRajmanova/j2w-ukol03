package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> seznamVizitek;

    public VizitkaController() {
        seznamVizitek = Arrays.asList(
                new Vizitka("Kateřina Rajmanová", "FyzioBe", "Lesní 221", "Bučovice 685 01", "email@email.com", "123 456 789", null),
                new Vizitka("Petr Sova", "Sovinec", "U Červeného mlýna 14", "Brno 612 00", "soma@email.com", "543 345 876", "www.sova.com"),
                new Vizitka("Jiří Anděl", "Spánek v oblacíh", "Nebeská 522", "Zlín 760 01", "andel@email.com", null, "www.andel.com"),
                new Vizitka("Gabriela Horká", "Čistírna", "Spálená 669", "Dambořice 696 35", "cistepradlo@email.com", "234 890 787", "www.cistepradlo.com"),
                new Vizitka("Ella Mokrá", "Meleme", "Vodní 949", "Vracov 696 42", null, "234 789 657", "www.meleme.com")

        );
    }


    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("vizitky", seznamVizitek);
        return result;
    }

    @GetMapping("/detail")
    public ModelAndView detail(int id) {
        ModelAndView result = new ModelAndView("detail");
        result.addObject("detailVizitky", seznamVizitek.get(id));
        return result;
    }
}
