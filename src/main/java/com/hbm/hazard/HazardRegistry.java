package com.hbm.hazard;

import com.hbm.blocks.ModBlocks;
import com.hbm.config.GeneralConfig;
import com.hbm.hazard.modifier.HazardModifier;
import com.hbm.hazard.modifier.HazardModifierFuelRadiation;
import com.hbm.hazard.modifier.HazardModifierRBMKHot;
import com.hbm.hazard.modifier.HazardModifierRBMKRadiation;
import com.hbm.hazard.modifier.HazardModifierRTGRadiation;
import com.hbm.hazard.transformer.HazardTransformerRadiationContainer;
import com.hbm.hazard.transformer.HazardTransformerRadiationME;
import com.hbm.hazard.transformer.HazardTransformerRadiationNBT;
import com.hbm.hazard.type.HazardTypeAsbestos;
import com.hbm.hazard.type.HazardTypeAutism;
import com.hbm.hazard.type.HazardTypeBase;
import com.hbm.hazard.type.HazardTypeBlinding;
import com.hbm.hazard.type.HazardTypeCoal;
import com.hbm.hazard.type.HazardTypeCryogenic;
import com.hbm.hazard.type.HazardTypeDigamma;
import com.hbm.hazard.type.HazardTypeExplosive;
import com.hbm.hazard.type.HazardTypeGlitch;
import com.hbm.hazard.type.HazardTypeHot;
import com.hbm.hazard.type.HazardTypeHydroactive;
import com.hbm.hazard.type.HazardTypeNeutron;
import com.hbm.hazard.type.HazardTypeRadiation;
import com.hbm.hazard.type.HazardTypeToxic;
import com.hbm.inventory.OreDictManager;
import com.hbm.inventory.material.MaterialShapes;
import com.hbm.items.ModItems;
import com.hbm.items.machine.ItemBreedingRod;
import com.hbm.items.machine.ItemPWRFuel;
import com.hbm.items.machine.ItemRTGPelletDepleted;
import com.hbm.items.machine.ItemWatzPellet;
import com.hbm.items.machine.ItemZirnoxRod;
import com.hbm.items.special.ItemHolotapeImage;
import com.hbm.util.Compat;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class HazardRegistry {
  public static final float gen_S = 10000.0F;

  public static final float gen_H = 2000.0F;

  public static final float gen_10D = 100.0F;

  public static final float gen_100D = 80.0F;

  public static final float gen_1Y = 50.0F;

  public static final float gen_10Y = 30.0F;

  public static final float gen_100Y = 10.0F;

  public static final float gen_1K = 7.5F;

  public static final float gen_10K = 6.25F;

  public static final float gen_100K = 5.0F;

  public static final float gen_1M = 2.5F;

  public static final float gen_10M = 1.5F;

  public static final float gen_100M = 1.0F;

  public static final float gen_1B = 0.5F;

  public static final float gen_10B = 0.1F;

  public static final float co60 = 30.0F;

  public static final float sr90 = 15.0F;

  public static final float tc99 = 2.75F;

  public static final float i131 = 150.0F;

  public static final float xe135 = 1250.0F;

  public static final float cs137 = 20.0F;

  public static final float au198 = 500.0F;

  public static final float pb209 = 10000.0F;

  public static final float at209 = 7500.0F;

  public static final float po210 = 75.0F;

  public static final float ra226 = 7.5F;

  public static final float ac227 = 30.0F;

  public static final float th232 = 0.1F;

  public static final float thf = 1.75F;

  public static final float u = 0.35F;

  public static final float u233 = 5.0F;

  public static final float u235 = 1.0F;

  public static final float u238 = 0.25F;

  public static final float uf = 0.5F;

  public static final float np237 = 2.5F;

  public static final float npf = 1.5F;

  public static final float pu = 7.5F;

  public static final float purg = 6.25F;

  public static final float pu238 = 10.0F;

  public static final float pu239 = 5.0F;

  public static final float pu240 = 7.5F;

  public static final float pu241 = 25.0F;

  public static final float puf = 4.25F;

  public static final float am241 = 8.5F;

  public static final float cm242 = 9.3F;

  public static final float cm243 = 5.6F;

  public static final float cm244 = 2.0F;

  public static final float cm245 = 0.8F;

  public static final float cm246 = 2.5F;

  public static final float cm247 = 0.2F;

  public static final float cmrg = 6.0F;

  public static final float cmf = 2.2F;

  public static final float bk247 = 10.5F;

  public static final float cf251 = 14.3F;

  public static final float cf252 = 15.3F;

  public static final float es253 = 18.3F;

  public static final float es255 = 19.3F;

  public static final float am242 = 9.5F;

  public static final float amrg = 9.0F;

  public static final float amf = 4.75F;

  public static final float mox = 2.5F;

  public static final float sa326 = 15.0F;

  public static final float sa327 = 17.5F;

  public static final float saf = 5.85F;

  public static final float sas3 = 5.0F;

  public static final float gh336 = 5.0F;

  public static final float mud = 1.0F;

  public static final float cn989 = 89.0F;

  public static final float radsource_mult = 3.0F;

  public static final float pobe = 225.0F;

  public static final float rabe = 22.5F;

  public static final float pube = 30.0F;

  public static final float zfb_bi = 0.35F;

  public static final float zfb_pu241 = 12.5F;

  public static final float zfb_am_mix = 4.5F;

  public static final float bf = 300000.0F;

  public static final float bfb = 500000.0F;

  public static final float radspice = 20000.0F;

  public static final float unof = 10000.0F;

  public static final float ts = 120.0F;

  public static final float sr = 1.5F;

  public static final float sb = 3.0F;

  public static final float trx = 25.0F;

  public static final float trn = 0.1F;

  public static final float wst = 450.0F;

  public static final float wstv = 150.0F;

  public static final float yc = 0.42000002F;

  public static final float fo = 10.0F;

  public static final float nugget = 0.11F;

  public static final float ingot = 1.0F;

  public static final float gem = 1.0F;

  public static final float plate = 1.0F;

  public static final float plateCast = 3.0F;

  public static final float plateWeld = 6.0F;

  public static final float heavyComp = 768.0F;

  public static final float wire = 0.11F;

  public static final float wireDense = 1.0F;

  public static final float pipe = 3.0F;

  public static final float shell = 4.0F;

  public static final float bolt = 0.11F;

  public static final float powder_mult = 3.0F;

  public static final float powder = 3.0F;

  public static final float powder_tiny = 0.32999998F;

  public static final float ore = 0.8F;

  public static final float specore = 1.0F;

  public static final float block = 9.0F;

  public static final float crystal = 9.0F;

  public static final float billet = 0.5F;

  public static final float rtg = 1.5F;

  public static final float rod = 0.5F;

  public static final float rod_dual = 1.0F;

  public static final float rod_quad = 2.0F;

  public static final float rod_rbmk = 4.0F;

  public static final float magt = 0.825F;

  public static final float tcalloy = 0.07F;

  public static final float ferro = 0.175F;

  public static final float lead = 15.0F;

  public static final float merc = 60.0F;

  public static final float ars = 1500.0F;

  public static final HazardTypeBase RADIATION = (HazardTypeBase)new HazardTypeRadiation();

  public static final HazardTypeBase DIGAMMA = (HazardTypeBase)new HazardTypeDigamma();

  public static final HazardTypeBase HOT = (HazardTypeBase)new HazardTypeHot();

  public static final HazardTypeBase BLINDING = (HazardTypeBase)new HazardTypeBlinding();

  public static final HazardTypeBase ASBESTOS = (HazardTypeBase)new HazardTypeAsbestos();

  public static final HazardTypeBase COAL = (HazardTypeBase)new HazardTypeCoal();

  public static final HazardTypeBase HYDROACTIVE = (HazardTypeBase)new HazardTypeHydroactive();

  public static final HazardTypeBase EXPLOSIVE = (HazardTypeBase)new HazardTypeExplosive();

  public static final HazardTypeBase AUTISM = (HazardTypeBase)new HazardTypeAutism();

  public static final HazardTypeBase GLITCH = (HazardTypeBase)new HazardTypeGlitch();

  public static final HazardTypeBase NEUTRON = (HazardTypeBase)new HazardTypeNeutron();

  public static final HazardTypeBase CRYOGENIC = (HazardTypeBase)new HazardTypeCryogenic();

  public static final HazardTypeBase TOXIC = (HazardTypeBase)new HazardTypeToxic();

  public static void registerItems() {
    HazardSystem.register(Items.gunpowder, makeData(EXPLOSIVE, 1.0F));
    HazardSystem.register(Blocks.tnt, makeData(EXPLOSIVE, 4.0F));
    HazardSystem.register(Items.pumpkin_pie, makeData(EXPLOSIVE, 1.0F));
    HazardSystem.register(new ItemStack(Item.getItemFromBlock(ModBlocks.bobblehead), 1, 22), makeData(ASBESTOS, 1F)); //this works okay
	HazardSystem.register(new ItemStack(Item.getItemFromBlock(ModBlocks.bobblehead), 1, 25), makeData(GLITCH, 1F));
    HazardSystem.register(ModItems.ammonium_nitrate, makeData(EXPLOSIVE, 4.0F));
    HazardSystem.register(ModItems.ball_dynamite, makeData(EXPLOSIVE, 2.0F));
    HazardSystem.register(ModItems.stick_dynamite, makeData(EXPLOSIVE, 1.0F));
    HazardSystem.register(ModItems.stick_tnt, makeData(EXPLOSIVE, 1.5F));
    HazardSystem.register(ModItems.stick_semtex, makeData(EXPLOSIVE, 2.5F));
    HazardSystem.register(ModItems.stick_c4, makeData(EXPLOSIVE, 2.5F));
    HazardSystem.register(ModItems.sat_gerald, makeData(AUTISM, 1.0F));
    HazardSystem.register(ModItems.powder_wd2004, makeData(DIGAMMA, 1.0F));
    HazardSystem.register(ModItems.powder_wd2004_tiny, makeData(DIGAMMA, 0.05F));
    HazardSystem.register(ModItems.cordite, makeData(EXPLOSIVE, 2.0F));
    HazardSystem.register(ModItems.ballistite, makeData(EXPLOSIVE, 1.0F));
    HazardSystem.register(ModItems.n2_charge, makeData(EXPLOSIVE, 20.0F));
    HazardSystem.register(ModItems.custom_tnt, makeData(EXPLOSIVE, 4.0F));
    HazardSystem.register(ModBlocks.det_cord, makeData(EXPLOSIVE, 1.0F));
    HazardSystem.register(ModBlocks.det_charge, makeData(EXPLOSIVE, 30.0F));
    HazardSystem.register(ModItems.insert_du, makeData(RADIATION, 2.25F));
    HazardSystem.register(ModItems.insert_polonium, makeData(RADIATION, 100.0F));
    HazardSystem.register(ModItems.insert_ghiorsium, makeData(RADIATION, 20.0F));
    HazardSystem.register(ModItems.powder_tennessine, makeData(RADIATION, 228.0F));
    HazardSystem.register(ModItems.ingot_tcalloy, makeData(RADIATION, 0.07F));
    HazardSystem.register(ModItems.powder_tcalloy, makeData(RADIATION, 0.21000001F));
    HazardSystem.register(ModBlocks.barrel_tcalloy, makeData(RADIATION, 0.42000002F));
    HazardSystem.register(ModBlocks.block_tcalloy, makeData(RADIATION, 0.63F));
    HazardSystem.register(ModItems.ingot_ferrouranium, makeData(RADIATION, 0.175F));
    HazardSystem.register(OreDictManager.TCALLOY.plateCast(), makeData(RADIATION, 0.21000001F));
    HazardSystem.register(OreDictManager.TCALLOY.plateWelded(), makeData(RADIATION, 0.42000002F));
    HazardSystem.register(OreDictManager.TCALLOY.lightBarrel(), makeData(RADIATION, 0.21000001F));
    HazardSystem.register(OreDictManager.TCALLOY.heavyBarrel(), makeData(RADIATION, 0.42000002F));
    HazardSystem.register(OreDictManager.TCALLOY.lightReceiver(), makeData(RADIATION, 0.28F));
    HazardSystem.register(OreDictManager.TCALLOY.heavyReceiver(), makeData(RADIATION, 0.63F));
    HazardSystem.register(OreDictManager.FERRO.plateCast(), makeData(RADIATION, 0.525F));
    HazardSystem.register(OreDictManager.FERRO.heavyBarrel(), makeData(RADIATION, 1.05F));
    HazardSystem.register(OreDictManager.FERRO.heavyReceiver(), makeData(RADIATION, 1.5749999F));
    HazardSystem.register(OreDictManager.SBD.plateCast(), makeData(RADIATION, 9.0F));
    HazardSystem.register(OreDictManager.SBD.wireDense(), makeData(RADIATION, 3.0F));
    HazardSystem.register(OreDictManager.SA326.wireFine(), makeData(RADIATION, 1.65F));
    HazardSystem.register(OreDictManager.SA326.wireDense(), makeData(RADIATION, 15.0F));
    HazardSystem.register(OreDictManager.U.fragment(), makeData(RADIATION, 0.0385F));
    HazardSystem.register(OreDictManager.U233.fragment(), makeData(RADIATION, 0.55F));
    HazardSystem.register(OreDictManager.U235.fragment(), makeData(RADIATION, 0.11F));
    HazardSystem.register(OreDictManager.U238.fragment(), makeData(RADIATION, 0.0275F));
    HazardSystem.register(OreDictManager.TH232.fragment(), makeData(RADIATION, 0.011F));
    HazardSystem.register(OreDictManager.PU.fragment(), makeData(RADIATION, 0.825F));
    HazardSystem.register(OreDictManager.PU239.fragment(), makeData(RADIATION, 0.55F));
    HazardSystem.register(OreDictManager.NP237.fragment(), makeData(RADIATION, 0.275F));
    HazardSystem.register(OreDictManager.PO210.fragment(), makeData(RADIATION, 8.25F));
    HazardSystem.register(OreDictManager.TC99.fragment(), makeData(RADIATION, 0.3025F));
    HazardSystem.register(OreDictManager.RA226.fragment(), makeData(RADIATION, 0.825F));
    HazardSystem.register(OreDictManager.CO60.fragment(), makeData(RADIATION, 3.3F));
    HazardSystem.register(OreDictManager.AU198.fragment(), makeData(RADIATION, 55.0F));
    HazardSystem.register(OreDictManager.PB209.fragment(), makeData(RADIATION, 1100.0F));
    HazardSystem.register(OreDictManager.SA326.fragment(), makeData(RADIATION, 1.65F));
    HazardSystem.register(OreDictManager.SA327.fragment(), makeData(RADIATION, 1.925F));
    HazardSystem.register(OreDictManager.GH336.fragment(), makeData(RADIATION, 0.55F));
    HazardSystem.register(OreDictManager.NA.fragment(), makeData(HYDROACTIVE, 0.11F));
    HazardSystem.register(OreDictManager.LI.fragment(), makeData(HYDROACTIVE, 0.11F));
    HazardSystem.register(OreDictManager.P_WHITE.fragment(), makeData(HOT, 0.22F));
    HazardSystem.register(OreDictManager.ASBESTOS.fragment(), makeData(ASBESTOS, 0.22F));
    HazardSystem.register(OreDictManager.SEMTEX.fragment(), makeData(EXPLOSIVE, 0.275F));
    HazardSystem.register(ModBlocks.ore_tikite, makeData(RADIATION, 20.0F));
    HazardSystem.register("dustCoal", makeData(COAL, 3.0F));
    HazardSystem.register("dustTinyCoal", makeData(COAL, 0.32999998F));
    HazardSystem.register("dustLignite", makeData(COAL, 3.0F));
    HazardSystem.register("dustTinyLignite", makeData(COAL, 0.32999998F));
    HazardSystem.register(ModItems.insert_polonium, makeData(RADIATION, 100.0F));
    HazardSystem.register(ModItems.demon_core_open, makeData(RADIATION, 5.0F));
    HazardSystem.register(ModItems.demon_core_closed, makeData().addEntry(RADIATION, 1000000.0F).addEntry(NEUTRON, 10000.0F));
    HazardSystem.register(ModBlocks.lamp_demon, makeData().addEntry(RADIATION, 1000000.0F).addEntry(NEUTRON, 10000.0F));
    HazardSystem.register(ModItems.apple_lead, makeData(TOXIC, 1.0F));
    registerHazItem(ModItems.apple_schrabidium, 12.0F, 0.0F, 50.0F);
    registerHazItem(ModItems.glowing_stew, 2.0F);
    registerHazItem(ModItems.balefire_scrambled, 360000.0F, 6.0F, 30.0F, 1000.0F, 6.0F);
    registerHazItem(ModItems.balefire_and_ham, 420000.0F, 30.0F, 30.0F, 2000.0F, 6.0F);

    HazardSystem.register(ModItems.powder_poison, makeData(TOXIC, 12000.0F));
    HazardSystem.register(ModItems.nugget_lead, makeData(TOXIC, lead*nugget));
    HazardSystem.register(ModItems.ingot_lead, makeData(TOXIC, lead*ingot));
    HazardSystem.register(ModItems.crystal_lead, makeData(TOXIC, lead*crystal));
    HazardSystem.register(ModBlocks.block_lead, makeData(TOXIC, lead*block));
    HazardSystem.register(ModItems.powder_lead, makeData(TOXIC, lead*powder));
    HazardSystem.register(ModItems.plate_lead, makeData(TOXIC, lead*plate));
    HazardSystem.register(OreDictManager.PB.plateCast(), makeData(TOXIC, lead*plateCast));
    HazardSystem.register(OreDictManager.PB.pipe(), makeData(TOXIC, lead*pipe));
    HazardSystem.register(OreDictManager.PB.fragment(), makeData(TOXIC, lead*ore));
    HazardSystem.register(OreDictManager.PB.wireFine(), makeData(TOXIC, lead*wire));
    HazardSystem.register(ModItems.nugget_mercury, makeData(TOXIC, merc*nugget));
    HazardSystem.register(ModItems.ingot_mercury, makeData(TOXIC, merc*ingot));
    HazardSystem.register(ModItems.nugget_arsenic, makeData(TOXIC, ars*nugget));
    HazardSystem.register(ModItems.ingot_arsenic, makeData(TOXIC, ars*ingot));
    HazardSystem.register(OreDictManager.AS.fragment(), makeData(TOXIC, ars*ore));
    HazardSystem.register(ModItems.ingot_arsenic_bronze, makeData(TOXIC, 1650.0F));
    HazardSystem.register(OreDictManager.ABRONZE.lightBarrel(), makeData(TOXIC, 6600.0F));
    HazardSystem.register(OreDictManager.ABRONZE.plateCast(), makeData(TOXIC, 4950.0F));
    HazardSystem.register(OreDictManager.ABRONZE.lightReceiver(), makeData(TOXIC, 6600.0F));
    HazardSystem.register(OreDictManager.ABRONZE.heavyReceiver(), makeData(TOXIC, 15000.0F));
    HazardSystem.register(ModItems.ingot_gaas, makeData(TOXIC, 4950.0F));
    HazardSystem.register(ModItems.nugget_gaas, makeData(TOXIC, 544.5F));
    HazardSystem.register(ModItems.billet_gaas, makeData(TOXIC, 2475.0F));
    HazardSystem.register(ModItems.powder_ice, makeData(CRYOGENIC, 4.0F));
    HazardSystem.register(ModBlocks.ore_tikite, makeData(CRYOGENIC, 4.0F));
    HazardSystem.register(ModItems.crystal_trixite, makeData(CRYOGENIC, 40.0F));
    HazardSystem.register(ModItems.cell_tritium, makeData(RADIATION, 0.001F));
    HazardSystem.register(ModItems.cell_sas3, makeData().addEntry(RADIATION, 5.0F).addEntry(BLINDING, 60.0F));
    HazardSystem.register(ModItems.cell_balefire, makeData(RADIATION, 50.0F));
    HazardSystem.register(ModItems.powder_balefire, makeData(RADIATION, 500.0F));
    HazardSystem.register(ModItems.egg_balefire_shard, makeData(RADIATION, 33000.0F));
    HazardSystem.register(ModItems.solid_fuel_bf, makeData(RADIATION, 1000.0F));
    HazardSystem.register(ModItems.solid_fuel_presto_bf, makeData(RADIATION, 2000.0F));
    HazardSystem.register(ModItems.nuclear_waste_long, makeData(RADIATION, 5.0F));
    HazardSystem.register(ModItems.nuclear_waste_long_tiny, makeData(RADIATION, 0.5F));
    HazardSystem.register(ModItems.nuclear_waste_short, makeData().addEntry(RADIATION, 30.0F).addEntry(HOT, 5.0F));
    HazardSystem.register(ModItems.nuclear_waste_short_tiny, makeData().addEntry(RADIATION, 3.0F).addEntry(HOT, 5.0F));
    HazardSystem.register(ModItems.nuclear_waste_long_depleted, makeData(RADIATION, 0.5F));
    HazardSystem.register(ModItems.nuclear_waste_long_depleted_tiny, makeData(RADIATION, 0.05F));
    HazardSystem.register(ModItems.nuclear_waste_short_depleted, makeData(RADIATION, 3.0F));
    HazardSystem.register(ModItems.nuclear_waste_short_depleted_tiny, makeData(RADIATION, 0.3F));
    HazardSystem.register(ModItems.scrap_nuclear, makeData(RADIATION, 1.0F));
    HazardSystem.register(ModItems.trinitite, makeData(RADIATION, 0.1F));
    HazardSystem.register(ModBlocks.block_trinitite, makeData(RADIATION, 0.90000004F));
    HazardSystem.register(ModItems.nuclear_waste, makeData(RADIATION, 450.0F));
    HazardSystem.register(ModBlocks.yellow_barrel, makeData(RADIATION, 4500.0F));
    HazardSystem.register(ModItems.billet_nuclear_waste, makeData(RADIATION, 225.0F));
    HazardSystem.register(ModItems.nuclear_waste_tiny, makeData(RADIATION, 49.5F));
    HazardSystem.register(ModItems.nuclear_waste_vitrified, makeData(RADIATION, 150.0F));
    HazardSystem.register(ModItems.nuclear_waste_vitrified_tiny, makeData(RADIATION, 16.5F));
    HazardSystem.register(ModBlocks.block_waste, makeData(RADIATION, 4050.0F));
    HazardSystem.register(ModBlocks.block_waste_painted, makeData(RADIATION, 4050.0F));
    HazardSystem.register(ModBlocks.block_waste_vitrified, makeData(RADIATION, 1350.0F));
    registerHazItem(ModBlocks.ancient_scrap, 150.0F);
    registerHazItem(ModBlocks.block_corium, 10000.0F);
    registerHazItem(ModBlocks.block_corium_cobble, 1000.0F);
    registerHazItem(ModBlocks.block_schrabidium_cluster, 70.0F, 0.0F, 30.0F);
    registerHazItem(ModBlocks.block_euphemium_cluster, 50.0F, 0.0F, 20.0F);
    registerHazItem(ModBlocks.glass_lead, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F);
    registerHazItem(ModBlocks.glass_uranium, 0.0385F);
    registerHazItem(ModBlocks.glass_trinitite, 1.0F);
    registerHazItem(ModBlocks.glass_polonium, 8.25F);
    if (GeneralConfig.enable528) {
      registerHazItem(ModItems.schrabidium_hammer, 4725.0F, 0.0F, 50.0F);
      registerHazItem(ModItems.schrabidium_helmet, 75.0F, 0.0F, 50.0F);
      registerHazItem(ModItems.schrabidium_plate, 120.0F, 0.0F, 50.0F);
      registerHazItem(ModItems.schrabidium_legs, 105.0F, 0.0F, 50.0F);
      registerHazItem(ModItems.schrabidium_boots, 60.0F, 0.0F, 50.0F);
      registerHazItem(ModItems.schrabidium_sword, 135.0F, 0.0F, 50.0F);
      registerHazItem(ModItems.balefire_and_steel, 33000.0F, 5.0F);
    }
    HazardSystem.register(new ItemStack(ModBlocks.sellafield, 1, 0), makeData(RADIATION, 0.5F));
    HazardSystem.register(new ItemStack(ModBlocks.sellafield, 1, 1), makeData(RADIATION, 1.0F));
    HazardSystem.register(new ItemStack(ModBlocks.sellafield, 1, 2), makeData(RADIATION, 2.5F));
    HazardSystem.register(new ItemStack(ModBlocks.sellafield, 1, 3), makeData(RADIATION, 4.0F));
    HazardSystem.register(new ItemStack(ModBlocks.sellafield, 1, 4), makeData(RADIATION, 5.0F));
    HazardSystem.register(new ItemStack(ModBlocks.sellafield, 1, 5), makeData(RADIATION, 10.0F));
    HazardSystem.register(new ItemStack(ModBlocks.ore_sellafield_radgem), makeData(RADIATION, 25.0F));
    HazardSystem.register(new ItemStack(ModItems.gem_rad), makeData(RADIATION, 25.0F));
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.NATURAL_URANIUM_FUEL.ordinal(), 0.35F, 5175.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.URANIUM_FUEL.ordinal(), 0.5F, 4500.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.TH232.ordinal(), 0.1F, 1.75F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.THORIUM_FUEL.ordinal(), 1.75F, 3375.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.MOX_FUEL.ordinal(), 2.5F, 4500.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.PLUTONIUM_FUEL.ordinal(), 4.25F, 5625.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.U233_FUEL.ordinal(), 5.0F, 4500.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.U235_FUEL.ordinal(), 1.0F, 4950.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.LES_FUEL.ordinal(), 5.85F, 6750.0F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.LITHIUM.ordinal(), 0.0F, 0.001F, false);
    registerOtherFuel((Item)ModItems.rod_zirnox, ItemZirnoxRod.EnumZirnoxType.ZFB_MOX.ordinal(), 2.5F, 2250.0F, false);
    HazardSystem.register(ModItems.rod_zirnox_natural_uranium_fuel_depleted, makeData(RADIATION, 5175.0F));
    HazardSystem.register(ModItems.rod_zirnox_uranium_fuel_depleted, makeData(RADIATION, 4500.0F));
    HazardSystem.register(ModItems.rod_zirnox_thorium_fuel_depleted, makeData(RADIATION, 3375.0F));
    HazardSystem.register(ModItems.rod_zirnox_mox_fuel_depleted, makeData(RADIATION, 4500.0F));
    HazardSystem.register(ModItems.rod_zirnox_plutonium_fuel_depleted, makeData(RADIATION, 5625.0F));
    HazardSystem.register(ModItems.rod_zirnox_u233_fuel_depleted, makeData(RADIATION, 4500.0F));
    HazardSystem.register(ModItems.rod_zirnox_u235_fuel_depleted, makeData(RADIATION, 4950.0F));
    HazardSystem.register(ModItems.rod_zirnox_les_fuel_depleted, makeData().addEntry(RADIATION, 6750.0F).addEntry(BLINDING, 20.0F));
    HazardSystem.register(ModItems.rod_zirnox_tritium, makeData(RADIATION, 0.001F));
    HazardSystem.register(ModItems.rod_zirnox_zfb_mox_depleted, makeData(RADIATION, 2250.0F));
    registerOtherWaste(ModItems.waste_natural_uranium, 2587.5F);
    registerOtherWaste(ModItems.waste_uranium, 2250.0F);
    registerOtherWaste(ModItems.waste_thorium, 1687.5F);
    registerOtherWaste(ModItems.waste_mox, 2250.0F);
    registerOtherWaste(ModItems.waste_plutonium, 2812.5F);
    registerOtherWaste(ModItems.waste_u233, 2250.0F);
    registerOtherWaste(ModItems.waste_u235, 2475.0F);
    registerOtherWaste(ModItems.waste_schrabidium, 3375.0F);
    registerOtherWaste(ModItems.waste_zfb_mox, 1125.0F);
    registerOtherFuel(ModItems.plate_fuel_u233, 5.0F, 5850.0F, false);
    registerOtherFuel(ModItems.plate_fuel_u235, 1.0F, 4500.0F, false);
    registerOtherFuel(ModItems.plate_fuel_mox, 2.5F, 7200.0F, false);
    registerOtherFuel(ModItems.plate_fuel_pu239, 5.0F, 6075.0F, false);
    registerOtherFuel(ModItems.plate_fuel_sa326, 15.0F, 4500.0F, true);
    registerOtherFuel(ModItems.plate_fuel_ra226be, 11.25F, 74.25F, false);
    registerOtherFuel(ModItems.plate_fuel_pu238be, 15.0F, 3.3F, false);
    registerOtherWaste(ModItems.waste_plate_u233, 5850.0F);
    registerOtherWaste(ModItems.waste_plate_u235, 4500.0F);
    registerOtherWaste(ModItems.waste_plate_mox, 7200.0F);
    registerOtherWaste(ModItems.waste_plate_pu239, 6075.0F);
    registerOtherWaste(ModItems.waste_plate_sa326, 4500.0F);
    registerRadSourceWaste(ModItems.waste_plate_ra226be, 74.25F);
    registerRadSourceWaste(ModItems.waste_plate_pu238be, 3.3F);
    HazardSystem.register(ModItems.debris_graphite, makeData().addEntry(RADIATION, 70.0F).addEntry(HOT, 5.0F));
    HazardSystem.register(ModItems.debris_metal, makeData(RADIATION, 5.0F));
    HazardSystem.register(ModItems.debris_fuel, makeData().addEntry(RADIATION, 500.0F).addEntry(HOT, 5.0F));
    HazardSystem.register(ModItems.debris_concrete, makeData(RADIATION, 30.0F));
    HazardSystem.register(ModItems.debris_exchanger, makeData(RADIATION, 25.0F));
    HazardSystem.register(ModItems.debris_shrapnel, makeData(RADIATION, 2.5F));
    HazardSystem.register(ModItems.debris_element, makeData(RADIATION, 100.0F));
    HazardSystem.register(ModItems.nugget_uranium_fuel, makeData(RADIATION, 0.055F));
    HazardSystem.register(ModItems.billet_uranium_fuel, makeData(RADIATION, 0.25F));
    HazardSystem.register(ModItems.ingot_uranium_fuel, makeData(RADIATION, 0.5F));
    HazardSystem.register(ModBlocks.block_uranium_fuel, makeData(RADIATION, 4.5F));
    HazardSystem.register(ModItems.nugget_plutonium_fuel, makeData(RADIATION, 0.4675F));
    HazardSystem.register(ModItems.billet_plutonium_fuel, makeData(RADIATION, 2.125F));
    HazardSystem.register(ModItems.ingot_plutonium_fuel, makeData(RADIATION, 4.25F));
    HazardSystem.register(ModBlocks.block_plutonium_fuel, makeData(RADIATION, 38.25F));
    HazardSystem.register(ModItems.nugget_thorium_fuel, makeData(RADIATION, 0.1925F));
    HazardSystem.register(ModItems.billet_thorium_fuel, makeData(RADIATION, 0.875F));
    HazardSystem.register(ModItems.ingot_thorium_fuel, makeData(RADIATION, 1.75F));
    HazardSystem.register(ModBlocks.block_thorium_fuel, makeData(RADIATION, 15.75F));
    HazardSystem.register(ModItems.nugget_neptunium_fuel, makeData(RADIATION, 0.16499999F));
    HazardSystem.register(ModItems.billet_neptunium_fuel, makeData(RADIATION, 0.75F));
    HazardSystem.register(ModItems.ingot_neptunium_fuel, makeData(RADIATION, 1.5F));
    HazardSystem.register(ModItems.nugget_mox_fuel, makeData(RADIATION, 0.275F));
    HazardSystem.register(ModItems.billet_mox_fuel, makeData(RADIATION, 1.25F));
    HazardSystem.register(ModItems.ingot_mox_fuel, makeData(RADIATION, 2.5F));
    HazardSystem.register(ModBlocks.block_mox_fuel, makeData(RADIATION, 22.5F));
    HazardSystem.register(ModItems.nugget_americium_fuel, makeData(RADIATION, 0.5225F));
    HazardSystem.register(ModItems.billet_americium_fuel, makeData(RADIATION, 2.375F));
    HazardSystem.register(ModItems.ingot_americium_fuel, makeData(RADIATION, 4.75F));
    HazardSystem.register(ModItems.nugget_schrabidium_fuel, makeData().addEntry(RADIATION, 0.6435F).addEntry(BLINDING, 0.55F));
    HazardSystem.register(ModItems.billet_schrabidium_fuel, makeData().addEntry(RADIATION, 2.925F).addEntry(BLINDING, 2.5F));
    HazardSystem.register(ModItems.ingot_schrabidium_fuel, makeData().addEntry(RADIATION, 5.85F).addEntry(BLINDING, 5.0F));
    HazardSystem.register(ModBlocks.block_schrabidium_fuel, makeData().addEntry(RADIATION, 52.649998F).addEntry(BLINDING, 45.0F));
    HazardSystem.register(ModItems.nugget_hes, makeData(RADIATION, 0.6435F));
    HazardSystem.register(ModItems.billet_hes, makeData(RADIATION, 2.925F));
    HazardSystem.register(ModItems.ingot_hes, makeData(RADIATION, 5.85F));
    HazardSystem.register(ModItems.nugget_les, makeData(RADIATION, 0.6435F));
    HazardSystem.register(ModItems.billet_les, makeData(RADIATION, 2.925F));
    HazardSystem.register(ModItems.ingot_les, makeData(RADIATION, 5.85F));
    HazardSystem.register(ModItems.billet_balefire_gold, makeData(RADIATION, 250.0F).addEntry(NEUTRON, 5.0F));
    HazardSystem.register(ModItems.billet_flashlead, makeData().addEntry(RADIATION, 6250.0F).addEntry(HOT, 7.0F).addEntry(NEUTRON, 10.0F));
    HazardSystem.register(ModItems.billet_po210be, makeData().addEntry(RADIATION, 112.5F).addEntry(NEUTRON, 11.25F));
    HazardSystem.register(ModItems.billet_ra226be, makeData().addEntry(RADIATION, 11.25F).addEntry(NEUTRON, 1.125F));
    HazardSystem.register(ModItems.billet_pu238be, makeData().addEntry(RADIATION, 15.0F).addEntry(NEUTRON, 1.5F));
    registerHazItem(ModItems.billet_zfb_bismuth, 0.175F);
    registerHazItem(ModItems.billet_zfb_pu241, 6.25F);
    registerHazItem(ModItems.billet_zfb_am_mix, 2.25F);
    registerHazItem(ModItems.pellet_rtg_radium, 11.25F, 0.0F, 0.0F, 0.0F, 7.0F);
    registerHazItem(ModItems.pellet_rtg_weak, 0.375F);
    registerHazItem(ModItems.pellet_rtg, 15.0F, 5.0F);
    registerHazItem(ModItems.pellet_rtg_strontium, 22.5F, 5.0F);
    registerHazItem(ModItems.pellet_rtg_cobalt, 45.0F, 5.0F);
    registerHazItem(ModItems.pellet_rtg_actinium, 45.0F, 5.0F);
    registerHazItem(ModItems.pellet_rtg_americium, 12.75F, 10.0F);
    registerHazItem(ModItems.pellet_rtg_polonium, 112.5F, 15.0F);
    registerHazItem(ModItems.pellet_rtg_gold, 750.0F, 15.0F);
    registerHazItem(ModItems.pellet_rtg_lead, 15000.0F, 15.0F, 5.0F, 2.0F, 0.0F);
    registerHazItem(ModItems.pellet_charged, 420.0F);
    registerHazItem(ModBlocks.sellafield_slaked, 2.5F);
    registerHazItem(ModBlocks.waste_leaves, 0.15F);
    for (int i = 0; i < 7; i++) {
      registerHazItem(new ItemStack(ModBlocks.waste_mycelium, 1, i), (i + 1) * 7.5F);
      registerHazItem(new ItemStack(ModBlocks.waste_earth, 1, i), ((i + 1) * 4));
      registerHazItem(new ItemStack(ModBlocks.waste_trinitite, 1, i), ((i + 1) * 10));
      registerHazItem(new ItemStack(ModBlocks.waste_trinitite_red, 1, i), ((i + 1) * 10));
    }
    HazardSystem.register(new ItemStack(ModItems.pellet_rtg_depleted, 1, ItemRTGPelletDepleted.DepletedRTGMaterial.NEPTUNIUM.ordinal()), makeData(RADIATION, 3.75F));
    HazardSystem.register(new ItemStack(ModItems.pellet_rtg_depleted, 1, ItemRTGPelletDepleted.DepletedRTGMaterial.AMERICIUM.ordinal()), makeData(RADIATION, 13.5F));
    HazardSystem.register(ModItems.pile_rod_uranium, makeData(RADIATION, 0.525F));
    HazardSystem.register(ModItems.pile_rod_pu239, makeData(RADIATION, !GeneralConfig.enable528 ? 5.8F : 230.625F));
    HazardSystem.register(ModItems.pile_rod_plutonium, makeData().addEntry(RADIATION, !GeneralConfig.enable528 ? 6.425F : 231.25F).addEntry(NEUTRON, 2.25F));
    HazardSystem.register(ModItems.pile_rod_source, makeData().addEntry(RADIATION, 33.75F).addEntry(NEUTRON, 3.3750002F));
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.TRITIUM, 0.001F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.CO60, 30.0F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.RA226, 7.5F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.AC227, 30.0F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.TH232, 0.1F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.THF, 1.75F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.U235, 1.0F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.NP237, 2.5F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.U238, 0.25F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.PU238, 10.0F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.PU239, 5.0F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.RGP, 6.25F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.WASTE, 450.0F);
    registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType.URANIUM, 0.35F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_ueu, 1.4F, 36000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_meu, 2.0F, 38700.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_heu233, 20.0F, 55800.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_heu235, 4.0F, 54000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_thmeu, 7.0F, 31500.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_lep, 17.0F, 45000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_mep, 25.0F, 54000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_hep239, 20.0F, 58500.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_hep241, 100.0F, 63000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_lea, 19.0F, 46800.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_mea, 36.0F, 54900.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_hea241, 34.0F, 60300.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_hea242, 38.0F, 61200.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_bk247, 42.0F, 68400.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_men, 6.0F, 40500.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_hen, 10.0F, 54000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_mox, 10.0F, 45900.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_les, 23.4F, 44100.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_mes, 23.4F, 54000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_hes, 23.4F, 90000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_leaus, 0.0F, 67500.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_heaus, 0.0F, 58500.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_po210be, 900.0F, 90.0F, true);
    registerRBMKRod((Item)ModItems.rbmk_fuel_ra226be, 90.0F, 36.0F, true);
    registerRBMKRod((Item)ModItems.rbmk_fuel_pu238be, 120.0F, 4500.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_balefire_gold, 2000.0F, 600000.0F, true);
    registerRBMKRod((Item)ModItems.rbmk_fuel_flashlead, 50000.0F, 220.0F, true);
    registerRBMKRod((Item)ModItems.rbmk_fuel_balefire, 1200000.0F, 1.2E8F, true);
    registerRBMKRod((Item)ModItems.rbmk_fuel_zfb_bismuth, 10.0F, 9000.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_zfb_pu241, 2.0F, 13500.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_zfb_am_mix, 10.0F, 18000.0F);
    registerRBMK((Item)ModItems.rbmk_fuel_drx, 1200000.0F, 1.2E8F, true, true, 0.0F, 0.33333334F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_lecm, 10.56F, 1800.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_mecm, 17.6F, 5400.0F);
    registerRBMKRod((Item)ModItems.rbmk_fuel_hecm, 35.2F, 9000.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_ueu, 0.175F, 4500.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_meu, 0.25F, 4837.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_heu233, 2.5F, 6975.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_heu235, 0.5F, 6750.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_thmeu, 0.875F, 3937.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_lep, 2.125F, 5625.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_mep, 3.125F, 6750.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_hep239, 2.5F, 7312.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_hep241, 12.5F, 7875.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_lea, 2.375F, 5850.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_mea, 4.5F, 6862.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_hea241, 4.25F, 7537.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_hea242, 4.75F, 7650.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_bk247, 5.25F, 8325.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_men, 0.75F, 5062.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_hen, 1.25F, 6750.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_mox, 1.25F, 5737.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_les, 2.925F, 5512.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_mes, 2.925F, 6750.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_hes, 2.925F, 11250.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_leaus, 0.0F, 8437.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_heaus, 0.0F, 7312.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_po210be, 112.5F, 11.25F, true);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_ra226be, 11.25F, 4.5F, true);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_pu238be, 15.0F, 675.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_balefire_gold, 250.0F, 75000.0F, true);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_flashlead, 6250.0F, 55.0F, true, 0.0F, 0.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_balefire, 150000.0F, 1.5E7F, true);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_zfb_bismuth, 1.25F, 1125.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_zfb_pu241, 0.25F, 1687.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_zfb_am_mix, 1.25F, 2250.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_drx, 150000.0F, 1.5E7F, true, 0.0F, 0.041666668F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_lecm, 3.0F, 17212.5F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_mecm, 3.0F, 17901.0F);
    registerRBMKPellet((Item)ModItems.rbmk_pellet_hecm, 3.0F, 18589.5F);
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.SCHRABIDIUM), makeData(RADIATION, 60.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.HES), makeData(RADIATION, 23.4F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.MES), makeData(RADIATION, 23.4F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.LES), makeData(RADIATION, 23.4F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.HEN), makeData(RADIATION, 10.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.MEU), makeData(RADIATION, 2.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.MEP), makeData(RADIATION, 25.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.DU), makeData(RADIATION, 1.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.NQD), makeData(RADIATION, 4.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.NQR), makeData(RADIATION, 20.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.PU241), makeData(RADIATION, 100.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.AMRG), makeData(RADIATION, 36.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.CMRG), makeData(RADIATION, 24.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.CMF), makeData(RADIATION, 8.8F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.BK247), makeData(RADIATION, 42.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.CF252), makeData(RADIATION, 61.2F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.watz_pellet, (Enum)ItemWatzPellet.EnumWatzType.ES253), makeData(RADIATION, 73.2F));
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.MEU, 0.5F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HEU233, 5.0F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HEU235, 1.0F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.MEN, 1.5F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HEN237, 2.5F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.MOX, 2.5F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.MEP, 6.25F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HEP239, 5.0F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HEP241, 25.0F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.MEA, 9.0F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HEA242, 9.5F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HES326, 15.0F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.HES327, 17.5F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.BFB_AM_MIX, 4.5F);
    registerPWRFuel(ItemPWRFuel.EnumPWRFuel.BFB_PU241, 12.5F);
    HazardSystem.register(ModItems.powder_yellowcake, makeData(RADIATION, 1.26F));
    HazardSystem.register(ModBlocks.block_yellowcake, makeData(RADIATION, 11.34F));
    HazardSystem.register(ModItems.fallout, makeData(RADIATION, 30.0F));
    HazardSystem.register(ModBlocks.fallout, makeData(RADIATION, 60.0F));
    HazardSystem.register(ModBlocks.block_fallout, makeData(RADIATION, 11.34F));
    HazardSystem.register(ModItems.powder_caesium, makeData().addEntry(HYDROACTIVE, 1.0F).addEntry(HOT, 3.0F));
    HazardSystem.register(ModItems.crystal_uranium, makeData(RADIATION, 3.1499999F));
    HazardSystem.register(ModItems.crystal_thorium, makeData(RADIATION, 0.90000004F));
    HazardSystem.register(ModItems.crystal_plutonium, makeData(RADIATION, 67.5F));
    HazardSystem.register(ModItems.crystal_schraranium, makeData(RADIATION, 13.5F));
    HazardSystem.register(ModItems.crystal_schrabidium, makeData(RADIATION, 135.0F));
    HazardSystem.register(ModItems.crystal_phosphorus, makeData(HOT, 18.0F));
    HazardSystem.register(ModItems.crystal_lithium, makeData(HYDROACTIVE, 9.0F));
    HazardSystem.register(ModItems.crystal_trixite, makeData(RADIATION, 225.0F));
    registerHazItem(ModItems.powder_yellowcake, 1.26F);
    registerHazItem(ModBlocks.block_yellowcake, 11.34F);
    HazardSystem.register(ModItems.fallout, makeData(RADIATION, 30.0F));
    registerHazItem(ModBlocks.fallout, 60.0F);
    registerHazItem(ModBlocks.block_fallout, 270.0F);
    HazardSystem.register(ModBlocks.brick_asbestos, makeData(ASBESTOS, 1.0F));
    HazardSystem.register(ModBlocks.brick_asbestos_stairs, makeData(ASBESTOS, 0.75F));
    HazardSystem.register(ModBlocks.tile_lab_broken, makeData(ASBESTOS, 1.0F));
    HazardSystem.register(ModBlocks.concrete_asbestos, makeData(ASBESTOS, 1.0F));
    HazardSystem.register(ModBlocks.concrete_asbestos_stairs, makeData(ASBESTOS, 0.75F));
    HazardSystem.register(ModBlocks.deco_lead, makeData(TOXIC, 1.0F));
    HazardSystem.register(ModBlocks.deco_asbestos, makeData(ASBESTOS, 0.75F));
    HazardSystem.register(ModItems.powder_coltan_ore, makeData(ASBESTOS, 3.0F));
    HazardSystem.register(ModBlocks.ash_digamma, makeData(DIGAMMA, 0.001F));
    HazardSystem.register(ModBlocks.digamma_matter, makeData(DIGAMMA, 0.2F));
    HazardSystem.register(ModItems.particle_digamma, makeData(RADIATION, 100.0F).addEntry(DIGAMMA, 0.3333F));
    HazardSystem.register(ModBlocks.frozen_grass, makeData(CRYOGENIC, 3.0F));
    HazardSystem.register(ModBlocks.frozen_log, makeData(CRYOGENIC, 2.0F));
    HazardSystem.register(ModBlocks.frozen_planks, makeData(CRYOGENIC, 2.0F));
    HazardSystem.register(ModBlocks.frozen_dirt, makeData(CRYOGENIC, 1.0F));
    HazardSystem.register(ModBlocks.waste_log, makeData(COAL, 2.0F));
    HazardSystem.register(ModBlocks.waste_planks, makeData(COAL, 1.0F));
    HazardSystem.register(ModItems.boy_propellant, makeData(EXPLOSIVE, 2.0F));
    HazardSystem.register(ModItems.gadget_core, makeData(RADIATION, 5.5F));
    HazardSystem.register(ModItems.boy_target, makeData(RADIATION, 2.0F));
    HazardSystem.register(ModItems.boy_bullet, makeData(RADIATION, 1.0F));
    HazardSystem.register(ModItems.man_core, makeData(RADIATION, 5.5F));
    HazardSystem.register(ModItems.mike_core, makeData(RADIATION, 0.275F));
    HazardSystem.register(ModItems.tsar_core, makeData(RADIATION, 8.25F));
    HazardSystem.register(ModItems.fleija_propellant, makeData().addEntry(RADIATION, 15.0F).addEntry(EXPLOSIVE, 8.0F).addEntry(BLINDING, 50.0F));
    HazardSystem.register(ModItems.fleija_core, makeData(RADIATION, 10.0F));
    HazardSystem.register(ModItems.solinium_propellant, makeData(EXPLOSIVE, 10.0F));
    HazardSystem.register(ModItems.solinium_core, makeData().addEntry(RADIATION, 15.4F).addEntry(BLINDING, 45.0F));
    HazardSystem.register(ModItems.part_lithium, makeData(HYDROACTIVE, 2.0F));
    HazardSystem.register(ModItems.part_carbon, makeData(COAL, 2.0F));
    registerHazItem(ModItems.part_plutonium, 5.625F);
    HazardSystem.register(ModBlocks.nuke_fstbmb, makeData(DIGAMMA, 0.01F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.holotape_image, (Enum)ItemHolotapeImage.EnumHoloImage.HOLO_RESTORED), makeData(DIGAMMA, 1.0F));
    HazardSystem.register(ModItems.holotape_damaged, makeData(DIGAMMA, 1000.0F));

    for (String oreg : OreDictManager.AS.all(MaterialShapes.ORE))
      HazardSystem.register(oreg, makeData(TOXIC, 12000.0F));
    for (String oreg : OreDictManager.PB.all(MaterialShapes.ORE))
      HazardSystem.register(oreg, makeData(TOXIC, 120.0F));

    Item recWaste = Compat.tryLoadItem("ReactorCraft", "reactorcraft_item_waste");
    if (recWaste != null)
      for (Compat.ReikaIsotope reikaIsotope : Compat.ReikaIsotope.values()) {
        if (reikaIsotope.getRad() > 0.0F)
          HazardSystem.register(new ItemStack(recWaste, 1, reikaIsotope.ordinal()), makeData(RADIATION, reikaIsotope.getRad()));
      }
    if (Compat.isModLoaded("gregtech")) {
      Object[][] data = { { "Naquadah", Float.valueOf(0.35F) }, { "Naquadah-Enriched", Float.valueOf(1.0F) }, { "Naquadria", Float.valueOf(5.0F) } };
      for (MaterialShapes shape : MaterialShapes.allShapes) {
        if (!shape.noAutogen)
          for (String prefix : shape.prefixes) {
            for (Object[] o : data)
              HazardSystem.register(prefix + o[0], (new HazardData()).setMutex(1).addEntry(new HazardEntry(RADIATION, ((Float)o[1]).floatValue() * shape.q(1) / MaterialShapes.INGOT.q(1))));
          }
      }
    }
    registerHazItem(ModBlocks.hadron_coil_magtung, 1.65F);
    registerHazItem(ModBlocks.hadron_coil_schrabidium, 31.65F);
    registerHazItem(ModBlocks.hadron_coil_schrabidate, 36.0F);
    registerFluid("radwater_fluid", 4.0F, 0.0F);
    registerFluid("hydrogen", 0.0F, 0.0F, 0.0F, 4.0F, 0.0F);
    registerFluid("deuterium", 0.0F, 0.0F, 0.0F, 4.0F, 0.0F);
    registerFluid("tritium", 0.5F, 0.0F, 0.0F, 4.0F, 0.0F);
    registerFluid("uf6", 2.0F, 0.0F);
    registerFluid("puf6", 10.0F, 0.0F);
    registerFluid("sas3", 20.0F, 50.0F);
    registerFluid("wastefluid", 80.0F, 0.0F);
    registerFluid("wastegas", 70.0F, 0.0F);
    registerFluid("toxic_fluid", 1000.0F, 0.0F, 50.0F, 0.0F, 0.0F);
    registerFluid("mud_fluid", 400.0F, 0.0F, 800.0F, 0.0F, 0.0F);
    registerFluid("radiosolvent", 200.0F, 0.0F, 200.0F, 0.0F, 0.0F);
    registerFluid("schrabidic", 700.0F, 20.0F);
    registerFluid("corium_fluid", 10000.0F, 0.0F);
    registerFluid("mercury", 0.0F, 0.0F, 2.0F, 0.0F, 0.0F);
    registerFluid("gasoline", 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    registerFluid("balefire", 20000.0F, 0.0F);
    registerFluid("liquid_osmiridium", 20.0F, 0.0F, 0.0F, 0.0F, 0.005F);
    registerFluid("iongel", 1.0F, 0.0F);
    registerFluid("poison", 0.0F, 0.0F, 7000.0F, 0.0F, 0.0F);
    registerFluid("liquidlithium", 0.0F, 0.0F, 0.0F, 5.0F, 0.0F);
    registerFluid("liquidtritium", 0.5F, 0.0F, 0.0F, 4.0F, 0.0F);
    registerFluid("liquiddeuterium", 0.0F, 0.0F, 0.0F, 4.0F, 0.0F);
    registerFluid("liquidhydrogen", 0.0F, 0.0F, 0.0F, 4.0F, 0.0F);
    registerFluid("nitroglycerin", 0.0F, 0.0F, 0.0F, 10.0F, 0.0F);
  }

  public static void registerTrafos() {
    HazardSystem.trafos.add(new HazardTransformerRadiationNBT());
    if (!GeneralConfig.enableLBSM || !GeneralConfig.enableLBSMSafeCrates)
      HazardSystem.trafos.add(new HazardTransformerRadiationContainer());
    if (!GeneralConfig.enableLBSM || !GeneralConfig.enableLBSMSafeMEDrives)
      HazardSystem.trafos.add(new HazardTransformerRadiationME());
  }

  private static void registerHazItem(Object item, float rads) {
    registerHazItem(item, rads, 0.0F, 0.0F, 0.0F, 0.0F);
  }

  private static void registerHazItem(Object item, float rads, float hot) {
    registerHazItem(item, rads, hot, 0.0F, 0.0F, 0.0F);
  }

  private static void registerHazItem(Object item, float rads, float hot, float blind) {
    registerHazItem(item, rads, hot, blind, 0.0F, 0.0F);
  }

  private static void registerHazItem(Object item, float rads, float hot, float blind, float tox, float hydro) {
    HazardData data = new HazardData();
    if (rads > 0.0F)
      data.addEntry(new HazardEntry(RADIATION, rads));
    if (hot > 0.0F)
      data.addEntry(new HazardEntry(HOT, hot));
    if (tox > 0.0F)
      data.addEntry(new HazardEntry(TOXIC, tox));
    if (blind > 0.0F)
      data.addEntry(new HazardEntry(BLINDING, hot));
    if (hydro > 0.0F)
      data.addEntry(new HazardEntry(HYDROACTIVE, hydro));
    if (!data.entries.isEmpty())
      HazardSystem.register(item, data);
  }

  private static void registerFluid(String f, float rads, float blind) {
    registerFluid(f, rads, blind, 0.0F, 0.0F, 0.0F);
  }

  private static void registerFluid(String f, float rads, float blind, float tox, float expl, float dig) {
    Fluid fluid = FluidRegistry.getFluid(f);
    if (fluid == null)
      return;
    int temp = fluid.getTemperature() - 273;
    HazardData data = new HazardData();
    if (rads > 0.0F)
      data.addEntry(new HazardEntry(RADIATION, rads));
    if (temp > 100)
      data.addEntry(new HazardEntry(HOT, Math.min(50.0F, temp / 50.0F)));
    if (temp < -60)
      data.addEntry(new HazardEntry(CRYOGENIC, Math.abs(temp / 20.0F)));
    if (tox > 0.0F)
      data.addEntry(new HazardEntry(TOXIC, tox));
    if (blind > 0.0F)
      data.addEntry(new HazardEntry(BLINDING, blind));
    if (expl > 0.0F)
      data.addEntry(new HazardEntry(EXPLOSIVE, expl));
    if (dig > 0.0F)
      data.addEntry(new HazardEntry(DIGAMMA, dig));
    if (!data.entries.isEmpty())
      HazardSystem.registerFluid(f, data);
  }

  private static void registerFluidBasic(Fluid fluid) {
    int temp = fluid.getTemperature() - 273;
    HazardData data = new HazardData();
    if (temp > 100)
      data.addEntry(new HazardEntry(HOT, Math.min(50.0F, temp / 50.0F)));
    if (temp < -60)
      data.addEntry(new HazardEntry(CRYOGENIC, Math.abs(temp / 20.0F)));
    if (!data.entries.isEmpty())
      HazardSystem.registerFluid(fluid.getName(), data);
  }

  private static HazardData makeData() {
    return new HazardData();
  }

  private static HazardData makeData(HazardTypeBase hazard) {
    return (new HazardData()).addEntry(hazard);
  }

  private static HazardData makeData(HazardTypeBase hazard, float level) {
    return (new HazardData()).addEntry(hazard, level);
  }

  private static HazardData makeData(HazardTypeBase hazard, float level, boolean override) {
    return (new HazardData()).addEntry(hazard, level, override);
  }

  private static void registerPWRFuel(ItemPWRFuel.EnumPWRFuel fuel, float baseRad) {
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.pwr_fuel, (Enum)fuel), makeData(RADIATION, baseRad));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.pwr_fuel_hot, (Enum)fuel), makeData(RADIATION, baseRad * 10.0F).addEntry(HOT, 5.0F));
    HazardSystem.register(OreDictManager.DictFrame.fromOne(ModItems.pwr_fuel_depleted, (Enum)fuel), makeData(RADIATION, baseRad * 10.0F));
  }

  private static void registerRBMKPellet(Item pellet, float base, float dep) {
    registerRBMKPellet(pellet, base, dep, false, 0.0F, 0.0F);
  }

  private static void registerRBMKPellet(Item pellet, float base, float dep, boolean linear) {
    registerRBMKPellet(pellet, base, dep, linear, 0.0F, 0.0F);
  }

  private static void registerRBMKPellet(Item pellet, float base, float dep, boolean linear, float blinding, float digamma) {
    HazardData data = new HazardData();
    data.addEntry((new HazardEntry(RADIATION, base)).addMod((HazardModifier)new HazardModifierRBMKRadiation(dep, linear)));
    if (blinding > 0.0F)
      data.addEntry(new HazardEntry(BLINDING, blinding));
    if (digamma > 0.0F)
      data.addEntry(new HazardEntry(DIGAMMA, digamma));
    HazardSystem.register(pellet, data);
  }

  private static void registerRBMKRod(Item rod, float base, float dep) {
    registerRBMK(rod, base, dep, true, false, 0.0F, 0.0F);
  }

  private static void registerRBMKRod(Item rod, float base, float dep, float blinding) {
    registerRBMK(rod, base, dep, true, false, blinding, 0.0F);
  }

  private static void registerRBMKRod(Item rod, float base, float dep, boolean linear) {
    registerRBMK(rod, base, dep, true, linear, 0.0F, 0.0F);
  }

  private static void registerRBMK(Item rod, float base, float dep, boolean hot, boolean linear, float blinding, float digamma) {
    HazardData data = new HazardData();
    data.addEntry((new HazardEntry(RADIATION, base)).addMod((HazardModifier)new HazardModifierRBMKRadiation(dep, linear)));
    if (hot)
      data.addEntry((new HazardEntry(HOT, 0.0F)).addMod((HazardModifier)new HazardModifierRBMKHot()));
    if (blinding > 0.0F)
      data.addEntry(new HazardEntry(BLINDING, blinding));
    if (digamma > 0.0F)
      data.addEntry(new HazardEntry(DIGAMMA, digamma));
    HazardSystem.register(rod, data);
  }

  private static void registerBreedingRodRadiation(ItemBreedingRod.BreedingRodType type, float base) {
    HazardSystem.register(new ItemStack(ModItems.rod, 1, type.ordinal()), makeData(RADIATION, base));
    HazardSystem.register(new ItemStack(ModItems.rod_dual, 1, type.ordinal()), makeData(RADIATION, base * 1.0F));
    HazardSystem.register(new ItemStack(ModItems.rod_quad, 1, type.ordinal()), makeData(RADIATION, base * 2.0F));
  }

  private static void registerOtherFuel(Item fuel, float base, float target, boolean blinding) {
    HazardData data = new HazardData();
    data.addEntry((new HazardEntry(RADIATION, base)).addMod((HazardModifier)new HazardModifierFuelRadiation(target)));
    if (blinding)
      data.addEntry(BLINDING, 20.0F);
    HazardSystem.register(fuel, data);
  }

  private static void registerOtherFuel(Item fuel, int meta, float base, float target, boolean blinding) {
    HazardData data = new HazardData();
    data.addEntry((new HazardEntry(RADIATION, base)).addMod((HazardModifier)new HazardModifierFuelRadiation(target)));
    if (blinding)
      data.addEntry(BLINDING, 20.0F);
    HazardSystem.register(new ItemStack(fuel, 1, meta), data);
  }

  private static void registerRTGPellet(Item pellet, float base, float target) {
    registerRTGPellet(pellet, base, target, 0.0F, 0.0F);
  }

  private static void registerRTGPellet(Item pellet, float base, float target, float hot) {
    registerRTGPellet(pellet, base, target, hot, 0.0F);
  }

  private static void registerRTGPellet(Item pellet, float base, float target, float hot, float blinding) {
    HazardData data = new HazardData();
    data.addEntry((new HazardEntry(RADIATION, base)).addMod((HazardModifier)new HazardModifierRTGRadiation(target)));
    if (hot > 0.0F)
      data.addEntry(new HazardEntry(HOT, hot));
    if (blinding > 0.0F)
      data.addEntry(new HazardEntry(BLINDING, blinding));
    HazardSystem.register(pellet, data);
  }

  private static void registerOtherWaste(Item waste, float base) {
    HazardSystem.register(new ItemStack(waste, 1, 0), makeData(RADIATION, base * 0.075F));
    HazardData data = new HazardData();
    data.addEntry(new HazardEntry(RADIATION, base));
    data.addEntry(new HazardEntry(HOT, 5.0F));
    HazardSystem.register(new ItemStack(waste, 1, 1), data);
  }

  private static void registerRadSourceWaste(Item waste, float base) {
    HazardSystem.register(new ItemStack(waste, 1, 0), makeData(RADIATION, base));
    HazardData data = new HazardData();
    data.addEntry(new HazardEntry(RADIATION, base));
    data.addEntry(new HazardEntry(HOT, 5.0F));
    HazardSystem.register(new ItemStack(waste, 1, 1), data);
  }
}
