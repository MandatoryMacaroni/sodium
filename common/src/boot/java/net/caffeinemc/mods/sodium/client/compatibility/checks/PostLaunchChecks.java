package net.caffeinemc.mods.sodium.client.compatibility.checks;

import net.caffeinemc.mods.sodium.client.compatibility.environment.GlContextInfo;
import net.caffeinemc.mods.sodium.client.compatibility.workarounds.nvidia.NvidiaWorkarounds;
import net.caffeinemc.mods.sodium.client.console.Console;
import net.caffeinemc.mods.sodium.client.console.message.MessageLevel;
import net.caffeinemc.mods.sodium.client.platform.NativeWindowHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Performs OpenGL driver validation after the game creates an OpenGL context. This runs immediately after OpenGL
 * context creation, and uses the implementation details of the OpenGL context to perform validation.
 */
public class PostLaunchChecks {
    private static final Logger LOGGER = LoggerFactory.getLogger("Sodium-PostlaunchChecks");

    public static void onContextInitialized(NativeWindowHandle window, GlContextInfo context) {
        GraphicsDriverChecks.postContextInit(window, context);
        NvidiaWorkarounds.applyContextChanges(context);
    }
}
