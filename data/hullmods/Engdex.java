package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class Engdex extends BaseHullMod {

    public static float ENGINE_HEALTH_BONUS = 100f;
    public static float PROFILE_MULT = 1.0f;
    public static float MANEUVER_BONUS = 150f;

    @Override
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getEngineHealthBonus().modifyPercent(id, ENGINE_HEALTH_BONUS);
        stats.getSensorProfile().modifyMult(id, PROFILE_MULT);
        stats.getAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
        stats.getDeceleration().modifyPercent(id, MANEUVER_BONUS);
        stats.getTurnAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
        stats.getMaxTurnRate().modifyPercent(id, MANEUVER_BONUS);
    }

    @Override
    public String getDescriptionParam(int index, HullSize hullSize) {
        switch (index) {
            case 0: return "" + (int) ENGINE_HEALTH_BONUS + "%";
            case 1: return "" + (int) Math.round((0.5f - PROFILE_MULT) * 100f) + "%";
            case 2: return "" + (int) MANEUVER_BONUS + "%";
            default: return null;
        }
    }
}
