package de.devversion.devcreative;

import de.devversion.devcreative.tabs.SignsTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="devcreative", version="0.1")
public class DevCreative {
	
	private final SignsTab signsTab = new SignsTab("tabSigns");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) throws Exception {
    	
    	/*final NBTSign sign = new NBTSign();
    
    	final FMLControlledNamespacedRegistry<Item> registry = (FMLControlledNamespacedRegistry<Item>) Item.itemRegistry;
    	
    	Method method = null;
    	int x = 0;
    	for (final Method m : FMLControlledNamespacedRegistry.class.getDeclaredMethods()) {
    		if (m.getParameterCount() != 3) continue;
    		if (m.getParameterTypes()[0] != int.class) continue;
    		if (m.getParameterTypes()[1] != ResourceLocation.class) continue;
    		if (x == 2) method = m;
    		x++;
    	}
    	
    	if (method == null) throw new IllegalStateException("Can't reflect the Item Registry - " + x);
    	
    	method.setAccessible(true);
    	method.invoke(registry, 323, new ResourceLocation("sign"), sign);
    	    	    	
    	sign.setCreativeTab(signsTab);*/
    }

}

