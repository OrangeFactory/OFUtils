package orangefactory.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

import net.minecraft.item.Item;
import net.minecraft.client.Minecraft;

public class ItemProperties {
	private static BufferedReader reader;
	private final static String path=Minecraft.getMinecraft().mcDataDir.getPath()+"/OrangeFactory/items/";
	private ItemProperties(){}  //封闭构建方法
	/**
	 * 获得物品的硬度
	 * @param item
	 * @return HarvestLevel
	 */
	public static String[] getBlockHarvestLevel(Item item){
		try {
			reader=new BufferedReader(new FileReader(path+item.getUnlocalizedName()+".cfg"));
			String[] s=new String[2];
			String[] s1=new String[2];
			s1[0]=reader.readLine();
			s1[1]=reader.readLine();
			s[0]=s1[0].substring(s1[0].indexOf(' '));
			s[1]=s1[1].substring(s1[1].indexOf(' '));
			reader.close();
			reader=null;
			return s;
		} catch (IOException e) {
			e.printStackTrace();	
			reader=null;
			return null;
		}
	}
	/**
	 * 获得物品材质路径。
	 * @param item
	 * @return texture path
	 */
	public static String getTexture(Item item){
		try {
			reader=new BufferedReader(new FileReader(path+item.getUnlocalizedName()+".cfg"));
			String s,s1;
			reader.readLine();
			reader.readLine();
			s=reader.readLine();
			s1=s.substring(s.indexOf(' ')+1);
			
			reader.close();
			reader=null;
			return s1;
		} catch (IOException e) {
			e.printStackTrace();	
			reader=null;
			return null;
		}
	}
}
