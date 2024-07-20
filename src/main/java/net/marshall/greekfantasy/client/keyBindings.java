package net.marshall.greekfantasy.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.marshall.greekfantasy.GreekFantasy;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public final class keyBindings {
    public static final keyBindings INSTANCE = new keyBindings();

    private keyBindings() {}

    private static final String CATEGORY = "key.categories." + GreekFantasy.MOD_ID;

    public final KeyMapping exampleKey = new KeyMapping(
            "key." + GreekFantasy.MOD_ID + ".example_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_P, -1),
            CATEGORY
    );

    public final KeyMapping examplePacketKey = new KeyMapping(
            "key." + GreekFantasy.MOD_ID + ".example_packet_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_V, -1),
            CATEGORY
    );

    public final KeyMapping newExamplePacketKey = new KeyMapping(
            "key." + GreekFantasy.MOD_ID + ".new_example_packet_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_K, -1),
            CATEGORY
    );
}
