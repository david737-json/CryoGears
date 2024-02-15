package com.example.examplemod.items;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.level.block.state.BlockState;

public class ModBow extends BowItem {
    public ModBow(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {

        arrow.setPierceLevel((byte) 99);
        arrow.setBaseDamage(99999);

        return super.customArrow(arrow);
    }
}
