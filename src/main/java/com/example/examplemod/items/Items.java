package com.example.examplemod.items;

import com.example.examplemod.VoidStranger;
import cpw.mods.modlauncher.api.IEnvironment;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.example.examplemod.items.ModToolTiers.*;

public class Items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VoidStranger.MODID);


            public static final RegistryObject<Item> VOID_INGOT = ITEMS.register("void_ingot",
                    () -> new Item(new Item.Properties()));
             public static final RegistryObject<Item> STAR_INGOT = ITEMS.register("star_ingot",
            () -> new Item(new Item.Properties()));
             public static final RegistryObject<Item> VOID_SWORD = ITEMS.register("void_sword",
            () -> new SwordItem(VOID, 4,4,new Item.Properties()));
    public static final RegistryObject<Item> VOID_PICKAXE = ITEMS.register("void_pickaxe",
            () -> new PickaxeItem(VOID, 4,4,new Item.Properties()));
    public static final RegistryObject<Item> VOID_BOW = ITEMS.register("void_bow",
            () -> new BowItem(new Item.Properties()));
    public static final RegistryObject<Item> VOID_PEARL = ITEMS.register("void_pearl",
            () -> (new VoidItem(new Item.Properties().defaultDurability(99))));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

            }
}
