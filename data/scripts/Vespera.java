package data.scripts;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Terrain;
import com.fs.starfarer.api.impl.campaign.procgen.NebulaEditor;
import com.fs.starfarer.api.impl.campaign.procgen.*;
import com.fs.starfarer.api.impl.campaign.terrain.HyperspaceTerrainPlugin;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.LocationAPI;

import com.fs.starfarer.api.util.Misc;
import java.awt.Color;

public class Vespera {

    public Vespera() {}

    public void generate(SectorAPI sector) {

        // try block - note: this is a try to generate the star system, if it fails it will report an error in the log en
        try 
        
        {

            // create the star system
            StarSystemAPI system = sector.createStarSystem("Vespera");
            LocationAPI hyper = Global.getSector().getHyperspace();
            PlanetAPI vespera_star = system.initStar(
                "vespera",                  // unique id for this star
                "star_white",               // id in planets.json
                700,                        // radius (in pixels at default zoom)
                400,                        // corona radius, from star edge
                10f,                        // solar wind burn level
                100,                        // flare probability
                2.0f                        // cr loss mult
            );
            system.setBackgroundTextureFilename("graphics/backgrounds/background6.jpg");
            system.autogenerateHyperspaceJumpPoints(true, true);

            // planets - faction - note: faction is set here, but in the vespera.json market conditions are set
            PlanetAPI planet0 = system.addPlanet("solara", vespera_star, "Solara", "rocky_metallic", 0, 100, 3000, 365);
            planet0.setCustomDescriptionId("planet_solara");
            
            PlanetAPI planet1 = system.addPlanet("nimoria", vespera_star, "Nimoria", "terran", 0, 130, 6000, 365);
            planet1.setCustomDescriptionId("planet_nimoria");
            
            PlanetAPI planet1a = system.addPlanet("amaris", planet1, "Amaris", "barren2", 0, 50, 700, 31);
            planet1a.setCustomDescriptionId("planet_amaris");

            PlanetAPI planet2 = system.addPlanet("vesperis", vespera_star, "Vesperis", "terran-eccentric", 0, 200, 9000, 365);
            planet2.setCustomDescriptionId("planet_vesperis");


            // planets - neutral - note: market conditions are here
            PlanetAPI planet3 = system.addPlanet("aetheris", vespera_star, "Aetheris", "ice_giant", 0, 300, 15000, 565);
            Misc.initConditionMarket(planet3);
            planet3.getMarket().setSurveyLevel(MarketAPI.SurveyLevel.FULL);
            planet3.getMarket().addCondition(Conditions.VERY_COLD);
            planet3.getMarket().addCondition(Conditions.EXTREME_WEATHER);
            planet3.getMarket().addCondition(Conditions.DENSE_ATMOSPHERE);
            planet3.getMarket().addCondition(Conditions.HIGH_GRAVITY);
            planet3.getMarket().addCondition(Conditions.VOLATILES_PLENTIFUL);


            PlanetAPI planet3a = system.addPlanet("ferronox", planet3, "Ferronox", "terran-eccentric", 0, 100, 1000, 60);
            Misc.initConditionMarket(planet3a);
            planet3a.getMarket().setSurveyLevel(MarketAPI.SurveyLevel.FULL);
            planet3a.getMarket().addCondition(Conditions.THIN_ATMOSPHERE);
            planet3a.getMarket().addCondition(Conditions.LOW_GRAVITY);
            planet3a.getMarket().addCondition(Conditions.ORE_MODERATE);
            planet3a.getMarket().addCondition(Conditions.RARE_ORE_MODERATE);
            planet3a.getMarket().addCondition(Conditions.RUINS_VAST);
            planet3a.getMarket().addCondition(Conditions.HABITABLE);
            planet3a.getMarket().addCondition(Conditions.ORGANICS_ABUNDANT);
            planet3a.getMarket().addCondition(Conditions.VOLATILES_ABUNDANT);

            PlanetAPI planet3b = system.addPlanet("celestra", planet3, "Celestra", "frozen2", 0, 80, 2000, 60);
            Misc.initConditionMarket(planet3b);
            planet3b.getMarket().setSurveyLevel(MarketAPI.SurveyLevel.FULL);
            planet3b.getMarket().addCondition(Conditions.COLD);
            planet3b.getMarket().addCondition(Conditions.LOW_GRAVITY);
            planet3b.getMarket().addCondition(Conditions.NO_ATMOSPHERE);
            planet3b.getMarket().addCondition(Conditions.RARE_ORE_RICH);
            planet3b.getMarket().addCondition(Conditions.RUINS_VAST);
            planet3b.getMarket().addCondition(Conditions.VOLATILES_PLENTIFUL);

            PlanetAPI planet4 = system.addPlanet("glacius", vespera_star, "Glacius", "tundra", 0, 220, 22000, 725);
            Misc.initConditionMarket(planet4);
            planet4.getMarket().setSurveyLevel(MarketAPI.SurveyLevel.FULL);
            planet4.getMarket().addCondition(Conditions.COLD);
            planet4.getMarket().addCondition(Conditions.RUINS_VAST);
            planet4.getMarket().addCondition(Conditions.EXTREME_WEATHER);
            planet4.getMarket().addCondition(Conditions.DENSE_ATMOSPHERE);
            planet4.getMarket().addCondition(Conditions.HIGH_GRAVITY);
            planet4.getMarket().addCondition(Conditions.VOLATILES_PLENTIFUL);


            // entities - note: these are custom entities
            SectorEntityToken entity1 = system.addCustomEntity("vespera_comm", "Vespera Comm", "comm_relay", "envoy"); 
            entity1.setCircularOrbitPointingDown(vespera_star, 0, 3000, 600);   

            SectorEntityToken entity2 = system.addCustomEntity("vespera_buoy", "Vespera Buoy", "nav_buoy", "envoy"); 
            entity2.setCircularOrbitPointingDown(vespera_star, 0, 15000, 600);    

            SectorEntityToken entity3 = system.addCustomEntity("vespera_sensor", "Vespera Sensor", "sensor_array", "envoy"); 
            entity3.setCircularOrbitPointingDown(vespera_star, 0, 22000, 600);        

            SectorEntityToken entity4 = system.addCustomEntity("vespera_gate", "Vespera Gate", "inactive_gate", "envoy"); 
            entity4.setCircularOrbitPointingDown(vespera_star, 0, 2000, 600);

            // rings and asteroid belts - note: these are custom rings and belts
            system.addRingBand(planet2, "misc", "rings_ice0", 256f, 2, Color.BLUE, 256f, 850, 21f, Terrain.RING, "Vesperis Ring");
            system.addRingBand(planet3, "misc", "rings_ice0", 256f, 2, Color.BLUE, 256f, 3000, 21f, Terrain.RING, "Aetheris Belt");
            system.addAsteroidBelt(vespera_star, 800, 4000, 256, 150, 250, Terrain.ASTEROID_BELT, "Vespera Line");
            system.addAsteroidBelt(vespera_star, 800, 25000, 256, 150, 250, Terrain.ASTEROID_BELT, "Vespera Belt");
            system.addRingBand(vespera_star, "misc", "rings_ice0", 256f, 0, Color.BLUE, 512f, 4000, 300f);
            system.addRingBand(vespera_star, "misc", "rings_ice0", 256f, 1, Color.BLUE, 512f, 25000, 300f);
            system.addRingBand(vespera_star, "misc", "rings_ice0", 256f, 1, Color.BLUE, 512f, 24900, 300f);
            system.addRingBand(vespera_star, "misc", "rings_ice0", 256f, 1, Color.BLUE, 512f, 24800, 300f);
            system.addRingBand(vespera_star, "misc", "rings_ice0", 256f, 1, Color.BLUE, 512f, 24700, 300f);


            // cleanup hyperspace terrain - note: this is a custom cleanup method, must have this method in the script
            cleanup(system);


        } 
        // catch block - note: this is a catch to report any errors that occur during system generation
        catch (Exception e) {
            Global.getLogger(Vespera.class).error("Error generating Vespera system: ", e);
        }

        
    }
    
    // cleanup hyperspace terrain - note: this is a custom cleanup method, must require the plugin to work
    void cleanup(StarSystemAPI system) {
        HyperspaceTerrainPlugin plugin = (HyperspaceTerrainPlugin) Misc.getHyperspaceTerrain().getPlugin();
        NebulaEditor editor = new NebulaEditor(plugin);
        float minRadius = plugin.getTileSize() * 2f;

        float radius = system.getMaxRadiusInHyperspace();
        editor.clearArc(system.getLocation().x, system.getLocation().y, 0, radius + minRadius * 2f, 0, 360f);
        editor.clearArc(system.getLocation().x, system.getLocation().y, 0, radius + minRadius, 0, 360f, 0.25f);

    }
}

