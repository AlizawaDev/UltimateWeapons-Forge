package com.alizawa.ultimateweapons.enchantment;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class AntiSonicBoom extends Enchantment {

    public AntiSonicBoom(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void doPostHurt(LivingEntity target, Entity attacker, int level) {
        ServerLevel world = (ServerLevel) target.level();
        world.sendParticles(ParticleTypes.ENCHANT, target.getX(),target.getY(),target.getZ(),
                5,0.5,0.5,0.5,1.0);
    }
}