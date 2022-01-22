package com.example.smartfit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.smartfit.UserDB.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);

        root = findViewById(R.id.root_element);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        btnSignIn.setOnClickListener(v -> showSignInWindow());
        btnRegister.setOnClickListener(v -> showRegisterWindow());
    }

    private void showSignInWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("SIGN IN");
        dialog.setMessage("Enter all login details");

        LayoutInflater inflater = LayoutInflater.from(this);
        View sign_in_window = inflater.inflate(R.layout.sign_in_window, null);
        dialog.setView(sign_in_window);

        final MaterialEditText email = sign_in_window.findViewById(R.id.emailField);
        final MaterialEditText pass = sign_in_window.findViewById(R.id.passField);

        dialog.setNegativeButton("Cancel", (dialogInterface, which) -> dialogInterface.dismiss());

        dialog.setPositiveButton("Sign in", (dialogInterface, which) -> {
            if(TextUtils.isEmpty(email.getText().toString())) {
                Snackbar.make(root,"Enter your email", Snackbar.LENGTH_SHORT).show();
                return;
            }

            if(pass.getText().toString().length() < 5) {
                Snackbar.make(root,"Enter a password that is longer than 5 characters", Snackbar.LENGTH_SHORT).show();
                return;
            }

            auth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            startActivity(new Intent(MainActivity.this, ChooseActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(e -> Snackbar.make(root, "Authorisation error. " + e.getMessage(), Snackbar.LENGTH_SHORT).show());
        });
        dialog.show();
    }

    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("SIGN UP");
        dialog.setMessage("Enter all details for registration");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.register_window, null);
        dialog.setView(register_window);

        final MaterialEditText email = register_window.findViewById(R.id.emailField);
        final MaterialEditText pass = register_window.findViewById(R.id.passField);
        final MaterialEditText name = register_window.findViewById(R.id.nameField);

        dialog.setNegativeButton("Cancel", (dialogInterface, which) -> dialogInterface.dismiss());

        dialog.setPositiveButton("Add", (dialogInterface, which) -> {
            if(TextUtils.isEmpty(email.getText().toString())) {
                Snackbar.make(root,"Enter your email", Snackbar.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(name.getText().toString())) {
                Snackbar.make(root,"Enter your name", Snackbar.LENGTH_SHORT).show();
                return;
            }

            if(pass.getText().toString().length() < 5) {
                Snackbar.make(root,"Enter a password that is longer than 5 characters", Snackbar.LENGTH_SHORT).show();
                return;
            }

            auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                    .addOnSuccessListener(authResult -> {
                        User user = new User();
                        user.setEmail(email.getText().toString());
                        user.setEmail(name.getText().toString());
                        user.setEmail(pass.getText().toString());

                        users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user)
                                .addOnSuccessListener(unused -> Snackbar.make(root, "User added!", Snackbar.LENGTH_SHORT).show());
                    }).addOnFailureListener(e -> Snackbar.make(root, "Authorisation error. " + e.getMessage(), Snackbar.LENGTH_SHORT).show());
        });
        dialog.show();
    }
}