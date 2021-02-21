package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class cont implements Initializable {

    static int stateu = 0;
    @FXML
    Label answerOne = new Label();
    @FXML
    private Button startBT;
    @FXML
    Label answerTow = new Label();
    @FXML
    Label answerThree = new Label();
    @FXML
    TextArea questionText = new TextArea();
    @FXML
    RadioButton r1 = new RadioButton();
    @FXML
    RadioButton r2 = new RadioButton();
    @FXML
    RadioButton r3 = new RadioButton();
    ToggleGroup tg = new ToggleGroup();
    static question q;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);

        q = potQuestion();
        questionText.setText(q.getQ());
        answerOne.setText(q.getAnswerOne());
        answerTow.setText(q.getAnswerTow());
        answerThree.setText(q.getAnswerThree());

    }
    public static boolean show = false;

    @FXML
    private Button submitBT;
    static public boolean g = false;

    @FXML
    void submitBTact(ActionEvent event) throws IOException, InterruptedException {
        submitBT.getScene().getWindow().hide();

        int i = 0;
        Stage primaryStage1 = new Stage();
        if (getSelected() == q.getAnswer()&&stateu==1) {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("vectory.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(cont.class.getName()).log(Level.SEVERE, null, ex);
            }
            primaryStage1.setTitle("vectory");
            primaryStage1.setScene(new Scene(root, 563, 369));
            primaryStage1.show();
            gameopengl2.TheGame.fram.destroy();

        }else

        if (getSelected() == q.getAnswer()) {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("courrect.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(cont.class.getName()).log(Level.SEVERE, null, ex);
            }
            primaryStage1.setTitle("Great");
            primaryStage1.setScene(new Scene(root, 407, 150));
            primaryStage1.show();

        }

        if (!(getSelected() == q.getAnswer())) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(cont.class.getName()).log(Level.SEVERE, null, ex);
            }
            primaryStage1.setTitle("pooo!!");
            primaryStage1.setScene(new Scene(root, 600, 332));
            primaryStage1.show();
            gameopengl2.TheGame.fram.destroy();

        }

    }

    @FXML
    void Start() throws IOException, InterruptedException {

        startBT.getScene().getWindow().hide();

        int i = -1;
        Stage primaryStage1 = new Stage();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    gameopengl2.TheGame.CallClass();
                } catch (IOException ex) {
                    Logger.getLogger(cont.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
        while (i == -1) {

            Thread.sleep(400);
            if (show && i == -1) {
                Parent root = FXMLLoader.load(getClass().getResource("Questions.fxml"));
                primaryStage1.setTitle("Questions");
                primaryStage1.setScene(new Scene(root, 600, 387));
                primaryStage1.show();
                break;
            }
            if (gameopengl2.TheGame.widthTime <= 0) {

                Parent root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
                primaryStage1.setTitle("oOpps!!");
                primaryStage1.setScene(new Scene(root, 600, 332));
                primaryStage1.show();
                gameopengl2.TheGame.fram.destroy();
                break;
            }

        }
    }

    @FXML
    void Exit() {
        startBT.getScene().getWindow().hide();

    }

    public void QuestionShow() throws IOException {
        Stage primaryStage1 = new Stage();
        primaryStage1 = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Questions.fxml"));
        primaryStage1.setTitle("Questions");
        primaryStage1.setScene(new Scene(root, 600, 480));
        primaryStage1.show();
        // ContrullerPages.primaryStage1.hide();

    }

    @FXML
    void ExitGameOver() {

    }
    @FXML
    private Button playAganBT;

    @FXML
    void playAgain() throws IOException, InterruptedException {
        gameopengl2.TheGame.delay=0;
        show = false;
        stateu=0;
        gameopengl2.TheGame.i = -25;
        gameopengl2.TheGame.j = -270;
        gameopengl2.TheGame.widthTime = 775;
        gameopengl2.TheGame.t = true;

        Stage primaryStage1 = new Stage();
        playAganBT.getScene().getWindow().hide();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    gameopengl2.TheGame.CallClass();
                } catch (IOException ex) {
                    Logger.getLogger(cont.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
        int i = -1;
        while (i == -1) {
            Thread.sleep(400);
            if (show && i == -1) {
                Parent root = FXMLLoader.load(getClass().getResource("Questions.fxml"));
                primaryStage1.setTitle("Questions");
                primaryStage1.setScene(new Scene(root, 600, 380));
                primaryStage1.show();
                break;
            }
            if (gameopengl2.TheGame.widthTime <= 0) {
                Parent root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
                primaryStage1.setTitle("GameOver");
                primaryStage1.setScene(new Scene(root, 600, 332));
                primaryStage1.show();
                gameopengl2.TheGame.fram.destroy();
                break;
            }

        }
    }

    question potQuestion() {
        question[] queStrings = new question[10];
        for (int i = 0; i < queStrings.length; i++) {
            queStrings[i] = new question();
        }

        queStrings[0].setQ("ما هي عاصمت فلسطين");
        queStrings[0].setAnswerOne("القدس");
        queStrings[0].setAnswerTow("رام الله");
        queStrings[0].setAnswerThree("بيت لحم");
        queStrings[0].setAnswer(1);

        queStrings[1].setQ("اسم الوباء الذي ظهر حديثا");
        queStrings[1].setAnswerOne("السل");
        queStrings[1].setAnswerTow("كورانا ");
        queStrings[1].setAnswerThree("ايدز");
        queStrings[1].setAnswer(2);

        queStrings[2].setQ("عدد ايام الحجر الصحي للمصاب بالكورونا هو ؟");
        queStrings[2].setAnswerOne("13");
        queStrings[2].setAnswerTow("15");
        queStrings[2].setAnswerThree("14");
        queStrings[2].setAnswer(3);

        queStrings[3].setQ("هل الفصل الثاني الكتروني");
        queStrings[3].setAnswerOne("الله اعلم");
        queStrings[3].setAnswerTow("نعم");
        queStrings[3].setAnswerThree("لا");
        queStrings[3].setAnswer(1);

        queStrings[4].setQ("هل ستنجح في مادة الجرفكس");
        queStrings[4].setAnswerOne("ربما");
        queStrings[4].setAnswerTow("بالتاكيد");
        queStrings[4].setAnswerThree("لا");
        queStrings[4].setAnswer(1);

        queStrings[5].setQ("هل تم صنع لقاح لكورونا ؟");
        queStrings[5].setAnswerOne("نعم");
        queStrings[5].setAnswerTow("لا");
        queStrings[5].setAnswerThree("ربما");
        queStrings[5].setAnswer(1);

        queStrings[6].setQ("مذا تفعل بوقت فراغك ؟");
        queStrings[6].setAnswerOne("ادرس جرافيك");
        queStrings[6].setAnswerTow("انام");
        queStrings[6].setAnswerThree("اذهب للمقهى");
        queStrings[6].setAnswer(1);

        queStrings[7].setQ("في اي عام حدث النكبه الفلسطينية؟");
        queStrings[7].setAnswerOne(" 1999");
        queStrings[7].setAnswerTow("1946");
        queStrings[7].setAnswerThree("1967");
        queStrings[7].setAnswer(2);

        queStrings[8].setQ("في اي عام حدث النكسه الفلسطينيه؟");
        queStrings[8].setAnswerOne(" 1999");
        queStrings[8].setAnswerTow("1946");
        queStrings[8].setAnswerThree("1967");
        queStrings[8].setAnswer(3);
        

        queStrings[9].setQ("ما اسم الصحابي الذي لم يهزم ابدا ؟");
        queStrings[9].setAnswerOne("حمزه بن عبد المطلب");
        queStrings[9].setAnswerTow("خالد بن الويلد");
        queStrings[9].setAnswerThree("عمر بن الخطاب");
        queStrings[9].setAnswer(2);

        return queStrings[(int) Math.floor(Math.random() * 10)];

    }

    public boolean isCurrect(question q, int i) {
        return i == q.getAnswer();
    }

    public int getSelected() {
        if (r1.isSelected()) {
            return 1;
        } else if (r2.isSelected()) {
            return 2;
        } else if (r3.isSelected()) {
            return 3;
        } else {
            return 0;
        }
    }

}
