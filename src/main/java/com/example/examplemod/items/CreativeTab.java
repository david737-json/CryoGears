package com.example.examplemod.items;

import com.example.examplemod.VoidStranger;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VoidStranger.MODID);


    public static final RegistryObject<CreativeModeTab> VOID_TAB = CREATIVE_MODE_TABS.register("void_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.VOID_INGOT.get()))
                    .title(Component.translatable("creativetab.void_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.VOID_INGOT.get());
                        pOutput.accept(Items.STAR_INGOT.get());
                        pOutput.accept(Items.VOID_SWORD.get());
                        pOutput.accept(Items.VOID_PICKAXE.get());
                        pOutput.accept(Items.VOID_PEARL.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
