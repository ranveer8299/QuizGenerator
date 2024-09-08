import java.util.*;

class QuizGenerator {

    // A class to represent a Question with its options and correct answer
    static class Question {
        String questionText;
        List<String> options;
        String correctAnswer;

        public Question(String questionText, List<String> options, String correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public boolean isCorrect(String answer) {
            return answer.equalsIgnoreCase(correctAnswer);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(questionText).append("\n");
            char optionLabel = 'A';
            for (String option : options) {
                sb.append(optionLabel).append(". ").append(option).append("\n");
                optionLabel++;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        
        // Adding sample questions
        questions.add(new Question("Which of the following is not a Java keyword?", 
                Arrays.asList("static", "abstract", "interface", "main"), "main"));
        
        questions.add(new Question(" What is the default value of a boolean variable in Java?", 
                Arrays.asList("true", "false", "0", "1"), "false"));

        questions.add(new Question(" What is the size of an int in Java?", 
                Arrays.asList("8 bits", "16 bits", "32 bits", "64 bits"), "32 bits"));
                
        questions.add(new Question("Which of these is a marker interface in Java?",
        Arrays.asList("Cloneable", "Runnable", "Serializable", "Comparable"),"Serializable"));
        
        questions.add(new Question("What is the superclass of all classes in Java?",
        Arrays.asList("java.lang.Object", "java.util.Class", "java.lang.Class", "java.util.Object"),"java.lang.Object"));

        int score = 0;

        System.out.println("Welcome to the Quiz!\n");

        for (Question question : questions) {
            System.out.println(question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + question.correctAnswer + "\n");
            }
        }

        System.out.println("Quiz finished! Your score is: " + score + "/" + questions.size());
        scanner.close();
    }
}