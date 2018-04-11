package com.olabode33.android.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BoardSize5 extends AppCompatActivity {

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
    String grd14 = "";
    String grd15 = "";

    String grd21 = "";
    String grd22 = "";
    String grd23 = "";
    String grd24 = "";
    String grd25 = "";

    String grd31 = "";
    String grd32 = "";
    String grd33 = "";
    String grd34 = "";
    String grd35 = "";

    String grd41 = "";
    String grd42 = "";
    String grd43 = "";
    String grd44 = "";
    String grd45 = "";

    String grd51 = "";
    String grd52 = "";
    String grd53 = "";
    String grd54 = "";
    String grd55 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_size5);

        //Get data from previous activity
        Intent intent = getIntent();
        playerCount = intent.getStringExtra(MainActivity.PLAYER_COUNT);
        p1Token = intent.getStringExtra(MainActivity.P1_TOKEN);
        p2Token = intent.getStringExtra(MainActivity.P2_TOKEN);

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
        Button grdBtn14 = (Button) findViewById(R.id.grd_btn_1_4);
        Button grdBtn15 = (Button) findViewById(R.id.grd_btn_1_5);

        Button grdBtn21 = (Button) findViewById(R.id.grd_btn_2_1);
        Button grdBtn22 = (Button) findViewById(R.id.grd_btn_2_2);
        Button grdBtn23 = (Button) findViewById(R.id.grd_btn_2_3);
        Button grdBtn24 = (Button) findViewById(R.id.grd_btn_2_4);
        Button grdBtn25 = (Button) findViewById(R.id.grd_btn_2_5);

        Button grdBtn31 = (Button) findViewById(R.id.grd_btn_3_1);
        Button grdBtn32 = (Button) findViewById(R.id.grd_btn_3_2);
        Button grdBtn33 = (Button) findViewById(R.id.grd_btn_3_3);
        Button grdBtn34 = (Button) findViewById(R.id.grd_btn_3_4);
        Button grdBtn35 = (Button) findViewById(R.id.grd_btn_3_5);

        Button grdBtn41 = (Button) findViewById(R.id.grd_btn_4_1);
        Button grdBtn42 = (Button) findViewById(R.id.grd_btn_4_2);
        Button grdBtn43 = (Button) findViewById(R.id.grd_btn_4_3);
        Button grdBtn44 = (Button) findViewById(R.id.grd_btn_4_4);
        Button grdBtn45 = (Button) findViewById(R.id.grd_btn_4_5);

        Button grdBtn51 = (Button) findViewById(R.id.grd_btn_5_1);
        Button grdBtn52 = (Button) findViewById(R.id.grd_btn_5_2);
        Button grdBtn53 = (Button) findViewById(R.id.grd_btn_5_3);
        Button grdBtn54 = (Button) findViewById(R.id.grd_btn_5_4);
        Button grdBtn55 = (Button) findViewById(R.id.grd_btn_5_5);

        grd11 = grdBtn11.getText().toString();
        grd12 = grdBtn12.getText().toString();
        grd13 = grdBtn13.getText().toString();
        grd14 = grdBtn14.getText().toString();
        grd15 = grdBtn15.getText().toString();

        grd21 = grdBtn21.getText().toString();
        grd22 = grdBtn22.getText().toString();
        grd23 = grdBtn23.getText().toString();
        grd24 = grdBtn24.getText().toString();
        grd25 = grdBtn25.getText().toString();

        grd31 = grdBtn31.getText().toString();
        grd32 = grdBtn32.getText().toString();
        grd33 = grdBtn33.getText().toString();
        grd34 = grdBtn34.getText().toString();
        grd35 = grdBtn35.getText().toString();

        grd41 = grdBtn41.getText().toString();
        grd42 = grdBtn42.getText().toString();
        grd43 = grdBtn43.getText().toString();
        grd44 = grdBtn44.getText().toString();
        grd45 = grdBtn45.getText().toString();

        grd51 = grdBtn51.getText().toString();
        grd52 = grdBtn52.getText().toString();
        grd53 = grdBtn53.getText().toString();
        grd54 = grdBtn54.getText().toString();
        grd55 = grdBtn55.getText().toString();
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
        Button grdBtn14 = (Button) findViewById(R.id.grd_btn_1_4);
        Button grdBtn15 = (Button) findViewById(R.id.grd_btn_1_5);

        Button grdBtn21 = (Button) findViewById(R.id.grd_btn_2_1);
        Button grdBtn22 = (Button) findViewById(R.id.grd_btn_2_2);
        Button grdBtn23 = (Button) findViewById(R.id.grd_btn_2_3);
        Button grdBtn24 = (Button) findViewById(R.id.grd_btn_2_4);
        Button grdBtn25 = (Button) findViewById(R.id.grd_btn_2_5);

        Button grdBtn31 = (Button) findViewById(R.id.grd_btn_3_1);
        Button grdBtn32 = (Button) findViewById(R.id.grd_btn_3_2);
        Button grdBtn33 = (Button) findViewById(R.id.grd_btn_3_3);
        Button grdBtn34 = (Button) findViewById(R.id.grd_btn_3_4);
        Button grdBtn35 = (Button) findViewById(R.id.grd_btn_3_5);

        Button grdBtn41 = (Button) findViewById(R.id.grd_btn_4_1);
        Button grdBtn42 = (Button) findViewById(R.id.grd_btn_4_2);
        Button grdBtn43 = (Button) findViewById(R.id.grd_btn_4_3);
        Button grdBtn44 = (Button) findViewById(R.id.grd_btn_4_4);
        Button grdBtn45 = (Button) findViewById(R.id.grd_btn_4_5);

        Button grdBtn51 = (Button) findViewById(R.id.grd_btn_5_1);
        Button grdBtn52 = (Button) findViewById(R.id.grd_btn_5_2);
        Button grdBtn53 = (Button) findViewById(R.id.grd_btn_5_3);
        Button grdBtn54 = (Button) findViewById(R.id.grd_btn_5_4);
        Button grdBtn55 = (Button) findViewById(R.id.grd_btn_5_5);

        grdBtn11.setText("");
        grdBtn12.setText("");
        grdBtn13.setText("");
        grdBtn14.setText("");
        grdBtn15.setText("");

        grdBtn21.setText("");
        grdBtn22.setText("");
        grdBtn23.setText("");
        grdBtn24.setText("");
        grdBtn25.setText("");

        grdBtn31.setText("");
        grdBtn32.setText("");
        grdBtn33.setText("");
        grdBtn34.setText("");
        grdBtn35.setText("");

        grdBtn41.setText("");
        grdBtn42.setText("");
        grdBtn43.setText("");
        grdBtn44.setText("");
        grdBtn45.setText("");

        grdBtn51.setText("");
        grdBtn52.setText("");
        grdBtn53.setText("");
        grdBtn54.setText("");
        grdBtn55.setText("");
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

        if (grd11 == token && grd12 == token && grd13 == token && grd14 == token && grd15 == token)
            return true;
        if (grd21 == token && grd22 == token && grd23 == token && grd24 == token && grd25 == token)
            return true;
        if (grd31 == token && grd32 == token && grd33 == token && grd34 == token && grd35 == token)
            return true;
        if (grd41 == token && grd42 == token && grd43 == token && grd44 == token && grd45 == token)
            return true;
        if (grd51 == token && grd52 == token && grd53 == token && grd54 == token && grd55 == token)
            return true;

        return false;
    }

    private boolean scoreVertical(String token) {
        getButtonValue();

        if (grd11 == token && grd21 == token && grd31 == token && grd41 == token && grd51 == token)
            return true;
        if (grd12 == token && grd22 == token && grd32 == token && grd42 == token && grd52 == token)
            return true;
        if (grd13 == token && grd23 == token && grd33 == token && grd43 == token && grd53 == token)
            return true;
        if (grd14 == token && grd24 == token && grd34 == token && grd44 == token && grd54 == token)
            return true;
        if (grd15 == token && grd25 == token && grd35 == token && grd45 == token && grd55 == token)
            return true;

        return false;
    }

    private boolean scoreDiagonal(String token) {
        getButtonValue();

        if (grd11 == token && grd22 == token && grd33 == token && grd44 == token && grd55 == token)
            return true;
        if (grd15 == token && grd24 == token && grd33 == token && grd42 == token && grd51 == token)
            return true;

        return false;
    }

    private boolean scoreDraw() {
        if (grd11 != "" && grd12 != "" && grd13 != "" && grd14 != "" && grd15 != "" &&
                grd21 != "" && grd22 != "" && grd23 != "" && grd24 != "" && grd25 != "" &&
                grd31 != "" && grd32 != "" && grd33 != "" && grd34 != "" && grd35 != "" &&
                grd41 != "" && grd42 != "" && grd43 != "" && grd44 != "" && grd45 != "" &&
                grd51 != "" && grd52 != "" && grd53 != "" && grd54 != "" && grd55 != "")
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

    public void grd14(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_1_4);
        playGrid(grdBtn);
    }

    public void grd15(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_1_5);
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

    public void grd24(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_2_4);
        playGrid(grdBtn);
    }

    public void grd25(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_2_5);
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

    public void grd34(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_3_4);
        playGrid(grdBtn);
    }

    public void grd35(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_3_5);
        playGrid(grdBtn);
    }

    public void grd41(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_4_1);
        playGrid(grdBtn);
    }

    public void grd42(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_4_2);
        playGrid(grdBtn);
    }

    public void grd43(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_4_3);
        playGrid(grdBtn);
    }

    public void grd44(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_4_4);
        playGrid(grdBtn);
    }

    public void grd45(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_4_5);
        playGrid(grdBtn);
    }

    public void grd51(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_5_1);
        playGrid(grdBtn);
    }

    public void grd52(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_5_2);
        playGrid(grdBtn);
    }

    public void grd53(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_5_3);
        playGrid(grdBtn);
    }

    public void grd54(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_5_4);
        playGrid(grdBtn);
    }

    public void grd55(View view) {
        //Grid Buttons
        Button grdBtn = (Button) findViewById(R.id.grd_btn_5_5);
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
