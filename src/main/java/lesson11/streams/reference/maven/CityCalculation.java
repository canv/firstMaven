package lesson11.streams.reference.maven;

import java.util.Set;

final class CityCalculation{

    static int totalSectorArea(Set<? extends CitySet> points){
        int totalResult = 0;
        for (CitySet cityPoint : points)
            totalResult += (cityPoint.getSectorLength()*cityPoint.getSectorWidth());
        return totalResult;
    }
    static int streetsLength(Set<Street> streets) {
        int totalResult = 0;
        for (Street street : streets)
            totalResult += street.getSectorLength();
        return totalResult;
    }
    static int totalSectorDamageArea(Set<? extends CitySet> points){
        int totalResult = 0;

        for (CitySet cityPoint : points) {
            Set<Damage> damages = cityPoint.getSectorDamages();
            for (Damage damage : damages) {
                totalResult += damage.getDamageLength() * damage.getDamageWidth();
            }
        }
        return totalResult;
    }
    static int totalUsableArea(City city) {
        return (totalSectorArea(city.getCityParks()) - totalSectorDamageArea(city.getCityParks())) +
                (totalSectorArea(city.getCityStreets()) - totalSectorDamageArea(city.getCityStreets())) +
                (totalSectorArea(city.getCityDistricts()) - totalSectorDamageArea(city.getCityDistricts()));
    }
}