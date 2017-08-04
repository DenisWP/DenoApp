package com.example.farid.denoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class TelaInicial extends AppCompatActivity {


    /* declarando os objetos criados. */
    private ImageView LogoFarid;
    private EditText edtCodBarras;
    private TextView txtCodBarras, txtDescProduto, txtSifrao, txtValor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        LogoFarid = (ImageView) findViewById(R.id.LogoFarid);
        edtCodBarras = (EditText) findViewById(R.id.edtCodBarras);
        txtCodBarras = (TextView) findViewById(R.id.txtCodBarras);
        txtDescProduto = (TextView) findViewById(R.id.txtDescProduto);
        txtSifrao = (TextView) findViewById(R.id.txtSifrao);
        txtValor = (TextView) findViewById(R.id.txtValor);

        String site = "http://192.168.0.12:8001/api/Produtos?regiao=1&codigobarra="+ edtCodBarras;

    }
}
