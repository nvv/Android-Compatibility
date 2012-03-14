package android.support.util;

import java.text.DecimalFormat;

public class CustomFormatter {

    public  static DecimalFormat format;
    public  static final long divisor = 1024;
    public static final String suffix = "B";
    public  static final String nbsp = "&nbsp;";
    public  static final String[] scale = {nbsp, "K","M","G","T",};

    static {
        format = (DecimalFormat) DecimalFormat.getNumberInstance();
        format.applyPattern("#,###.##");
    }

    /**
     * Gets formatted value.
     *
     * @param value as long
     * @return value as string
     */
    public static String formatBytes(long value) {
        float scaledValue = 0;
        String scaleSuffix = scale[0];
        if (value != 0) {
            for (int i = scale.length - 1; i >= 0; i--) {
                long div = (long) Math.pow(divisor, i);
                if (value >= div) {
                    scaledValue = (float) (1.0 * value / div);
                    scaleSuffix = scale[i];
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder(3);
        sb.append(format.format(scaledValue));

        sb.append(" ");
        if (!scaleSuffix.equals(scale[0])) {
            sb.append(scaleSuffix);
        }

        sb.append(suffix);
        return sb.toString();
    }

}
