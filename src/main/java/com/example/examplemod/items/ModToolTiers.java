package com.example.examplemod.items;

import com.example.examplemod.VoidStranger;
import com.example.examplemod.items.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier VOID = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(Items.VOID_INGOT.get())),
            new ResourceLocation(VoidStranger.MODID, "void_ingot"), List.of(Tiers.NETHERITE), List.of());

}
