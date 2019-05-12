package org.elmedievo.medievoutils.Configuration;


import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.util.Generic.LOADED_CONFIG;
import static org.elmedievo.medievoutils.util.Methods.ConsoleAlerts.sendConsoleAlert;

public class LoadConfig {
    public static void loadConfig() {
        MedievoUtils.instance.getConfig().options().copyDefaults(true);
        MedievoUtils.instance.saveConfig();
        sendConsoleAlert(LOADED_CONFIG);
    }
}
