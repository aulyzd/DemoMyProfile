package sg.edu.rp.c346.id20014198.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }



    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float floatGPA = Float.valueOf(strGPA);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa",floatGPA);


        prefEdit.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String msg1 = prefs.getString("name", "No Name Input");
        Float msg2 = prefs.getFloat("gpa", 0);

        etName.setText(msg1);
        etGPA.setText(msg2 + "");

    }
}

