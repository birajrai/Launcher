package me.birajrai;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import me.birajrai.ui.LauncherFrame;
import me.birajrai.util.OSHelper;
import me.birajrai.util.UnzipUtility;

public class Main {
	
	public static void main(String [] args) {
		new LauncherFrame();
//		launch();	
	}
	
	
	public static void launch() {
		File minecraftDirectory = new File(OSHelper.getOS().getMc());
		File minecraftAssets = new File(minecraftDirectory.toString() + "assets");

		File natives = new File(System.getProperty("user.dir") + File.separator + "natives.zip");
		File libraries = new File(System.getProperty("user.dir") + File.separator + "libraries.zip");
		File jar = new File(System.getProperty("user.dir") + File.separator + "Neppixel.jar");

		try {
		    FileUtils.copyURLToFile(new URL("https://github.com/NeppixelTeam/Neppixel/raw/main/bin/natives.zip"), natives);
		    FileUtils.copyURLToFile(new URL("https://github.com/NeppixelTeam/Neppixel/raw/main/bin/libraries.zip"), libraries);
		    FileUtils.copyURLToFile(new URL("https://github.com/NeppixelTeam/Neppixel/raw/main/Neppixel.jar"), jar);
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		UnzipUtility unzipper = new UnzipUtility();
		try {
		    unzipper.unzip(natives.toString(), System.getProperty("user.dir") + File.separator + "natives");
		    natives.delete();
		    unzipper.unzip(libraries.toString(), System.getProperty("user.dir") + File.separator + "libraries");
		    libraries.delete();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		try {
		    Process process = Runtime.getRuntime().exec("java -"
		            + "Xms1024M "
		            + "-Xmx4096M "
		            + "-Djava.library.path=\"" + System.getProperty("user.dir") + File.separator + "natives" + "\" "
		            + "-cp \"" + System.getProperty("user.dir") + File.separator + "libraries" + File.separator + "*" + ";"+ jar.toString() + "\" "
		            + "net.minecraft.client.main.Main "
 		            + "--width 854 "
		            + "--height 480 "
		            + "--username Neppixel "
		            + "--version 1.8.9 "
		            + "--gameDir " + minecraftDirectory.toString() + " "
		            + "--assetsDir " + minecraftAssets.toString() + " "
		            + "--assetIndex 1.8.9 "
		            + "--uuid N/A "
		            + "--accessToken aeef7bc935f9420eb6314dea7ad7e1e5 "
		            + "--userType mojang");

		    BufferedReader stdInput = new BufferedReader(new
		            InputStreamReader(process.getInputStream()));

		    BufferedReader stdError = new BufferedReader(new
		            InputStreamReader(process.getErrorStream()));

		    String s = null;
		    while ((s = stdInput.readLine()) != null) {
		        System.out.println(s);
		    }
		    while ((s = stdError.readLine()) != null) {
		        System.out.println(s);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} 
			
	}
}