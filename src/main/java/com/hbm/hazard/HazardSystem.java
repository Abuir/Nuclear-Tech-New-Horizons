package com.hbm.hazard;

import com.hbm.hazard.modifier.HazardModifier;
import com.hbm.hazard.transformer.HazardTransformerBase;
import com.hbm.hazard.type.HazardTypeBase;
import com.hbm.interfaces.Untested;
import com.hbm.inventory.RecipesCommon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@Untested
public class HazardSystem {
  public static final HashMap<String, HazardData> oreMap = new HashMap<>();
  
  public static final HashMap<Item, HazardData> itemMap = new HashMap<>();
  
  public static final HashMap<RecipesCommon.ComparableStack, HazardData> stackMap = new HashMap<>();
  
  public static final HashSet<RecipesCommon.ComparableStack> stackBlacklist = new HashSet<>();
  
  public static final HashSet<String> dictBlacklist = new HashSet<>();
  
  public static final List<HazardTransformerBase> trafos = new ArrayList<>();
  
  public static final HashMap<String, HazardData> fluidMap = new HashMap<>();
  
  public static void registerFluid(String o, HazardData data) {
    if (o != null)
      fluidMap.put(o, data); 
  }
  
  public static void register(Object o, HazardData data) {
    if (o instanceof String)
      oreMap.put((String)o, data); 
    if (o instanceof Item)
      itemMap.put((Item)o, data); 
    if (o instanceof Block)
      itemMap.put(Item.func_150898_a((Block)o), data); 
    if (o instanceof ItemStack)
      stackMap.put(new RecipesCommon.ComparableStack((ItemStack)o), data); 
    if (o instanceof RecipesCommon.ComparableStack)
      stackMap.put((RecipesCommon.ComparableStack)o, data); 
  }
  
  public static void blacklist(Object o) {
    if (o instanceof ItemStack) {
      stackBlacklist.add((new RecipesCommon.ComparableStack((ItemStack)o)).makeSingular());
    } else if (o instanceof String) {
      dictBlacklist.add((String)o);
    } 
  }
  
  public static boolean isItemBlacklisted(ItemStack stack) {
    RecipesCommon.ComparableStack comp = (new RecipesCommon.ComparableStack(stack)).makeSingular();
    if (stackBlacklist.contains(comp))
      return true; 
    int[] ids = OreDictionary.getOreIDs(stack);
    for (int id : ids) {
      String name = OreDictionary.getOreName(id);
      if (dictBlacklist.contains(name)) {
        stackBlacklist.add(comp);
        return true;
      } 
    } 
    return false;
  }
  
  public static List<HazardEntry> getHazardsFromFluid(String f) {
    List<HazardEntry> chronological = new ArrayList<>();
    if (fluidMap.containsKey(f))
      chronological.addAll(((HazardData)fluidMap.get(f)).entries); 
    return chronological;
  }
  
  public static List<HazardEntry> getHazardsFromStack(ItemStack stack) {
    if (isItemBlacklisted(stack))
      return new ArrayList<>(); 
    List<HazardData> chronological = new ArrayList<>();
    int[] ids = OreDictionary.getOreIDs(stack);
    for (int id : ids) {
      String name = OreDictionary.getOreName(id);
      if (oreMap.containsKey(name))
        chronological.add(oreMap.get(name)); 
    } 
    if (itemMap.containsKey(stack.func_77973_b()))
      chronological.add(itemMap.get(stack.func_77973_b())); 
    RecipesCommon.ComparableStack comp = (new RecipesCommon.ComparableStack(stack)).makeSingular();
    if (stackMap.containsKey(comp))
      chronological.add(stackMap.get(comp)); 
    List<HazardEntry> entries = new ArrayList<>();
    for (HazardTransformerBase trafo : trafos)
      trafo.transformPre(stack, entries); 
    int mutex = 0;
    for (HazardData data : chronological) {
      if (data.doesOverride)
        entries.clear(); 
      if ((data.getMutex() & mutex) == 0) {
        entries.addAll(data.entries);
        mutex |= data.getMutex();
      } 
    } 
    for (HazardTransformerBase trafo : trafos)
      trafo.transformPost(stack, entries); 
    return entries;
  }
  
  public static float getHazardLevelFromStack(ItemStack stack, HazardTypeBase hazard) {
    List<HazardEntry> entries = getHazardsFromStack(stack);
    for (HazardEntry entry : entries) {
      if (entry.type == hazard)
        return HazardModifier.evalAllModifiers(stack, null, entry.baseLevel, entry.mods); 
    } 
    return 0.0F;
  }
  
  public static void applyHazards(ItemStack stack, EntityLivingBase entity) {
    List<HazardEntry> hazards = getHazardsFromStack(stack);
    for (HazardEntry hazard : hazards)
      hazard.applyHazard(stack, entity); 
  }
  
  public static void updatePlayerInventory(EntityPlayer player) {
    for (int i = 0; i < player.field_71071_by.field_70462_a.length; i++) {
      ItemStack stack = player.field_71071_by.field_70462_a[i];
      if (stack != null) {
        applyHazards(stack, (EntityLivingBase)player);
        if (stack.field_77994_a == 0)
          player.field_71071_by.field_70462_a[i] = null; 
      } 
    } 
    for (ItemStack stack : player.field_71071_by.field_70460_b) {
      if (stack != null)
        applyHazards(stack, (EntityLivingBase)player); 
    } 
  }
  
  public static void updateLivingInventory(EntityLivingBase entity) {
    for (int i = 0; i < 5; i++) {
      ItemStack stack = entity.func_71124_b(i);
      if (stack != null)
        applyHazards(stack, entity); 
    } 
  }
  
  public static void updateDroppedItem(EntityItem entity) {
    ItemStack stack = entity.func_92059_d();
    if (entity.field_70128_L || stack == null || stack.func_77973_b() == null || stack.field_77994_a <= 0)
      return; 
    List<HazardEntry> hazards = getHazardsFromStack(stack);
    for (HazardEntry entry : hazards)
      entry.type.updateEntity(entity, HazardModifier.evalAllModifiers(stack, null, entry.baseLevel, entry.mods)); 
  }
  
  @SideOnly(Side.CLIENT)
  public static void addFullTooltip(ItemStack stack, EntityPlayer player, List list) {
    List<HazardEntry> hazards = getHazardsFromStack(stack);
    for (HazardEntry hazard : hazards)
      hazard.type.addHazardInformation(player, list, hazard.baseLevel, stack, hazard.mods); 
  }
}
