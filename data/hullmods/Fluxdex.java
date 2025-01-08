package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class Fluxdex extends BaseHullMod {

    public static float FLUX_RESISTANCE = 50f;
    public static float VENT_RATE_BONUS = 25f;

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getEmpDamageTakenMult().modifyMult(id, 1f - FLUX_RESISTANCE * 0.01f);
        stats.getVentRateMult().modifyPercent(id, VENT_RATE_BONUS);
    }

    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "" + (int) FLUX_RESISTANCE + "%";
        if (index == 1) return "" + (int) VENT_RATE_BONUS + "%";
        return null;
    }
}