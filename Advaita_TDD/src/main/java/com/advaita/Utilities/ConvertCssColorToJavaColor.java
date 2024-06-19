package com.advaita.Utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConvertCssColorToJavaColor {
	
//	 public static Color convertCssColorToJavaColor(String cssColor) {
//	        if (cssColor.startsWith("rgba")) {
//	            Pattern pattern = Pattern.compile("rgba\\((\\d+),\\s*(\\d+),\\s*(\\d+),\\s*([01]?\\.\\d+)\\)");
//	            Matcher matcher = pattern.matcher(cssColor);
//	            if (matcher.matches()) {
//	                int red = Integer.parseInt(matcher.group(1));
//	                int green = Integer.parseInt(matcher.group(2));
//	                int blue = Integer.parseInt(matcher.group(3));
//	                float alpha = Float.parseFloat(matcher.group(4));
//	                return new Color(red, green, blue, (int) (alpha * 255));
//	            }
//	        } else if (cssColor.startsWith("rgb")) {
//	            Pattern pattern = Pattern.compile("rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)");
//	            Matcher matcher = pattern.matcher(cssColor);
//	            if (matcher.matches()) {
//	                int red = Integer.parseInt(matcher.group(1));
//	                int green = Integer.parseInt(matcher.group(2));
//	                int blue = Integer.parseInt(matcher.group(3));
//	                return new Color(red, green, blue);
//	            }
//	        }
//	        throw new IllegalArgumentException("Invalid CSS color value: " + cssColor);
//	    

	
	private static final Map<String, String> colorMap = new HashMap<>();

	  static {
	    colorMap.put("rgba(255, 0, 0, 1)", "red");
	    colorMap.put("rgba(0, 255, 0, 1)", "green");
	    colorMap.put("rgba(0, 0, 255, 1)", "blue");
	    // Add more colors and their RGB values to the map
	  }

	  public static String getColorName(WebDriver driver, WebElement element, String colorProperty) {
	    String colorValue = element.getCssValue(colorProperty);
	    String colorName = colorMap.get(colorValue);
	    if (colorName == null) {
	      colorName = "Color not found in predefined list";
	    }
	    return colorName;
	  }
	 
	
	

}
