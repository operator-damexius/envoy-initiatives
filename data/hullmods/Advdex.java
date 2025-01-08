package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class Advdex extends BaseHullMod {

    public static float RANGE_BONUS = 200f;
    public static float PD_BONUS = 50f;

    @Override
    public boolean isApplicableToShip(ShipAPI ship) {
        return true;
    }

    public String getUnapplicableReason(ShipAPI ship) {
        return null;
    }
    
    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "" + (int) Math.round(RANGE_BONUS) + "%"; 
        if (index == 1) return "" + (int) Math.round(PD_BONUS) + "%";
        return null;
    }
    
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getBallisticWeaponRangeBonus().modifyPercent(id, RANGE_BONUS);
        stats.getEnergyWeaponRangeBonus().modifyPercent(id, RANGE_BONUS);
        stats.getNonBeamPDWeaponRangeBonus().modifyPercent(id, PD_BONUS);
        stats.getBeamPDWeaponRangeBonus().modifyPercent(id, PD_BONUS);
    }
}
