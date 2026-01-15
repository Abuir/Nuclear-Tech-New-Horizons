package com.hbm.hazard.type;

import com.hbm.hazard.modifier.HazardModifier;
import com.hbm.lib.Library;
import com.hbm.util.ArmorRegistry;
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

public class HazardTypeToxic extends HazardTypeBase {
  public void onUpdate(EntityLivingBase livingTEntity, float level, ItemStack stack) {
    boolean hasToxFilter = false;
    boolean hasHazmat = false;
    level *= stack.field_77994_a;
    if (livingTEntity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)livingTEntity;
      if (player.field_71075_bZ.field_75098_d)
        return; 
      if (ArmorRegistry.hasProtection(livingTEntity, 3, ArmorRegistry.HazardClass.NERVE_AGENT)) {
        ArmorUtil.damageGasMaskFilter(livingTEntity, 1);
        hasToxFilter = true;
      } 
      hasHazmat = ArmorUtil.checkForHazmat(livingTEntity);
    } 
    if (!hasToxFilter && !hasHazmat) {
      if (level > 0.0F)
        livingTEntity.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 110, Math.min(255, (int)level))); 
      if (level > 10.0F)
        livingTEntity.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 110, Math.min(255, (int)level / 10))); 
      if (level > 100.0F)
        livingTEntity.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 110, Math.min(4, (int)level / 100))); 
      if (level > 1000.0F && (
        level > 2000.0F || livingTEntity.field_70170_p.field_73012_v.nextInt((int)(2000.0F / level)) == 0))
        livingTEntity.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 110, Math.min(255, (int)level / 1000))); 
    } 
    if (!hasHazmat || !hasToxFilter) {
      if (level > 2000.0F)
        livingTEntity.func_70690_d(new PotionEffect(Potion.field_76419_f.field_76415_H, 110, Math.min(255, (int)level / 2000))); 
      if (level > 10000.0F)
        livingTEntity.func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 110, Math.min(255, (int)level / 5000))); 
    } 
  }
  
  public void updateEntity(EntityItem item, float level) {}
  
  public void addHazardInformation(EntityPlayer player, List<String> list, float level, ItemStack stack, List<HazardModifier> modifiers) {
    level *= stack.field_77994_a;
    float rl = Library.roundFloat(level, 3);
    if (level > 10000.0F) {
      list.add(EnumChatFormatting.GREEN + "[" + I18nUtil.resolveKey("adjective.extreme", new Object[0]) + " " + I18nUtil.resolveKey("trait.toxic", new Object[0]) + "] ");
    } else if (level > 1000.0F) {
      list.add(EnumChatFormatting.GREEN + "[" + I18nUtil.resolveKey("adjective.veryhigh", new Object[0]) + " " + I18nUtil.resolveKey("trait.toxic", new Object[0]) + "] ");
    } else if (level > 100.0F) {
      list.add(EnumChatFormatting.GREEN + "[" + I18nUtil.resolveKey("adjective.high", new Object[0]) + " " + I18nUtil.resolveKey("trait.toxic", new Object[0]) + "] ");
    } else if (level > 10.0F) {
      list.add(EnumChatFormatting.GREEN + "[" + I18nUtil.resolveKey("adjective.medium", new Object[0]) + " " + I18nUtil.resolveKey("trait.toxic", new Object[0]) + "] ");
    } else if (level > 0.0F) {
      list.add(EnumChatFormatting.GREEN + "[" + I18nUtil.resolveKey("adjective.little", new Object[0]) + " " + I18nUtil.resolveKey("trait.toxic", new Object[0]) + "] ");
    } 
  }
}
