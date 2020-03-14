package com.example.testeandroidibm.ui.account;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroidibm.R;
import com.example.testeandroidibm.data.model.Statement;
import com.example.testeandroidibm.ui.adapter.AdapterAccount;
import com.example.testeandroidibm.ui.login.MainActivity;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AccountActivity extends AppCompatActivity implements AccountContract.ListStatementView {

    private ImageButton imageButtonLogout;
    private RecyclerView recyclerViewAccount;
    private List<AccountActivity> listAccount;
    private TextView textViewName, textViewConta, textViewBankAccount, textViewSaldo, textViewBalance;
    private Dialog dialog;
    private Button buttonChosserYes, buttonChosserNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        loadUi();

        Bundle b = getIntent().getExtras();

        if (b != null) {
            textViewName.setText(b.getString("Name"));
            textViewBankAccount.setText(b.getString("BankAccount") + " / " +
                    b.getString("Agency").replaceAll("([0-9]{2})([0-9]{6})([0-9])","$1.$2-$3"));

            Locale locale = new Locale("pt", "BR");
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            String currency = format.format(b.getDouble("Balance"));
            textViewBalance.setText(currency);

            AccountContract.ListStatementPresenter presenter = new AccountPresenter(this);

            presenter.getStatement(b.getInt("Id"));
        }

        imageButtonLogout.setOnClickListener(v -> showDialogChooser());

    }

    private void configAdapter(List<Statement> statements) {
        AdapterAccount adapter = new AdapterAccount(AccountActivity.this, statements);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewAccount.setLayoutManager(layoutManager);
        recyclerViewAccount.setHasFixedSize(true);
        recyclerViewAccount.setAdapter(adapter);

    }

    private void loadUi() {
        imageButtonLogout = findViewById(R.id.imageButtonLogout);
        recyclerViewAccount = findViewById(R.id.recyclerViewAccount);
        textViewName = findViewById(R.id.textViewName);
        textViewConta = findViewById(R.id.textViewConta);
        textViewBankAccount = findViewById(R.id.textViewBankAccount);
        textViewSaldo = findViewById(R.id.textViewSaldo);
        textViewBalance = findViewById(R.id.textViewBalance);
    }


    public void showDialogChooser() {
        dialog = new Dialog(this, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_dialog_chooser);
        dialog.setCancelable(false);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.
                SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.show();

        buttonChosserYes = dialog.findViewById(R.id.button_dialog_chooser_yes);
        buttonChosserNo = dialog.findViewById(R.id.buttton_dialog_chooser_no);

        buttonChosserYes.setOnClickListener(v -> {
            final Statement statement = (Statement) AccountActivity.this.getIntent().getSerializableExtra("statement");

            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            AccountActivity.this.startActivity(intent);
        });
        buttonChosserNo.setOnClickListener(v -> dialog.dismiss());
    }

    @Override
    public void showList(List<Statement> statements) {
        configAdapter(statements);
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "Erro ao obter o seu extrato!", Toast.LENGTH_LONG).show();

    }
}