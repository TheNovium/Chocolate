package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.common.block.BarrelOfBlock;
import com.awriterish.chocolate.setup.registration.ModBlocks;
import com.awriterish.chocolate.setup.registration.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;


public class ChocolateRecipes extends RecipeProvider {
    public ChocolateRecipes(DataGenerator gen){
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        //Single item crafting recipes
        {
            ShapelessRecipeBuilder.shapeless(ModItems.RUBY.get(), 9)
                    .requires(ModBlocks.RUBY_BLOCK.get(), 1)
                    .unlockedBy("ruby_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.RUBY_BLOCK.get()));
        }

        //Basic shapeless crafting recipes
        {
            ShapelessRecipeBuilder.shapeless(ModBlocks.RUBY_BLOCK.get(), 1)
                    .requires(ModItems.RUBY.get(), 9)
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer, "ruby_block");
            ShapelessRecipeBuilder.shapeless(ModItems.SALMON_SUSHI_ROLL.get())
                    .requires(ModItems.RICE.get())
                    .requires(Items.DRIED_KELP)
                    .requires(Items.SALMON)
                    .unlockedBy("rice", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RICE.get(), Items.DRIED_KELP, Items.SALMON))
                    .save(consumer, "salmon_sushi_roll");
            ShapelessRecipeBuilder.shapeless(Items.STRING, 4)
                    .requires(Ingredient.of(ItemTags.WOOL))
                    .requires(ModItems.CRAB_CLAW.get())
                    .unlockedBy("string_creation", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRAB_CLAW.get(), Items.WHITE_WOOL))
                    .save(consumer, "string_from_claw");
        }

        //Special Recipes (e.g. fireworks)
        {
        }

        //Shaped crafting recipes
        {
            /*ShapedRecipeBuilder.shaped(ModBlocks.BARREL_OF.get())
                    .pattern("www")
                    .pattern("wiw")
                    .pattern("www")
                    .group("chocolate")
                    .unlockedBy("barrel_of", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.PLANKS).build()))
                    .save(consumer);*/
            ShapedRecipeBuilder.shaped(ModBlocks.CARROT_CAKE.get())
                    .pattern("cmc")
                    .pattern("ses")
                    .pattern("www")
                    .define('c', Items.CARROT)
                    .define('m', Items.MILK_BUCKET)
                    .define('s', Items.SUGAR)
                    .define('e', Items.EGG)
                    .define('w', Items.WHEAT)
                    .group("chocolate")
                    .unlockedBy("carrot_cake", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CARROT, Items.MILK_BUCKET, Items.SUGAR, Items.WHEAT, Items.EGG))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.CRAB_BOOTS.get())
                    .pattern("c c")
                    .pattern("c c")
                    .define('c', ModItems.CRAB_CLAW.get())
                    .group("chocolate")
                    .unlockedBy("crab_claw_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRAB_CLAW.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModBlocks.REDSTONE_GATE.get())
                    .pattern("tqt")
                    .pattern("sss")
                    .define('t', Items.REDSTONE_TORCH)
                    .define('q', Items.QUARTZ)
                    .define('s', Items.STONE)
                    .unlockedBy("redstone_gate", InventoryChangeTrigger.TriggerInstance.hasItems(Items.REDSTONE_TORCH, Items.QUARTZ, Items.STONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_AXE.get())
                    .pattern("rr")
                    .pattern("rs")
                    .pattern(" s")
                    .define('r', ModItems.RUBY.get())
                    .define('s', Items.STICK)
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_BOOTS.get())
                    .pattern("r r")
                    .pattern("r r")
                    .define('r', ModItems.RUBY.get())
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_CHESTPLATE.get())
                    .pattern("r r")
                    .pattern("rrr")
                    .pattern("rrr")
                    .define('r', ModItems.RUBY.get())
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_HELMET.get())
                    .pattern("rrr")
                    .pattern("r r")
                    .define('r', ModItems.RUBY.get())
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_HOE.get())
                    .pattern("rr")
                    .pattern(" s")
                    .pattern(" s")
                    .define('r', ModItems.RUBY.get())
                    .define('s', Items.STICK)
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_LEGGINGS.get())
                    .pattern("rrr")
                    .pattern("r r")
                    .pattern("r r")
                    .define('r', ModItems.RUBY.get())
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_PICKAXE.get())
                    .pattern("rrr")
                    .pattern(" s ")
                    .pattern(" s ")
                    .define('r', ModItems.RUBY.get())
                    .define('s', Items.STICK)
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_SHOVEL.get())
                    .pattern("r")
                    .pattern("s")
                    .pattern("s")
                    .define('r', ModItems.RUBY.get())
                    .define('s', Items.STICK)
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(ModItems.RUBY_SWORD.get())
                    .pattern("r")
                    .pattern("r")
                    .pattern("s")
                    .define('r', ModItems.RUBY.get())
                    .define('s', Items.STICK)
                    .group("chocolate")
                    .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBY.get()))
                    .save(consumer);
        }

        //Smelting recipes
        {
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.END_STONE_RUBY_ORE_ITEM.get()),
                            ModItems.RUBY.get(), 1.5f, 100)
                    .unlockedBy("has_ore", has(ModItems.END_STONE_RUBY_ORE_ITEM.get()))
                    .save(consumer, "ruby");
            SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.RAW_CRAB_MEAT.get()),
                            ModItems.COOKED_CRAB_MEAT.get(), 0.8f, 100)
                    .unlockedBy("has_food", has(ModItems.RAW_CRAB_MEAT.get()))
                    .save(consumer, "cooked_crab_meat");
        }
    }
}
