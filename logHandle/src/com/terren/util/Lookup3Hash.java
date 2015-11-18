package com.terren.util;


public class Lookup3Hash implements String64bitID {

	@Override
	public long toID(String str) {
		if(str != null)
			return lookup3ycs64(str, 0, str.length(), 0xefcdab8967452301L) & 0x7FFFFFFFFFFFFFFFL;
		else
			return 0;
	}

	@Override
	public long toID(byte[] bytes) {
		return nlookup3ycs64(bytes, 0, bytes.length, 0xefcdab8967452301L) & 0x7FFFFFFFFFFFFFFFL;
	}

	  public static long nlookup3ycs64(byte[] bs, int start, int end, long initval) {
		    int a,b,c;
		    a = b = c = 0xdeadbeef + (int)initval;
		    c += (int)(initval>>>32);
		    // only difference from lookup3 is that "+ (length<<2)" is missing
		    // since we don't know the number of code points to start with,
		    // and don't want to have to pre-scan the string to find out.

		    int i=start;
		    boolean mixed=true;  // have the 3 state variables been adequately mixed?
		    for(;;) {
		      if (i>= end) break;
		      mixed=false;
		      byte ch;
		      ch = bs[i++];
		      a += ch;
		      if (i>= end) break;
		      ch = bs[i++];
		      b += ch;
		      if (i>= end) break;
		      ch = bs[i++];
		      c += ch;
		      if (i>= end) break;

		      // mix(a,b,c)... Java needs "out" parameters!!!
		      // Note: recent JVMs (Sun JDK6) turn pairs of shifts (needed to do a rotate)
		      // into real x86 rotate instructions.
		      {
		        a -= c;  a ^= (c<<4)|(c>>>-4);   c += b;
		        b -= a;  b ^= (a<<6)|(a>>>-6);   a += c;
		        c -= b;  c ^= (b<<8)|(b>>>-8);   b += a;
		        a -= c;  a ^= (c<<16)|(c>>>-16); c += b;
		        b -= a;  b ^= (a<<19)|(a>>>-19); a += c;
		        c -= b;  c ^= (b<<4)|(b>>>-4);   b += a;
		      }
		      mixed=true;
		    }


		    if (!mixed) {
		      // final(a,b,c)
		        c ^= b; c -= (b<<14)|(b>>>-14);
		        a ^= c; a -= (c<<11)|(c>>>-11);
		        b ^= a; b -= (a<<25)|(a>>>-25);
		        c ^= b; c -= (b<<16)|(b>>>-16);
		        a ^= c; a -= (c<<4)|(c>>>-4);
		        b ^= a; b -= (a<<14)|(a>>>-14);
		        c ^= b; c -= (b<<24)|(b>>>-24);
		    }

		    return c + (((long)b) << 32);
		  }

	public static long lookup3ycs64(CharSequence s, int start, int end, long initval) {
		    int a,b,c;
		    a = b = c = 0xdeadbeef + (int)initval;
		    c += (int)(initval>>>32);
		    // only difference from lookup3 is that "+ (length<<2)" is missing
		    // since we don't know the number of code points to start with,
		    // and don't want to have to pre-scan the string to find out.

		    int i=start;
		    boolean mixed=true;  // have the 3 state variables been adequately mixed?
		    for(;;) {
		      if (i>= end) break;
		      mixed=false;
		      char ch;
		      ch = s.charAt(i++);
		      a += Character.isHighSurrogate(ch) && i< end ? Character.toCodePoint(ch, s.charAt(i++)) : ch;
		      if (i>= end) break;
		      ch = s.charAt(i++);
		      b += Character.isHighSurrogate(ch) && i< end ? Character.toCodePoint(ch, s.charAt(i++)) : ch;
		      if (i>= end) break;
		      ch = s.charAt(i++);
		      c += Character.isHighSurrogate(ch) && i< end ? Character.toCodePoint(ch, s.charAt(i++)) : ch;
		      if (i>= end) break;

		      // mix(a,b,c)... Java needs "out" parameters!!!
		      // Note: recent JVMs (Sun JDK6) turn pairs of shifts (needed to do a rotate)
		      // into real x86 rotate instructions.
		      {
		        a -= c;  a ^= (c<<4)|(c>>>-4);   c += b;
		        b -= a;  b ^= (a<<6)|(a>>>-6);   a += c;
		        c -= b;  c ^= (b<<8)|(b>>>-8);   b += a;
		        a -= c;  a ^= (c<<16)|(c>>>-16); c += b;
		        b -= a;  b ^= (a<<19)|(a>>>-19); a += c;
		        c -= b;  c ^= (b<<4)|(b>>>-4);   b += a;
		      }
		      mixed=true;
		    }


		    if (!mixed) {
		      // final(a,b,c)
		        c ^= b; c -= (b<<14)|(b>>>-14);
		        a ^= c; a -= (c<<11)|(c>>>-11);
		        b ^= a; b -= (a<<25)|(a>>>-25);
		        c ^= b; c -= (b<<16)|(b>>>-16);
		        a ^= c; a -= (c<<4)|(c>>>-4);
		        b ^= a; b -= (a<<14)|(a>>>-14);
		        c ^= b; c -= (b<<24)|(b>>>-24);
		    }

		    return c + (((long)b) << 32);
		  }
	public static void main(String[] args) {
		System.out.println(new Lookup3Hash().toID("http://www.cnr.cn/newscenter/xwtz/201111/t20111106_508736099_1.shtml"));
	}

}
