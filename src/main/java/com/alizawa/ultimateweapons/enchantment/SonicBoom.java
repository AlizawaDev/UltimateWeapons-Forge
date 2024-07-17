package com.alizawa.ultimateweapons.enchantment;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SonicBoom extends Enchantment {

    public SonicBoom(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int pLevel) {
        if (pLevel == 1) {
            ServerLevel level = (ServerLevel) target.level();
            for (int i = 0; i < 10; i++) {
                double dx = (level.random.nextDouble() - 0.5) * 2.0;
                double dy = (level.random.nextDouble() - 0.5) * 2.0;
                double dz = (level.random.nextDouble() - 0.5) * 2.0;


                level.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 1.0F, 1.0F);
                ;
                level.sendParticles(ParticleTypes.SONIC_BOOM, target.getX() + dx, target.getY() + 0.3 + dy, target.getZ() + dz,
                        1, 0.5, 0.5, 0.5, 2.0);

                target.hurt(level.damageSources().sonicBoom(attacker), 18.0F);
                target.setPos(target.getX(), target.getY() + 0.5, target.getZ());
            }
        }
        if (pLevel == 2) {
            ServerLevel level = (ServerLevel) target.level();
            for (int i = 0; i < 10; i++) {
                double dx = (level.random.nextDouble() - 0.5) * 2.0;
                double dy = (level.random.nextDouble() - 0.5) * 2.0;
                double dz = (level.random.nextDouble() - 0.5) * 2.0;


                level.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 1.0F, 1.0F);
                ;
                level.sendParticles(ParticleTypes.SONIC_BOOM, target.getX() + dx, target.getY() + 0.7 + dy, target.getZ() + dz,
                        1, 1, 1, 1, 2.0);

                target.hurt(level.damageSources().sonicBoom(attacker), 10.0F);
                target.setPos(target.getX(), target.getY() + 1.1, target.getZ());
            }
        }
    }
}
