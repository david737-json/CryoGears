package com.example.examplemod.items.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Properties;

import static com.example.examplemod.items.ModToolTiers.VOID;

public class EnderTool extends PickaxeItem {


    public EnderTool(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {

        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public float getAttackDamage() {
        return 4.0f;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {


        pEntityLiving.setHealth(pEntityLiving.getMaxHealth());
        pLevel.playSound((Player) pEntityLiving,pPos,SoundEvents.ENDERMAN_TELEPORT,SoundSource.PLAYERS);
        Vec3 pos = pPos.getCenter();
        for(int j = 0;j < 10; j++){
            pLevel.addParticle(ParticleTypes.PORTAL, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
        }

        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return 4.0f;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.enderitem"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {

        Vec3 pos = player.getEyePosition();
        Vec3 v = player.getLookAngle();

        for(int i = 0; i < 220; i++){

            pos = pos.add(v.x,v.y,v.z);

            BlockState state = level.getBlockState(BlockPos.containing(pos));
            Block block = state.getBlock();
            if(block != Blocks.AIR) {
                player.resetFallDistance();
                player.moveTo(pos.x - v.x, pos.y - v.y, pos.z - v.z);
                BlockPos bPos = player.getOnPos();
                level.playSound(player,bPos,SoundEvents.ENDERMAN_TELEPORT,SoundSource.PLAYERS);
                for(int j = 0;j < 10; j++){
                    level.addParticle(ParticleTypes.PORTAL, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
                }


                i = 220;
            }
        }


        return super.use(level, player, pUsedHand);
    }

}
