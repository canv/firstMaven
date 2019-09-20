package lesson11.streams.reference.maven;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

class City{
    private final String cityName;
    private Set<Park> cityParks;
    private Set<Street> cityStreets;
    private Set<District> cityDistricts;

    City(String cityName) {
        this.cityName = cityName;
        this.cityParks = new HashSet<>();
        this.cityStreets = new HashSet<>();
        this.cityDistricts = new HashSet<>();
    }

    String getCityName() {
        return cityName;
    }
    Set<Park> getCityParks() {
        return cityParks;
    }
    Set<Street> getCityStreets() {
        return cityStreets;
    }
    Set<District> getCityDistricts() {
        return cityDistricts;
    }

    void addSector(Park park){
        cityParks.add(park);
    }
    void addSector(Street street){
        cityStreets.add(street);
    }
    void addSector(District district){
        cityDistricts.add(district);
    }

    static void addDamage(Set<? extends CitySet> city, String sectorName, UUID damageID, int damageLength, int DamageWidth){
        for (CitySet point : city) {
            if (sectorName.equals(point.getSectorName())) point.addDamage(damageID,damageLength,DamageWidth);
        }
    }
}