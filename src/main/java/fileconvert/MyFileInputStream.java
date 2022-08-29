package fileHandling.outputStream.myFileIOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class MyFileInputStream {


    public static void main(String[] args) throws IOException {

        String SOURCE_PATH = "/home/admin1/IdeaProjects/Test/src/fileHandling/outputStream/myFileIOStream/";
        String RAW_STREAM_FILE = "stream";

        String H264_STREAM_FILE = "streamVid1.H264";

        String OUTPUT_VID = "Output_Vid1.mp4";


        byte[] bytes;
        try (FileInputStream fileInputStream = new FileInputStream(SOURCE_PATH + RAW_STREAM_FILE)) {
            System.out.println(fileInputStream.available());
            System.out.println(fileInputStream.read());

            bytes = fileInputStream.readAllBytes();
        }

        byte[] newBytes = Arrays.copyOfRange(bytes, 43, bytes.length);
        System.out.println(newBytes.length);

        try (OutputStream fileOutputStream = new FileOutputStream(SOURCE_PATH + H264_STREAM_FILE)) {

            fileOutputStream.write(newBytes);
        }


        String[] cmd={"ffmpeg", "-i", SOURCE_PATH+H264_STREAM_FILE, "-c", "copy", SOURCE_PATH+OUTPUT_VID};
        Runtime.getRuntime().exec(cmd);
    }
}
