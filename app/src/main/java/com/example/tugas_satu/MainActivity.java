package com.example.tugas_satu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean myShowPassword = false;

    EditText NamaDepan, NamaBelakang, TempatLahir,
            TanggalLahir, Alamat, Telepon, Email, Password,
            KonfirmasiPassword;
    Button Daftar, Kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NamaDepan = findViewById(R.id.nama_depan);
        NamaBelakang = findViewById(R.id.nama_belakang);
        TempatLahir = findViewById(R.id.tempat_lahir);
        TanggalLahir = findViewById(R.id.tanggal_lahir);
        Alamat = findViewById(R.id.alamat);
        Telepon = findViewById(R.id.telepon);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        KonfirmasiPassword = findViewById(R.id.konfirmasi_password);
        Daftar = findViewById(R.id.daftar);
        Kembali = findViewById(R.id.kembali);

        Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NamaDepan.length()==0)
                {
                    NamaDepan.setError("Nama Depan Harus Diisi!");
                }
                if (NamaBelakang.length()==0)
                {
                    NamaBelakang.setError("Nama Belakang Harus Diisi!");
                }
                if (TempatLahir.length()==0)
                {
                    TempatLahir.setError("Tempat Lahir Harus Diisi!");
                }
                if (TanggalLahir.length()==0)
                {
                    TanggalLahir.setError("Tanggal Lahir Harus Diisi!");
                }
                if (Alamat.length()==0)
                {
                    Alamat.setError("Alamat Harus Diisi!");
                }
                if (Telepon.length()==0)
                {
                    Telepon.setError("Nomor Telepon Harus Diisi!");
                }
                if (Email.length()==0)
                {
                    Email.setError("Email Harus Diisi!");
                }
                if (Password.length()==0)
                {
                    Password.setError("Password Harus Diisi!");
                }
                if (NamaDepan.getText().toString().length()>=1 && NamaBelakang.getText().toString().length()>=1 &&
                        TempatLahir.getText().toString().length()>=1 && TanggalLahir.getText().toString().length()>=1 &&
                        Alamat.getText().toString().length()>=1 && Telepon.getText().toString().length()>=1 &&
                        Email.getText().toString().length()>1 && Password.getText().toString().length()>1)
                {
                    Toast.makeText(MainActivity.this, "Pendaftaran Berhasil",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myShowPassword = !myShowPassword;
                setMyShowPassword(myShowPassword);
            }
        });

        KonfirmasiPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myShowPassword = !myShowPassword;
                setMyConfirmShowPassword(myShowPassword);
            }
        });

        Kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }

    private void setMyShowPassword(Boolean isShow) {
        if (isShow) {
            Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            Password.getTransformationMethod().equals(R.drawable.ic_hide_password_24dp);
        } else {
            Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            Password.getTransformationMethod().equals(R.drawable.ic_show_password_24dp);
        }
        Password.setSelection(Password.getText().toString().length());
    }

    private void setMyConfirmShowPassword(Boolean isShow) {
        if (isShow) {
            KonfirmasiPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            KonfirmasiPassword.getTransformationMethod().equals(R.drawable.ic_hide_password_24dp);
        } else {
            KonfirmasiPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            KonfirmasiPassword.getTransformationMethod().equals(R.drawable.ic_show_password_24dp);
        }
        KonfirmasiPassword.setSelection(KonfirmasiPassword.getText().toString().length());
    }
}
