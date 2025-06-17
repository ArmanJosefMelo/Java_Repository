import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame implements ActionListener {
    
    Label questionLabel;
    CheckboxGroup choicesGroup;
    Checkbox answer1, answer2, answer3, answer4;
    Button nextButton;
    int questionNum = 0;
    int score = 0;

    // Sample Questions and Choices.
    String[] quizQuestions = {
        "Which programming language uses CSS?",
        "Which programming language uses Swing?",
        "What does CSS stand for?"
    };

    String[][] quizChoices = {
        {"HTML", "Java", "Python", "None of the above"},
        {"HTML", "Java", "Python", "None of the above"},
        {"Cascade Style Sheet", "Cascading Style Sheet", "Cascade Style Sheets", "Cascading Style Sheets"}
    };

    int[] correctAnswers = {0, 1, 3}; // Index Number of Correct Answers.

    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(new GridLayout(6 , 2));

    // Window Closing
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
        }
    });


        questionLabel = new Label();
        add(questionLabel);

        choicesGroup = new CheckboxGroup();
        answer1 = new Checkbox("", choicesGroup, false);
        answer2 = new Checkbox("", choicesGroup, false);
        answer3 = new Checkbox("", choicesGroup, false);
        answer4 = new Checkbox("", choicesGroup, false);

        add(answer1);
        add(answer2);
        add(answer3);
        add(answer4);

        nextButton = new Button("Next Question");
        nextButton.addActionListener(this);
        add(nextButton);

        loadQuestion();

        setResizable(false);
        setVisible(true);
    }

    void loadQuestion() {
        if (questionNum < quizQuestions.length) {
            questionLabel.setText("Q" + (questionNum + 1) + ": " + quizQuestions[questionNum]);
            answer1.setLabel(quizChoices[questionNum][0]);
            answer2.setLabel(quizChoices[questionNum][1]);
            answer3.setLabel(quizChoices[questionNum][2]);
            answer4.setLabel(quizChoices[questionNum][3]);
            choicesGroup.setSelectedCheckbox(null);
        } else {
            showResult();
        }
    }

    void showResult() {
        questionLabel.setText("Quiz Completed! Your Score: " + score + " out of " + quizQuestions.length);
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);
        nextButton.setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        Checkbox selected = choicesGroup.getSelectedCheckbox();
        if (selected == null) {
            nextButton.setLabel("Please select an Answer");
            return;
        }

        String selectedAnswer = selected.getLabel();
        int correctIndex = correctAnswers[questionNum];
        if (selectedAnswer.equals(quizChoices[questionNum][correctIndex])) {
            score ++;
        }

        questionNum++;
        loadQuestion();
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}

