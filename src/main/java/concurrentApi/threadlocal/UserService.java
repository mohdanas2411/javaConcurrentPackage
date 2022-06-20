package concurrentApi.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

class ThreadSafeFormatter extends ThreadLocal {
    public static ThreadLocal<SimpleDateFormat> tf = new ThreadLocal<SimpleDateFormat>();


    @Override
    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }


    @Override
    public SimpleDateFormat get() {
        return (SimpleDateFormat) super.get();
    }
}


public class UserService {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = ThreadSafeFormatter.tf.get();
        String format = dateFormat.format(new Date(567821));

        System.out.println(format);

    }
}
