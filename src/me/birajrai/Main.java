package me.birajrai;

public class Main {
	
	public static void main(String [] args) {
		
	}
	
	public void launch() {
		File minecraftDirectory = new File(OSHelper.getOS().getMc());
		File minecraftAssets = new File(minecraftDirectory.toString() + "assets");
		
		File natives = new File(System.getProperty("user.dir") + File.separator + "natives.zip");
		File libraries = new File(System.getProperty("user.dir") + File.separator + "libraries.zip");
		File jar = new File(System.getProperty("user.dir") + File.separator + "Neppixel.jar");
		
		
		try {
			FileUtils.copyURLToFile(new URL("https://github.com/NeppixelTeam/Neppixel/raw/main/bin/natives.zip"), natives);
			FileUtils.copyURLToFile(new URL("https://github.com/NeppixelTeam/Neppixel/raw/main/bin/libraries.zip"), libraries);
			FileUtils.copyURLToFile(new URL("https://github.com/NeppixelTeam/Neppixel/raw/main/Neppixel.jar"), jar);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UnzipUtility unzipper = new UnzipUtility();
		try {
			unzipper.unzip(natives.toString(), System.getProperty("user.dir") + File.separator + "natives");
			natives.delete();
			unzipper.unzip(libraries.toString(), System.getProperty("user.dir") + File.separator + "libraries");
			libraries.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Process process - Runtime.getRuntime().exec(
					"java -"
							+ "Xms1024M "
					        + "-Xmx4069M "
							+ "-Djava.library.path=\"" + System.getProperty("user.dir") + File.separator + "natives" + "\" "
					        + "-cp \"" + System.getProperty("user.dir") + File.separator + "libraries" + File.separator + "*" + ";" + jar.toString() + "\*"
					        + "net.minecraft.net.client.main.Main "
					        + "--width 854 "
					        + "--height 400 "
					        + "--username Neppixel "
					        + "--version 1.8.8 "
					        + "--gameDir " + minecraftDirectory
					);
		}
	}

}
