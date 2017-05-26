package net.deveando.elprono.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.deveando.elprono.R;
import net.deveando.elprono.util.UtilHelper;

import static android.content.SharedPreferences.*;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        if (prefs.getString("name", null) != null && prefs.getString("mail", null) != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText inputName = (EditText) findViewById(R.id.inputName);
                EditText inputMail = (EditText) findViewById(R.id.inputMail);

                if (!UtilHelper.validName(inputName.getText().toString())) {
                    inputName.setError(getString(R.string.error_name));
                }
                else if (!UtilHelper.validMail(inputMail.getText().toString())) {
                    inputMail.setError(getString(R.string.error_mail));
                }
                else {
                    Editor editor = prefs.edit();
                    editor.putString("name", inputName.getText().toString());
                    editor.putString("mail", inputMail.getText().toString());
                    editor.commit();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }
}
