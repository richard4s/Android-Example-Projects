package com.example.richard.classproject1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyingFilesTest extends AppCompatActivity {

    String LOG_TAG = getClass().getSimpleName();
    int SELECT_IMAGE_REQUEST = 0;
    public static final int GET_FROM_GALLERY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copying_files_test);
        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(e -> {
            Log.e(LOG_TAG, "Button Clicked");
            System.out.println("Button has been clicked");
            selectFromImageGallery();
        });
    }

    public void selectFromImageGallery() {
        Intent intent;
        if(android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        } else {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }

        intent.setType("images/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, GET_FROM_GALLERY);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GET_FROM_GALLERY && resultCode == RESULT_OK) {
            if(data.getData() != null) {
                Uri selectedImageUri = data.getData();
                Bitmap bitmap = null;

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
