package com.example.farid.denoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;




public class TelaInicial extends AppCompatActivity {


    ImageView LogoFarid;
    EditText edtCodBarras;
    TextView txtCodBarras, txtCodProduto, txtDescProduto, txtSifrao, txtValor;
    String[] objetos = new String[3];
    String regiao = "1";
    String pegaCodBarras;
    Button btnVer, btnLimpar;
    String url = "http://192.168.0.12:8001/api/Produtos?regiao=1&codigobarra=123456";


    JSONObject jsonObjectTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        LogoFarid = (ImageView) findViewById(R.id.LogoFarid);
        //txtCodBarras = (TextView) findViewById(R.id.txtCodBarras);
        //txtDescProduto = (TextView) findViewById(R.id.txtDescProduto);
        txtSifrao = (TextView) findViewById(R.id.txtSifrao);
       //txtValor = (TextView) findViewById(R.id.txtValor);
        edtCodBarras = (EditText) findViewById(R.id.edtCodBarras);

        /*Botões para testes*/

        pegaCodBarras = edtCodBarras.getText().toString();
        //final String url = "http://192.168.0.12:8001/api/Produtos?regiao=" + regiao + "1&codigobarra="+ pegaCodBarras;


        btnVer = (Button) findViewById(R.id.btnVer);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTaskExample().execute(url);
            }
        });



        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparDados();
            }
        });





        /*edtCodBarras.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                new AsyncTaskExample().execute(url);
            }
        });*/


    }

    public void limparDados(){
        txtCodProduto.setText("");
        txtDescProduto.setText("");
        txtValor.setText("");
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

            txtCodProduto = (TextView) findViewById(R.id.txtCodProduto);
            txtDescProduto = (TextView) findViewById(R.id.txtDescProduto);
            txtValor = (TextView) findViewById(R.id.txtValor);



            txtCodProduto.setText(stringFromDoInBackground[0]);
            txtDescProduto.setText(stringFromDoInBackground[1]);
            txtValor.setText(stringFromDoInBackground[2]);

        }
    }


}
