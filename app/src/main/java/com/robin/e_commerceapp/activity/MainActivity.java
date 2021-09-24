package com.robin.e_commerceapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.robin.e_commerceapp.R;
import com.robin.e_commerceapp.entity.service.TapusuPven;
import com.robin.e_commerceapp.entity.service.TapusuPvenPK;
import com.robin.e_commerceapp.utils.DateSerializer;
import com.robin.e_commerceapp.utils.TimeSerializer;
import com.robin.e_commerceapp.viewmodel.TapusuPvenViewModel;

import java.sql.Date;
import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail,edtPassword;
    private Button btnIniciarSesion;

    private TapusuPvenViewModel viewModel;

    private TextView txtInputUsuario,txtInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initViewModel();
        this.init();
    }

    public void initViewModel() {
        this.viewModel = new ViewModelProvider(this).get(TapusuPvenViewModel.class);
    }

    public void init(){
        this.edtEmail = findViewById(R.id.edtMail);
        this.edtPassword = findViewById(R.id.edtPassword);
        this.btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        this.btnIniciarSesion.setOnClickListener(v -> {
            TapusuPven tapusuPven = new TapusuPven();
            TapusuPvenPK tapusuPvenPK =new TapusuPvenPK();
            tapusuPvenPK.setNoCia("01");

            tapusuPven.setTapusuPvenPK(tapusuPvenPK);
            tapusuPven.setEmail(edtEmail.getText().toString());
            tapusuPven.setClave(edtPassword.getText().toString());

            this.viewModel.login(tapusuPven).observe(this, response ->{
                if (response.getRpta() == 1){
                    Toast.makeText(this,response.getMessage(),Toast.LENGTH_LONG).show();
                    TapusuPven u = response.getBody();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = preferences.edit();
                    final Gson g = new GsonBuilder()
                            .registerTypeAdapter(Date.class,new DateSerializer())
                            .registerTypeAdapter(Time.class, new TimeSerializer())
                            .create();
                    editor.putString("TapusuPvenJson",g.toJson(u, new TypeToken<TapusuPven>(){
                    }.getType()));
                    editor.apply();
                    edtEmail.setText("");
                    edtPassword.setText("");
                    //NOS VAMOS A LA OTRA ACTIVIDADA
                    startActivity(new Intent(this,InicioActivity.class));
                }else{
                    Toast.makeText(this,"Ocurrio un error "+response.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        });

    }
}