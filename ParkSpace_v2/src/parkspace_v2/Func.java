/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkspace_v2;
/**
 *
 * @author cyber
 */
public class Func {
    public static String data; 

    public static void setData(String newData) {
        data = newData;
    }

    public static String getData() {
        return data;
    }
    
    public static int stringToInt(String input) {
        String cleanedString = input.replaceAll("[^0-9.]", "");
        cleanedString = cleanedString.replace(".", "");

        int result;

        try {
            result = Integer.parseInt(cleanedString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Gagal mengonversi string menjadi int: " + e.getMessage());
        }

        return result;
    }
}
