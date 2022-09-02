package net.rugmj.logicalredstone.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rugmj.logicalredstone.StateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Block.class)
public class OnPlaceMixin {
	@Inject(method = "onPlaced", at = @At("HEAD"))
	public void onPlaced(World world, BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, ItemStack itemStack, CallbackInfo info) {

		if (!StateManager.getAutoDustState()) return;
		if (!state.getBlock().getName().getString().contains("Wool")) return;
		if (!world.getBlockState(pos.up(1)).isAir()) return;
		world.setBlockState(pos.up(1), Blocks.REDSTONE_WIRE.getDefaultState());
	}
}
