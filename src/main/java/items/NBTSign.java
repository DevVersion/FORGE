package items;

import net.minecraft.block.BlockStandingSign;
import net.minecraft.block.BlockWallSign;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSign;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class NBTSign extends ItemSign {

	public NBTSign() {
		this.maxStackSize = 16;

	}

	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (side == EnumFacing.DOWN) {
			return false;
		} else if (!worldIn.getBlockState(pos).getBlock().getMaterial().isSolid()) {
			return false;
		} else {
			pos = pos.offset(side);

			if (!playerIn.canPlayerEdit(pos, side, stack)) {
				return false;
			} else if (!Blocks.standing_sign.canPlaceBlockAt(worldIn, pos)) {
				return false;
			} else if (worldIn.isRemote) {
				return true;
			} else {
				if (side == EnumFacing.UP) {
					int i = MathHelper.floor_double((double) ((playerIn.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					worldIn.setBlockState(pos, Blocks.standing_sign.getDefaultState().withProperty(BlockStandingSign.ROTATION, Integer.valueOf(i)), 3);
				} else {
					worldIn.setBlockState(pos, Blocks.wall_sign.getDefaultState().withProperty(BlockWallSign.FACING, side), 3);
				}

				--stack.stackSize;
				TileEntity tileentity = worldIn.getTileEntity(pos);

				if (tileentity instanceof TileEntitySign && !ItemBlock.setTileEntityNBT(worldIn, pos, stack, playerIn)) {
					playerIn.openEditSign((TileEntitySign) tileentity);
				}

				return true;
			}
		}
	}
}
