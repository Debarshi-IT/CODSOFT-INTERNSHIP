import java.util.*;
import java.util.concurrent.*;

class Question {
    String qu;
    String[] op;
    int cA;
    public Question(String qu, String[] op, int cA) {
        this.qu = qu;
        this.op = op;
        this.cA = cA;
    }
}
public class CodSoft_Task4 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Question> qu = new ArrayList<>();
    private static int score = 0;
    private static final int TIME_LIMIT = 10;
    public static void main(String[] args) {
        loadQuestions();
        playQuiz();
        showResults();
    }
    private static void loadQuestions() {
        qu.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
        qu.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 2));
        qu.add(new Question("Who wrote 'Hamlet'?", new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Jane Austen", "4. Mark Twain"}, 2));
        qu.add(new Question("What is the pH value of the human body?", new String[]{"1. 9.2 to 9.8", "2. 7.0 to 7.8", "3. 6.1 to 6.3", "4. 5.4 to 5.6"}, 2));
        qu.add(new Question("Which of the following are called 'Key Industrial animals'?", new String[]{"1. Producers", "2. Tertiary consumers", "3. Primary consumers", "4. None of these"}, 3));
        qu.add(new Question("Which of the following Himalayan regions is called ''Shivalik's''?", new String[]{"1. Upper Himalayas", "2. Lower Himalayas", "3. Outer Himalayas", "4. Inner Himalayas"}, 3));
        qu.add(new Question("Forming of Association in India is", new String[]{"1. Legal Right", "2. Illegal Right", "3. Natural Right", "4. Fundamental Right."}, 4));
        qu.add(new Question("The Samkhya School of Philosophy was founded by", new String[]{"1. Gautam Buddha", "2. Mahipala", "3. Gopala", "4. Kapila"}, 4));
        qu.add(new Question("Chelaiya Samiti is related to which of the following?", new String[]{"1. Banking sector", "2. Insurance sector", "3. Health Sector", "4. Tax reforms"}, 4));
        qu.add(new Question("Which of the given compounds is used to make fireproof clothing?", new String[]{"1. Aluminum chloride", "2. Aluminum Sulphate", "3. Magnesium Chloride", "4. Magnesium Sulphate"}, 2));
    }
    private static void playQuiz() {
        for (int i = 0; i < qu.size(); i++) {
            Question q = qu.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.qu);
            for (String option : q.op) {
                System.out.println(option);
            }
            int userAnswer = getUserAnswerWithTimer();
            if (userAnswer == q.cA) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.cA);
            }
        }
    }
    private static int getUserAnswerWithTimer() {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            System.out.print("Enter your answer (1-4) within " + TIME_LIMIT + " seconds: ");
            return scanner.nextInt();
        });
        try {
            return future.get(TIME_LIMIT, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("\nTime's up! Moving to the next question.");
            return -1;
        } catch (Exception e) {
            return -1;
        } finally {
            executor.shutdown();
        }
    }
    private static void showResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score: " + score + " out of " + qu.size());
    }
}
