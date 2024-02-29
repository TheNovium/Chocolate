package com.awriterish.chocolate.common.block.enums;

import net.minecraft.util.StringRepresentable;

public enum RedstoneGateMode implements StringRepresentable {
    AND("and"),
    NOR("nor"),
    XOR("xor");

    private final String name;

    private RedstoneGateMode(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}