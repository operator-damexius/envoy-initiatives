package data.scripts;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.BaseModPlugin;
import exerelin.campaign.SectorManager;
import data.scripts.EnvoyGen;
import data.scripts.Vespera;

public class EnvoyModPlugin extends BaseModPlugin {

    @Override
    public void onNewGame() {
        boolean haveNexerelin = Global.getSettings().getModManager().isModEnabled("nexerelin");
        Global.getLogger(EnvoyModPlugin.class).info("Nexerelin enabled: " + haveNexerelin);
        
        if (!haveNexerelin || SectorManager.getCorvusMode()) {
            try {
                Vespera vespera = new Vespera();
                vespera.generate(Global.getSector());
                Global.getLogger(EnvoyModPlugin.class).info("Successfully generated Vespera system.");
            } catch (Exception e) {
                Global.getLogger(EnvoyModPlugin.class).error("Error generating Vespera system: ", e);
            }
        } else {
            Global.getLogger(EnvoyModPlugin.class).info("Nexerelin is enabled; Vespera system generation skipped.");
        }
    }
}
