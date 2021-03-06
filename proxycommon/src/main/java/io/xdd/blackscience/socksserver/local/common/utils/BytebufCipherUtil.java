package io.xdd.blackscience.socksserver.local.common.utils;

import io.netty.buffer.ByteBuf;
import io.xdd.blackscience.socksserver.local.common.crypto.SSCipher;

public class BytebufCipherUtil {

    /**
     * 把 in 中的数据update到 out中
     * */
    public static void update(SSCipher cipher, ByteBuf in, ByteBuf out){
        int bytes = in.readableBytes();//需要解密的数据大小
        byte[] decryptBuffer=new byte[bytes];
        in.readBytes(decryptBuffer,0,bytes);
        byte[] result=cipher.update(decryptBuffer);
        out.writeBytes(result);
    }
}
