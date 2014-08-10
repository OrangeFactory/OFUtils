package orangefactory.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;

/**
 * OrangeFactory 方块属性获取类。
 * 存放在.minecraft/OrangeFactory/blocks/的文件将被读取。
 * @author OrangeFactory
 *
 */
public class BlockProperties {
	private static BufferedReader reader;
	private final static String path=Minecraft.getMinecraft().mcDataDir.getPath()+"/OrangeFactory/blocks/";
	private BlockProperties(){}  //封闭构建方法
	/**
	 * 获得方块的硬度
	 * @param block
	 * @return HarvestLevel
	 */
	public static String[] getBlockHarvestLevel(Block block){
		try {
			reader=new BufferedReader(new FileReader(path+block.getUnlocalizedName()+".cfg"));
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
	 * 获得方块材质路径。
	 * @param block
	 * @return texture path
	 */
	public static String getTexture(Block block){
		int[] a=(int[]) Array.newInstance(int.class, 2,3,4);
		try {
			reader=new BufferedReader(new FileReader(path+block.getUnlocalizedName()+".cfg"));
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
