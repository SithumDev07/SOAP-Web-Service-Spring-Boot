package lk.ac.kln.soap;

import lk.ac.kln.gen.Country;
import lk.ac.kln.gen.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Sri Lanka");
        spain.setCapital("Colombo");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(1234444);

        countries.put(spain.getName(), spain);

        Country india = new Country();
        india.setName("India");
        india.setCapital("Delhi");
        india.setCurrency(Currency.PLN);
        india.setPopulation(455657557);

        countries.put(india.getName(), india);

        Country tailand = new Country();
        tailand.setName("Tailand");
        tailand.setCapital("Mukbung");
        tailand.setCurrency(Currency.GPG);
        tailand.setPopulation(343434343);

        countries.put(tailand.getName(), tailand);
    }

    public Country findCountryByName(final String name) {
        Assert.notNull(name, "The country's name should not be null");
        return countries.get(name);
    }
}
