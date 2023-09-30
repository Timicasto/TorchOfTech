package moe.timicasto.torchoftech.utils;

public class Utils {
	public static boolean isTempIn(double temp, double min, double max) {
		return temp >= min && temp < max;
	}
}
