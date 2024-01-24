package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {

    public static void main(String[] args) {

        /* 수업목표. FileOutputStream에 대해 이해하고 활용할 수 있다. */
        FileOutputStream fout = null;

        try {
            fout = new FileOutputStream("src/main/java/com/ohgiraffers/section02/stream/testOutputStream.txt");
//            fout.write('a');
//            fout.write(97);
            byte[] bArr = new byte[]{'a','p','p','l','e'};
//            for(byte b: bArr) {
//                fout.write(b);
//            }

//            fout.write(bArr);
            fout.write(bArr, 1, 3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e ) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(fout != null) fout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
