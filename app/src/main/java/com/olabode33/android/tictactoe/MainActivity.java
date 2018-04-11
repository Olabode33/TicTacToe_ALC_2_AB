package com.olabode33.android.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PLAYER_COUNT = "com.olabode33.android.tictactoe.PLAYER_COUNT";
    public static final String P1_TOKEN = "com.olabode33.android.tictactoe.P1_TOKEN";
    public static final String P2_TOKEN = "com.olabode33.android.tictactoe.P2_TOKEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        populateSpinners();
    }

    private void populateSpinners() {
        //player count spinner
        Spinner playerCountSpinner = (Spinner) findViewById(R.id.player_count_spinner);
        ArrayAdapter<CharSequence> playerAdapter = ArrayAdapter.createFromResource(
                this, R.array.input_spn_player, android.R.layout.simple_spinner_item
        );
        playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerCountSpinner.setAdapter(playerAdapter);

        //board size spinner
        Spinner boardSizeSpinner = (Spinner) findViewById(R.id.board_size_spinner);
        ArrayAdapter<CharSequence> boardSizeAdapter = ArrayAdapter.createFromResource(
                this, R.array.input_spn_board, android.R.layout.simple_spinner_item
        );
        boardSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boardSizeSpinner.setAdapter(boardSizeAdapter);

        //Token spinner
        Spinner p1TokenSpinner = (Spinner) findViewById(R.id.token_spinner_p1);
        Spinner p2TokenSpinner = (Spinner) findViewById(R.id.token_spinner_p2);
        ArrayAdapter<CharSequence> tokenAdapter = ArrayAdapter.createFromResource(this,
                R.array.input_token, android.R.layout.simple_spinner_item);
        tokenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        p1TokenSpinner.setAdapter(tokenAdapter);
        p2TokenSpinner.setAdapter(tokenAdapter);
    }

    public void startGame(View view) {
        Spinner playerCountSpinner = (Spinner) findViewById(R.id.player_count_spinner);
        Spinner boardSizeSpinner = (Spinner) findViewById(R.id.board_size_spinner);
        Spinner p1TokenSpinner = (Spinner) findViewById(R.id.token_spinner_p1);
        Spinner p2TokenSpinner = (Spinner) findViewById(R.id.token_spinner_p2);

        String playerCount = playerCountSpinner.getSelectedItem().toString();
        String boardSize = boardSizeSpinner.getSelectedItem().toString();
        String p1Token = p1TokenSpinner.getSelectedItem().toString();
        String p2Token = p2TokenSpinner.getSelectedItem().toString();

        Intent intent;

        String board3 = "3 by 3";

        if (boardSize.equals(board3)) {
            intent = new Intent(this, BoardSize3.class);
            intent.putExtra(PLAYER_COUNT, playerCount);
            intent.putExtra(P1_TOKEN, p1Token);
            intent.putExtra(P2_TOKEN, p2Token);
        } else {
            intent = new Intent(this, BoardSize5.class);
            intent.putExtra(PLAYER_COUNT, playerCount);
            intent.putExtra(P1_TOKEN, p1Token);
            intent.putExtra(P2_TOKEN, p2Token);
        }

        if (p1Token == p2Token) {
            DisplayToast("You can't choose the same token for both player's please choose a different token" + boardSize);
        } else {
            startActivity(intent);
        }
    }

    private void DisplayToast(String msg) {
        Context context = getApplicationContext();
        CharSequence t_msg = msg + "!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, t_msg, duration);
        toast.show();
    }

}
