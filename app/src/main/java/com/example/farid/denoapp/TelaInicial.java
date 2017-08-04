package com.example.farid.denoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class TelaInicial extends AppCompatActivity {


    /* declarando os objetos criados. */
    private ImageView LogoFarid;
    private EditText edtCodBarras;
    private TextView txtCodBarras, txtDescProduto, txtSifrao, txtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

         /*Recuperando os objetos, e retornando uma referência. [Polimorfismo]*/
        LogoFarid = (ImageView) findViewById(R.id.LogoFarid);
        edtCodBarras = (EditText) findViewById(R.id.edtCodBarras);
        txtCodBarras = (TextView) findViewById(R.id.txtCodBarras);
        txtDescProduto = (TextView) findViewById(R.id.txtDescProduto);
        txtSifrao = (TextView) findViewById(R.id.txtSifrao);
        txtValor = (TextView) findViewById(R.id.txtValor);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


    }
}
