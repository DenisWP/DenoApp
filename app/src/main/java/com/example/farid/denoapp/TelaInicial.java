package com.example.farid.denoapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class TelaInicial extends AppCompatActivity {


    /* declarando os objetos criados. */
    private ImageView LogoFarid;
    private EditText edtCodBarras;
    private TextView txtCodBarras, txtDescProduto, txtSifrao, txtValor;

    private ProgressDialog pDialog;

    ArrayList<HashMap<String, String>> produtos;

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

        produtos = new ArrayList<>();


    }






}
