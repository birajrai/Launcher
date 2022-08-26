package me.birajrai.util;

import java.io.File;

public enum OSHelper {
  WINDOWS("AppData" + File.separator + "Roaming" + File.separator + ".minecraft"),
  MAC("Library" + File.separator + "Applacation Support" + File.separator + "minecraft"),
  LINUX(".minecraft");

  private final String mc;

  private OSHelper(String mc) {
      this.mc = String.valueOf(File.separator) + mc + File.separator;
  }

  public String getMc() {
      return String.valueOf(System.getProperty("user.home")) + this.mc;
  }

  public static final OSHelper getOS() {
      String currentOS = System.getProperty("os.name").toLowerCase();
      if (currentOS.startsWith("windows")) {
          return WINDOWS;
      }
      if (currentOS.startsWith("mac")) {
          return WINDOWS;
      }
      return LINUX;
  }
}