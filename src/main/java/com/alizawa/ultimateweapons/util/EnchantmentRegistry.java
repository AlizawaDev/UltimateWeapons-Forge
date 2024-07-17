package com.alizawa.ultimateweapons.util;

import com.alizawa.ultimateweapons.UltimateWeaponsMain;
import com.alizawa.ultimateweapons.enchantment.AntiSonicBoom;
import com.alizawa.ultimateweapons.enchantment.SonicBoom;
import com.alizawa.ultimateweapons.item.SonicBoomSword;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentRegistry {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UltimateWeaponsMain.MODID);


    public static final RegistryObject<Enchantment> SONIC_BOOM_ENCHANTMENT = ENCHANTMENTS.register("sonic_boom_enchantment",
            () -> new SonicBoom(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static final RegistryObject<Enchantment> ANTI_SONIC_BOOM = ENCHANTMENTS.register("anti_sonic_boom",
            () -> new AntiSonicBoom(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, EquipmentSlot.HEAD,
                    EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET));

    public static void EnchantmentsInit(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
