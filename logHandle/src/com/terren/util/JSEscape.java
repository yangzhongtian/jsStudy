package com.terren.util;

import java.io.UnsupportedEncodingException;

/**
 * <p/>功能描述：js escape unescap 标准java实现， 从rg.mozilla.javascript整理出来 <p/>创 建
 * 人：BlackStone 创建时间：Sep 21, 2007 5:29:43 PM
 */
public class JSEscape {
	/**
	 * The global method escape, as per ECMA-262 15.1.2.4.
	 * 
	 * Includes code for the 'mask' argument supported by the C escape method,
	 * which used to be part of the browser imbedding. Blame for the strange
	 * constant names should be directed there. ps:做了一点改动
	 */
	public static String js_escape(String s) {
		final int URL_XALPHAS = 1;
		final int URL_XPALPHAS = 2;
		final int URL_PATH = 4;

		int mask = URL_XALPHAS | URL_XPALPHAS | URL_PATH;
		StringBuffer sb = null;

		for (int k = 0, L = s.length(); k != L; ++k) {
			int c = s.charAt(k);

			if ((mask != 0)
				&& (((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'Z'))
					|| ((c >= 'a') && (c <= 'z')) || (c == '@') || (c == '*')
					|| (c == '_') || (c == '-') || (c == '.') || ((0 != (mask & URL_PATH)) && ((c == '/') || (c == '+'))))) {
				if (sb != null) {
					sb.append((char) c);
				}
			} else {
				if (sb == null) {
					sb = new StringBuffer(L + 3);
					sb.append(s);
					sb.setLength(k);
				}

				int hexSize;

				if (c < 256) {
					if ((c == ' ') && (mask == URL_XPALPHAS)) {
						sb.append('+');

						continue;
					}

					sb.append('%');
					hexSize = 2;
				} else {
					sb.append('%');
					sb.append('u');
					hexSize = 4;
				}

				// append hexadecimal form of c left-padded with 0
				for (int shift = (hexSize - 1) * 4; shift >= 0; shift -= 4) {
					int digit = 0xf & (c >> shift);
					int hc = (digit < 10) ? ('0' + digit) : ('A' - 10 + digit);
					sb.append((char) hc);
				}
			}
		}

		return (sb == null) ? s : sb.toString();
	}

