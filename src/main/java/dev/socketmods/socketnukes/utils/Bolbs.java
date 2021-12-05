package dev.socketmods.socketnukes.utils;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.List;

public class Bolbs {

    private static final List<String> CURLES = ImmutableList.of("TheCurle", "Curle");

    // These people, developers and contributors of the mod, will be given a bolbmas hat in-game.
    private static final List<String> BOLBERS = ImmutableList.of(
        "d23dfef7-36a5-40aa-b851-6b8201e0c779", // mthwzrd / sciwhiz12
        "7133ccb3-efc0-47c9-b3f1-44b04464f06c", // Curle
        "4cf999cf-0773-4624-bfcb-d014c13fdf34", // Unbekannt
        "86a71cfb-8a07-4f35-9560-5ee28d183264", // dpeter99
        "d64548d3-d532-42fa-b0bb-cfc96b0dd72a"  // AterAnimAvis
    );

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Whether the Non Player Entity should have the Vanity Hat rendered
     */
    public static boolean isCurle(LivingEntity entity) {
        return CURLES.contains(entity.getName().getString());
    }

    /**
     * Whether the Player should have the Vanity Hat rendered
     */
    public static boolean hasHat(Player player) {
        return isAllowedHat(player); //TODO: && hasHatEnabled(player)
    }

    //------------------------------------------------------------------------------------------------------------------

    private static boolean isAllowedHat(Player player) {
        // If a Holiday has enabled the Hats Feature
        if (HolidayTracker.enabledHats()) return true;

        // If were in a Dev Environment
        if (!FMLLoader.isProduction()) return true;

        // Otherwise do they have the Bolb-iness Factor
        return BOLBERS.contains(player.getStringUUID());
    }

}
