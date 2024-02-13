package com.example.examplemod.items.util;


import com.example.examplemod.VoidStranger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_VOID_TOOL = tag("needs_void_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(VoidStranger.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(VoidStranger.MODID, name));
        }
    }
}