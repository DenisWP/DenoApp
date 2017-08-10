package com.example.farid.denoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;


public class TelaInicial extends AppCompatActivity {

    ImageView LogoFarid;
    EditText edtCodBarras;
    TextView txtCodProduto, txtDescProduto, txtSifrao, txtValor;
    String[] objetos = new String[3];
    String regiao = "1";
    String url, CB;
    JSONObject jsonObjectTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); /*Retirando a barra de título do app*/
        setContentView(R.layout.activity_tela_inicial);

        LogoFarid = (ImageView) findViewById(R.id.LogoFarid);
        txtCodProduto = (TextView) findViewById(R.id.txtCodProduto);
        txtDescProduto = (TextView) findViewById(R.id.txtDescProduto);
        txtSifrao = (TextView) findViewById(R.id.txtSifrao);
        txtValor = (TextView) findViewById(R.id.txtValor);
        edtCodBarras = (EditText) findViewById(R.id.edtCodBarras);
        txtSifrao.setVisibility(View.INVISIBLE);

        edtCodBarras.setFocusableInTouchMode(true);
        edtCodBarras.requestFocus();
        edtCodBarras.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
               if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    CB = edtCodBarras.getText().toString();
                    url = "http://192.168.0.12:8001/api/Produtos?regiao=" +regiao+ "&codigobarra="+CB;
                    edtCodBarras.setText("");
                    new AsyncTaskExample().execute(url);

                    /*Thred criada para apagar os campos após 5 segundos*/
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(6000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    limparDados();
                                }
                            });
                        }
                    }).start();
                    return true;
                }
                return false;
            }
        });
    }

    public void limparDados() {
            txtCodProduto.setText("");
            txtDescProduto.setText("");
            txtValor.setText("");
            txtSifrao.setVisibility(View.INVISIBLE);
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
        protected void onPostExecute(String[] jsonWinthor) {
            txtCodProduto.setText(jsonWinthor[0]);
            txtDescProduto.setText(jsonWinthor[1]);
            txtValor.setText(jsonWinthor[2]);
            txtSifrao.setVisibility(View.VISIBLE);
        }
    }
}

