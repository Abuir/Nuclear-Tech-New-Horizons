package com.hbm.hazard.type;

import com.hbm.config.GeneralConfig;
import com.hbm.config.RadiationConfig;
import com.hbm.hazard.modifier.HazardModifier;
import com.hbm.items.ModItems;
import com.hbm.util.ArmorUtil;
import com.hbm.util.i18n.I18nUtil;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;

public class HazardTypeCryogenic extends HazardTypeBase {
  public void onUpdate(EntityLivingBase target, float level, ItemStack stack) {
    //if (RadiationConfig.disableCryo)
    //  return; 
    boolean reacher = false;
    if (target instanceof EntityPlayer && !GeneralConfig.enable528)
      reacher = ((EntityPlayer)target).inventory.hasItem(ModItems.reacher); 
    if (!reacher) {
      boolean isProtected = (target instanceof EntityPlayer && ArmorUtil.checkForHazmat(target));
      if (!isProtected) {
        target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 110, (int)level - 1));
        target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 110, Math.min(4, (int)level - 1)));
        target.addPotionEffect(new PotionEffect(Potion.weakness.id, 110, (int)level - 1));
        if (level > 4.0F) {
          target.addPotionEffect(new PotionEffect(Potion.wither.id, 110, (int)level - 3));
          target.extinguish();
        } 
      } 
    } 
  }
  
  public void updateEntity(EntityItem item, float level) {}
  
  public void addHazardInformation(EntityPlayer player, List list, float level, ItemStack stack, List<HazardModifier> modifiers) {
    level = HazardModifier.evalAllModifiers(stack, (EntityLivingBase)player, level, modifiers);
    if (level > 0.0F)
      list.add(EnumChatFormatting.AQUA + "[" + I18nUtil.resolveKey("trait.cryogenic", new Object[0]) + "]"); 
  }
}
