package com.evan.android.agenda;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUpdateRegistry extends Activity {

    private DatabaseHelper mydb;
    private Context ctx;
    private Button cancel;
    private Button insert;
    private EditText editTextName;
    private EditText editTextTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_update_registry);

        ctx = this;

        mydb = new DatabaseHelper(this);

        cancel = (Button) this.findViewById(R.id.btnCreateRegCancel);
        insert = (Button) this.findViewById(R.id.btnCreateRegSave);

        editTextName = (EditText) this.findViewById(R.id.editTextNomeAluno);
        editTextTel = (EditText) this.findViewById(R.id.editTextTel);

        cancelar();
        inserir();
    }

    public void inserir() {
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, tel;
                nome = editTextName.getText().toString();
                tel = editTextTel.getText().toString();

                mydb.updatePessoa(nome, tel);

                //Voltando
                CreateUpdateRegistry.this.finish();
            }
        });
    }

    public void cancelar() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateUpdateRegistry.this.finish();
            }
        });
    }

}
