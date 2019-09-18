package lesson11.streams.reference.maven;

import java.util.Set;
import java.util.UUID;

public interface CitySet {
    String getSectorName();
    UUID getSectorID();
    int getSectorLength();
    int getSectorWidth();
    Set<Damage> getSectorDamages();

    void addDamage(UUID damageID, int damageLength, int damageWidth);
}