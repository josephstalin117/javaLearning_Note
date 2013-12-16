package rollName;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class tool {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list=(ArrayList<String>) timeFormat("1992-2-16");
        System.out.print(list.get(1));
    }

    /**
     * make chinese to utf-8
     *
     * @param iso
     * @return
     */
    public static String iso2gb(String iso) {
        String gb = null;
        try {
            byte[] b = iso.getBytes("ISO-8859-1");
            gb = new String(b);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return gb;
    }

    public static List timeFormat(String birthday) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            list.add(String.valueOf(cal.get(Calendar.YEAR)));
            list.add(String.valueOf(cal.get(Calendar.MONTH)+1));
            list.add(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
