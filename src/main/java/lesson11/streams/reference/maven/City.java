package lesson11.streams.reference.maven;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

class City{
    private String cityName;
    private Set<Park> cityParks;
    private Set<Street> cityStreets;
    private Set<LivingDistrict> cityDistricts;

    City() {
        this.cityName = "none";
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
    Set<LivingDistrict> getCityDistricts() {
        return cityDistricts;
    }

    void addSector(Park park){
        cityParks.add(park);
    }
    void addSector(Street street){
        cityStreets.add(street);
    }
    void addSector(LivingDistrict livingDistrict){
        cityDistricts.add(livingDistrict);
    }

    static void addDamage(Set<? extends CitySet> points, String sectorName, UUID id, int length, int width){
        for (CitySet point : points) {
            if (sectorName.equals(point.getSectorName())) point.addDamage(id,length,width);
        }
    }
}