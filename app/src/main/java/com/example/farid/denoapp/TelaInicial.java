package com.example.farid.denoapp;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Timer;


public class TelaInicial extends AppCompatActivity {


    ImageView LogoFarid;
    EditText edtCodBarras;
    TextView txtCodBarras, txtCodProduto, txtDescProduto, txtSifrao, txtValor;
    String[] objetos = new String[3];
    String regiao = "1";
    Button btnVer, btnLimpar;
    String url, CB;
    JSONObject jsonObjectTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        LogoFarid = (ImageView) findViewById(R.id.LogoFarid);
        txtCodBarras = (TextView) findViewById(R.id.txtCodBarras);
        txtCodProduto = (TextView) findViewById(R.id.txtCodProduto);
        txtDescProduto = (TextView) findViewById(R.id.txtDescProduto);
        txtSifrao = (TextView) findViewById(R.id.txtSifrao);
        txtValor = (TextView) findViewById(R.id.txtValor);
        edtCodBarras = (EditText) findViewById(R.id.edtCodBarras);


        BuscaProduto();

         /*edtCodBarras.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                CB = edtCodBarras.getText().toString();
                url = "http://192.168.0.12:8001/api/Produtos?regiao=" +regiao+ "&codigobarra="+CB;
                new AsyncTaskExample().execute(url);
            }


        });*/




    }

    public void BuscaProduto (){
        edtCodBarras.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                CB = edtCodBarras.getText().toString();
                url = "http://192.168.0.12:8001/api/Produtos?regiao=" +regiao+ "&codigobarra="+CB;
                new AsyncTaskExample().execute(url);
            }
        });
    }

    public void limparDados() {
            txtCodProduto.setText("");
            txtDescProduto.setText("");
            txtValor.setText("");
            edtCodBarras.setText("");
    }


    public class AsyncTaskExample extends AsyncTask<String, String, String[]> {


        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String[] doInBackground(String... url) {
            try {
                jsonObjectTexts = JsonParser.LerJsonUrl(url[0]);
                objetos[0] = jsonObjectTexts.getString("Codigo");
                objetos[1] = jsonObjectTexts.getString("Descricao");
                objetos[2] = jsonObjectTexts.getString("Preco");
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return objetos;
        }

        @Override
        protected void onPostExecute(String[] stringFromDoInBackground) {
            txtCodProduto.setText(stringFromDoInBackground[0]);
            txtDescProduto.setText(stringFromDoInBackground[1]);
            txtValor.setText(stringFromDoInBackground[2]);
        }
    }
}
