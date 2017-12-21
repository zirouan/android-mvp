package br.com.liveo.mvp.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudsonlima on 8/16/16.
 */
public class PermissionUtils {
    public static boolean isPermissionGranted(String[] grantPermissions, int[] grantResults,
                                              String permission) {
        for (int i = 0; i < grantPermissions.length; i++) {
            if (permission.equals(grantPermissions[i])) {
                return grantResults[i] == PackageManager.PERMISSION_GRANTED;
            }
        }
        return false;
    }

    public static boolean hasCameraPermission(Activity activity, int permissionRequestCode) {
        List<String> permissoes = new ArrayList<>();

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.CAMERA);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.RECORD_AUDIO);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (!permissoes.isEmpty()) {
            String[] array = new String[permissoes.size()];
            permissoes.toArray(array);
            ActivityCompat.requestPermissions(activity, array, permissionRequestCode);
            return false;
        }

        return true;
    }

    public static boolean hasStoragePermission(Activity activity, int storagePermissionRequestCode) {
        List<String> permissoes = new ArrayList<>();

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissoes.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (!permissoes.isEmpty()) {
            String[] array = new String[permissoes.size()];
            permissoes.toArray(array);
            ActivityCompat.requestPermissions(activity, array, storagePermissionRequestCode);
            return false;
        }

        return true;
    }
}
