package com.example.examplemod.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ModBow extends BowItem {
    public ModBow(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {


        Level level = player.getCommandSenderWorld();

        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 5,16));

       if(entity instanceof LivingEntity){
           ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,16));
       }
        for(int i = 0; i < 50; i++) {
            Vec3 pos = player.getEyePosition();
            level.addParticle(ParticleTypes.ENCHANT, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }


    @Override
    public int getUseDuration(ItemStack pStack) {



        return super.getUseDuration(pStack);
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {

        arrow.setPierceLevel((byte) 99);
        arrow.setBaseDamage(99999);

        return super.customArrow(arrow);
    }
}
