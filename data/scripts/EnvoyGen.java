package data.scripts;


import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.shared.SharedData;

import data.scripts.Vespera;

public class EnvoyGen {
    // This method is called by the engine when generating the sector
    public void generate(SectorAPI sector) {
        SharedData.getData().getPersonBountyEventData().addParticipatingFaction("envoy"); // Add the faction to the bounty system
        initFactionRelationships(sector); // Initialize faction relationships
            (new Vespera()).generate(sector); // Generate the Vespera system
        }

    // This method initializes faction relationships
    public static void initFactionRelationships(SectorAPI sector) {
        FactionAPI hegemony = sector.getFaction(Factions.HEGEMONY);
	    FactionAPI tritachyon = sector.getFaction(Factions.TRITACHYON);
	    FactionAPI pirates = sector.getFaction(Factions.PIRATES);
	    FactionAPI independent = sector.getFaction(Factions.INDEPENDENT);
	    FactionAPI kol = sector.getFaction(Factions.KOL);
	    FactionAPI church = sector.getFaction(Factions.LUDDIC_CHURCH);
	    FactionAPI path = sector.getFaction(Factions.LUDDIC_PATH);
	    FactionAPI player = sector.getFaction(Factions.PLAYER);
	    FactionAPI diktat = sector.getFaction(Factions.DIKTAT);
        FactionAPI league = sector.getFaction(Factions.PERSEAN);
        FactionAPI envoy = sector.getFaction("envoy");

        // Set faction relationships
        player.setRelationship(envoy.getId(),          0.0f);
        envoy.setRelationship(hegemony.getId(),       -0.9f);
        envoy.setRelationship(pirates.getId(),        -0.1f);
        envoy.setRelationship(diktat.getId(),          0.0f);
        envoy.setRelationship(tritachyon.getId(),      1.0f);
        envoy.setRelationship(independent.getId(),     0.9f);
        envoy.setRelationship(league.getId(),         -0.9f);
        church.setRelationship(envoy.getId(),          0.1f);
        path.setRelationship(envoy.getId(),           -0.9f);
        kol.setRelationship(envoy.getId(),             0.9f);
        
        
        // Mod factions
        envoy.setRelationship("tiandong", RepLevel.FAVORABLE);               // The enemy of my enemy is my friend.
        envoy.setRelationship("blackrock_driveyards", RepLevel.NEUTRAL);     // They ot some nice tech to trade
        envoy.setRelationship("br_consortium", RepLevel.NEUTRAL);            // Black Rock's defenders, treat them the same
        envoy.setRelationship("6eme_bureau", RepLevel.NEUTRAL);              // They leave us alone, so we return the favor
        envoy.setRelationship("dassault_mikoyan", RepLevel.FAVORABLE);       // They trade with us sometimes and are all right
        envoy.setRelationship("united_security", RepLevel.NEUTRAL);          // Competing mercs should be watched carefully
        envoy.setRelationship("blade_breakers", RepLevel.VENGEFUL);          // AGI was a mistake, neural links are even worse
        envoy.setRelationship("diableavionics", RepLevel.NEUTRAL);           // Don't like them but hey, they create jobs for us
        envoy.setRelationship("exigency", RepLevel.SUSPICIOUS);              // Space Assholes™, but they like to trade as well...
        envoy.setRelationship("exipirated", RepLevel.HOSTILE);               // Pirates, but worse
        envoy.setRelationship("gmda", RepLevel.NEUTRAL);                     // Who the hell decided they should be the Space Police?
        envoy.setRelationship("gmda_patrol", RepLevel.NEUTRAL);              // Who the hell decided they should be the Space Police redux?
        envoy.setRelationship("draco", RepLevel.HOSTILE);                    // Space Vampire Pirates? Not in my Sector!
        envoy.setRelationship("fang", RepLevel.HOSTILE);                     // Psycho Werewolves, kill with nuclear fire
        envoy.setRelationship("HMI", RepLevel.INHOSPITABLE);                 // "Legitimate" Pirates that feed the Sector
        envoy.setRelationship("mess", RepLevel.VENGEFUL);                    // AGI was a mistake, gray goo is WORSE
        envoy.setRelationship("interstellarimperium", RepLevel.FAVORABLE);   // Trusted trading partners
        envoy.setRelationship("ii_imperial_guard", RepLevel.FAVORABLE);      // Their elite guard, treat them the same
        envoy.setRelationship("junk_pirates", RepLevel.HOSTILE);             // Space Pirates in junk heaps
        envoy.setRelationship("junk_pirates_hounds", RepLevel.HOSTILE);      // Space anarchists in junk heaps
        envoy.setRelationship("junk_pirates_junkboys", RepLevel.HOSTILE);    // Space anarchists in better junk heaps
        envoy.setRelationship("junk_pirates_technicians", RepLevel.HOSTILE); // Space anarchists in the best junk heaps
        envoy.setRelationship("pack", RepLevel.FAVORABLE);                   // In their isolation, they learned to be humble
        envoy.setRelationship("syndicate_asp", RepLevel.WELCOMING);          // Space FedEx is wise to cooperate with
        envoy.setRelationship("syndicate_asp_familia", RepLevel.WELCOMING);  // Space FedEx's elite guard, treat them the same
        envoy.setRelationship("al_ars", RepLevel.SUSPICIOUS);                // Nobody is quite sure what they are up to...
        envoy.setRelationship("mayorate", RepLevel.INHOSPITABLE);            // Rumor is they are working on their own AGI
        envoy.setRelationship("ORA", RepLevel.FAVORABLE);                    // Pays for help killing Pirates
        envoy.setRelationship("SCY", RepLevel.SUSPICIOUS);                   // Intel trading is useful, but can't be trusted
        envoy.setRelationship("shadow_industry", RepLevel.FAVORABLE);        // A positive force in the Sector and trading partners
        envoy.setRelationship("the_cartel", RepLevel.HOSTILE);               // Pirates with a new coat of paint
        envoy.setRelationship("nullorder", RepLevel.HOSTILE);                // Religious fanatics with highly dangerous technology
        envoy.setRelationship("sylphon", RepLevel.WELCOMING);                // Rumors of cooperative ship building projects abound
        envoy.setRelationship("templars", RepLevel.HOSTILE);                 // Space Assholes™ with ostensibly alien tech
        envoy.setRelationship("Coalition", RepLevel.WELCOMING);              // Rumors of cooperative ship building projects abound
        envoy.setRelationship("cabal", RepLevel.HOSTILE);                    // Space Assholes™ with too much money
        //envoy.setRelationship("nomads", RepLevel.NEUTRAL);                   // Will let them decide in their code / I don't know!
        //envoy.setRelationship("approlight", RepLevel.NEUTRAL);               // Will let them decide in their code / I don't know!
        //envoy.setRelationship("immortallight", RepLevel.NEUTRAL);            // Will let them decide in their code / I don't know!
        //envoy.setRelationship("lte_boss", RepLevel.NEUTRAL);                 // Will let them decide in their code / I don't know!
        //envoy.setRelationship("Lte", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("noir", RepLevel.NEUTRAL);                     // Will let them decide in their code / I don't know!
        //envoy.setRelationship("crystanite", RepLevel.NEUTRAL);               // Will let them decide in their code / I don't know!
        //envoy.setRelationship("crystanite_pir", RepLevel.HOSTILE);           // Sounds like Pirates and they should explode
        //envoy.setRelationship("exlane", RepLevel.NEUTRAL);                   // Will let them decide in their code / I don't know!
        //envoy.setRelationship("infected", RepLevel.HOSTILE);                 // Even mercs will not tolerate Space Zombies
        //envoy.setRelationship("neutrinocorp", RepLevel.NEUTRAL);             // Will let them decide in their code / I don't know!
        //envoy.setRelationship("oculus", RepLevel.NEUTRAL);                   // Will let them decide in their code / I don't know!
        //envoy.setRelationship("thulelegacy", RepLevel.NEUTRAL);              // Will let them decide in their code / I don't know!
        //envoy.setRelationship("corvus_scavengers", RepLevel.NEUTRAL);        // Will let them decide in their code / I don't know!
        //envoy.setRelationship("new_galactic_order", RepLevel.VENGEFUL);      // Fuck Space Nazis, too dirty even for mercs
        //envoy.setRelationship("TF7070_D3C4", RepLevel.HOSTILE);              // Rogue terraformer ships, what could possibly go wrong?
        //envoy.setRelationship("mayasura", RepLevel.NEUTRAL);                 // Will let them decide in their code / I don't know!
        //envoy.setRelationship("sad", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("cmc", RepLevel.NEUTRAL);                      // They leave us be, so we leave them be
        //envoy.setRelationship("kadur_remnant", RepLevel.SUSPICIOUS);         // Shifty relic of a bygone age, keep an eye on them
        //envoy.setRelationship("vesperon", RepLevel.NEUTRAL);                 // Will let them decide in their code / I don't know!
        //envoy.setRelationship("almighty_dollar", RepLevel.NEUTRAL);          // Will let them decide in their code / I don't know!
        //envoy.setRelationship("communist_clouds", RepLevel.NEUTRAL);         // Will let them decide in their code / I don't know!
        //envoy.setRelationship("science_fuckers", RepLevel.NEUTRAL);          // Will let them decide in their code / I don't know!
        //envoy.setRelationship("warhawk_republic", RepLevel.NEUTRAL);         // Will let them decide in their code / I don't know!
        //envoy.setRelationship("pulseindustry", RepLevel.NEUTRAL);            // Will let them decide in their code / I don't know!
        //envoy.setRelationship("ae_ixbattlegroup", RepLevel.NEUTRAL);         // Will let them decide in their code / I don't know!
        //envoy.setRelationship("omicron_faction", RepLevel.NEUTRAL);          // Will let them decide in their code / I don't know!
        //envoy.setRelationship("fringe_defence_syndicate", RepLevel.NEUTRAL); // Will let them decide in their code / I don't know!
        //envoy.setRelationship("gladiator", RepLevel.NEUTRAL);                // Will let them decide in their code / I don't know!
        //envoy.setRelationship("andorian", RepLevel.NEUTRAL);                 // Will let them decide in their code / I don't know!
        //envoy.setRelationship("united_federation", RepLevel.NEUTRAL);        // Will let them decide in their code / I don't know!
        //envoy.setRelationship("klingon_empire", RepLevel.NEUTRAL);           // Will let them decide in their code / I don't know!
        //envoy.setRelationship("romulan_empire", RepLevel.NEUTRAL);           // Will let them decide in their code / I don't know!
        //envoy.setRelationship("vulcan", RepLevel.NEUTRAL);                   // Will let them decide in their code / I don't know!
        //envoy.setRelationship("borg", RepLevel.NEUTRAL);                     // Will let them decide in their code / I don't know!
        //envoy.setRelationship("tahlan_greathouses", RepLevel.NEUTRAL);       // Will let them decide in their code / I don't know!
        //envoy.setRelationship("tahlan_legioinfernalis", RepLevel.NEUTRAL);   // Will let them decide in their code / I don't know!
        //envoy.setRelationship("OCI", RepLevel.INHOSPITABLE);                 // Newcomers to the Sector that are creeping about
        //envoy.setRelationship("prv", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("rb", RepLevel.NEUTRAL);                       // Will let them decide in their code / I don't know!
        //envoy.setRelationship("magellan_protectorate", RepLevel.SUSPICIOUS); // Tread carefully... Not very pleasent.
        //envoy.setRelationship("sun_ice", RepLevel.NEUTRAL);                  // Will let them decide in their code / I don't know!
        //envoy.setRelationship("sun_ici", RepLevel.NEUTRAL);                  // Will let them decide in their code / I don't know!
        //envoy.setRelationship("GKSec", RepLevel.NEUTRAL);                    // Some sort of security contractors, shoot if needed.
        //envoy.setRelationship("hiigaran_descendants", RepLevel.NEUTRAL);     // Will let them decide in their code / I don't know!
        //envoy.setRelationship("AI", RepLevel.NEUTRAL);                       // Will let them decide in their code / I don't know!
        //envoy.setRelationship("ALIENS", RepLevel.NEUTRAL);                   // Will let them decide in their code / I don't know!
        //envoy.setRelationship("FFS", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("FTG", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("ISA", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("MAR", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("ROCK", RepLevel.NEUTRAL);                     // Will let them decide in their code / I don't know!
        //envoy.setRelationship("RSF", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("UIN", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("VNS", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("WDW", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("XLE", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        //envoy.setRelationship("fob", RepLevel.NEUTRAL);                      // Will let them decide in their code / I don't know!
        
    }
}
