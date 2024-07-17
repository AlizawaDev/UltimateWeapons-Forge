package com.alizawa.ultimateweapons.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.warden.SonicBoom;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SonicBoomSword extends SwordItem {


    public SonicBoomSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerLevel level = (ServerLevel) target.level();
        for (int i = 0; i < 10; i++) {
            double dx = (level.random.nextDouble() - 0.5) * 2.0;
            double dy = (level.random.nextDouble() - 0.5) * 2.0;
            double dz = (level.random.nextDouble() - 0.5) * 2.0;


            level.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 1.0F, 1.0F);
            ;
            level.sendParticles(ParticleTypes.SONIC_BOOM, target.getX() + dx, target.getY() + 0.3, target.getZ() + dz,
                    1, 0.5, 0.5, 0.5, 2.0);

            target.hurt(level.damageSources().sonicBoom(attacker), 20.0F);
            target.setPos(target.getX(), target.getY() + 0.5, target.getZ());
        }
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.literal("攻击可造成小范围监守者的§a音爆§f效果"));
        pTooltipComponents.add(Component.literal("并将目标炸飞"));
        pTooltipComponents.add(Component.literal(" "));
        pTooltipComponents.add(Component.literal("§f§l● 真实伤害"));
        pTooltipComponents.add(Component.literal(" "));
        pTooltipComponents.add(Component.literal("§e求个一键三连 = ="));
    }
}