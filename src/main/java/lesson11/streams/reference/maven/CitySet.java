package lesson11.streams.reference.maven;

import java.util.Set;

public interface CitySet {
    String getName();
    int getLength();
    int getWidth();
    Set<Damage> getDamage();
    void addDamage(int length, int width);
}