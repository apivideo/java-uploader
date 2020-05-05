package org.yitzi.video.core.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class StringUtils {

    private static SecureRandom random = new SecureRandom();

    public static String generateUniqueString() {
        return new BigInteger(130, random).toString(32);
    }
}
