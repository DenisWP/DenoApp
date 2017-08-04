package com.example.farid.denoapp;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/*
* https://www.youtube.com/watch?v=tgQbLEckNIo
* */


public class Conexao {

    private static final String TAG = Conexao.class.getSimpleName();

    public Conexao(){

    }

    public String conectando(String reqUrl){
        String resposta = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(conn.getInputStream());
            //resposta = convertStremToString(in);


        } catch (ProtocolException e) {
            Log.e(TAG,"ProtocolException" + e.getMessage());
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException" + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG,"IOException" + e.getMessage());
        }catch (Exception e){
            Log.e(TAG,"Exception" + e.getMessage());
        }
        return resposta;
    }

/*
*
* Talvez não precise, pois o arquivo JSON já está em formato String.
* */
    private String convertStremToString(InputStream in){
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return sb.toString();
    }
}
