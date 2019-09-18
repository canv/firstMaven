package lesson11.streams.reference.maven;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

abstract class CitySectors implements CitySet {

    private String sectorName;
    private final UUID sectorID;
    private int sectorLength;
    private int sectorWidth;
    private Set<Damage> sectorDamages;

    CitySectors(String sectorName, UUID sectorID, int sectorLength, int sectorWidth) {
        this.sectorName = sectorName;
        this.sectorID = sectorID;
        this.sectorLength = sectorLength;
        this.sectorWidth = sectorWidth;
        this.sectorDamages = new HashSet<>();
    }

    @Override
    public String getSectorName() {
        return sectorName;
    }

    @Override
    public UUID getSectorID(){return  sectorID;}

    @Override
    public int getSectorLength() {
        return sectorLength;
    }

    @Override
    public int getSectorWidth() {
        return sectorWidth;
    }

    @Override
    public Set<Damage> getSectorDamages() {

        return sectorDamages;
    }

    @Override
    public void addDamage(UUID damageID, int damageLength, int damageWidth) {
        sectorDamages.add(new Damage(damageID, damageLength,damageWidth));
    }
}

class Park extends CitySectors {
    Park(String name, UUID id, int length, int width) {
        super(name, id, length, width);
    }
}

class Street extends CitySectors {
    Street(String name, UUID id, int length, int width) {
        super(name, id, length, width);
    }
}

class LivingDistrict extends CitySectors {
    LivingDistrict(String name, UUID id, int length, int width) {
        super(name, id, length, width);
    }
}

class Damage {
    private final UUID damageID;
    private int damageLength;
    private int damageWidth;

    Damage(UUID damageID, int damageLength, int damageWidth) {
        this.damageID = damageID;
        this.damageLength = damageLength;
        this.damageWidth = damageWidth;
    }

    UUID getDamageID() {
        return damageID;
    }
    int getDamageLength() {
        return damageLength;
    }
    int getDamageWidth() {
        return damageWidth;
    }
}