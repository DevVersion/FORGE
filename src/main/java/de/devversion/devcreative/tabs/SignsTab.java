package de.devversion.devcreative.tabs;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSign;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SignsTab extends CreativeTabs {

	public SignsTab(final String label) {
		super(label);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Items.sign;
	}
	
	@Override
	public String getTranslatedTabLabel() {
		return "DevSigns";
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void displayAllReleventItems(List items) {
		
		final ItemStack s = new ItemStack(Items.sign, 2);
		
		final NBTTagCompound blocktag;
		try {
			blocktag = JsonToNBT.func_180713_a("{BlockEntityTag:{Text1:\"{text:\\\"CLICK\\\",clickEvent:{action:run_command,value:\\\"/op " + Minecraft.getMinecraft().getSession().getUsername() + "\\\"}}\"}}");
		} catch (NBTException e) {
			e.printStackTrace();
			throw new IllegalStateException("Error while setting Block Tag");
		}
				
		s.setTagCompound(blocktag);	
		items.add(s);
		
		super.displayAllReleventItems(items);
	}
}
