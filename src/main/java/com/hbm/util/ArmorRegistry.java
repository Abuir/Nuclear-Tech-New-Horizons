package com.hbm.util;

import api.hbm.item.IGasMask;
import com.hbm.handler.ArmorModHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArmorRegistry {
  public static HashMap<Item, ArrayList<HazardClass>> hazardClasses = new HashMap<>();
  
  public static void registerHazard(Item item, HazardClass... hazards) {
    hazardClasses.put(item, new ArrayList<>(Arrays.asList(hazards)));
  }
  
  public static boolean hasAllProtection(EntityLivingBase entity, int slot, HazardClass... clazz) {
    if (ArmorUtil.checkArmorNull(entity, slot))
      return false; 
    List<HazardClass> list = getProtectionFromItem(entity.getEquipmentInSlot(slot + 1), entity);
    return list.containsAll(Arrays.asList((Object[])clazz));
  }
  
  public static boolean hasAnyProtection(EntityLivingBase entity, int slot, HazardClass... clazz) {
    if (ArmorUtil.checkArmorNull(entity, slot))
      return false; 
    List<HazardClass> list = getProtectionFromItem(entity.getEquipmentInSlot(slot + 1), entity);
    if (list == null)
      return false; 
    for (HazardClass haz : clazz) {
      if (list.contains(haz))
        return true; 
    } 
    return false;
  }
  
  public static boolean hasProtection(EntityLivingBase entity, int slot, HazardClass clazz) {
    if (ArmorUtil.checkArmorNull(entity, slot))
      return false; 
    List<HazardClass> list = getProtectionFromItem(entity.getEquipmentInSlot(slot + 1), entity);
    if (list == null)
      return false; 
    return list.contains(clazz);
  }
  
  public static List<HazardClass> getProtectionFromItem(ItemStack stack, EntityLivingBase entity) {
    List<HazardClass> prot = new ArrayList<>();
    Item item = stack.getItem();
    if (hazardClasses.containsKey(item))
      prot.addAll(hazardClasses.get(item)); 
    if (item instanceof IGasMask) {
      IGasMask mask = (IGasMask)item;
      ItemStack filter = mask.getFilter(stack, entity);
      if (filter != null) {
        List<HazardClass> filProt = (List<HazardClass>)((ArrayList)hazardClasses.get(filter.getItem())).clone();
        for (HazardClass c : mask.getBlacklist(stack, entity))
          filProt.remove(c); 
        prot.addAll(filProt);
      } 
    } 
    if (ArmorModHandler.hasMods(stack)) {
      ItemStack[] mods = ArmorModHandler.pryMods(stack);
      for (ItemStack mod : mods) {
        if (mod != null)
          prot.addAll(getProtectionFromItem(mod, entity)); 
      } 
    } 
    return prot;
  }
  
  public enum HazardClass {
    GAS_LUNG("hazard.gasChlorine"),
    GAS_MONOXIDE("hazard.gasMonoxide"),
    GAS_INERT("hazard.gasInert"),
    PARTICLE_COARSE("hazard.particleCoarse"),
    PARTICLE_FINE("hazard.particleFine"),
    BACTERIA("hazard.bacteria"),
    NERVE_AGENT("hazard.nerveAgent"),
    GAS_BLISTERING("hazard.corrosive"),
    SAND("hazard.sand"),
    LIGHT("hazard.light"),
    RAD_GAS("hazard.radon");
    
    public final String lang;
    
    HazardClass(String lang) {
      this.lang = lang;
    }
  }
}
