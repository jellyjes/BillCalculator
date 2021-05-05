package sg.edu.rp.c346.id20047778.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amtTxt;
    EditText noOfPax;
    TextView dispTxt;
    ToggleButton tgBtnSVS;
    ToggleButton tgBtnGST;
    Button splitBtn;
    Button resetBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amtTxt = findViewById(R.id.AmountTextView);
        noOfPax = findViewById(R.id.noOfPaxTextView);
        dispTxt = findViewById(R.id.displayText);
        tgBtnGST = findViewById(R.id.toggleButtonGST);
        tgBtnSVS = findViewById(R.id.toggleButtonSVS);
        splitBtn = findViewById(R.id.splitButton);
        resetBtn = findViewById(R.id.resetButton);




        tgBtnSVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double amount = Double.parseDouble(amtTxt.getText().toString());
                int noPax = Integer.parseInt(noOfPax.getText().toString());

                if (tgBtnSVS.isChecked() && splitBtn.isPressed()){      //it can be reduced to 1 line by doing etInput.setEnabled(tgBtn.isChecked());
                    double charge = 0.1;
                    double total_amt = amount + charge;
                    double amt_each = amount / noPax;

                    dispTxt.setText("Total Bill: $"+ total_amt);
                    dispTxt.setText("Each Pays: $" + amt_each);

                } else{
                    double charge = amount * 0.7;
                    double total_amt = amount + charge;
                    double amt_each = amount / noPax;

                    dispTxt.setText("Total Bill: $"+ total_amt);
                    dispTxt.setText("Each Pays: $" + amt_each);

                }
            }
        });


    }
}