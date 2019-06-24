package org.elmedievo.medievoutils.util;

import static org.elmedievo.medievoutils.EventHandlers.PlayerJoin.registerPlayerJoinEvent;
import static org.elmedievo.medievoutils.EventHandlers.PlayerKill.registerPlayerKillEvent;
import static org.elmedievo.medievoutils.Scoreboard.Scoreboard.registerScoreboardEvents;

public class EventRegistry {
    public static void registerEvents() {
        registerPlayerKillEvent();
        registerScoreboardEvents();
        registerPlayerJoinEvent();
    }
}
