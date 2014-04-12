/**
Author: Lei Zhang
File Creation Date: Apr 11, 2014
Class Description:
*/
package bestroomie.util;
public enum CATAGORY_INDEX {
	AUTO,DINING,CLOTHING,GROCERY,RENT,UTILITY;
	
	public static CATAGORY_INDEX fromInteger(int x) {
        switch(x) {
        case 0:
            return AUTO;
        case 1:
            return DINING;
        case 2:
        	return CLOTHING;
        case 3:
        	return GROCERY;
        case 4:
        	return RENT;
        case 5:
        	return UTILITY;
        }
        return null;
    }
	
	public static String getCatagoryString(CATAGORY_INDEX i) {
		switch(i) {
        case AUTO:
            return "Auto";
        case DINING:
            return "Dinning";
        case CLOTHING:
        	return "Clothing";
        case GROCERY:
        	return "Grocery";
        case RENT:
        	return "Rent";
        case UTILITY:
        	return "Utility";
        default:
        	return "Unknown";
        }
	}
}
