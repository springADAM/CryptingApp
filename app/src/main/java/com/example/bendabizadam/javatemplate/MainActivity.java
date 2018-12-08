package com.example.bendabizadam.javatemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void Crypt(View v){
        TextView vkey = findViewById(R.id.txtKey);
        TextView vtxtOriginal = findViewById(R.id.originalText);
        TextView txtCrypter = findViewById(R.id.cryptedText);
        String key = vkey.getText().toString();
        String isTxt = (key.length())+key+vtxtOriginal.getText().toString();
        String out="";
        for (int i=0;i<isTxt.length(); i++){
//return the cher at the spicific index
            int index = isTxt.charAt(i);
            char s=(char)(index+1);
            out=out + String.valueOf(s);

        }
        txtCrypter.setText(out);
        vtxtOriginal.setText("");
        vkey.setText("");
    }
    public void Decrypt(View v){
        TextView vkey = findViewById(R.id.txtKey);
        TextView vtxtOriginal = findViewById(R.id.originalText);
        TextView txtCrypter = findViewById(R.id.cryptedText);
        String istxt= txtCrypter.getText().toString();
        char k=(char)(istxt.charAt(0));
        int jumkey =Integer.parseInt(String.valueOf(k))-1;

        String key="", out="";
        for (int i=1; i<=jumkey; i++){
            int index=istxt.charAt(i);
            char s=(char)(index-1);
            key=key+String.valueOf(s);
        }
        if(key.equals(vkey.getText().toString())){
            for (int i=(1+jumkey); i<istxt.length(); i++){
                int index=istxt.charAt(i);
                char s=(char)(index-1);
                out=out+String.valueOf(s);
            }
            vtxtOriginal.setText(out);
        }else{
        Toast.makeText(this,"wrong key",Toast.LENGTH_LONG).show();        }
    }
}
