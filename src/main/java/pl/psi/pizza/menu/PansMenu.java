package pl.psi.pizza.menu;

import pl.psi.pizza.model.Pan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PansMenu {
    public List<Pan> getPansMenu() {
        ArrayList<Pan> pans = new ArrayList<>();
        pans.add(new Pan("cienkie", new BigDecimal("10.0")));
        pans.add(new Pan("grube", new BigDecimal("12.0")));
        return pans;
    }
}
