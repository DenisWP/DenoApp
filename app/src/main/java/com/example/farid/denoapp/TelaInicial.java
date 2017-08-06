package com.example.farid.denoapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.os.AsyncTask;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;




public class TelaInicial extends AppCompatActivity {


    /* declarando os objetos criados. */
    ImageView LogoFarid;
    EditText edtCodBarras;
    TextView txtCodBarras, txtCodProduto, txtDescProduto, txtSifrao, txtValor;


    String[] objetos = new String[3];
    String regiao = "1";


    JSONObject jsonObjectTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        LogoFarid = (ImageView) findViewById(R.id.LogoFarid);
        txtCodBarras = (TextView) findViewById(R.id.txtCodBarras);
        txtDescProduto = (TextView) findViewById(R.id.txtDescProduto);
        txtSifrao = (TextView) findViewById(R.id.txtSifrao);
        txtValor = (TextView) findViewById(R.id.txtValor);
        edtCodBarras = (EditText) findViewById(R.id.edtCodBarras);



        String pegaCodBarras = edtCodBarras.getText().toString();
        String url = "http://192.168.0.12:8001/api/Produtos?regiao=" + regiao + "1&codigobarra="+ pegaCodBarras;





        new AsyncTaskExample().execute(url);
    }



    public class AsyncTaskExample extends AsyncTask<String, String, String[]> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String[] doInBackground(String... url) {

            try {
                jsonObjectTexts = JsonParser.LerJsonUrl(url[0]);
                objetos[0] = jsonObjectTexts.getString("codigo");
                objetos[1] = jsonObjectTexts.getString("descricao");
                objetos[2] = jsonObjectTexts.getString("valor");
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



            txtCodBarras.setText(stringFromDoInBackground[0]);
            txtDescProduto.setText(stringFromDoInBackground[1]);
            txtValor.setText(stringFromDoInBackground[2]);

        }
    }


}
