package com.alizawa.ultimateweapons.util;

import com.alizawa.ultimateweapons.UltimateWeaponsMain;
import com.alizawa.ultimateweapons.item.SonicBoomSword;
import com.alizawa.ultimateweapons.item.SonicWand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UltimateWeaponsMain.MODID);


    public static final RegistryObject<Item> SONIC_BOOM_SWORD = ITEMS.register("sonic_boom_sword",
            () -> new SonicBoomSword(Tiers.STONE,
                    1,
                    0.2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> SONIC_WAND = ITEMS.register("sonic_wand", () -> new SonicWand(new Item.Properties()));


    public static void ItemsInit(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
