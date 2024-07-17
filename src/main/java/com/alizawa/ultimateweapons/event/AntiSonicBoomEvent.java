package com.alizawa.ultimateweapons.event;

import com.alizawa.ultimateweapons.UltimateWeaponsMain;
import com.alizawa.ultimateweapons.util.EnchantmentRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UltimateWeaponsMain.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AntiSonicBoomEvent {
    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            DamageSource source = event.getSource();

            if (source.getMsgId().equals("warden_sonic_boom")) {
                boolean hasEnchantment = false;
                for (EquipmentSlot slot : EquipmentSlot.values()) {
                    ItemStack armor = player.getItemBySlot(slot);
                    if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentRegistry.ANTI_SONIC_BOOM.get(), armor) > 0) {
                        hasEnchantment = true;
                        break;
                    }
                    if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentRegistry.ANTI_SONIC_BOOM.get(), armor) > 1) {
                        hasEnchantment = true;
                        break;
                    }
                }

                if (hasEnchantment) {
                    event.setAmount(event.getAmount() / 1.5F);
                }

                if (hasEnchantment) {
                    event.setAmount(event.getAmount() / 2.0F);
                }
            }
        }
    }
}
