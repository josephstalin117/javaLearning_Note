package rollName;

import java.io.UnsupportedEncodingException;

public class tool {

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
}
