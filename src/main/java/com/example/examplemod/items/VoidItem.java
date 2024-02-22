package com.example.examplemod.items;

import com.google.common.collect.Multimap;
import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class VoidItem extends Item{
    public VoidItem(Item.Properties pProperties){
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.voiditem"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {

        Attribute attr = Attributes.ATTACK_DAMAGE;
        AttributeModifier mod = new AttributeModifier("Damage", 1.0, AttributeModifier.Operation.ADDITION);
        stack.addAttributeModifier(attr,mod,EquipmentSlot.MAINHAND);

        Attribute attr2 = Attributes.ATTACK_SPEED;
        AttributeModifier mod2 = new AttributeModifier("Speed", 4.0, AttributeModifier.Operation.ADDITION);
        stack.addAttributeModifier(attr2,mod2,EquipmentSlot.MAINHAND);

        return super.getAttributeModifiers(slot, stack);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return true;
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        BlockPos bPos = pContext.getClickedPos();
        level.destroyBlock(bPos,true);

        Vec3 pos = bPos.getCenter();

        for(int i = 0; i < 20; i++) {
            level.addParticle(ParticleTypes.ASH, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
        }

        return super.useOn(pContext);
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
     return 9999;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {


        player.setHealth(20);
        entity.kill();
        Vec3 pos = entity.getEyePosition();
        BlockPos bPos = player.getOnPos();
        Level level = player.getCommandSenderWorld();
        level.playSound(player,bPos,SoundEvents.TOTEM_USE,SoundSource.PLAYERS);

        for(int i = 0; i < 20; i++) {
            level.addParticle(ParticleTypes.ASH, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player player, LivingEntity entity, InteractionHand pUsedHand) {

        player.setHealth(20);
        entity.kill();
        Vec3 pos = entity.getEyePosition();
        BlockPos bPos = player.getOnPos();
        Level level = player.getCommandSenderWorld();
        level.playSound(player,bPos,SoundEvents.TOTEM_USE,SoundSource.PLAYERS);

        for(int i = 0; i < 20; i++) {
            level.addParticle(ParticleTypes.ASH, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0, 0, 0);
        }
        return super.interactLivingEntity(pStack, player, entity, pUsedHand);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if(pEntity instanceof Player){

            Player player = (Player) pEntity;
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2,2));
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 2,2));


        }


        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {

        Vec3 pos = player.getEyePosition();
        Vec3 v = player.getLookAngle();
        for (int i = 0;i < 50 ; i++) {


            pos = pos.add(v.x * 0.5,v.y * 0.5,v.z * 0.5);
            level.addParticle(ParticleTypes.ASH,pos.x,pos.y,pos.z,0,0,0);
            level.addParticle(ParticleTypes.ENCHANT,pos.x,pos.y,pos.z,0,0,0);
            List<LivingEntity> ent = level.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(pos, 0.1, 0.1, 0.1));
            for (LivingEntity l : ent) {
                if (l != player) {
                    pos = l.getEyePosition();
                    BlockPos bPos= player.getOnPos();
                    l.kill();
                    level.playSound(player,bPos,SoundEvents.TOTEM_USE,SoundSource.PLAYERS);
                    for(int j = 0; j < 50; j++) {
                        level.addParticle(ParticleTypes.ASH, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0,0,0);
                        level.addParticle(ParticleTypes.ENCHANT, pos.x + (Math.random() * 2) - 1, pos.y + (Math.random() * 2) - 1, pos.z + (Math.random() * 2) - 1, 0,0,0);
                    }
                    i = 50;
                }
            }
        }


      /*  for(Entity ent : list){

            if(player.hasLineOfSight(ent)){
            ent.kill();
            }

        }*/


        return super.use(level, player, pUsedHand);
    }
}
