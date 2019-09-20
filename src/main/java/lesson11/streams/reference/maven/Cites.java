package lesson11.streams.reference.maven;

import java.util.*;

class Cites{
    private Map<String,City> cities;

    Cites() {
        this.cities = new HashMap<>();
    }

    boolean isHere(String name){
        return cities.containsKey(name);
    }

    City getCity(String name) {
        return cities.get(name);
    }
    void addCity(String name, City city) {
        cities.put(name,city);
    }
}

