package com.evan.android.agenda;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChoosingNameRegistry extends Activity {

    private Context ctx;
    private Button insert;
    private Button cancel;
    private EditText editTextName;
    private DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_name_registry);

        insert = (Button) this.findViewById(R.id.save);
        cancel = (Button) this.findViewById(R.id.cancel);

        editTextName = (EditText) this.findViewById(R.id.editTextNomeAluno);

        ctx = this;

        mydb = new DatabaseHelper(this);

        cancelar();
        deletar();
    }

    public void cancelar() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoosingNameRegistry.this.finish();
            }
        });
    }

    public void deletar(){
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                mydb.removePessoa(name);
                ChoosingNameRegistry.this.finish();
            }
        });
    }

}