	/**
	 * The global unescape method, as per ECMA-262 15.1.2.5.
	 * 
	 * @param browser_encode
	 */
	public static String js_unescape(String s, String browser_encode, String page_default_encode) {
		String ret = s;
		s = s.replaceAll("%25u", "%u");
		boolean found_unicode_escape = false;
		int firstEscapePos = s.indexOf('%');

		if (firstEscapePos >= 0) {
			int L = s.length();
			char[] buf = s.toCharArray();
			int destination = firstEscapePos;

			for (int k = firstEscapePos; k != L;) {
				char c = buf[k];
				++k;

				if ((c == '%') && (k != L)) {
					int end;
					int start;

					if (buf[k] == 'u') {
						found_unicode_escape = true;
						start = k + 1;
						end = k + 5;
					} else {
						start = k;
						end = k + 2;
					}

					if (end <= L) {
						int x = 0;

						for (int i = start; i != end; ++i) {
							x = xDigitToInt(buf[i], x);
						}

						if (x >= 0) {
							c = (char) x;
							k = end;
						}
					}
				}

				buf[destination] = c;
				++destination;
			}

			ret = new String(buf, 0, destination);
			if(!found_unicode_escape && browser_encode != null && page_default_encode != null
				&& (browser_encode.equalsIgnoreCase("Windows-1252") || browser_encode.equalsIgnoreCase("ISO-8859-1"))) {
				try {
					ret = new String(ret.getBytes(browser_encode), page_default_encode);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}

		return ret;
	}


	/**
	 * If character <tt>c</tt> is a hexadecimal digit, return
	 * <tt>accumulator</tt> 16 plus corresponding number. Otherise return -1.
	 */
	public static int xDigitToInt(int c, int accumulator) {
		check: {
			// Use 0..9 < A..Z < a..z
			if (c <= '9') {
				c -= '0';

				if (0 <= c) {
					break check;
				}
			} else if (c <= 'F') {
				if ('A' <= c) {
					c -= ('A' - 10);

					break check;
				}
			} else if (c <= 'f') {
				if ('a' <= c) {
					c -= ('a' - 10);

					break check;
				}
			}

			return -1;
		}

		return (accumulator << 4) | c;
	}
	
    private final static String[] hex = {
        "00","01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F",
        "10","11","12","13","14","15","16","17","18","19","1A","1B","1C","1D","1E","1F",
        "20","21","22","23","24","25","26","27","28","29","2A","2B","2C","2D","2E","2F",
        "30","31","32","33","34","35","36","37","38","39","3A","3B","3C","3D","3E","3F",
        "40","41","42","43","44","45","46","47","48","49","4A","4B","4C","4D","4E","4F",
        "50","51","52","53","54","55","56","57","58","59","5A","5B","5C","5D","5E","5F",
        "60","61","62","63","64","65","66","67","68","69","6A","6B","6C","6D","6E","6F",
        "70","71","72","73","74","75","76","77","78","79","7A","7B","7C","7D","7E","7F",
        "80","81","82","83","84","85","86","87","88","89","8A","8B","8C","8D","8E","8F",
        "90","91","92","93","94","95","96","97","98","99","9A","9B","9C","9D","9E","9F",
        "A0","A1","A2","A3","A4","A5","A6","A7","A8","A9","AA","AB","AC","AD","AE","AF",
        "B0","B1","B2","B3","B4","B5","B6","B7","B8","B9","BA","BB","BC","BD","BE","BF",
        "C0","C1","C2","C3","C4","C5","C6","C7","C8","C9","CA","CB","CC","CD","CE","CF",
        "D0","D1","D2","D3","D4","D5","D6","D7","D8","D9","DA","DB","DC","DD","DE","DF",
        "E0","E1","E2","E3","E4","E5","E6","E7","E8","E9","EA","EB","EC","ED","EE","EF",
        "F0","F1","F2","F3","F4","F5","F6","F7","F8","F9","FA","FB","FC","FD","FE","FF"
    };
    private final static byte[] val = {
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x0A,0x0B,0x0C,0x0D,0x0E,0x0F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x0A,0x0B,0x0C,0x0D,0x0E,0x0F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
        0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F
    };
    public static String escape(String s) {
        StringBuffer sbuf = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int ch = s.charAt(i);
            if (ch == ' ') {                        // space : map to '+' 
                sbuf.append('+');
            } else if ('A' <= ch && ch <= 'Z') {    // 'A'..'Z' : as it was
                sbuf.append((char)ch);
            } else if ('a' <= ch && ch <= 'z') {    // 'a'..'z' : as it was
                sbuf.append((char)ch);
            } else if ('0' <= ch && ch <= '9') {    // '0'..'9' : as it was
                sbuf.append((char)ch);
            } else if (ch == '-' || ch == '_'       // unreserved : as it was
                || ch == '.' || ch == '!'
                || ch == '~' || ch == '*'
                || ch == '\'' || ch == '('
                || ch == ')') {
                sbuf.append((char)ch);
            } else if (ch <= 0x007F) {              // other ASCII : map to %XX
                sbuf.append('%');
                sbuf.append(hex[ch]);
            } else {                                // unicode : map to %uXXXX
                sbuf.append('%');
                sbuf.append('u');
                sbuf.append(hex[(ch >>> 8)]);
                sbuf.append(hex[(0x00FF & ch)]);
            }
        }
        return sbuf.toString();
    }
    
    public static String newunescape(String s, String charset) {
        StringBuffer sbuf = new StringBuffer();
        int i = 0;
        int len = s.length();
        while (i < len) {
            int ch = s.charAt(i);
            if (ch == '+') {                        // + : map to ' ' 
                sbuf.append(' ');
            } else if ('A' <= ch && ch <= 'Z') {    // 'A'..'Z' : as it was
                sbuf.append((char)ch);
            } else if ('a' <= ch && ch <= 'z') {    // 'a'..'z' : as it was
                sbuf.append((char)ch);
            } else if ('0' <= ch && ch <= '9') {    // '0'..'9' : as it was
                sbuf.append((char)ch);
            } else if (ch == '-' || ch == '_'       // unreserved : as it was
                || ch == '.' || ch == '!'
                || ch == '~' || ch == '*'
                || ch == '\'' || ch == '('
                || ch == ')') {
                sbuf.append((char)ch);
            } else if (ch == '%') {
                int cint = 0;
                if ('u' != s.charAt(i+1)) {         // %XX : map to ascii(XX)
                    cint = (cint << 4) | val[s.charAt(i+1)];
                    cint = (cint << 4) | val[s.charAt(i+2)];
                    i+=2;
                } else {                            // %uXXXX : map to unicode(XXXX)
                    cint = (cint << 4) | val[s.charAt(i+2)];
                    cint = (cint << 4) | val[s.charAt(i+3)];
                    cint = (cint << 4) | val[s.charAt(i+4)];
                    cint = (cint << 4) | val[s.charAt(i+5)];
                    i+=5;
                }
                sbuf.append((char)cint);
            }
            i++;
        }
        return sbuf.toString();
    }
}

