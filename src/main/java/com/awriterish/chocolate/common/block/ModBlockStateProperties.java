package com.awriterish.chocolate.common.block;

import com.awriterish.chocolate.common.block.enums.RedstoneGateMode;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockStateProperties {
    public static final EnumProperty<RedstoneGateMode> MODE_REDSTONE_GATE = EnumProperty.create("mode", RedstoneGateMode.class);
    public static final IntegerProperty LEVEL_BARREL_OF = IntegerProperty.create("level", 0, 2048);
    public static final IntegerProperty BARREL_OF_FILL_LEVEL = IntegerProperty.create("fill_level", 0, 8);
}
