package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.util.Misc;

public class Nexdex extends BaseHullMod {

    private static final float ARMOR_BONUS = 200f;
    private static final float CAPACITY_MULT = 2f;
    private static final float DISSIPATION_MULT = 2f;

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getArmorBonus().modifyFlat(id, ARMOR_BONUS);
        stats.getFluxCapacity().modifyMult(id, CAPACITY_MULT);
        stats.getFluxDissipation().modifyMult(id, DISSIPATION_MULT);
    }

    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return Misc.getRoundedValue(ARMOR_BONUS);
        if (index == 1) return "" + (int) Math.round((CAPACITY_MULT - 1f) * 100f) + "%";
        if (index == 2) return "" + (int) Math.round((DISSIPATION_MULT - 1f) * 100f) + "%";
        return null;
    }
}
