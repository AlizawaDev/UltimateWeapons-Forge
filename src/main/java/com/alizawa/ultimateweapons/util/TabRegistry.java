package com.alizawa.ultimateweapons.util;

import com.alizawa.ultimateweapons.UltimateWeaponsMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            UltimateWeaponsMain.MODID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TAB.register("mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.SONIC_BOOM_SWORD.get()))
                    .title(Component.literal("UltimateWeapons - 究极武器"))
                    .displayItems((pParameters, pOutput) ->  {
                        pOutput.accept(ItemRegistry.SONIC_BOOM_SWORD.get());
                        pOutput.accept(ItemRegistry.SONIC_WAND.get());
                    })
                    .build());

    public static void TabInit(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
