package com.example.myapplication.uit;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCompanyLogoBinding;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class CompanyLogo extends AppCompatActivity {
    private ActivityCompanyLogoBinding binding;
    private final int GALLERY_REQ_CODE = 1000;
    private CircleImageView showImg;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 101;
    private Uri capturedImageUri;
    private  Uri imageUri;
    private Boolean flagALbum = Boolean.FALSE;
    private Boolean flagCamera = Boolean.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompanyLogoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showImg = binding.ivCircleImage;
        if (!checkCameraPermission()) {
            requestCameraPermission();
        }

        binding.tvNextBtnCompanyLogo.setOnClickListener(view -> {
            if(flagALbum) {
                Intent intent = new Intent(this, CompanyName.class);
                intent.putExtra("imageUri", imageUri.toString());
                startActivity(intent);
                finish();
            }
            else if(flagCamera){
                Intent intent = new Intent(this, CompanyName.class);
                intent.putExtra("imageUri", capturedImageUri.toString());
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this, "Picture not uploaded!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.upload_picture, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_camera:
                        openCamera();
                        return true;

                    case R.id.menu_album:
                        openAlbum();
                        return true;

                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

    private void openAlbum() {
        Intent albums = new Intent(Intent.ACTION_PICK);
        albums.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(albums, GALLERY_REQ_CODE);
    }

    private void openCamera() {
        if (checkCameraPermission()) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                File photoFile = createImageFile();
                if (photoFile != null) {
                    capturedImageUri = FileProvider.getUriForFile(this, getPackageName() + ".provider", photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri);
                    startActivityForResult(cameraIntent, CAMERA_PERMISSION_REQUEST_CODE);
                }
            }
        } else {
            requestCameraPermission();
        }
    }

    private File createImageFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        try {
            return File.createTempFile(imageFileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQ_CODE) {
                imageUri = data.getData();
                showImg.setImageURI(imageUri);
                flagALbum = true;
            }
            else if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
                if (capturedImageUri != null) {
                    showImg.setImageURI(capturedImageUri);
                    flagCamera = true;
                }
            }
        }
    }

    private boolean checkCameraPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can now use the camera
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}