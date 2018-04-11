package com.olabode33.android.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BoardSize3 extends AppCompatActivity {

    String playerCount = "";

    String currentPlayer = "";
    String p1Label = "Player 1";
    String p2Label = "Player 2";
    String p1Token = "";
    String p2Token = "";

    int p1Score = 0;
    int p2Score = 0;
    int drawCount = 0;

    int gameCount = 0;

    //Grids Values
    String grd11 = "";
    String grd12 = "";
    String grd13 = "";
    String grd21 = "";
    String grd22 = "";
    String grd23 = "";
    String grd31 = "";
    String grd32 = "";
    String grd33 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_size3);

        //Get data from previous activity
        Intent intent = getIntent();
        playerCount = intent.getStringExtra(MainActivity.PLAYER_COUNT);
        p1Token = intent.getStringExtra(MainActivity.P1_TOKEN);
        p2Token = intent.getStringExtra(MainActivity.P2_TOKEN);

        //
        if (playerCount.equals("1 Player")) {
            //p1Label = "Self - " + p1Token;
            p2Label = p1Label;
        }

        //Set current player label
        currentPlayer = "p1";

        //Set number of games
        gameCount = 1;

        //Display current Player
        displayCurrentPlayer();
    }

    private void displayCurrentPlayer() {
        String currentPlayerLabel;

        switch (currentPlayer) {
            case "p1":
                currentPlayerLabel = p1Label + " (" + p1Token + ")";
                DisplayToast("Game: " + gameCount + " - " + p1Label + "'s turn");
                break;
            case "p2":
                currentPlayerLabel = p2Label + " (" + p2Token + ")";
                DisplayToast("Game: " + gameCount + " - " + p2Label + "'s turn");
                break;
            default:
                currentPlayerLabel = p1Label + " (" + p1Token + ")";
                DisplayToast("Game: " + gameCount + " - " + p1Label + "'s turn");
                break;
        }

        TextView tv = (TextView) findViewById(R.id.tv_cp_text);
        tv.setText(currentPlayerLabel);

        TextView tvGame = (TextView) findViewById(R.id.tv_game_text);
        tvGame.setText("" + gameCount);

        TextView tvP1Score = (TextView) findViewById(R.id.tv_p1_score);
        tvP1Score.setText("" + p1Score);

        TextView tvP2Score = (TextView) findViewById(R.id.tv_p2_score);
        tvP2Score.setText("" + p2Score);

        TextView tvDraw = (TextView) findViewById(R.id.tv_draw_count);
        tvDraw.setText("" + drawCount);
    }

    public void playGrid(Button grdBtn) {

        switch (currentPlayer) {
            case "p1":
                grdBtn.setText(p1Token);
                scoreGame();
                currentPlayer = "p2";
                break;
            case "p2":
                grdBtn.setText(p2Token);
                scoreGame();
                currentPlayer = "p1";
                break;
            default:
                grdBtn.setText(p1Token);
                scoreGame();
                currentPlayer = "p2";
                break;
        }

        displayCurrentPlayer();
    }

    public void getButtonValue() {
        //Grid Buttons
        Button grdBtn11 = (Button) findViewById(R.id.grd_btn_1_1);
        Button grdBtn12 = (Button) findViewById(R.id.grd_btn_1_2);
        Button grdBtn13 = (Button) findViewById(R.id.grd_btn_1_3);
        Button grdBtn21 = (Button) findViewById(R.id.grd_btn_2_1);
        Button grdBtn22 = (Button) findViewById(R.id.grd_btn_2_2);
        Button grdBtn23 = (Button) findViewById(R.id.grd_btn_2_3);
        Button grdBtn31 = (Button) findViewById(R.id.grd_btn_3_1);
        Button grdBtn32 = (Button) findViewById(R.id.grd_btn_3_2);
        Button grdBtn33 = (Button) findViewById(R.id.grd_btn_3_3);

        grd11 = grdBtn11.getText().toString();
        grd12 = grdBtn12.getText().toString();
        grd13 = grdBtn13.getText().toString();
        grd21 = grdBtn21.getText().toString();
        grd22 = grdBtn22.getText().toString();
        grd23 = grdBtn23.getText().toString();
        grd31 = grdBtn31.getText().toString();
        grd32 = grdBtn32.getText().toString();
        grd33 = grdBtn33.getText().toString();
    }

    public void resetGame(View view) {
        currentPlayer = "p1";
        p1Score = 0;
        p2Score = 0;
        gameCount = 1;
        drawCount = 0;

        clearGrid();
        displayCurrentPlayer();
    }

    public void clearGrid() {
        //Grid Buttons
        Button grdBtn11 = (Button) findViewById(R.id.grd_btn_1_1);
        Button grdBtn12 = (Button) findViewById(R.id.grd_btn_1_2);
        Button grdBtn13 = (Button) findViewById(R.id.grd_btn_1_3);
        Button grdBtn21 = (Button) findViewById(R.id.grd_btn_2_1);
        Button grdBtn22 = (Button) findViewById(R.id.grd_btn_2_2);
        Button grdBtn23 = (Button) findViewById(R.id.grd_btn_2_3);
        Button grdBtn31 = (Button) findViewById(R.id.grd_btn_3_1);
        Button grdBtn32 = (Button) findViewById(R.id.grd_btn_3_2);
        Button grdBtn33 = (Button) findViewById(R.id.grd_btn_3_3);

        grdBtn11.setText("");
        grdBtn12.setText("");
        grdBtn13.setText("");
        grdBtn21.setText("");
        grdBtn22.setText("");
        grdBtn23.setText("");
        grdBtn31.setText("");
        grdBtn32.setText("");
        grdBtn33.setText("");
    }

    private void scoreGame() {
        if (scoreGrid(p1Token)) {
            p1Score++;
            String msg = p1Label + "(" + p1Token + ") wins";
            DisplayToast(msg);
            clearGrid();
            gameCount++;
        }
        if (scoreGrid(p2Token)) {
            p2Score++;
            String msg = p2Label + "(" + p2Token + ") wins";
            DisplayToast(msg);
            clearGrid();
            gameCount++;
        }
        if (scoreDraw()) {
            drawCount++;
            String msg = "DRAW";
            DisplayToast(msg);
            clearGrid();
            gameCount++;
        }
    }

    private boolean scoreGrid(String token) {
        if (scoreHorizontal(token))
            return true;
        if (scoreVertical(token))
            return true;
        if (scoreDiagonal(token))
            return true;

        return false;
    }

    private boolean scoreHorizontal(String token) {
        getButtonValue();

        if (grd11 == token && grd12 == token && grd13 == token)
            return true;
        if (grd21 == token && grd22 == token && grd23 == token)
            return true;
        if (grd31 == token && grd32 == token && grd33 == token)
            return true;

        return false;
    }

    private boolean scoreVertical(String token) {
        getButtonValue();

        if (grd11 == token && grd21 == token && grd31 == token)
            return true;
        if (grd12 == token && grd22 == token && grd32 == token)
            return true;
        if (grd13 == token && grd23 == token && grd33 == token)
            return true;

        return false;
    }

    private boolean scoreDiagonal(String token) {
        getButtonValue();

        if (grd11 == token && grd22 == token && grd33 == token)
            return true;
        if (grd13 == token && grd22 == token && grd31 == token)
            return true;

        return false;
    }

    private boolean scoreDraw() {
        if (grd11 != "" && grd12 != "" && grd13 != "" &&
                grd21 != "" && grd22 != "" && grd23 != "" &&
                grd31 != "" && grd32 != "" && grd33 != "")
            return true;

        return false;
    }

    public void grd11(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_1_1);
        playGrid(grdBtn);
    }

    public void grd12(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_1_2);
        playGrid(grdBtn);
    }

    public void grd13(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_1_3);
        playGrid(grdBtn);
    }

    public void grd21(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_2_1);
        playGrid(grdBtn);
    }

    public void grd22(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_2_2);
        playGrid(grdBtn);
    }

    public void grd23(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_2_3);
        playGrid(grdBtn);
    }

    public void grd31(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_3_1);
        playGrid(grdBtn);
    }

    public void grd32(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_3_2);
        playGrid(grdBtn);
    }

    public void grd33(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_3_3);
        playGrid(grdBtn);
    }

    private void DisplayToast(String msg) {
        Context context = getApplicationContext();
        CharSequence t_msg = msg + "!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, t_msg, duration);
        toast.show();
    }
}
