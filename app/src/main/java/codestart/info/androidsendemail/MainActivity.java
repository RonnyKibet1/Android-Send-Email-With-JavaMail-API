package codestart.info.androidsendemail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText toEmailEditText;
    private EditText subjectEditText;
    private EditText messageEditText;
    private Button sendButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign views
        toEmailEditText = (EditText)findViewById(R.id.toEmailEditText);
        subjectEditText = (EditText)findViewById(R.id.subjectEditText);
        messageEditText = (EditText)findViewById(R.id.messageEditText);
        sendButton = (Button)findViewById(R.id.sendMessageButton);
        clearButton = (Button)findViewById(R.id.clearButton);


        //listen to send button click
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String to = toEmailEditText.getText().toString().trim();
                    String subject = subjectEditText.getText().toString();
                    String message = messageEditText.getText().toString();

                    if(to.isEmpty()){
                        Toast.makeText(MainActivity.this, "You must enter a recipient email", Toast.LENGTH_LONG).show();
                    }else if(subject.isEmpty()){
                        Toast.makeText(MainActivity.this, "You must enter a Subject", Toast.LENGTH_LONG).show();
                    }else if(message.isEmpty()){
                        Toast.makeText(MainActivity.this, "You must enter a message", Toast.LENGTH_LONG).show();
                    }else {
                        //everything is filled out
                        //send email
                        new SimpleMail().sendEmail(to, subject, message);
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }


            }

        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEmailEditText.setText(null);
                subjectEditText.setText(null);
                messageEditText.setText(null);
            }
        });



    }
}
