import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Main extends Application {

    private static boolean mClear = false;

    public static void main(String[] args) {
        launch(args);
    }

    private static double addition(double a, double b) {
        return a + b;
    }

    private static double subtraction(double a, double b) {
        // TODO : a minus b
        return 0;
    }

    private static double multiplication(double a, double b) {
        // TODO : a multiplied by b
        return 0;
    }

    private static double division(double a, double b) {
        // TODO : a divided by b
        return 0;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();

        root.setPadding(new Insets(30));
        root.setHgap(15);
        root.setVgap(15);

        TextField field = new TextField();
        field.setEditable(false);
        field.setPrefWidth(110);
        root.add(field, 0, 0, 3, 1);

        Button num7 = new Button();
        num7.setText("7");
        root.add(num7, 0, 1);
        num7.setOnAction(event -> addOperator("7", field));

        Button num8 = new Button();
        num8.setText("8");
        root.add(num8, 1, 1);
        num8.setOnAction(event -> addOperator("8", field));

        Button num9 = new Button();
        num9.setText("9");
        root.add(num9, 2, 1);
        num9.setOnAction(event -> addOperator("9", field));

        // TODO : fix numpad 3
        Button num4 = new Button();
        num4.setText("#");
        root.add(num4, 0, 2);
        num4.setOnAction(event -> addOperator("4", field));

        Button num5 = new Button();
        num5.setText("5");
        root.add(num5, 1, 2);
        num5.setOnAction(event -> addOperator("5", field));

        Button num6 = new Button();
        num6.setText("6");
        root.add(num6, 2, 2);
        num6.setOnAction(event -> addOperator("6", field));

        Button num1 = new Button();
        num1.setText("1");
        root.add(num1, 0, 3);
        num1.setOnAction(event -> addOperator("1", field));

        Button num2 = new Button();
        num2.setText("2");
        root.add(num2, 1, 3);
        num2.setOnAction(event -> addOperator("2", field));

        Button num3 = new Button();
        num3.setText("3");
        root.add(num3, 2, 3);
        num3.setOnAction(event -> addOperator("3", field));

        Button num0 = new Button();
        num0.setText("0");
        root.add(num0, 1, 4);
        num0.setOnAction(event -> addOperator("0", field));

        Button clear = new Button();
        clear.setText("C");
        root.add(clear, 2, 4);
        clear.setOnAction(actionEvent -> field.setText(""));

        Button plus = new Button();
        plus.setText("+");
        plus.setPrefWidth(30);
        root.add(plus, 3, 0);
        plus.setOnAction(event -> addOperator("+", field));

        Button minus = new Button();
        minus.setText("-");
        minus.setPrefWidth(30);
        root.add(minus, 3, 1);
        minus.setOnAction(event -> addOperator("-", field));

        Button mult = new Button();
        mult.setText("*");
        mult.setPrefWidth(30);
        root.add(mult, 3, 2);
        mult.setOnAction(event -> addOperator("*", field));

        Button div = new Button();
        div.setText("/");
        div.setPrefWidth(30);
        root.add(div, 3, 3);
        div.setOnAction(event -> addOperator("/", field));

        Button equal = new Button();
        equal.setText("=");
        equal.setPrefWidth(30);
        root.add(equal, 3, 4);
        equal.setOnAction(actionEvent -> {
            String line = field.getText();
            String[] operators = line.split("[+\\-*/]");
            double a;
            double b;
            if (operators.length != 2) {
                field.setText("ERROR");
                mClear = true;
            } else {
                try {
                    a = Integer.parseInt(operators[0]);
                    b = Integer.parseInt(operators[1]);
                } catch (NumberFormatException e) {
                    field.setText("ERROR");
                    mClear = true;
                    return;
                }
                DecimalFormat df = new DecimalFormat("#.###");
                if (line.contains("+")) {
                    field.setText(df.format(addition(a, b)));
                } else if (line.contains("-")) {
                    field.setText(df.format(subtraction(a, b)));
                } else if (line.contains("*")) {
                    field.setText(df.format(multiplication(a, b)));
                } else if (line.contains("/")) {
                    field.setText(df.format(division(a, b)));
                } else {
                    field.setText("ERROR");
                    mClear = true;
                }
            }
        });

        Scene scene = new Scene(root, 214, 250);
        primaryStage.setTitle("Calculotron");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addOperator(String operator, TextField field) {
        if (mClear) {
            field.setText("");
            mClear = false;
        }
        field.appendText(operator + "");
    }
}
