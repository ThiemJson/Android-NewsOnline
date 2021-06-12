package teneocto.thiemjason.newsonline.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.UUID;

public class Utils {
    /**
     * Get Byte base64 from Bitmap
     *
     * @param bitmap Bitmap
     * @return byte[]
     */
    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    /**
     * Get Bitmap from byte[]
     *
     * @param byteBase64 bytp[] base64
     * @return Bitmap
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Bitmap getBitmapFromByteArray(String byteBase64) {
        byte[] imageBase64 = Base64.getDecoder().decode(byteBase64);
        return BitmapFactory.decodeByteArray(imageBase64, 0, imageBase64.length, null);
    }

    /**
     * Change Image Resolution
     */
    public static Bitmap prettyBitmap(Bitmap bitmap) {
        Bitmap resultBitmap = bitmap;
        if (
                (bitmap.getWidth() > 1080 && bitmap.getHeight() < 1080)
                        || (bitmap.getWidth() > 1080 && bitmap.getHeight() < 1080)
                        || (bitmap.getWidth() < 1080 && bitmap.getHeight() < 1080)
        ) {
            return resultBitmap;
        }
        Double ratio = 1080.0 / bitmap.getWidth();
        int newWidth = (int) Math.round(bitmap.getWidth() * ratio);
        int newHeight = (int) Math.round(bitmap.getHeight() * ratio);
        resultBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(newWidth), Math.round(newHeight), true);
        return resultBitmap;
    }

    /**
     * Random ID
     *
     * @return String
     */
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
