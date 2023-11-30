/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkspace_v2;

/**
 *
 * @author cyber
 */
public class ComboBoxItem {
    private String visibleValue;
    private Object hiddenValue;

    public ComboBoxItem(String visibleValue, Object hiddenValue) {
        this.visibleValue = visibleValue;
        this.hiddenValue = hiddenValue;
    }

    public String getVisibleValue() {
        return visibleValue;
    }

    public Object getHiddenValue() {
        return hiddenValue;
    }

    @Override
    public String toString() {
        return visibleValue;
    }
}

