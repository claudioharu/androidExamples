package com.evan.android.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateRegistryActivity extends Activity {

    Button cancel;
    Button insert;
    EditText textName;
    EditText textPhone;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_registry);

        cancel = (Button) this.findViewById(R.id.btnCreateRegCancel);
        insert = (Button) this.findViewById(R.id.btnCreateRegSave);

        textName = (EditText) this.findViewById(R.id.editTextNomeAluno);
        textPhone = (EditText) this.findViewById(R.id.editTextTel);

        //banco
        mydb = new DatabaseHelper(this);

        cancelRegistry();
        insertRegistry();

    }

    public void insertRegistry() {
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, tel;
                nome = textName.getText().toString();
                tel = textPhone.getText().toString();

                boolean check = mydb.insertPessoa(nome, tel);

                if(check)
                    Log.d("inserir", "inseriu no banco");
                else
                    Log.d("inserir", "nao inseriu no banco");

                //Voltando
                CreateRegistryActivity.this.finish();
            }
        });




    }

    public void cancelRegistry(){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateRegistryActivity.this.finish();
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
    }

}
