package org.elmedievo.medievoutils.util;

import static org.elmedievo.medievoutils.EventHandlers.PlayerKill.registerPlayerKillEvent;

public class EventRegistry {
    public static void registerEvents() {
        registerPlayerKillEvent();
    }
}
